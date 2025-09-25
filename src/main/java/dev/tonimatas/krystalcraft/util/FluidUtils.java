package dev.tonimatas.krystalcraft.util;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleSlotStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.collection.DefaultedList;

public class FluidUtils {
    public static long extractInternal(SingleSlotStorage<FluidVariant> storage, long amount) {
        try (Transaction transaction = Transaction.openOuter()) {
            long transferred = storage.extract(storage.getResource(), amount, transaction);
            transaction.commit();
            return transferred;
        }
    }

    public static long insertInternal(SingleSlotStorage<FluidVariant> storage, long amount) {
        return insertInternalWithVariant(storage.getResource(), storage, amount);
    }

    public static long insertInternalWithVariant(FluidVariant fluidVariant, SingleSlotStorage<FluidVariant> storage, long amount) {
        try (Transaction transaction = Transaction.openOuter()) {
            long transferred = storage.insert(fluidVariant, amount, transaction);
            transaction.commit();
            return transferred;
        }
    }

    public static void tryBucketTransfer(DefaultedList<ItemStack> inventory, int inputSlot, int outputSlot, SingleVariantStorage<FluidVariant> fluidStorage) {
        ItemStack inputStack = inventory.get(inputSlot);
        ItemStack outputStack = inventory.get(outputSlot);

        if (inputStack.isOf(Items.BUCKET)) {
            if (fluidStorage.getAmount() >= 1000 && outputStack.isEmpty()) {
                inputStack.setCount(inputStack.getCount() - 1);
                inventory.set(inputSlot, inputStack);
                inventory.set(outputSlot, new ItemStack(Items.WATER_BUCKET));
                extractInternal(fluidStorage, 1000);
            }
        } else if (inputStack.isOf(Items.WATER_BUCKET)) {
            if (fluidStorage.getCapacity() - fluidStorage.getAmount() < 1000) return;

            if (outputStack.isEmpty() || (outputStack.isOf(Items.BUCKET) && outputStack.getCount() < 16)) {
                inventory.set(inputSlot, ItemStack.EMPTY);
                inventory.set(outputSlot, new ItemStack(Items.BUCKET, outputStack.getCount() + 1));
                insertInternalWithVariant(FluidVariant.of(Fluids.WATER), fluidStorage, 1000);
            }
        }
    }
}
