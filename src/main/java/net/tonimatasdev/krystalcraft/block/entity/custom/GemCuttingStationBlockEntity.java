package net.tonimatasdev.krystalcraft.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.tonimatasdev.krystalcraft.block.entity.ModBlockEntities;
import net.tonimatasdev.krystalcraft.block.entity.utils.Simplify;
import net.tonimatasdev.krystalcraft.recipe.GemCuttingStationRecipe;
import net.tonimatasdev.krystalcraft.screen.GemCuttingStationMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Optional;

public class GemCuttingStationBlockEntity extends BlockEntity implements MenuProvider {
    protected final ContainerData data;
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private int progress = 0;
    private int maxProgress = 72;

    public GemCuttingStationBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.GEM_CUTTING_STATION_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);

        this.data = new ContainerData() {

            @SuppressWarnings("EnhancedSwitchMigration")
            public int get(int index) {
                switch (index) {
                    case 0:
                        return GemCuttingStationBlockEntity.this.progress;
                    case 1:
                        return GemCuttingStationBlockEntity.this.maxProgress;
                    default:
                        return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> GemCuttingStationBlockEntity.this.progress = value;
                    case 1 -> GemCuttingStationBlockEntity.this.maxProgress = value;
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, GemCuttingStationBlockEntity pBlockEntity) {
        if (hasRecipe(pBlockEntity)) {
            pBlockEntity.progress++;
            setChanged(pLevel, pPos, pState);

            if (pBlockEntity.progress > pBlockEntity.maxProgress) {
                craftItem(pBlockEntity);
            }
        } else {
            pBlockEntity.resetProgress();
            setChanged(pLevel, pPos, pState);
        }
    }

    private static boolean hasRecipe(GemCuttingStationBlockEntity entity) {
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        Level level = entity.level;

        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<GemCuttingStationRecipe> match = Objects.requireNonNull(level).getRecipeManager().getRecipeFor(GemCuttingStationRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && Simplify.canInsertAmountIntoOutputSlot(inventory, 3) && Simplify.canInsertItemIntoOutputSlot(inventory, match.get().getResultItem(Objects.requireNonNull(entity.getLevel()).registryAccess()), 3) &&
                Simplify.hasWaterInWaterSlot(entity.itemHandler, 0) && Simplify.hasToolsInToolSlot(entity.itemHandler, 2);
    }

    private static void craftItem(GemCuttingStationBlockEntity entity) {
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        Level level = entity.level;

        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<GemCuttingStationRecipe> match = Objects.requireNonNull(level).getRecipeManager().getRecipeFor(GemCuttingStationRecipe.Type.INSTANCE, inventory, level);

        if (match.isPresent()) {
            entity.itemHandler.getStackInSlot(0).hurt(1, RandomSource.create(), null);

            if ((entity.itemHandler.getStackInSlot(0).getMaxDamage() - entity.itemHandler.getStackInSlot(0).getDamageValue()) <= 0) {
                entity.itemHandler.extractItem(0, 1, false);
            }

            entity.itemHandler.extractItem(1, 1, false);
            entity.itemHandler.getStackInSlot(2).hurt(1, RandomSource.create(), null);

            if ((entity.itemHandler.getStackInSlot(2).getMaxDamage() - entity.itemHandler.getStackInSlot(2).getDamageValue()) <= 0) {
                entity.itemHandler.extractItem(2, 1, false);
            }

            entity.itemHandler.setStackInSlot(3, new ItemStack(match.get().getResultItem(Objects.requireNonNull(entity.level).registryAccess()).getItem(), entity.itemHandler.getStackInSlot(3).getCount() + 1));
            entity.resetProgress();
        }
    }

    @Override
    @Nonnull
    public Component getDisplayName() {
        return Component.translatable("Gem Cutting Station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, @Nullable Inventory pInventory, @Nullable Player pPlayer) {
        return new GemCuttingStationMenu(pContainerId, pInventory, this, this.data);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("gem_cutting_station.progress", progress);
        super.saveAdditional(tag);
    }

    @Override
    public void load(@Nullable CompoundTag nbt) {
        super.load(Objects.requireNonNull(nbt));
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("gem_cutting_station.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());

        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(Objects.requireNonNull(this.level), this.worldPosition, inventory);
    }

    private void resetProgress() {
        this.progress = 0;
    }
}