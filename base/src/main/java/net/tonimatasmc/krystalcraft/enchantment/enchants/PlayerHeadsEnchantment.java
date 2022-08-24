package net.tonimatasmc.krystalcraft.enchantment.enchants;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import javax.annotation.Nullable;

public class PlayerHeadsEnchantment extends Enchantment {
    public PlayerHeadsEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @Nullable Entity pTarget, int pLevel) {
        if (!pAttacker.level.isClientSide()) {

            if (pLevel == 1) {
                if (!(pTarget instanceof Player)) {
                    ItemStack stack = new ItemStack(Items.PLAYER_HEAD, 1);
                    assert pTarget != null;

                    stack.getOrCreateTag().putString("SkullOwner", pTarget.getName().toString());

                }
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}