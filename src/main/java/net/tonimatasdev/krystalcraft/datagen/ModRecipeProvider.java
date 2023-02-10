package net.tonimatasdev.krystalcraft.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
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

        RecipeProviderUtils.createResourceKit(ModTags.Items.BRONZE_NUGGETS, ModTags.Items.BRONZE_INGOT, "bronze",
                ModItems.BRONZE_INGOT.get(),
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

        RecipeProviderUtils.createResourceKit(ModTags.Items.COPPER_NUGGETS, Tags.Items.INGOTS_COPPER, "copper",
                Items.COPPER_INGOT,
                ModItems.COPPER_SWORD.get(),
                ModItems.COPPER_PICKAXE.get(),
                ModItems.COPPER_AXE.get(),
                ModItems.COPPER_SHOVEL.get(),
                ModItems.COPPER_HOE.get(),
                ModItems.COPPER_HELMET.get(),
                ModItems.COPPER_CHESTPLATE.get(),
                ModItems.COPPER_LEGGINGS.get(),
                ModItems.COPPER_BOOTS.get(),
                null, inventoryTrigger(ItemPredicate.Builder.item().of(Tags.Items.INGOTS_COPPER).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(null, ModTags.Items.JADE_GEM, "jade",
                null,
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

        RecipeProviderUtils.createResourceKit(ModTags.Items.LEAD_NUGGETS, ModTags.Items.LEAD_INGOT, "lead",
                ModItems.LEAD_INGOT.get(),
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

        RecipeProviderUtils.createResourceKit(ModTags.Items.PLATINUM_NUGGETS, ModTags.Items.PLATINUM_INGOT, "platinum",
                ModItems.PLATINUM_INGOT.get(),
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

        RecipeProviderUtils.createResourceKit(null, ModTags.Items.RUBY_GEM, "ruby",
                null,
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

        RecipeProviderUtils.createResourceKit(null, ModTags.Items.SAPPHIRE_GEM, "sapphire",
                null,
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

        RecipeProviderUtils.createResourceKit(ModTags.Items.SILVER_NUGGETS, ModTags.Items.SILVER_INGOT, "silver",
                ModItems.SILVER_INGOT.get(),
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

        RecipeProviderUtils.createResourceKit(ModTags.Items.TIN_NUGGETS, ModTags.Items.TIN_INGOT, "tin",
                ModItems.TIN_INGOT.get(),
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

        RecipeProviderUtils.createResourceKit(null, ModTags.Items.TOPAZ_GEM, "topaz",
                null,
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GRINDING_GEAR.get())
                .define('0', Tags.Items.INGOTS_IRON)
                .pattern(" 0 ")
                .pattern("0 0")
                .pattern(" 0 ")
                .unlockedBy("has_iron_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(Tags.Items.INGOTS_IRON).build()))
                .group(KrystalCraft.MOD_ID)
                .save(finishedConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SET_WATER_BOTTLES.get())
                .define('0', Tags.Items.GLASS)
                .define('1', Items.WATER_BUCKET)
                .pattern("010")
                .pattern(" 0 ")
                .unlockedBy("has_glass_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(Tags.Items.GLASS).build()))
                .group(KrystalCraft.MOD_ID)
                .save(finishedConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GEM_CUTTER_TOOL.get())
                .define('0', Items.STICK)
                .define('1', ModTags.Items.LEAD_INGOT)
                .define('2', Tags.Items.INGOTS_IRON)
                .pattern(" 1 ")
                .pattern("0 1")
                .pattern("20 ")
                .unlockedBy("has_lead_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.LEAD_INGOT).build()))
                .group(KrystalCraft.MOD_ID)
                .save(finishedConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COAL_COMBINER.get())
                .define('0', Items.STICK)
                .define('1', Tags.Items.COBBLESTONE)
                .define('2', Items.BLAST_FURNACE)
                .pattern("000")
                .pattern("212")
                .pattern("111")
                .unlockedBy("has_blast_furnace_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(Items.BLAST_FURNACE).build()))
                .group(KrystalCraft.MOD_ID)
                .save(finishedConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COAL_CRUSHER.get())
                .define('0', ModTags.Items.LEAD_INGOT)
                .define('1', Tags.Items.COBBLESTONE)
                .define('2', ModTags.Items.REDSTONE_RAW_MATERIAL)
                .define('3', Tags.Items.STORAGE_BLOCKS_IRON)
                .define('4', Tags.Items.FENCES)
                .pattern(" 3 ")
                .pattern("042")
                .pattern("111")
                .unlockedBy("has_lead_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.LEAD_INGOT).build()))
                .group(KrystalCraft.MOD_ID)
                .save(finishedConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GEM_CUTTING_STATION.get())
                .define('0', ModTags.Items.LEAD_INGOT)
                .define('1', Tags.Items.INGOTS_IRON)
                .define('2', Tags.Items.DUSTS_REDSTONE)
                .define('3', ModTags.Items.DIAMOND_RAW_MATERIAL)
                .define('4', Tags.Items.FENCES)
                .pattern("232")
                .pattern("040")
                .pattern("1 1")
                .unlockedBy("has_raw_diamond_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.DIAMOND_RAW_MATERIAL).build()))
                .group(KrystalCraft.MOD_ID)
                .save(finishedConsumer);

        itemShapeless(ModTags.Items.BRONZE_BLOCK, ModItems.BRONZE_INGOT.get(), "bronze_ingot");
        itemShapeless(ModTags.Items.BRONZE_INGOT, ModItems.BRONZE_NUGGET.get(), "bronze_nugget");
        itemShapeless(Tags.Items.INGOTS_COPPER, ModItems.COPPER_NUGGET.get(), "copper_nugget");
        itemShapeless(ModTags.Items.JADE_BLOCK, ModItems.JADE.get(), "jade");
        itemShapeless(ModTags.Items.LEAD_BLOCK, ModItems.LEAD_INGOT.get(), "lead_ingot");
        itemShapeless(ModTags.Items.LEAD_INGOT, ModItems.LEAD_NUGGET.get(), "lead_nugget");
        itemShapeless(ModTags.Items.PLATINUM_BLOCK, ModItems.PLATINUM_INGOT.get(), "platinum_ingot");
        itemShapeless(ModTags.Items.PLATINUM_INGOT, ModItems.PLATINUM_NUGGET.get(), "platinum_nugget");
        itemShapeless(ModTags.Items.RUBY_BLOCK, ModItems.RUBY.get(), "ruby");
        itemShapeless(ModTags.Items.SAPPHIRE_BLOCK, ModItems.SAPPHIRE.get(), "sapphire");
        itemShapeless(ModTags.Items.SILVER_BLOCK, ModItems.SILVER_INGOT.get(), "silver_ingot");
        itemShapeless(ModTags.Items.SILVER_INGOT, ModItems.SILVER_NUGGET.get(), "silver_nugget");
        itemShapeless(ModTags.Items.TIN_BLOCK, ModItems.TIN_INGOT.get(), "tin_ingot");
        itemShapeless(ModTags.Items.TIN_INGOT, ModItems.TIN_NUGGET.get(), "tin_nugget");
        itemShapeless(ModTags.Items.TOPAZ_BLOCK, ModItems.TOPAZ.get(), "topaz");

        itemSmelting(ModTags.Items.BRONZE_DUST, ModItems.BRONZE_INGOT.get(), "bronze_ingot_with_dust");
        itemSmelting(ModTags.Items.COPPER_DUST, Items.COPPER_INGOT, "copper_ingot_with_dust");
        itemSmelting(ModTags.Items.LEAD_DUST, ModItems.LEAD_INGOT.get(), "lead_ingot_with_dust");
        itemSmelting(ModTags.Items.PLATINUM_DUST, ModItems.PLATINUM_INGOT.get(), "platinum_ingot_with_dust");
        itemSmelting(ModTags.Items.SILVER_DUST, ModItems.SILVER_INGOT.get(), "silver_ingot_with_dust");
        itemSmelting(ModTags.Items.TIN_DUST, ModItems.TIN_INGOT.get(), "tin_ingot_with_dust");
    }

    private static void itemSmelting(TagKey<Item> pTagKey, Item pItem, String pName) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(pTagKey), RecipeCategory.MISC, pItem, 0.5F, 200)
                .unlockedBy("has_" + pName, inventoryTrigger(ItemPredicate.Builder.item().of(pTagKey).build()))
                .group(KrystalCraft.MOD_ID)
                .save(finishedConsumer, new ResourceLocation(KrystalCraft.MOD_ID, "smelting/" + pName));
    }

    private static void itemShapeless(TagKey<Item> pTagKey, Item pItem, String pName) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pItem, 9)
                .requires(Ingredient.of(pTagKey))
                .unlockedBy("has_" + pName, inventoryTrigger(ItemPredicate.Builder.item().of(pTagKey).build()))
                .group(KrystalCraft.MOD_ID)
                .save(finishedConsumer, new ResourceLocation(KrystalCraft.MOD_ID, "shapeless/" + pName));
    }

    private static void itemBlasting(TagKey<Item> pTagKey, Item pItem, String pName) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(pTagKey), RecipeCategory.MISC, pItem, 0.5F, 100)
                .unlockedBy("has_" + pName, inventoryTrigger(ItemPredicate.Builder.item().of(pTagKey).build()))
                .group(KrystalCraft.MOD_ID)
                .save(finishedConsumer, new ResourceLocation(KrystalCraft.MOD_ID, "blasting/" + pName));
    }
}
