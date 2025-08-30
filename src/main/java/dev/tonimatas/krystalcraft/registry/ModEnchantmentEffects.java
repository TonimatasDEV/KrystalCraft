package dev.tonimatas.krystalcraft.registry;

import com.mojang.serialization.MapCodec;
import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.enchantment.*;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> FREEZING = registerEntityEffect("freezing", FreezingEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING_STRIKER = registerEntityEffect("lightning_striker", LightningStrikeEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> VENOM = registerEntityEffect("venom", VenomEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> LIFE_LEECH = registerEntityEffect("life_leech", LifeLeechEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> XP_LEECH = registerEntityEffect("xp_leech", XpLeechEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name, MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(KrystalCraft.MOD_ID, name), codec);
    }
    
    public static void initialize() {
        // 
    }
}
