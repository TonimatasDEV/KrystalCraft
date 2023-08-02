package net.tonimatasdev.krystalcraft.networking;

import com.teamresourceful.resourcefullib.common.networking.NetworkChannel;
import com.teamresourceful.resourcefullib.common.networking.base.NetworkDirection;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.networking.packet.messages.ClientboundMachineInfoPacket;

public class NetworkHandler {
    public static final NetworkChannel CHANNEL = new NetworkChannel(KrystalCraft.MOD_ID, 0, "main");

    public static void init() {
        CHANNEL.registerPacket(NetworkDirection.SERVER_TO_CLIENT, ClientboundMachineInfoPacket.ID, ClientboundMachineInfoPacket.HANDLER, ClientboundMachineInfoPacket.class);
    }
}
