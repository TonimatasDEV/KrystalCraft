package net.tonimatasdev.krystalcraft.plorix.networking.fabric;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.tonimatasdev.krystalcraft.plorix.networking.Packet;
import net.tonimatasdev.krystalcraft.plorix.networking.PacketHandler;

@Environment(EnvType.CLIENT)
public class FabricClientPacketHelper {

    @Environment(EnvType.CLIENT)
    public static <T extends Packet<T>> void clientOnlyRegister(ResourceLocation location, PacketHandler<T> handler) {
        ClientPlayNetworking.registerGlobalReceiver(location, (client, handler1, buf, responseSender) -> {
            T decode = handler.decode(buf);
            client.execute(() -> handler.handle(decode).apply(client.player, client.level));
        });
    }

    @Environment(EnvType.CLIENT)
    public static <T extends Packet<T>> void sendToServerClientOnly(ResourceLocation channel, T packet) {
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        packet.getHandler().encode(packet, buf);
        ClientPlayNetworking.send(createChannelLocation(channel, packet.getId()), buf);
    }

    private static ResourceLocation createChannelLocation(ResourceLocation channel, ResourceLocation id) {
        return new ResourceLocation(channel.getNamespace(), channel.getPath() + "/" + id.getNamespace() + "/" + id.getPath());
    }
}
