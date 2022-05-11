package net.tonimatasmc.krystalcraft.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import javax.annotation.Nullable;
import java.util.Objects;

public class XpLeechEnchantment extends Enchantment {
    protected XpLeechEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
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