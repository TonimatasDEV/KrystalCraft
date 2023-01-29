package net.tonimatasdev.krystalcraft.screen;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tonimatasdev.krystalcraft.KrystalCraft;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, KrystalCraft.MOD_ID);

    public static final RegistryObject<MenuType<GemCuttingStationMenu>> GEM_CUTTING_STATION_MENU = registerMenuType(GemCuttingStationMenu::new, "gem_cutting_station_menu");
    public static final RegistryObject<MenuType<CoalCrusherMenu>> COAL_CRUSHER_MENU = registerMenuType(CoalCrusherMenu::new, "coal_crusher_menu");
    public static final RegistryObject<MenuType<CoalCombinerMenu>> COAL_COMBINER_MENU = registerMenuType(CoalCombinerMenu::new, "coal_combiner_menu");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> containerFactory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(containerFactory));
    }
}
