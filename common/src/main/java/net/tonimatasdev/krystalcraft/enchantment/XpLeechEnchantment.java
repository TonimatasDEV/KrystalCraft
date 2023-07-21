package net.tonimatasdev.krystalcraft.enchantment;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class XpLeechEnchantment extends Enchantment {
    public XpLeechEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public void doPostAttack(LivingEntity attacker, Entity target, int level) {
        if (attacker instanceof ServerPlayer player) {
            player.giveExperiencePoints(level);
        }
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
}