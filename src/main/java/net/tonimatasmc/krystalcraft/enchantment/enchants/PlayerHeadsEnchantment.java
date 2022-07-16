package net.tonimatasmc.krystalcraft.enchantment.enchants;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import javax.annotation.Nullable;
import java.util.Objects;

public class PlayerHeadsEnchantment extends Enchantment {
    public PlayerHeadsEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @Nullable Entity pTarget, int pLevel) {
        if (!pAttacker.level.isClientSide()) {
            BlockPos position = Objects.requireNonNull(pTarget).blockPosition();

            if (pLevel == 1) {
                if (!(pTarget instanceof Player)) {
                    ItemStack stack = new ItemStack(Items.PLAYER_HEAD, 1);
                    stack.getOrCreateTag().putString("SkullOwner", pTarget.getName().toString());

                    ItemEntity itementity = new ItemEntity(pTarget.level, position.getX(), position.getY(), position.getZ(), stack);
                }
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}