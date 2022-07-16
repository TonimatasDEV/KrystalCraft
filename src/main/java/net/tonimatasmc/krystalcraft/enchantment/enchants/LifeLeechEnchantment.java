package net.tonimatasmc.krystalcraft.enchantment.enchants;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import javax.annotation.Nullable;

public class LifeLeechEnchantment extends Enchantment {
    public LifeLeechEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @Nullable Entity pTarget, int pLevel) {
        if (!pAttacker.level.isClientSide()) {
            if (pLevel == 1) {
                float health = pAttacker.getHealth();
                pAttacker.setHealth((float) (health + 0.1));
            }

            if (pLevel == 2) {
                float health = pAttacker.getHealth();
                pAttacker.setHealth((float) (health + 0.2));
            }

            if (pLevel == 3) {
                float health = pAttacker.getHealth();
                pAttacker.setHealth((float) (health + 0.3));
            }

            if (pLevel == 4) {
                float health = pAttacker.getHealth();
                pAttacker.setHealth((float) (health + 0.4));
            }

            if (pLevel == 5) {
                float health = pAttacker.getHealth();
                pAttacker.setHealth((float) (health + 0.5));
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
}