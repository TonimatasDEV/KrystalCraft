package net.tonimatasdev.krystalcraft.enchantment.enchants;

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
    public VenomEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @Nullable Entity pTarget, int pLevel) {
        if (!pAttacker.level.isClientSide()) {
            LivingEntity entity = (LivingEntity) pTarget;

            if (pLevel == 1) {
                Objects.requireNonNull(entity).addEffect(new MobEffectInstance(MobEffects.POISON, 60, 1));
            }

            if (pLevel == 2) {
                Objects.requireNonNull(entity).addEffect(new MobEffectInstance(MobEffects.POISON, 120, 2));
            }

            if (pLevel == 3) {
                Objects.requireNonNull(entity).addEffect(new MobEffectInstance(MobEffects.POISON, 180, 3));
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
