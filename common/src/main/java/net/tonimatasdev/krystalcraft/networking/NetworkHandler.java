package net.tonimatasdev.krystalcraft.networking;

import dev.tonimatas.mythlib.networking.NetworkChannel;
import dev.tonimatas.mythlib.networking.NetworkDirection;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.networking.packet.messages.ClientboundMachineInfoPacket;

public class NetworkHandler {
    public static final NetworkChannel CHANNEL = new NetworkChannel(KrystalCraft.MOD_ID, "main");

    public static void init() {
        CHANNEL.registerPacket(NetworkDirection.SERVER_TO_CLIENT, ClientboundMachineInfoPacket.ID, ClientboundMachineInfoPacket.HANDLER, ClientboundMachineInfoPacket.class);
    }
}
