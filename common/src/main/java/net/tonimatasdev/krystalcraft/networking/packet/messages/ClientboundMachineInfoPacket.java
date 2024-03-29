package net.tonimatasdev.krystalcraft.networking.packet.messages;

import dev.tonimatas.mythlib.fluid.base.FluidHolder;
import dev.tonimatas.mythlib.fluid.util.FluidUtils;
import dev.tonimatas.mythlib.networking.Packet;
import dev.tonimatas.mythlib.networking.PacketContext;
import dev.tonimatas.mythlib.networking.PacketHandler;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.menu.AbstractMachineMenu;

import java.util.List;

public record ClientboundMachineInfoPacket(long energy, List<FluidHolder> fluidHolders) implements Packet<ClientboundMachineInfoPacket> {
    public static final ResourceLocation ID = new ResourceLocation(KrystalCraft.MOD_ID, "machine_info");
    public static final PacketHandler<ClientboundMachineInfoPacket> HANDLER = new PacketHandler<>() {
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
            return new ClientboundMachineInfoPacket(buf.readLong(), buf.readList(buf2 -> FluidUtils.newFluidHolder(BuiltInRegistries.FLUID.get(buf2.readResourceLocation()), buf2.readLong(), null)));
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
    };

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public PacketHandler<ClientboundMachineInfoPacket> getHandler() {
        return HANDLER;
    }
}
