package net.tonimatasdev.krystalcraft.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import net.tonimatasdev.krystalcraft.block.entity.ModBlockEntities;
import net.tonimatasdev.krystalcraft.block.entity.utils.Simplify;
import net.tonimatasdev.krystalcraft.recipe.CoalCombinerRecipe;
import net.tonimatasdev.krystalcraft.screen.CoalCombinerMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

public class CoalCombinerBlockEntity extends KrystalCraftBlockEntity {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private int fuel;

    public CoalCombinerBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.COAL_COMBINER_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> CoalCombinerBlockEntity.this.progress;
                    case 1 -> CoalCombinerBlockEntity.this.maxProgress;
                    case 2 -> CoalCombinerBlockEntity.this.fuel;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> CoalCombinerBlockEntity.this.progress = value;
                    case 1 -> CoalCombinerBlockEntity.this.maxProgress = value;
                    case 2 -> CoalCombinerBlockEntity.this.fuel = value;
                }
            }

            public int getCount() {
                return 3;
            }
        };
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, CoalCombinerBlockEntity pBlockEntity) {
        if (hasRecipe(pBlockEntity)) {
            pBlockEntity.progress++;
            setChanged(pLevel, pPos, pState);

            if (pBlockEntity.progress > pBlockEntity.maxProgress) {
                if (pBlockEntity.fuel > 0) {
                    craftItem(pBlockEntity);
                } else {
                    if (pBlockEntity.itemHandler.getStackInSlot(2).getItem() == Items.COAL || pBlockEntity.itemHandler.getStackInSlot(2).getItem() == Items.CHARCOAL) {
                        pBlockEntity.itemHandler.extractItem(2, 1, false);
                        pBlockEntity.fuel = 8;
                    }
                }
            }
        } else {
            pBlockEntity.resetProgress();
            setChanged(pLevel, pPos, pState);
        }
    }

    private static boolean hasRecipe(CoalCombinerBlockEntity entity) {
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        Level level = entity.level;

        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<CoalCombinerRecipe> match = Objects.requireNonNull(level).getRecipeManager().getRecipeFor(CoalCombinerRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && Simplify.canInsertAmountIntoOutputSlot(inventory, 3) && Simplify.canInsertItemIntoOutputSlot(inventory, match.get().getResultItem(Objects.requireNonNull(entity.level).registryAccess()), 3) &&
                Simplify.hasWaterInWaterSlot(entity.itemHandler, 0);
    }

    private static void craftItem(CoalCombinerBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());

        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<CoalCombinerRecipe> match = Objects.requireNonNull(level).getRecipeManager().getRecipeFor(CoalCombinerRecipe.Type.INSTANCE, inventory, level);

        if (match.isPresent()) {
            entity.itemHandler.extractItem(0, 1, false);
            entity.itemHandler.extractItem(1, 1, false);

            entity.itemHandler.setStackInSlot(3, new ItemStack(match.get().getResultItem(Objects.requireNonNull(entity.level).registryAccess()).getItem(), entity.itemHandler.getStackInSlot(3).getCount() + 1));

            entity.fuel = entity.fuel - 1;
            entity.resetProgress();
        }
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("block.krystalcraft.coal_combiner");
    }

    @Override
    public AbstractContainerMenu createMenu(int pContainerId, @Nullable Inventory pInventory, @Nullable Player pPlayer) {
        return new CoalCombinerMenu(pContainerId, pInventory, this, this.data);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("coal_combiner.progress", progress);
        tag.putInt("coal_combiner.fuel", fuel);
        super.saveAdditional(tag);
    }

    @Override
    public void load(@Nullable CompoundTag nbt) {
        super.load(Objects.requireNonNull(nbt));
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("coal_combiner.progress");
        progress = nbt.getInt("coal_combiner.fuel");
    }

    public void drops() {
        super.drop(itemHandler);
    }
}