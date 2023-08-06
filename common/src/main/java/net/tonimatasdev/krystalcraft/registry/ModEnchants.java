package net.tonimatasdev.krystalcraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.enchantment.*;

public class ModEnchants {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(KrystalCraft.MOD_ID, Registries.ENCHANTMENT);

    public static RegistrySupplier<Enchantment> LIGHTNING_STRIKER = ENCHANTMENTS.register("lightning_striker", LightningStrikeEnchantment::new);
    public static RegistrySupplier<Enchantment> VENOM = ENCHANTMENTS.register("venom", VenomEnchantment::new);
    public static RegistrySupplier<Enchantment> LIFE_LEECH = ENCHANTMENTS.register("life_leech", LifeLeechEnchantment::new);
    public static RegistrySupplier<Enchantment> XP_LEECH = ENCHANTMENTS.register("xp_leech", XpLeechEnchantment::new);
    public static RegistrySupplier<Enchantment> FREEZING = ENCHANTMENTS.register("freezing", FreezingEnchantment::new);
}
