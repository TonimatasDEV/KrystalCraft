package net.tonimatasdev.krystalcraft.enchantment.enchants;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class FreezingEnchantment extends Enchantment {
    public FreezingEnchantment() {
        super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity attacker, @Nullable Entity target, int level) {
        if (target instanceof LivingEntity entity) {
            entity.setTicksFrozen(30 * level);
        }
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}