package net.tonimatasdev.krystalcraft.client.handler;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.tonimatasdev.krystalcraft.client.handler.slot.ModResultSlot;
import net.tonimatasdev.krystalcraft.registry.ScreenHandlerRegistry;
import org.jetbrains.annotations.NotNull;

public class GemCuttingMenuHandler extends AbstractContainerMenu {
    private static final int TE_INVENTORY_SLOT_COUNT = 4; // Number of slots in the screen
    private final ContainerData data;
    private final Container container;

    public GemCuttingMenuHandler(int syncId, Inventory playerInventory) {
        this(syncId, playerInventory, new SimpleContainer(4), new SimpleContainerData(3));
    }

    public GemCuttingMenuHandler(int syncId, Inventory playerInventory, Container inventory, ContainerData data) {
        super(ScreenHandlerRegistry.GEM_CUTTING_MENU.get(), syncId);

        this.container = inventory;
        checkContainerSize(inventory, 4);
        this.data = data;

        this.addSlot(new Slot(inventory, 0, 34, 40));
        this.addSlot(new Slot(inventory, 1, 57, 18));
        this.addSlot(new Slot(inventory, 2, 103, 18));
        this.addSlot(new ModResultSlot(inventory, 3, 80, 60));

        buildPlayerContainer(playerInventory);
    }


    private void buildPlayerContainer(Container playerInventory) {
        int i;
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
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
    public @NotNull ItemStack quickMoveStack(Player player, int index) {
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

        sourceSlot.onTake(player, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return container.stillValid(player);
    }
}