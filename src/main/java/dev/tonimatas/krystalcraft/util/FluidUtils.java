package dev.tonimatas.krystalcraft.util;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleSlotStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;

public class FluidUtils {
    public static long extractInternal(SingleSlotStorage<FluidVariant> storage, long amount) {
        try (Transaction transaction = Transaction.openOuter()) {
            long transferred = storage.extract(storage.getResource(), amount, transaction);
            transaction.commit();
            return transferred;
        }
    }

    public static long insertInternal(SingleSlotStorage<FluidVariant> storage, long amount) {
        try (Transaction transaction = Transaction.openOuter()) {
            long transferred = storage.insert(storage.getResource(), amount, transaction);
            transaction.commit();
            return transferred;
        }
    }
}
