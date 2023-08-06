package net.tonimatasdev.krystalcraft.networking;

import dev.architectury.networking.NetworkChannel;
import net.minecraft.resources.ResourceLocation;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.networking.packet.messages.ClientboundMachineInfoPacket;

public class NetworkHandler {
    public static final NetworkChannel CHANNEL = NetworkChannel.create(new ResourceLocation(KrystalCraft.MOD_ID, "main"));

    public static void init() {
        CHANNEL.register(ClientboundMachineInfoPacket.class,
                ClientboundMachineInfoPacket::encode,
                ClientboundMachineInfoPacket::new,
                ClientboundMachineInfoPacket::apply);
    }
}
