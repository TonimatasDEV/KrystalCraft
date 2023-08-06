package net.tonimatasdev.krystalcraft.networking.packet.messages;

import dev.architectury.networking.NetworkManager;
import earth.terrarium.botarium.common.fluid.base.FluidHolder;
import earth.terrarium.botarium.common.fluid.utils.FluidHooks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.tonimatasdev.krystalcraft.menu.AbstractMachineMenu;

import java.util.List;
import java.util.function.Supplier;

public class ClientboundMachineInfoPacket {
    private final long energyAmount;
    private final List<FluidHolder> fluidHolders;

    public ClientboundMachineInfoPacket(FriendlyByteBuf buf) {
        this(buf.readLong(), buf.readList(buf2 -> FluidHooks.newFluidHolder(BuiltInRegistries.FLUID.get(buf2.readResourceLocation()), buf2.readLong(), null)));

    }

    public ClientboundMachineInfoPacket(long energyAmount, List<FluidHolder> fluidHolders) {
        this.energyAmount = energyAmount;
        this.fluidHolders = fluidHolders;

    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeLong(energyAmount);
        buf.writeCollection(fluidHolders, (buf2, fluid) -> {
            buf2.writeResourceLocation(BuiltInRegistries.FLUID.getKey(fluid.getFluid()));
            buf2.writeLong(fluid.getFluidAmount());
        });
    }

    public void apply(Supplier<NetworkManager.PacketContext> packetContextSupplier) {
        packetContextSupplier.get().queue(() -> {
            Player player = packetContextSupplier.get().getPlayer();

            if (player.containerMenu instanceof AbstractMachineMenu<?> handler) {
                handler.setEnergyAmount(energyAmount);
                handler.setFluids(fluidHolders);
            }
        });
    }
}
