package net.tonimatasdev.krystalcraft.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.tonimatasdev.krystalcraft.registry.ItemRegistry;

public class ModItemTier {
    public static final Tier JADE = new Tier(2, 452, 4.0F, 1.0F, 10, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(ItemRegistry.JADE.get())) {
    };

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
}
