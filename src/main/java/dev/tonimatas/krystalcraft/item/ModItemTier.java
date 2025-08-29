package dev.tonimatas.krystalcraft.item;

import dev.tonimatas.krystalcraft.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum ModItemTier implements ToolMaterial {
    JADE(2, 452, 4.0F, 1.0F, 10, () -> Ingredient.ofItems(ModItems.JADE)),
    LEAD(3, 1800, 7.0F, 0.0F, 6, () -> Ingredient.ofItems(ModItems.LEAD_INGOT)),
    TOPAZ(3, 782, 5.5F, 0.0F, 28, () -> Ingredient.ofItems(ModItems.TOPAZ)),
    SILVER(2, 400, 6.0F, 0.0F, 23, () -> Ingredient.ofItems(ModItems.SILVER_INGOT)),
    TIN(1, 200, 5.0F, 0.0F, 8, () -> Ingredient.ofItems(ModItems.TIN_INGOT)),
    COPPER(1, 200, 5.0F, 0.0F, 8, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    PLATINUM(4, 2300, 8.0F, 0.0F, 56, () -> Ingredient.ofItems(ModItems.PLATINUM_INGOT)),
    SAPPHIRE(3, 755, 6.2F, 2.0F, 15, () -> Ingredient.ofItems(ModItems.SAPPHIRE)),
    RUBY(3, 420, 4.2F, 2.0F, 70, () -> Ingredient.ofItems(ModItems.RUBY)),
    BRONZE(2, 380, 5.2F, 0.0F, 80, () -> Ingredient.ofItems(ModItems.BRONZE_INGOT));

    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int level;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    ModItemTier(int level, int uses, float speed, float attackDamageBonus, int enchantmentValue, @NotNull Supplier<Ingredient> repairIngredient) {
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.level = level;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }
    
    @Override
    public int getDurability() {
        return uses;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return speed;
    }

    @Override
    public float getAttackDamage() {
        return attackDamageBonus;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return null;
    }

    @Override
    public int getEnchantability() {
        return enchantmentValue;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return repairIngredient;
    }
}
