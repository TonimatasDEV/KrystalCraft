package net.tonimatasdev.krystalcraft.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.tonimatasdev.krystalcraft.blockentity.CrushingFactoryBlockEntity;
import net.tonimatasdev.krystalcraft.menu.slots.BatterySlot;
import net.tonimatasdev.krystalcraft.menu.slots.ResultSlot;
import net.tonimatasdev.krystalcraft.menu.slots.UpgradeSlot;
import net.tonimatasdev.krystalcraft.networking.NetworkHandler;
import net.tonimatasdev.krystalcraft.networking.packet.messages.ClientboundMachineInfoPacket;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

import java.util.List;

public class CrushingFactoryMenu extends FactoryMenu<CrushingFactoryBlockEntity> {
    public CrushingFactoryMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (CrushingFactoryBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CrushingFactoryMenu(int syncId, Inventory inventory, CrushingFactoryBlockEntity blockEntity) {
        super(ModMenus.CRUSHING_FACTORY_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, 0),
                        new ResultSlot(blockEntity, 1, 80, 50),
                        new BatterySlot(blockEntity, 2, 129, 41),
                        new UpgradeSlot(blockEntity, 3, 106, -12),
                        new UpgradeSlot(blockEntity, 4, 126, -12)
                });
    }

    @Override
    public void syncClientScreen() {
        super.syncClientScreen();
        NetworkHandler.CHANNEL.sendToPlayer(new ClientboundMachineInfoPacket(machine.energyAmount(), List.of()), player);
    }
}