package net.tonimatasdev.krystalcraft.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.tonimatasdev.krystalcraft.registry.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum ModItemTier implements Tier {
    JADE(2, 452, 4.0F, 1.0F, 10, () -> Ingredient.of(ModItems.JADE.get())),
    LEAD(3, 1800, 7.0F, 0.0F, 6, () -> Ingredient.of(ModItems.LEAD_INGOT.get())),
    TOPAZ(3, 782, 5.5F, 0.0F, 28, () -> Ingredient.of(ModItems.TOPAZ.get())),
    SILVER(2, 400, 6.0F, 0.0F, 23, () -> Ingredient.of(ModItems.SILVER_INGOT.get())),
    TIN(1, 200, 5.0F, 0.0F, 8, () -> Ingredient.of(ModItems.TIN_INGOT.get())),
    COPPER(1, 200, 5.0F, 0.0F, 8, () -> Ingredient.of(Items.COPPER_INGOT)),
    PLATINUM(4, 2300, 8.0F, 0.0F, 56, () -> Ingredient.of(ModItems.PLATINUM_INGOT.get())),
    SAPPHIRE(3, 755, 6.2F, 2.0F, 15, () -> Ingredient.of(ModItems.SAPPHIRE.get())),
    RUBY(3, 420, 4.2F, 2.0F, 70, () -> Ingredient.of(ModItems.RUBY.get())),
    BRONZE(2, 380, 5.2F, 0.0F, 80, () -> Ingredient.of(ModItems.BRONZE_INGOT.get()));

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
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamageBonus;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }
}

/*

    public static final ForgeTier LEAD = new ForgeTier(3, 1800, 7.0F, 0.0F, 6, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(ItemRegistry.LEAD_INGOT.get()));

    public static final ForgeTier TOPAZ = new ForgeTier(3, 782, 5.5F, 0.0F, 28, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(ItemRegistry.TOPAZ.get()));

    public static final ForgeTier SILVER = new ForgeTier(2, 400, 6.0F, 0.0F, 23, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(ItemRegistry.SILVER_INGOT.get()));

    public static final ForgeTier TIN = new ForgeTier(1, 200, 5.0F, 0.0F, 8, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(ItemRegistry.TIN_INGOT.get()));

    public static final ForgeTier COPPER = new ForgeTier(1, 200, 5.0F, 0.0F, 8, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(Items.COPPER_INGOT));

    public static final ForgeTier PLATINUM = new ForgeTier(4, 2300, 8.0F, 0.0F, 56, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(ItemRegistry.PLATINUM_INGOT.get()));

    public static final ForgeTier SAPPHIRE = new ForgeTier(3, 755, 6.2F, 2.0F, 15, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(ItemRegistry.SAPPHIRE.get()));

    public static final ForgeTier RUBY = new ForgeTier(3, 420, 4.2F, 2.0F, 70, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(ItemRegistry.RUBY.get()));

    public static final ForgeTier BRONZE = new ForgeTier(2, 380, 5.2F, 0.0F, 80, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(ItemRegistry.BRONZE_INGOT.get()));
 */
