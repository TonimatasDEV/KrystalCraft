package net.tonimatasdev.krystalcraft.plorix.networking;

import net.minecraft.resources.ResourceLocation;

public interface Packet<T extends Packet<T>> {
    ResourceLocation getId();

    PacketHandler<T> getHandler();
}
