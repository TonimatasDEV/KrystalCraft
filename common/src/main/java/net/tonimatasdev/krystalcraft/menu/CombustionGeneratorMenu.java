package net.tonimatasdev.krystalcraft.menu;

import earth.terrarium.botarium.util.CommonHooks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.tonimatasdev.krystalcraft.blockentity.CombustionGeneratorBlockEntity;
import net.tonimatasdev.krystalcraft.networking.NetworkHandler;
import net.tonimatasdev.krystalcraft.networking.packet.messages.ClientboundMachineInfoPacket;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

import java.util.List;

public class CombustionGeneratorMenu extends AbstractMachineMenu<CombustionGeneratorBlockEntity> {
    protected DataSlot burnTime;
    protected DataSlot totalBurnTime;

    public CombustionGeneratorMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (CombustionGeneratorBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CombustionGeneratorMenu(int syncId, Inventory inventory, CombustionGeneratorBlockEntity blockEntity) {
        super(ModMenus.COMBUSTION_GENERATOR_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, 0) {
                            @Override
                            public boolean mayPlace(ItemStack itemStack) {
                                return CommonHooks.getBurnTime(itemStack) > 0;
                            }
                        },
                        new Slot(blockEntity, 1, 129, 41)
                });

        this.burnTime = this.addDataSlot(DataSlot.standalone());
        this.totalBurnTime = this.addDataSlot(DataSlot.standalone());
    }

    @Override
    public void syncClientScreen() {
        burnTime.set(machine.getBurnTime());
        totalBurnTime.set(machine.getTotalBurnTime());
        NetworkHandler.CHANNEL.sendToPlayer(new ClientboundMachineInfoPacket(machine.getEnergyStorage().getStoredEnergy(), List.of()), player);
    }

    public int getBurnTime() {
        return burnTime.get();
    }

    public int getTotalBurnTime() {
        return totalBurnTime.get();
    }

    public long getMaxEnergyCapacity() {
        return machine.getEnergyStorage().getMaxCapacity();
    }

    @Override
    public int getPlayerInventoryOffset() {
        return -2;
    }
}