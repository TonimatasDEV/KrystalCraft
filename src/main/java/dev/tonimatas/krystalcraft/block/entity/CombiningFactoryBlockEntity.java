package dev.tonimatas.krystalcraft.block.entity;

import dev.tonimatas.krystalcraft.recipe.CombiningRecipe;
import dev.tonimatas.krystalcraft.recipe.input.CombiningRecipeInput;
import dev.tonimatas.krystalcraft.registry.ModBlockEntities;
import dev.tonimatas.krystalcraft.registry.ModRecipes;
import dev.tonimatas.krystalcraft.screen.CombiningFactoryScreenHandler;
import dev.tonimatas.krystalcraft.util.EnergyUtils;
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
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public class CombiningFactoryBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {
    private static final int INPUT1_SLOT = 0;
    private static final int INPUT2_SLOT = 1;
    private static final int RESULT_SLOT = 2;
    private static final int BATTERY_SLOT = 3;
    private static final int UPGRADE1_SLOT = 4;
    private static final int UPGRADE2_SLOT = 5;
    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(30000, 50, 50) {
        @Override
        protected void onFinalCommit() {
            markDirty();
            getWorld().updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    };
    protected final PropertyDelegate propertyDelegate;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(6, ItemStack.EMPTY);
    protected int progress;
    protected int maxProgress = 100;

    public CombiningFactoryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COMBINING_FACTORY_BLOCK_ENTITY, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> CombiningFactoryBlockEntity.this.progress;
                    case 1 -> CombiningFactoryBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        CombiningFactoryBlockEntity.this.progress = value;
                    case 1:
                        CombiningFactoryBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
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
        nbt.putInt("combining_factory.progress", progress);
        nbt.putLong("combining_factory.energy", energyStorage.amount);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("combining_factory.progress");
        energyStorage.amount = nbt.getLong("combining_factory.energy");
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
        return Text.translatable("block.krystalcraft.combining_factory");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CombiningFactoryScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        EnergyUtils.moveFromItem(this, energyStorage, BATTERY_SLOT);

        if (hasRecipe()) {
            if (energyStorage.amount >= 5 && EnergyUtils.extractInternal(energyStorage, 5) == 5) {
                progress++;
            }

            if (this.progress >= this.maxProgress) {
                craftItem();
                this.progress = 0;
            }
        } else {
            this.progress = 0;
        }
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<CombiningRecipe>> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }

        ItemStack output = recipe.get().value().result();

        return canInsertItemStack(output);
    }

    private Optional<RecipeEntry<CombiningRecipe>> getCurrentRecipe() {
        return this.getWorld().getRecipeManager().getFirstMatch(ModRecipes.COMBINING_RECIPE_TYPE, new CombiningRecipeInput(inventory.get(INPUT1_SLOT), inventory.get(INPUT2_SLOT)), this.getWorld());
    }

    private void craftItem() {
        Optional<RecipeEntry<CombiningRecipe>> recipe = getCurrentRecipe();

        ItemStack output = recipe.get().value().result();
        this.removeStack(INPUT1_SLOT, 1);
        this.removeStack(INPUT2_SLOT, 1);
        this.setStack(RESULT_SLOT, new ItemStack(output.getItem(), this.getStack(RESULT_SLOT).getCount() + output.getCount()));
    }

    private boolean canInsertItemStack(ItemStack newStack) {
        ItemStack stack = this.getStack(RESULT_SLOT);
        int maxCount = stack.isEmpty() ? 64 : stack.getMaxCount();
        int currentCount = stack.getCount();

        return maxCount >= currentCount + newStack.getCount() && (stack.isOf(newStack.getItem()) || stack.isEmpty());
    }
}
