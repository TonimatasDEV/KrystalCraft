package net.tonimatasmc.krystalcraft.enchantment.enchants;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import javax.annotation.Nullable;
import java.util.Objects;

public class LightningStrikeEnchantment extends Enchantment {
    public LightningStrikeEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @Nullable Entity pTarget, int pLevel) {
        if (!pAttacker.level.isClientSide()) {
            ServerLevel world = (ServerLevel) pAttacker.level;
            ServerPlayer player = ((ServerPlayer) pAttacker);
            BlockPos position = Objects.requireNonNull(pTarget).blockPosition();

            if (pLevel == 1) {
                if( Math.random() <= 0.10 ) {
                    EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
                }
            }

            if (pLevel == 2) {
                if( Math.random() <= 0.20 ) {
                    EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
                }
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
