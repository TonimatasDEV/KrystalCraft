package net.tonimatasdev.krystalcraft.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.enchantment.enchants.*;

@SuppressWarnings("unused")
public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, KrystalCraft.MOD_ID);

    public static RegistryObject<Enchantment> LIGHTNING_STRIKER = ENCHANTMENTS.register("lightning_striker", LightningStrikeEnchantment::new);
    public static RegistryObject<Enchantment> VENOM = ENCHANTMENTS.register("venom", VenomEnchantment::new);
    public static RegistryObject<Enchantment> LIFE_LEECH = ENCHANTMENTS.register("life_leech", LifeLeechEnchantment::new);
    public static RegistryObject<Enchantment> XP_LEECH = ENCHANTMENTS.register("xp_leech", XpLeechEnchantment::new);
    public static RegistryObject<Enchantment> FREEZING = ENCHANTMENTS.register("freezing", FreezingEnchantment::new);

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
