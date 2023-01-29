package net.tonimatasdev.krystalcraft.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.block.ModBlocks;
import net.tonimatasdev.krystalcraft.item.ModItems;
import net.tonimatasdev.krystalcraft.util.ModTags;
import net.tonimatasdev.krystalcraft.util.RecipeProviderUtils;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static Consumer<FinishedRecipe> finishedConsumer;

    public ModRecipeProvider(DataGenerator generator) {
        super(generator.getPackOutput());
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pFinishedConsumer) {
        finishedConsumer = pFinishedConsumer;

        itemBlasting(ModTags.Items.LEAD_RAW_MATERIAL, ModItems.LEAD_INGOT.get(), "lead_ingot");
        itemBlasting(ModTags.Items.PLATINUM_RAW_MATERIAL, ModItems.PLATINUM_INGOT.get(), "platinum_ingot");
        itemBlasting(ModTags.Items.SILVER_RAW_MATERIAL, ModItems.SILVER_INGOT.get(), "silver_ingot");
        itemBlasting(ModTags.Items.TIN_RAW_MATERIAL, ModItems.TIN_INGOT.get(), "tin_ingot");

        RecipeProviderUtils.createResourceKit(ModTags.Items.BRONZE_INGOT, "bronze",
                ModItems.BRONZE_SWORD.get(),
                ModItems.BRONZE_PICKAXE.get(),
                ModItems.BRONZE_AXE.get(),
                ModItems.BRONZE_SHOVEL.get(),
                ModItems.BRONZE_HOE.get(),
                ModItems.BRONZE_HELMET.get(),
                ModItems.BRONZE_CHESTPLATE.get(),
                ModItems.BRONZE_LEGGINGS.get(),
                ModItems.BRONZE_BOOTS.get(),
                ModBlocks.BRONZE_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.BRONZE_INGOT).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(ModTags.Items.JADE_GEM, "jade",
                ModItems.JADE_SWORD.get(),
                ModItems.JADE_PICKAXE.get(),
                ModItems.JADE_AXE.get(),
                ModItems.JADE_SHOVEL.get(),
                ModItems.JADE_HOE.get(),
                ModItems.JADE_HELMET.get(),
                ModItems.JADE_CHESTPLATE.get(),
                ModItems.JADE_LEGGINGS.get(),
                ModItems.JADE_BOOTS.get(),
                ModBlocks.BRONZE_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.JADE_GEM).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(ModTags.Items.LEAD_INGOT, "lead",
                ModItems.LEAD_SWORD.get(),
                ModItems.LEAD_PICKAXE.get(),
                ModItems.LEAD_AXE.get(),
                ModItems.LEAD_SHOVEL.get(),
                ModItems.LEAD_HOE.get(),
                ModItems.LEAD_HELMET.get(),
                ModItems.LEAD_CHESTPLATE.get(),
                ModItems.LEAD_LEGGINGS.get(),
                ModItems.LEAD_BOOTS.get(),
                ModBlocks.LEAD_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.LEAD_INGOT).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(ModTags.Items.PLATINUM_INGOT, "platinum",
                ModItems.PLATINUM_SWORD.get(),
                ModItems.PLATINUM_PICKAXE.get(),
                ModItems.PLATINUM_AXE.get(),
                ModItems.PLATINUM_SHOVEL.get(),
                ModItems.PLATINUM_HOE.get(),
                ModItems.PLATINUM_HELMET.get(),
                ModItems.PLATINUM_CHESTPLATE.get(),
                ModItems.PLATINUM_LEGGINGS.get(),
                ModItems.PLATINUM_BOOTS.get(),
                ModBlocks.PLATINUM_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.PLATINUM_INGOT).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(ModTags.Items.RUBY_GEM, "ruby",
                ModItems.RUBY_SWORD.get(),
                ModItems.RUBY_PICKAXE.get(),
                ModItems.RUBY_AXE.get(),
                ModItems.RUBY_SHOVEL.get(),
                ModItems.RUBY_HOE.get(),
                ModItems.RUBY_HELMET.get(),
                ModItems.RUBY_CHESTPLATE.get(),
                ModItems.RUBY_LEGGINGS.get(),
                ModItems.RUBY_BOOTS.get(),
                ModBlocks.RUBY_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.RUBY_GEM).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(ModTags.Items.SAPPHIRE_GEM, "sapphire",
                ModItems.SAPPHIRE_SWORD.get(),
                ModItems.SAPPHIRE_PICKAXE.get(),
                ModItems.SAPPHIRE_AXE.get(),
                ModItems.SAPPHIRE_SHOVEL.get(),
                ModItems.SAPPHIRE_HOE.get(),
                ModItems.SAPPHIRE_HELMET.get(),
                ModItems.SAPPHIRE_CHESTPLATE.get(),
                ModItems.SAPPHIRE_LEGGINGS.get(),
                ModItems.SAPPHIRE_BOOTS.get(),
                ModBlocks.SAPPHIRE_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.SAPPHIRE_GEM).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(ModTags.Items.SILVER_INGOT, "silver",
                ModItems.SILVER_SWORD.get(),
                ModItems.SILVER_PICKAXE.get(),
                ModItems.SILVER_AXE.get(),
                ModItems.SILVER_SHOVEL.get(),
                ModItems.SILVER_HOE.get(),
                ModItems.SILVER_HELMET.get(),
                ModItems.SILVER_CHESTPLATE.get(),
                ModItems.SILVER_LEGGINGS.get(),
                ModItems.SILVER_BOOTS.get(),
                ModBlocks.SILVER_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.SILVER_INGOT).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(ModTags.Items.TIN_INGOT, "tin",
                ModItems.TIN_SWORD.get(),
                ModItems.TIN_PICKAXE.get(),
                ModItems.TIN_AXE.get(),
                ModItems.TIN_SHOVEL.get(),
                ModItems.TIN_HOE.get(),
                ModItems.TIN_HELMET.get(),
                ModItems.TIN_CHESTPLATE.get(),
                ModItems.TIN_LEGGINGS.get(),
                ModItems.TIN_BOOTS.get(),
                ModBlocks.TIN_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.TIN_INGOT).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(ModTags.Items.TOPAZ_GEM, "topaz",
                ModItems.TOPAZ_SWORD.get(),
                ModItems.TOPAZ_PICKAXE.get(),
                ModItems.TOPAZ_AXE.get(),
                ModItems.TOPAZ_SHOVEL.get(),
                ModItems.TOPAZ_HOE.get(),
                ModItems.TOPAZ_HELMET.get(),
                ModItems.TOPAZ_CHESTPLATE.get(),
                ModItems.TOPAZ_LEGGINGS.get(),
                ModItems.TOPAZ_BOOTS.get(),
                ModBlocks.TOPAZ_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.TOPAZ_GEM).build()), pFinishedConsumer);
    }

    public static void itemBlasting(TagKey<Item> pTagKey, Item pItem, String pName) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(pTagKey), RecipeCategory.MISC, pItem, 0.5F, 100)
                .unlockedBy("has_" + pName, inventoryTrigger(ItemPredicate.Builder.item().of(pTagKey).build()))
                .group(KrystalCraft.MOD_ID)
                .save(finishedConsumer, new ResourceLocation(KrystalCraft.MOD_ID, "blasting/" + pName));
    }
}
