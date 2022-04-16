package net.tonimatasmc.krystalcraft.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ModItemTier {
    public static final ForgeTier JADE = new ForgeTier(2, 452, 4f, 1f, 10, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(ModItems.JADE.get()));

    public static final ForgeTier LEAD = new ForgeTier(3, 1800, 7.0F, 0.0F, 6, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(ModItems.LEAD_INGOT.get()));

    public static final ForgeTier TOPAZ = new ForgeTier(3, 782, 5.5F, 0.0F, 28, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(ModItems.TOPAZ.get()));

    public static final ForgeTier SILVER = new ForgeTier(2, 400, 9.0F, 0.0F, 23, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(ModItems.SILVER_INGOT.get()));

    public static final ForgeTier TIN = new ForgeTier(1, 200, 5.0F, 0.0F,8, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(ModItems.TIN_INGOT.get()));

    public static final ForgeTier COPPER = new ForgeTier(1, 200, 5.0F, 0.0F, 8, Tags.Blocks.NEEDS_GOLD_TOOL, () ->
            Ingredient.of(Items.COPPER_INGOT));
}
