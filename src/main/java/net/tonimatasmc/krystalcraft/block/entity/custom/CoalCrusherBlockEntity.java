package net.tonimatasmc.krystalcraft.block.entity.custom;

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
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.tonimatasmc.krystalcraft.block.entity.ModBlockEntities;
import net.tonimatasmc.krystalcraft.item.ModItems;
import net.tonimatasmc.krystalcraft.recipe.CoalCrusherRecipe;
import net.tonimatasmc.krystalcraft.screen.CoalCrusherMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Optional;

public class CoalCrusherBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;
    private static int fuelProgress = 0;
    private static final int fuelMaxProgress = 72*8;

    public CoalCrusherBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.COAL_CRUSHER_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {

            @SuppressWarnings("EnhancedSwitchMigration")
            public int get(int index) {
                switch (index) {
                    case 0: return CoalCrusherBlockEntity.this.progress;
                    case 1: return CoalCrusherBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> CoalCrusherBlockEntity.this.progress = value;
                    case 1 -> CoalCrusherBlockEntity.this.maxProgress = value;
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    @Nonnull
    public Component getDisplayName() {
        return Component.translatable("Coal Crusher");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, @Nullable Inventory pInventory, @Nullable Player pPlayer) {
        return new CoalCrusherMenu(pContainerId, pInventory, this, this.data);
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
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("coal_crusher.progress", progress);
        super.saveAdditional(tag);
    }

    @Override
    public void load(@Nullable CompoundTag nbt) {
        super.load(Objects.requireNonNull(nbt));
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("coal_crusher.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(Objects.requireNonNull(this.level), this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, CoalCrusherBlockEntity pBlockEntity) {
        if(hasRecipe(pBlockEntity)) {
            pBlockEntity.progress++;
            fuelProgress++;
            setChanged(pLevel, pPos, pState);

            if (pBlockEntity.progress > pBlockEntity.maxProgress && fuelProgress <= fuelMaxProgress) {
                craftItem(pBlockEntity);
            }
        } else {
            pBlockEntity.resetProgress();
            setChanged(pLevel, pPos, pState);
        }
    }

    private static boolean hasRecipe(CoalCrusherBlockEntity entity) {
        Level level = entity.level;

        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());

        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<CoalCrusherRecipe> match = Objects.requireNonNull(level).getRecipeManager()
                .getRecipeFor(CoalCrusherRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem()) &&
                hasWaterInWaterSlot(entity) && hasCoalSlot(entity);
    }

    private static boolean hasWaterInWaterSlot(CoalCrusherBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(0).getItem() == ModItems.SET_WATER_BOTTLES.get();
    }

    private static boolean hasCoalSlot(CoalCrusherBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(2).getItem() == Items.COAL || fuelProgress <= fuelMaxProgress;
    }

    private static void craftItem(CoalCrusherBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());

        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<CoalCrusherRecipe> match = Objects.requireNonNull(level).getRecipeManager().getRecipeFor(CoalCrusherRecipe.Type.INSTANCE, inventory, level);

        if(match.isPresent()) {

            entity.itemHandler.getStackInSlot(0).hurt(1, RandomSource.create(), null);

            if ((entity.itemHandler.getStackInSlot(0).getMaxDamage() - entity.itemHandler.getStackInSlot(0).getDamageValue()) <= 0) {
                entity.itemHandler.extractItem(0,1, false);
            }

            entity.itemHandler.extractItem(1,1, false);

            entity.itemHandler.setStackInSlot(3, new ItemStack(match.get().getResultItem().getItem(), entity.itemHandler.getStackInSlot(3).getCount() + 1));

            if (fuelProgress >= fuelMaxProgress) {
                entity.itemHandler.extractItem(2, 1, false);
                fuelProgress = 0;
            }

            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    public static int getFuelProgress() {
        return fuelProgress;
    }

    public static int getFuelMaxProgress() {
        return fuelMaxProgress;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(3).getItem() == output.getItem() || inventory.getItem(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(3).getMaxStackSize() > inventory.getItem(3).getCount();
    }
}