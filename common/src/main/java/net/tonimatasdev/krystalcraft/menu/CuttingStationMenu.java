package net.tonimatasdev.krystalcraft.menu;

import earth.terrarium.botarium.common.fluid.impl.WrappedBlockFluidContainer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.material.Fluids;
import net.tonimatasdev.krystalcraft.blockentity.CuttingStationBlockEntity;
import net.tonimatasdev.krystalcraft.menu.slots.CombustionSlot;
import net.tonimatasdev.krystalcraft.menu.slots.FluidSlot;
import net.tonimatasdev.krystalcraft.menu.slots.ResultSlot;
import net.tonimatasdev.krystalcraft.networking.NetworkHandler;
import net.tonimatasdev.krystalcraft.networking.packet.messages.ClientboundMachineInfoPacket;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

public class CuttingStationMenu extends StationMenu<CuttingStationBlockEntity> {
    public CuttingStationMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (CuttingStationBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CuttingStationMenu(int syncId, Inventory inventory, CuttingStationBlockEntity blockEntity) {
        super(ModMenus.CUTTING_STATION_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, 0),
                        new ResultSlot(blockEntity, 1, 80, 50),
                        new CombustionSlot(blockEntity, 2, 128, 44),
                        new FluidSlot(blockEntity, 3, 6, 5, Fluids.WATER),
                        new ResultSlot(blockEntity, 4, 6, 40)
                });
    }

    public WrappedBlockFluidContainer getFluidContainer() {
        return machine.getFluidContainer();
    }

    @Override
    public void syncClientScreen() {
        super.syncClientScreen();
        NetworkHandler.CHANNEL.sendToPlayer(new ClientboundMachineInfoPacket(0, getFluidContainer().getFluids()), player);
    }
}