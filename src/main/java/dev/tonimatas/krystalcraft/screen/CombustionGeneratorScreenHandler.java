package dev.tonimatas.krystalcraft.screen;

import dev.tonimatas.krystalcraft.block.entity.CombustionGeneratorBlockEntity;
import dev.tonimatas.krystalcraft.registry.ModScreenHandlers;
import dev.tonimatas.krystalcraft.screen.slots.EnergySlot;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

public class CombustionGeneratorScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final CombustionGeneratorBlockEntity blockEntity;
    
    public CombustionGeneratorScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(pos), new ArrayPropertyDelegate(2));
    }
    
    public CombustionGeneratorScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate propertyDelegate) {
        super(ModScreenHandlers.COMBUSTION_GENERATOR_SCREEN_HANDLER, syncId);
        this.inventory = (Inventory) blockEntity;
        this.blockEntity = (CombustionGeneratorBlockEntity) blockEntity;
        this.propertyDelegate = propertyDelegate;

        this.addSlot(new Slot(inventory, 0, 80, 17));
        this.addSlot(new EnergySlot(inventory, 1, 129, 58));
        
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
        
        addProperties(propertyDelegate);
    }
    
    public boolean isBurning() {
        return propertyDelegate.get(0) > 0;
    }

    public int getScaledLoader() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int loaderSize = 13;

        return maxProgress != 0 && progress != 0 ?  progress * loaderSize / maxProgress : 0;
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
