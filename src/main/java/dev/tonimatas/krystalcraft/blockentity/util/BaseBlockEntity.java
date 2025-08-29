package dev.tonimatas.krystalcraft.blockentity.util;

import com.teamresourceful.resourcefullib.common.menu.ContentMenuProvider;
import dev.tonimatas.krystalcraft.inventory.ModInventory;
import dev.tonimatas.krystalcraft.menu.content.BlockPosContent;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import org.jetbrains.annotations.Nullable;

@MethodsReturnNonnullByDefault
public abstract class BaseBlockEntity extends BlockEntity implements ModInventory, WorldlyContainer, ContentMenuProvider<BlockPosContent> {
    public final NonNullList<ItemStack> inventory;

    public BaseBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        inventory = NonNullList.withSize(getInventorySize(), ItemStack.EMPTY);
    }

    public abstract void tick();

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return null;
    }

    public int getInventorySize() {
        return 0;
    }

    @Override
    public Component getDisplayName() {
        return Component.empty();
    }

    @Override
    public BlockPosContent createContent(ServerPlayer player) {
        return new BlockPosContent(this.getBlockPos());
    }

    @Override
    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);

        if (getInventorySize() > 0) {
            ContainerHelper.loadAllItems(compoundTag, this.inventory, provider);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        if (getInventorySize() > 0) {
            ContainerHelper.saveAllItems(compoundTag, this.inventory, provider);
        }
    }

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
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        return this.saveWithoutMetadata(provider);
    }
}
