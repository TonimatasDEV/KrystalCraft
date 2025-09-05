package dev.tonimatas.krystalcraft.block.entity;

import dev.tonimatas.krystalcraft.recipe.CrushingRecipe;
import dev.tonimatas.krystalcraft.recipe.input.SimpleRecipeInput;
import dev.tonimatas.krystalcraft.registry.ModBlockEntities;
import dev.tonimatas.krystalcraft.registry.ModRecipes;
import dev.tonimatas.krystalcraft.screen.CrushingStationScreenHandler;
import dev.tonimatas.krystalcraft.util.FabricUtils;
import dev.tonimatas.krystalcraft.util.ImplementedInventory;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
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

public class CrushingStationBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {
    protected static final int INPUT_SLOT = 0;
    protected static final int RESULT_SLOT = 1;
    protected static final int FUEL_SLOT = 2;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    protected int burnTime;
    protected int burnTimeTotal;
    protected int progress;
    protected int maxProgress = 100;

    public CrushingStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CRUSHING_STATION_BLOCK_ENTITY, pos, state);
        
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> CrushingStationBlockEntity.this.burnTime;
                    case 1 -> CrushingStationBlockEntity.this.burnTimeTotal;
                    case 2 -> CrushingStationBlockEntity.this.progress;
                    case 3 -> CrushingStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: CrushingStationBlockEntity.this.burnTime = value;
                    case 1: CrushingStationBlockEntity.this.burnTimeTotal  = value;
                    case 2: CrushingStationBlockEntity.this.progress  = value;
                    case 3: CrushingStationBlockEntity.this.maxProgress  = value;
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
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("crushing_station.burn_time", burnTime);
        nbt.putInt("crushing_station.burn_time_total", burnTimeTotal);
        nbt.putInt("crushing_station.progress", progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory, registryLookup);
        burnTime = nbt.getInt("crushing_station.burn_time");
        burnTimeTotal = nbt.getInt("crushing_station.burn_time_total");
        progress = nbt.getInt("crushing_station.progress");
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
        return Text.translatable("block.krystalcraft.crushing_station");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CrushingStationScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
    
    public void tick(World world, BlockPos pos, BlockState state) {
        if (world == null) return;
        if (world.isClient) return;

        if (hasRecipe()) {
            if (burnTime <= 0) {
                burnTime = FabricUtils.getBurnTime(getStack(FUEL_SLOT));
                burnTimeTotal = burnTime;
                removeStack(FUEL_SLOT, 1);
            } else {
                progress++;
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
        Optional<RecipeEntry<CrushingRecipe>> recipe = getCurrentRecipe();
        
        if (recipe.isEmpty()) {
            return false;
        }
        
        ItemStack output = recipe.get().value().result();
        
        return canInsertItemStack(output);
    }

    private Optional<RecipeEntry<CrushingRecipe>> getCurrentRecipe() {
        return this.getWorld().getRecipeManager().getFirstMatch(ModRecipes.CRUSHING_RECIPE_TYPE, new SimpleRecipeInput(inventory.get(INPUT_SLOT)), this.getWorld());
    }

    private void craftItem() {
        Optional<RecipeEntry<CrushingRecipe>> recipe = getCurrentRecipe();
        
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
