package dev.tonimatas.krystalcraft.util;

import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleSlotStorage;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.EnergyStorageUtil;

public class EnergyUtils {
    public static void distributeEnergyNearby(EnergyStorage energyStorage, World world, BlockPos pos) {
        EnergyStorageUtil.move(energyStorage, EnergyStorage.SIDED.find(world, pos.up(), null), Long.MAX_VALUE, null);
    }
    
    public static void moveToItem(BlockEntity blockEntity, EnergyStorage energyStorage, int slot) {
        InventoryStorage inventoryStorage = InventoryStorage.of((ImplementedInventory) blockEntity, null);
        SingleSlotStorage<ItemVariant> singleSlotStorage = inventoryStorage.getSlot(slot);
        ContainerItemContext context = ContainerItemContext.ofSingleSlot(singleSlotStorage);

        EnergyStorageUtil.move(energyStorage,  EnergyStorage.ITEM.find(singleSlotStorage.getResource().toStack(), context), Long.MAX_VALUE, null);
    }
    
    public static boolean isEnergyItem(Inventory inventory, int slot, ItemStack stack) {
        InventoryStorage inventoryStorage = InventoryStorage.of(inventory, null);
        SingleSlotStorage<ItemVariant> singleSlotStorage = inventoryStorage.getSlot(slot);
        ContainerItemContext context = ContainerItemContext.ofSingleSlot(singleSlotStorage);
        return EnergyStorage.ITEM.find(stack, context) != null;
    }
}
