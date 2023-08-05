package net.tonimatasdev.krystalcraft.menu;

import earth.terrarium.botarium.common.fluid.impl.WrappedBlockFluidContainer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.tonimatasdev.krystalcraft.blockentity.CuttingFactoryBlockEntity;
import net.tonimatasdev.krystalcraft.item.custom.UpgradeItem;
import net.tonimatasdev.krystalcraft.networking.NetworkHandler;
import net.tonimatasdev.krystalcraft.networking.packet.messages.ClientboundMachineInfoPacket;
import net.tonimatasdev.krystalcraft.registry.ModItems;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

public class CuttingFactoryMenu extends FactoryMenu<CuttingFactoryBlockEntity> {
    public CuttingFactoryMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (CuttingFactoryBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CuttingFactoryMenu(int syncId, Inventory inventory, CuttingFactoryBlockEntity blockEntity) {
        super(ModMenus.CUTTING_FACTORY_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, 0),
                        new Slot(blockEntity, 1, 80, 50) {
                            @Override
                            public boolean mayPlace(ItemStack itemStack) {
                                return false;
                            }
                        },
                        new Slot(blockEntity, 2, 129, 41) {
                            @Override
                            public boolean mayPlace(ItemStack itemStack) {
                                return itemStack.getItem() == ModItems.BATTERY.get();
                            }
                        },
                        new Slot(blockEntity, 3, 106, -12) {
                            @Override
                            public boolean mayPlace(ItemStack itemStack) {
                                return itemStack.getItem() instanceof UpgradeItem;
                            }
                        },
                        new Slot(blockEntity, 4, 126, -12) {
                            @Override
                            public boolean mayPlace(ItemStack itemStack) {
                                return itemStack.getItem() instanceof UpgradeItem;
                            }
                        },
                        new Slot(blockEntity, 5, 6, 5) {
                            @Override
                            public boolean mayPlace(ItemStack itemStack) {
                                return itemStack.getItem() == Items.WATER_BUCKET || itemStack.getItem() == Items.BUCKET;
                            }
                        },
                        new Slot(blockEntity, 6, 6, 40) {
                            @Override
                            public boolean mayPlace(ItemStack itemStack) {
                                return false;
                            }
                        }
                });
    }

    public WrappedBlockFluidContainer getFluidContainer() {
        return machine.getFluidContainer();
    }

    @Override
    public void syncClientScreen() {
        super.syncClientScreen();
        NetworkHandler.CHANNEL.sendToPlayer(new ClientboundMachineInfoPacket(machine.getEnergyStorage().getStoredEnergy(), getFluidContainer().getFluids()), this.player);
    }
}