package net.tonimatasdev.krystalcraft.block.entity.custom;

import earth.terrarium.botarium.common.menu.ExtraDataMenuProvider;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.util.ModInventory;

@MethodsReturnNonnullByDefault
public abstract class AbstractMachineBlockEntity extends BlockEntity implements ExtraDataMenuProvider, ModInventory, WorldlyContainer {
    private final NonNullList<ItemStack> inventory;

    public AbstractMachineBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        inventory = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
    }

    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return null;
    }

    public abstract void tick();

    @Override
    public void writeExtraData(ServerPlayer player, FriendlyByteBuf buffer) {
        buffer.writeBlockPos(this.getBlockPos());
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        if (getContainerSize() > 0) {
            ContainerHelper.loadAllItems(compoundTag, this.inventory);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        if (getContainerSize() > 0) {
            ContainerHelper.saveAllItems(compoundTag, this.inventory);
        }
    }

    @Override
    public void setChanged() {
        super.setChanged();

        if (this.level instanceof ServerLevel serverWorld) {
            serverWorld.getChunkSource().blockChanged(this.worldPosition);
        }
    }

    public abstract int getContainerSize();

    @Override
    public int[] getSlotsForFace(Direction side) {
        int[] result = new int[getItems().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    @Override
    public boolean canPlaceItemThroughFace(int slot, ItemStack stack, Direction dir) {
        ItemStack slotStack = this.getItem(slot);
        return slotStack.isEmpty() || (slotStack.is(stack.getItem()) && slotStack.getCount() <= slotStack.getMaxStackSize());
    }

    @Override
    public boolean canTakeItemThroughFace(int slot, ItemStack stack, Direction dir) {
        return true;
    }


    public NonNullList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
    }

    @Override
    public Component getDisplayName() {
        return null;
    }
}
