package net.tonimatasdev.krystalcraft.plorix.networking.fabric;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.tonimatasdev.krystalcraft.plorix.networking.Packet;
import net.tonimatasdev.krystalcraft.plorix.networking.PacketHandler;

import java.util.function.BooleanSupplier;

public class PacketChannelHelperImpl {
    public static void registerChannel(ResourceLocation channel, int protocolVersion, BooleanSupplier optional) {
    }

    public static <T extends Packet<T>> void registerS2CPacket(ResourceLocation channel, ResourceLocation id, PacketHandler<T> handler, Class<T> packetClass) {
        if (FabricLoader.getInstance().getEnvironmentType().equals(EnvType.CLIENT))
            FabricClientPacketHelper.clientOnlyRegister(createChannelLocation(channel, id), handler);
    }

    public static <T extends Packet<T>> void registerC2SPacket(ResourceLocation channel, ResourceLocation id, PacketHandler<T> handler, Class<T> packetClass) {
        ServerPlayNetworking.registerGlobalReceiver(createChannelLocation(channel, id), (server, player, handler1, buf, responseSender) -> {
            T decode = handler.decode(buf);
            server.execute(() -> handler.handle(decode).apply(player, player.level()));
        });
    }

    public static <T extends Packet<T>> void sendToServer(ResourceLocation channel, T packet) {
        if (FabricLoader.getInstance().getEnvironmentType().equals(EnvType.CLIENT))
            FabricClientPacketHelper.sendToServerClientOnly(channel, packet);
    }

    public static <T extends Packet<T>> void sendToPlayer(ResourceLocation channel, T packet, Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
            packet.getHandler().encode(packet, buf);
            ServerPlayNetworking.send(serverPlayer, createChannelLocation(channel, packet.getId()), buf);
        }
    }

    private static ResourceLocation createChannelLocation(ResourceLocation channel, ResourceLocation id) {
        return new ResourceLocation(channel.getNamespace(), channel.getPath() + "/" + id.getNamespace() + "/" + id.getPath());
    }

    public static boolean canSendPlayerPackets(ResourceLocation channel, Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            for (ResourceLocation location : ServerPlayNetworking.getSendable(serverPlayer.connection)) {
                if (location.getNamespace().equals(channel.getNamespace()) && location.getPath().startsWith(channel.getPath())) {
                    return true;
                }
            }
        }
        return false;
    }

}
