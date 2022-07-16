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
import net.tonimatasmc.krystalcraft.block.entity.Utils.Simplify;
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
    private int fuel;

    public CoalCrusherBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.COAL_CRUSHER_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {

            @SuppressWarnings("EnhancedSwitchMigration")
            public int get(int index) {
                switch (index) {
                    case 0: return CoalCrusherBlockEntity.this.progress;
                    case 1: return CoalCrusherBlockEntity.this.maxProgress;
                    case 2: return CoalCrusherBlockEntity.this.fuel;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> CoalCrusherBlockEntity.this.progress = value;
                    case 1 -> CoalCrusherBlockEntity.this.maxProgress = value;
                    case 2 -> CoalCrusherBlockEntity.this.fuel = value;
                }
            }

            public int getCount() {
                return 3;
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
        tag.putInt("coal_crusher.fuel", fuel);
        super.saveAdditional(tag);
    }

    @Override
    public void load(@Nullable CompoundTag nbt) {
        super.load(Objects.requireNonNull(nbt));
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("coal_crusher.progress");
        progress = nbt.getInt("coal_crusher.fuel");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());

        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(Objects.requireNonNull(this.level), this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, CoalCrusherBlockEntity pBlockEntity) {
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

    private static boolean hasRecipe(CoalCrusherBlockEntity entity) {
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        Level level = entity.level;

        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<CoalCrusherRecipe> match = Objects.requireNonNull(level).getRecipeManager().getRecipeFor(CoalCrusherRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && Simplify.canInsertAmountIntoOutputSlot(inventory) && Simplify.canInsertItemIntoOutputSlot(inventory, match.get().getResultItem()) &&
                Simplify.hasWaterInWaterSlot(entity.itemHandler);
    }

    private static void craftItem(CoalCrusherBlockEntity entity) {
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        Level level = entity.level;

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

            entity.fuel = entity.fuel - 1;
            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }
}