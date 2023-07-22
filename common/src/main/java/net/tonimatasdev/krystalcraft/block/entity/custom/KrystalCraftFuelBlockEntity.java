package net.tonimatasdev.krystalcraft.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public abstract class KrystalCraftFuelBlockEntity extends BlockEntity implements Container, MenuProvider {
    protected NonNullList<ItemStack> inventory;
    protected int progress = 0;
    protected int maxProgress = 100;
    protected int fuel;
    private final int capacity;

    protected ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> KrystalCraftFuelBlockEntity.this.progress;
                case 1 -> KrystalCraftFuelBlockEntity.this.maxProgress;
                case 2 -> KrystalCraftFuelBlockEntity.this.fuel;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> KrystalCraftFuelBlockEntity.this.progress = value;
                case 1 -> KrystalCraftFuelBlockEntity.this.maxProgress = value;
                case 2 -> KrystalCraftFuelBlockEntity.this.fuel = value;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    };

    public KrystalCraftFuelBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int inventorySize) {
        super(blockEntityType, blockPos, blockState);
        this.inventory = NonNullList.withSize(inventorySize, ItemStack.EMPTY);
        this.capacity = inventorySize;
    }

    @Override
    public int getContainerSize() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return inventory.stream().allMatch(ItemStack::isEmpty);
    }
    @Override
    public @NotNull ItemStack getItem(int slot) {
        return this.inventory.get(slot);
    }

    @Override
    public @NotNull ItemStack removeItem(int slot, int amount) {
        return ContainerHelper.removeItem(this.inventory, slot, amount);
    }

    @Override
    public @NotNull ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(this.inventory, slot);
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        final ItemStack stackInSlot = this.inventory.get(slot);
        boolean dirty = !stack.isEmpty() && ItemStack.isSameItem(stack, stackInSlot) && ItemStack.matches(stack, stackInSlot);        this.inventory.set(slot, stack);
        if (stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }
        if (slot == 1 || slot == 2) {
            if (!dirty) {
                this.progress = 0;
                setChanged();
            }
        }
    }

    @Override
    public boolean stillValid(Player player) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return player.distanceToSqr((double) this.worldPosition.getX() + 0.5, (double) this.worldPosition.getY() + 0.5, (double) this.worldPosition.getZ() + 0.5) <= 64.0;
        }
    }

    @Override
    public void clearContent() {
        this.inventory.clear();
    }
}
