package dev.tonimatas.krystalcraft.registry;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    JADE(BlockTags.INCORRECT_FOR_IRON_TOOL, 452, 4.0F, 1.0F, 10, () -> Ingredient.ofItems(ModItems.JADE)),
    LEAD(BlockTags.INCORRECT_FOR_IRON_TOOL, 1800, 7.0F, 0.0F, 6, () -> Ingredient.ofItems(ModItems.LEAD_INGOT)),
    TOPAZ(BlockTags.INCORRECT_FOR_IRON_TOOL, 782, 5.5F, 0.0F, 28, () -> Ingredient.ofItems(ModItems.TOPAZ)),
    SILVER(BlockTags.INCORRECT_FOR_STONE_TOOL, 400, 6.0F, 0.0F, 23, () -> Ingredient.ofItems(ModItems.SILVER_INGOT)),
    TIN(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 200, 5.0F, 0.0F, 8, () -> Ingredient.ofItems(ModItems.TIN_INGOT)),
    COPPER(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 200, 5.0F, 0.0F, 8, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    PLATINUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2300, 8.0F, 0.0F, 56, () -> Ingredient.ofItems(ModItems.PLATINUM_INGOT)),
    SAPPHIRE(BlockTags.INCORRECT_FOR_IRON_TOOL, 755, 6.2F, 2.0F, 15, () -> Ingredient.ofItems(ModItems.SAPPHIRE)),
    RUBY(BlockTags.INCORRECT_FOR_IRON_TOOL, 420, 4.2F, 2.0F, 70, () -> Ingredient.ofItems(ModItems.RUBY)),
    BRONZE(BlockTags.INCORRECT_FOR_STONE_TOOL, 380, 5.2F, 0.0F, 80, () -> Ingredient.ofItems(ModItems.BRONZE_INGOT));

    private final TagKey<Block> inverseTag;
    private final int durability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(TagKey<Block> inverseTag, int durability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }
    
    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
