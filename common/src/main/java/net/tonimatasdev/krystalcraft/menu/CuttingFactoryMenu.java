package net.tonimatasdev.krystalcraft.menu;

import earth.terrarium.botarium.common.fluid.impl.WrappedBlockFluidContainer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.material.Fluids;
import net.tonimatasdev.krystalcraft.blockentity.CuttingFactoryBlockEntity;
import net.tonimatasdev.krystalcraft.menu.slots.BatterySlot;
import net.tonimatasdev.krystalcraft.menu.slots.FluidSlot;
import net.tonimatasdev.krystalcraft.menu.slots.ResultSlot;
import net.tonimatasdev.krystalcraft.menu.slots.UpgradeSlot;
import net.tonimatasdev.krystalcraft.networking.NetworkHandler;
import net.tonimatasdev.krystalcraft.networking.packet.messages.ClientboundMachineInfoPacket;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

public class CuttingFactoryMenu extends FactoryMenu<CuttingFactoryBlockEntity> {
    public CuttingFactoryMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (CuttingFactoryBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CuttingFactoryMenu(int syncId, Inventory inventory, CuttingFactoryBlockEntity blockEntity) {
        super(ModMenus.CUTTING_FACTORY_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, 0),
                        new ResultSlot(blockEntity, 1, 80, 50),
                        new BatterySlot(blockEntity, 2, 129, 41),
                        new UpgradeSlot(blockEntity, 3, 106, -12),
                        new UpgradeSlot(blockEntity, 4, 126, -12),
                        new FluidSlot(blockEntity, 5, 6, 5, Fluids.WATER),
                        new ResultSlot(blockEntity, 6, 6, 40)
                });
    }

    public WrappedBlockFluidContainer getFluidContainer() {
        return machine.getFluidContainer();
    }

    @Override
    public void syncClientScreen() {
        super.syncClientScreen();
        NetworkHandler.CHANNEL.sendToPlayer(new ClientboundMachineInfoPacket(machine.energyAmount(), getFluidContainer().getFluids()), player);
    }
}