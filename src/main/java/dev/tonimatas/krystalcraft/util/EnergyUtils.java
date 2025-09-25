package dev.tonimatas.krystalcraft.util;

import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleSlotStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.EnergyStorageUtil;

public class EnergyUtils {
    public static long distributeEnergyNearby(EnergyStorage from, World world, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            EnergyStorage energyStorage = EnergyStorage.SIDED.find(world, pos.offset(direction), null);

            if (energyStorage != null) {
                return EnergyStorageUtil.move(from, energyStorage, Long.MAX_VALUE, null);
            }
        }

        return 0;
    }

    public static long moveToItem(BlockEntity blockEntity, EnergyStorage from, int slot) {
        return EnergyStorageUtil.move(from, getStackEnergyStorage(blockEntity, slot), Long.MAX_VALUE, null);
    }

    public static long moveFromItem(BlockEntity blockEntity, EnergyStorage to, int slot) {
        return EnergyStorageUtil.move(getStackEnergyStorage(blockEntity, slot), to, Long.MAX_VALUE, null);
    }

    public static long extractInternal(EnergyStorage energyStorage, long amount) {
        try (Transaction transaction = Transaction.openOuter()) {
            long transferred = energyStorage.extract(amount, transaction);
            transaction.commit();
            return transferred;
        }
    }

    public static long insertInternal(EnergyStorage energyStorage, long amount) {
        try (Transaction transaction = Transaction.openOuter()) {
            long transferred = energyStorage.insert(amount, transaction);
            transaction.commit();
            return transferred;
        }
    }

    public static boolean isEnergyItem(Inventory inventory, int slot, ItemStack stack) {
        InventoryStorage inventoryStorage = InventoryStorage.of(inventory, null);
        SingleSlotStorage<ItemVariant> singleSlotStorage = inventoryStorage.getSlot(slot);
        ContainerItemContext context = ContainerItemContext.ofSingleSlot(singleSlotStorage);
        return EnergyStorage.ITEM.find(stack, context) != null;
    }

    public static EnergyStorage getStackEnergyStorage(BlockEntity blockEntity, int slot) {
        InventoryStorage inventoryStorage = InventoryStorage.of((ImplementedInventory) blockEntity, null);
        SingleSlotStorage<ItemVariant> singleSlotStorage = inventoryStorage.getSlot(slot);
        ContainerItemContext context = ContainerItemContext.ofSingleSlot(singleSlotStorage);

        return EnergyStorage.ITEM.find(singleSlotStorage.getResource().toStack(), context);
    }
}
