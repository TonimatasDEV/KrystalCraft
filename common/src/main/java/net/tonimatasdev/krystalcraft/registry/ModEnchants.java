package net.tonimatasdev.krystalcraft.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.enchantment.*;

@SuppressWarnings("unused")
public class ModEnchants {
    public static final ResourcefulRegistry<Enchantment> ENCHANTMENTS = ResourcefulRegistries.create(BuiltInRegistries.ENCHANTMENT, KrystalCraft.MOD_ID);

    public static RegistryEntry<Enchantment> LIGHTNING_STRIKER = ENCHANTMENTS.register("lightning_striker", LightningStrikeEnchantment::new);
    public static RegistryEntry<Enchantment> VENOM = ENCHANTMENTS.register("venom", VenomEnchantment::new);
    public static RegistryEntry<Enchantment> LIFE_LEECH = ENCHANTMENTS.register("life_leech", LifeLeechEnchantment::new);
    public static RegistryEntry<Enchantment> XP_LEECH = ENCHANTMENTS.register("xp_leech", XpLeechEnchantment::new);
    public static RegistryEntry<Enchantment> FREEZING = ENCHANTMENTS.register("freezing", FreezingEnchantment::new);
}
