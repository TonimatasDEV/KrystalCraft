package net.tonimatasdev.krystalcraft.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.tonimatasdev.krystalcraft.blockentity.CombiningFactoryBlockEntity;
import net.tonimatasdev.krystalcraft.item.custom.UpgradeItem;
import net.tonimatasdev.krystalcraft.networking.NetworkHandler;
import net.tonimatasdev.krystalcraft.networking.packet.messages.ClientboundMachineInfoPacket;
import net.tonimatasdev.krystalcraft.registry.ModItems;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

import java.util.List;

public class CombiningFactoryMenu extends FactoryMenu<CombiningFactoryBlockEntity> {
    public CombiningFactoryMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (CombiningFactoryBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CombiningFactoryMenu(int syncId, Inventory inventory, CombiningFactoryBlockEntity blockEntity) {
        super(ModMenus.COMBINING_FACTORY_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, -8),
                        new Slot(blockEntity, 1, 80, 9),
                        new Slot(blockEntity, 2, 80, 50) {
                            @Override
                            public boolean mayPlace(ItemStack itemStack) {
                                return false;
                            }
                        },
                        new Slot(blockEntity, 3, 129, 41) {
                            @Override
                            public boolean mayPlace(ItemStack itemStack) {
                                return itemStack.getItem() == ModItems.BATTERY.get();
                            }
                        },
                        new Slot(blockEntity, 4, 106, -12) {
                            @Override
                            public boolean mayPlace(ItemStack itemStack) {
                                return itemStack.getItem() instanceof UpgradeItem;
                            }
                        },
                        new Slot(blockEntity, 5, 126, -12) {
                            @Override
                            public boolean mayPlace(ItemStack itemStack) {
                                return itemStack.getItem() instanceof UpgradeItem;
                            }
                        }
                });
    }

    @Override
    public void syncClientScreen() {
        super.syncClientScreen();
        NetworkHandler.CHANNEL.sendToPlayer(new ClientboundMachineInfoPacket(machine.getEnergyStorage().getStoredEnergy(), List.of()), player);
    }
}