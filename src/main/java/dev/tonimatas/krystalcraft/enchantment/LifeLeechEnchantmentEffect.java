package dev.tonimatas.krystalcraft.enchantment;


import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record LifeLeechEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<LifeLeechEnchantmentEffect> CODEC = MapCodec.unit(LifeLeechEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (context.owner() instanceof ServerPlayerEntity player) {
            player.setHealth(player.getHealth() + ((float) level / 10));
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}