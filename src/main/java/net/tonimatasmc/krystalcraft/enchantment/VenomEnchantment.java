package net.tonimatasmc.krystalcraft.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import javax.annotation.Nullable;
import java.util.Objects;

public class VenomEnchantment extends Enchantment {
    protected VenomEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @SuppressWarnings("unused")
    @Override
    public void doPostAttack(LivingEntity pAttacker, @Nullable Entity pTarget, int pLevel) {
        if (!pAttacker.level.isClientSide()) {
            ServerLevel world = (ServerLevel) pAttacker.level;
            ServerPlayer player = ((ServerPlayer) pAttacker);
            BlockPos position = Objects.requireNonNull(pTarget).blockPosition();

            if (pLevel == 1) {
                LivingEntity entity = (LivingEntity) pTarget;
                entity.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 1));
            }

            if (pLevel == 2) {
                LivingEntity entity = (LivingEntity) pTarget;
                entity.addEffect(new MobEffectInstance(MobEffects.POISON, 120, 2));
            }

            if (pLevel == 3) {
                LivingEntity entity = (LivingEntity) pTarget;
                entity.addEffect(new MobEffectInstance(MobEffects.POISON, 180, 3));
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
