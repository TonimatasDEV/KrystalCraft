package net.tonimatasdev.krystalcraft.enchantment.enchants;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LightningStrikeEnchantment extends Enchantment {
    public LightningStrikeEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity attacker, @Nullable Entity target, int level) {
        if (target == null) return;
        if (Math.random() <= ((double) level/10)) return;
        EntityType.LIGHTNING_BOLT.spawn((ServerLevel) attacker.level(), target.getOnPos(), MobSpawnType.TRIGGERED);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
