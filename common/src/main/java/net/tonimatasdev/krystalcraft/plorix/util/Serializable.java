package net.tonimatasdev.krystalcraft.plorix.util;

import net.minecraft.nbt.CompoundTag;

public interface Serializable {
    void deserialize(CompoundTag nbt);

    CompoundTag serialize(CompoundTag nbt);
}
