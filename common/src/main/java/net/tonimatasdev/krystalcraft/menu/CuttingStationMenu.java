package net.tonimatasdev.krystalcraft.menu;

import earth.terrarium.botarium.util.CommonHooks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.tonimatasdev.krystalcraft.blockentity.CuttingStationBlockEntity;
import net.tonimatasdev.krystalcraft.registry.ModMenus;

public class CuttingStationMenu extends StationMenu<CuttingStationBlockEntity> {
    public CuttingStationMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, (CuttingStationBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CuttingStationMenu(int syncId, Inventory inventory, CuttingStationBlockEntity blockEntity) {
        super(ModMenus.CUTTING_STATION_MENU.get(), syncId, inventory, blockEntity,
                new Slot[]{
                        new Slot(blockEntity, 0, 80, 0),
                        new Slot(blockEntity, 1, 80, 50) {
                            @Override
                            public boolean mayPlace(ItemStack itemStack) {
                                return false;
                            }
                        },
                        new Slot(blockEntity, 2, 128, 44) {
                            @Override
                            public boolean mayPlace(ItemStack itemStack) {
                                return CommonHooks.getBurnTime(itemStack) > 0;
                            }
                        },
                        new Slot(blockEntity, 3, 6, 5) {
                            @Override
                            public boolean mayPlace(ItemStack itemStack) {
                                return itemStack.getItem() == Items.WATER_BUCKET || itemStack.getItem() == Items.BUCKET;
                            }
                        },
                        new Slot(blockEntity, 4, 6, 40) {
                            @Override
                            public boolean mayPlace(ItemStack itemStack) {
                                return false;
                            }
                        }
                });
    }

}