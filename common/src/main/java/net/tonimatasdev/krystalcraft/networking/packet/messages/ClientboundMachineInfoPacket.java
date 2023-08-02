package net.tonimatasdev.krystalcraft.networking.packet.messages;

import com.teamresourceful.resourcefullib.common.networking.base.Packet;
import com.teamresourceful.resourcefullib.common.networking.base.PacketContext;
import com.teamresourceful.resourcefullib.common.networking.base.PacketHandler;
import earth.terrarium.botarium.common.fluid.base.FluidHolder;
import earth.terrarium.botarium.common.fluid.utils.FluidHooks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.menu.AbstractMachineMenu;

import java.util.List;

public record ClientboundMachineInfoPacket(long energy, List<FluidHolder> fluidHolders) implements Packet<ClientboundMachineInfoPacket> {

    public static final ResourceLocation ID = new ResourceLocation(KrystalCraft.MOD_ID, "machine_info");
    public static final Handler HANDLER = new Handler();

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public PacketHandler<ClientboundMachineInfoPacket> getHandler() {
        return HANDLER;
    }

    private static class Handler implements PacketHandler<ClientboundMachineInfoPacket> {
        @Override
        public void encode(ClientboundMachineInfoPacket packet, FriendlyByteBuf buf) {
            buf.writeLong(packet.energy());
            buf.writeCollection(packet.fluidHolders, (buf2, fluid) -> {
                buf2.writeResourceLocation(BuiltInRegistries.FLUID.getKey(fluid.getFluid()));
                buf2.writeLong(fluid.getFluidAmount());
            });
        }

        @Override
        public ClientboundMachineInfoPacket decode(FriendlyByteBuf buf) {
            return new ClientboundMachineInfoPacket(buf.readLong(), buf.readList(buf2 -> FluidHooks.newFluidHolder(BuiltInRegistries.FLUID.get(buf2.readResourceLocation()), buf2.readLong(), null)));
        }

        @Override
        public PacketContext handle(ClientboundMachineInfoPacket packet) {
            return (player, level) -> {
                if (player.containerMenu instanceof AbstractMachineMenu<?> handler) {
                    handler.setEnergyAmount(packet.energy());
                    handler.setFluids(packet.fluidHolders);
                }
            };
        }
    }
}
