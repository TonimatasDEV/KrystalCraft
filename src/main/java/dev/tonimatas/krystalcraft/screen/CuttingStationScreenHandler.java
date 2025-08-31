package dev.tonimatas.krystalcraft.screen;

import dev.tonimatas.krystalcraft.block.entity.CuttingStationBlockEntity;
import dev.tonimatas.krystalcraft.registry.ModScreenHandlers;
import dev.tonimatas.krystalcraft.screen.slots.FluidSlot;
import dev.tonimatas.krystalcraft.screen.slots.FuelSlot;
import dev.tonimatas.krystalcraft.screen.slots.ResultSlot;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

public class CuttingStationScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final CuttingStationBlockEntity blockEntity;
    
    public CuttingStationScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(pos), new ArrayPropertyDelegate(4));
    }
    
    public CuttingStationScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate propertyDelegate) {
        super(ModScreenHandlers.CUTTING_STATION_SCREEN_HANDLER, syncId);
        this.inventory = (Inventory) blockEntity;
        this.blockEntity = (CuttingStationBlockEntity) blockEntity;
        this.propertyDelegate = propertyDelegate;

        this.addSlot(new Slot(inventory, 0, 80, 17));
        this.addSlot(new FluidSlot(inventory, 1, 6, 22, Fluids.WATER));
        this.addSlot(new ResultSlot(inventory, 2, 6, 57));
        this.addSlot(new FuelSlot(inventory, 3, 128, 61));
        this.addSlot(new ResultSlot(inventory, 4, 80, 67));
        
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(propertyDelegate);
    }

    public boolean isCrafting() {
        return propertyDelegate.get(2) > 0;
    }

    public int getScaledLoader() {
        int progress = this.propertyDelegate.get(2);
        int maxProgress = this.propertyDelegate.get(3);
        int loaderSize = 13;

        return maxProgress != 0 && progress != 0 ? progress * loaderSize / maxProgress : 0;
    }

    public int getBurnTime() {
        return this.propertyDelegate.get(0);
    }

    public int getBurnTimeTotal() {
        return this.propertyDelegate.get(1);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);

        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();

            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        int y = 99;
        
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, y + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        int y = 157;
        
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, y));
        }
    }
}
