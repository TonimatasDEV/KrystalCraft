package net.tonimatasdev.krystalcraft.enchantment.enchants;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import javax.annotation.Nullable;

public class XpLeechEnchantment extends Enchantment {
    public XpLeechEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @Nullable Entity pTarget, int pLevel) {
        if (!pAttacker.level.isClientSide()) {
            ServerPlayer player = ((ServerPlayer) pAttacker);

            if (pLevel == 1) {
                player.giveExperiencePoints(1);
            }

            if (pLevel == 2) {
                player.giveExperiencePoints(2);
            }

            if (pLevel == 3) {
                player.giveExperiencePoints(3);
            }

            if (pLevel == 4) {
                player.giveExperiencePoints(4);
            }

            if (pLevel == 5) {
                player.giveExperiencePoints(5);
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
}