package net.tonimatasdev.krystalcraft.enchantment.enchants;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import javax.annotation.Nullable;

public class FreezingEnchantment extends Enchantment {
    public FreezingEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @Nullable Entity pTarget, int pLevel) {
        if (!pAttacker.level.isClientSide()) {
            if (pLevel == 1) {
                if (pTarget instanceof LivingEntity eTarget) {
                    eTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, true, true));
                }
            }

            if (pLevel == 2) {
                if (pTarget instanceof LivingEntity eTarget) {
                    eTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, true, true));
                }
            }

            if (pLevel == 3) {
                if (pTarget instanceof LivingEntity eTarget) {
                    eTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2, true, true));
                }
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}