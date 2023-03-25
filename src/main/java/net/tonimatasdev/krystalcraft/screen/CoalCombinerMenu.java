package net.tonimatasdev.krystalcraft.screen;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.tonimatasdev.krystalcraft.block.ModBlocks;
import net.tonimatasdev.krystalcraft.block.entity.custom.CoalCombinerBlockEntity;
import net.tonimatasdev.krystalcraft.screen.slot.ModFuelSlot;
import net.tonimatasdev.krystalcraft.screen.slot.ModResultSlot;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@SuppressWarnings("removal")
public class CoalCombinerMenu extends AbstractContainerMenu {
    private static final int TE_INVENTORY_SLOT_COUNT = 4; // Number of slots in the screen
    private final CoalCombinerBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public CoalCombinerMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(4));
    }

    public CoalCombinerMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.COAL_COMBINER_MENU.get(), pContainerId);

        checkContainerSize(inv, 4);
        blockEntity = ((CoalCombinerBlockEntity) entity);

        this.level = inv.player.level;
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 70, 31));
            this.addSlot(new SlotItemHandler(handler, 1, 88, 31));
            this.addSlot(new ModFuelSlot(handler, 2, 80, 64));
            this.addSlot(new ModResultSlot(handler, 3, 80, 86));
        });

        addDataSlots(data);
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    @SuppressWarnings("unused")
    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int progressArrowSize = 14;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public int getFuelScaledProgress() {
        int progress = this.data.get(2);
        int progressArrowSize = 14;

        return progress != 0 ? progress * progressArrowSize / 8 : 0;
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        if (index < 36) {
            if (!moveItemStackTo(sourceStack, 36, 36 + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else if (index < 36 + TE_INVENTORY_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, 0, 36, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }

        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }

        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), Objects.requireNonNull(pPlayer), ModBlocks.COAL_COMBINER.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 110 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 168));
        }
    }
}