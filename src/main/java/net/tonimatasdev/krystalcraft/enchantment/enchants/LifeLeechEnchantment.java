package net.tonimatasdev.krystalcraft.enchantment.enchants;


import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class LifeLeechEnchantment extends Enchantment {
    public LifeLeechEnchantment() {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity attacker, @Nullable Entity target, int level) {
        if (attacker instanceof ServerPlayer player) {
            player.setHealth(attacker.getHealth() + ((float) level /10));
        }
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}