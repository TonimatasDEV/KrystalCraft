package dev.tonimatas.krystalcraft.block.entity;

import dev.tonimatas.krystalcraft.recipe.CuttingRecipe;
import dev.tonimatas.krystalcraft.recipe.input.SimpleRecipeInput;
import dev.tonimatas.krystalcraft.registry.ModBlockEntities;
import dev.tonimatas.krystalcraft.registry.ModRecipes;
import dev.tonimatas.krystalcraft.screen.CuttingStationScreenHandler;
import dev.tonimatas.krystalcraft.util.FabricUtils;
import dev.tonimatas.krystalcraft.util.FluidUtils;
import dev.tonimatas.krystalcraft.util.ImplementedInventory;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CuttingStationBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {
    protected static final int INPUT_SLOT = 0;
    protected static final int TANK_INPUT_SLOT = 1;
    protected static final int TANK_OUTPUT_SLOT = 2;
    protected static final int FUEL_SLOT = 3;
    protected static final int RESULT_SLOT = 4;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    protected int burnTime;
    protected int burnTimeTotal;
    protected int progress;
    protected int maxProgress = 100;

    public final SingleVariantStorage<FluidVariant> fluidStorage = new SingleVariantStorage<>() {
        @Override
        protected FluidVariant getBlankVariant() {
            return FluidVariant.of(Fluids.WATER);
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            return (FluidConstants.BUCKET / 81) * 10;
        }

        @Override
        protected void onFinalCommit() {
            markDirty();
            getWorld().updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    };

    public CuttingStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CUTTING_STATION_BLOCK_ENTITY, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> CuttingStationBlockEntity.this.burnTime;
                    case 1 -> CuttingStationBlockEntity.this.burnTimeTotal;
                    case 2 -> CuttingStationBlockEntity.this.progress;
                    case 3 -> CuttingStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: CuttingStationBlockEntity.this.burnTime = value;
                    case 1: CuttingStationBlockEntity.this.burnTimeTotal  = value;
                    case 2: CuttingStationBlockEntity.this.progress  = value;
                    case 3: CuttingStationBlockEntity.this.maxProgress  = value;
                }
            }

            @Override
            public int size() {
                return 4;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putInt("cutting_station.burn_time", burnTime);
        nbt.putInt("cutting_station.burn_time_total", burnTimeTotal);
        nbt.putInt("cutting_station.progress", progress);
        SingleVariantStorage.writeNbt(fluidStorage, FluidVariant.CODEC, nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory, registryLookup);
        burnTime = nbt.getInt("cutting_station.burn_time");
        burnTimeTotal = nbt.getInt("cutting_station.burn_time_total");
        progress = nbt.getInt("cutting_station.progress");
        SingleVariantStorage.readNbt(fluidStorage, FluidVariant.CODEC, FluidVariant::blank, nbt, registryLookup);
        super.readNbt(nbt, registryLookup);
    }

    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.krystalcraft.cutting_station");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CuttingStationScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (hasRecipe()) {
            if (burnTime <= 0) {
                burnTime = FabricUtils.getBurnTime(getStack(FUEL_SLOT));
                burnTimeTotal = burnTime;
                removeStack(FUEL_SLOT, 1);
            } else {
                long amount = FluidUtils.extractInternal(fluidStorage, 5);

                if (amount == 5) {
                    progress++;
                }
            }
   
            markDirty(world, pos, state);

            if (this.progress >= this.maxProgress) {
                craftItem();
                this.progress = 0;
            }
        } else {
            this.progress = 0;
        }

        if (burnTime > 0) burnTime--;
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<CuttingRecipe>> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }

        ItemStack output = recipe.get().value().result();

        return canInsertItemStack(output);
    }

    private Optional<RecipeEntry<CuttingRecipe>> getCurrentRecipe() {
        return this.getWorld().getRecipeManager().getFirstMatch(ModRecipes.CUTTING_RECIPE_TYPE, new SimpleRecipeInput(inventory.get(INPUT_SLOT)), this.getWorld());
    }

    private void craftItem() {
        Optional<RecipeEntry<CuttingRecipe>> recipe = getCurrentRecipe();

        ItemStack output = recipe.get().value().result();
        this.removeStack(INPUT_SLOT, 1);
        this.setStack(RESULT_SLOT, new ItemStack(output.getItem(), this.getStack(RESULT_SLOT).getCount() + output.getCount()));
    }

    private boolean canInsertItemStack(ItemStack newStack) {
        ItemStack stack = this.getStack(RESULT_SLOT);
        int maxCount = stack.isEmpty() ? 64 : stack.getMaxCount();
        int currentCount = stack.getCount();

        return maxCount >= currentCount + newStack.getCount() && (stack.isOf(newStack.getItem()) || stack.isEmpty());
    }
}
