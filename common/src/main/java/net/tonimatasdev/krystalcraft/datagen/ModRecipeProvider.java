package net.tonimatasdev.krystalcraft.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.registry.ItemRegistry;
import net.tonimatasdev.krystalcraft.util.ModTags;
import net.tonimatasdev.krystalcraft.util.RecipeProviderUtils;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static Consumer<FinishedRecipe> finishedConsumer;

    public ModRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pFinishedConsumer) {
        finishedConsumer = pFinishedConsumer;

        itemBlasting(ModTags.Items.LEAD_RAW_MATERIAL, ItemRegistry.LEAD_INGOT.get(), "lead_ingot");
        itemBlasting(ModTags.Items.PLATINUM_RAW_MATERIAL, ItemRegistry.PLATINUM_INGOT.get(), "platinum_ingot");
        itemBlasting(ModTags.Items.SILVER_RAW_MATERIAL, ItemRegistry.SILVER_INGOT.get(), "silver_ingot");
        itemBlasting(ModTags.Items.TIN_RAW_MATERIAL, ItemRegistry.TIN_INGOT.get(), "tin_ingot");

        RecipeProviderUtils.createResourceKit(ModTags.Items.BRONZE_NUGGETS, ModTags.Items.BRONZE_INGOT, "bronze",
                ItemRegistry.BRONZE_INGOT.get(),
                ItemRegistry.BRONZE_SWORD.get(),
                ItemRegistry.BRONZE_PICKAXE.get(),
                ItemRegistry.BRONZE_AXE.get(),
                ItemRegistry.BRONZE_SHOVEL.get(),
                ItemRegistry.BRONZE_HOE.get(),
                ItemRegistry.BRONZE_HELMET.get(),
                ItemRegistry.BRONZE_CHESTPLATE.get(),
                ItemRegistry.BRONZE_LEGGINGS.get(),
                ItemRegistry.BRONZE_BOOTS.get(),
                ModBlocks.BRONZE_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.BRONZE_INGOT).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(ModTags.Items.COPPER_NUGGETS, Tags.Items.INGOTS_COPPER, "copper",
                Items.COPPER_INGOT,
                ItemRegistry.COPPER_SWORD.get(),
                ItemRegistry.COPPER_PICKAXE.get(),
                ItemRegistry.COPPER_AXE.get(),
                ItemRegistry.COPPER_SHOVEL.get(),
                ItemRegistry.COPPER_HOE.get(),
                ItemRegistry.COPPER_HELMET.get(),
                ItemRegistry.COPPER_CHESTPLATE.get(),
                ItemRegistry.COPPER_LEGGINGS.get(),
                ItemRegistry.COPPER_BOOTS.get(),
                null, inventoryTrigger(ItemPredicate.Builder.item().of(Tags.Items.INGOTS_COPPER).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(null, ModTags.Items.JADE_GEM, "jade",
                null,
                ItemRegistry.JADE_SWORD.get(),
                ItemRegistry.JADE_PICKAXE.get(),
                ItemRegistry.JADE_AXE.get(),
                ItemRegistry.JADE_SHOVEL.get(),
                ItemRegistry.JADE_HOE.get(),
                ItemRegistry.JADE_HELMET.get(),
                ItemRegistry.JADE_CHESTPLATE.get(),
                ItemRegistry.JADE_LEGGINGS.get(),
                ItemRegistry.JADE_BOOTS.get(),
                ModBlocks.BRONZE_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.JADE_GEM).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(ModTags.Items.LEAD_NUGGETS, ModTags.Items.LEAD_INGOT, "lead",
                ItemRegistry.LEAD_INGOT.get(),
                ItemRegistry.LEAD_SWORD.get(),
                ItemRegistry.LEAD_PICKAXE.get(),
                ItemRegistry.LEAD_AXE.get(),
                ItemRegistry.LEAD_SHOVEL.get(),
                ItemRegistry.LEAD_HOE.get(),
                ItemRegistry.LEAD_HELMET.get(),
                ItemRegistry.LEAD_CHESTPLATE.get(),
                ItemRegistry.LEAD_LEGGINGS.get(),
                ItemRegistry.LEAD_BOOTS.get(),
                ModBlocks.LEAD_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.LEAD_INGOT).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(ModTags.Items.PLATINUM_NUGGETS, ModTags.Items.PLATINUM_INGOT, "platinum",
                ItemRegistry.PLATINUM_INGOT.get(),
                ItemRegistry.PLATINUM_SWORD.get(),
                ItemRegistry.PLATINUM_PICKAXE.get(),
                ItemRegistry.PLATINUM_AXE.get(),
                ItemRegistry.PLATINUM_SHOVEL.get(),
                ItemRegistry.PLATINUM_HOE.get(),
                ItemRegistry.PLATINUM_HELMET.get(),
                ItemRegistry.PLATINUM_CHESTPLATE.get(),
                ItemRegistry.PLATINUM_LEGGINGS.get(),
                ItemRegistry.PLATINUM_BOOTS.get(),
                ModBlocks.PLATINUM_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.PLATINUM_INGOT).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(null, ModTags.Items.RUBY_GEM, "ruby",
                null,
                ItemRegistry.RUBY_SWORD.get(),
                ItemRegistry.RUBY_PICKAXE.get(),
                ItemRegistry.RUBY_AXE.get(),
                ItemRegistry.RUBY_SHOVEL.get(),
                ItemRegistry.RUBY_HOE.get(),
                ItemRegistry.RUBY_HELMET.get(),
                ItemRegistry.RUBY_CHESTPLATE.get(),
                ItemRegistry.RUBY_LEGGINGS.get(),
                ItemRegistry.RUBY_BOOTS.get(),
                ModBlocks.RUBY_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.RUBY_GEM).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(null, ModTags.Items.SAPPHIRE_GEM, "sapphire",
                null,
                ItemRegistry.SAPPHIRE_SWORD.get(),
                ItemRegistry.SAPPHIRE_PICKAXE.get(),
                ItemRegistry.SAPPHIRE_AXE.get(),
                ItemRegistry.SAPPHIRE_SHOVEL.get(),
                ItemRegistry.SAPPHIRE_HOE.get(),
                ItemRegistry.SAPPHIRE_HELMET.get(),
                ItemRegistry.SAPPHIRE_CHESTPLATE.get(),
                ItemRegistry.SAPPHIRE_LEGGINGS.get(),
                ItemRegistry.SAPPHIRE_BOOTS.get(),
                ModBlocks.SAPPHIRE_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.SAPPHIRE_GEM).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(ModTags.Items.SILVER_NUGGETS, ModTags.Items.SILVER_INGOT, "silver",
                ItemRegistry.SILVER_INGOT.get(),
                ItemRegistry.SILVER_SWORD.get(),
                ItemRegistry.SILVER_PICKAXE.get(),
                ItemRegistry.SILVER_AXE.get(),
                ItemRegistry.SILVER_SHOVEL.get(),
                ItemRegistry.SILVER_HOE.get(),
                ItemRegistry.SILVER_HELMET.get(),
                ItemRegistry.SILVER_CHESTPLATE.get(),
                ItemRegistry.SILVER_LEGGINGS.get(),
                ItemRegistry.SILVER_BOOTS.get(),
                ModBlocks.SILVER_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.SILVER_INGOT).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(ModTags.Items.TIN_NUGGETS, ModTags.Items.TIN_INGOT, "tin",
                ItemRegistry.TIN_INGOT.get(),
                ItemRegistry.TIN_SWORD.get(),
                ItemRegistry.TIN_PICKAXE.get(),
                ItemRegistry.TIN_AXE.get(),
                ItemRegistry.TIN_SHOVEL.get(),
                ItemRegistry.TIN_HOE.get(),
                ItemRegistry.TIN_HELMET.get(),
                ItemRegistry.TIN_CHESTPLATE.get(),
                ItemRegistry.TIN_LEGGINGS.get(),
                ItemRegistry.TIN_BOOTS.get(),
                ModBlocks.TIN_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.TIN_INGOT).build()), pFinishedConsumer);

        RecipeProviderUtils.createResourceKit(null, ModTags.Items.TOPAZ_GEM, "topaz",
                null,
                ItemRegistry.TOPAZ_SWORD.get(),
                ItemRegistry.TOPAZ_PICKAXE.get(),
                ItemRegistry.TOPAZ_AXE.get(),
                ItemRegistry.TOPAZ_SHOVEL.get(),
                ItemRegistry.TOPAZ_HOE.get(),
                ItemRegistry.TOPAZ_HELMET.get(),
                ItemRegistry.TOPAZ_CHESTPLATE.get(),
                ItemRegistry.TOPAZ_LEGGINGS.get(),
                ItemRegistry.TOPAZ_BOOTS.get(),
                ModBlocks.TOPAZ_BLOCK.get(), inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.TOPAZ_GEM).build()), pFinishedConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.GRINDING_GEAR.get())
                .define('0', Tags.Items.INGOTS_IRON)
                .pattern(" 0 ")
                .pattern("0 0")
                .pattern(" 0 ")
                .unlockedBy("has_iron_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(Tags.Items.INGOTS_IRON).build()))
                .group(KrystalCraft.MOD_ID)
                .save(finishedConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.SET_WATER_BOTTLES.get())
                .define('0', Tags.Items.GLASS)
                .define('1', Items.WATER_BUCKET)
                .pattern("010")
                .pattern(" 0 ")
                .unlockedBy("has_glass_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(Tags.Items.GLASS).build()))
                .group(KrystalCraft.MOD_ID)
                .save(finishedConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.GEM_CUTTER_TOOL.get())
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

        itemShapeless(ModTags.Items.BRONZE_BLOCK, ItemRegistry.BRONZE_INGOT.get(), "bronze_ingot");
        itemShapeless(ModTags.Items.BRONZE_INGOT, ItemRegistry.BRONZE_NUGGET.get(), "bronze_nugget");
        itemShapeless(Tags.Items.INGOTS_COPPER, ItemRegistry.COPPER_NUGGET.get(), "copper_nugget");
        itemShapeless(ModTags.Items.JADE_BLOCK, ItemRegistry.JADE.get(), "jade");
        itemShapeless(ModTags.Items.LEAD_BLOCK, ItemRegistry.LEAD_INGOT.get(), "lead_ingot");
        itemShapeless(ModTags.Items.LEAD_INGOT, ItemRegistry.LEAD_NUGGET.get(), "lead_nugget");
        itemShapeless(ModTags.Items.PLATINUM_BLOCK, ItemRegistry.PLATINUM_INGOT.get(), "platinum_ingot");
        itemShapeless(ModTags.Items.PLATINUM_INGOT, ItemRegistry.PLATINUM_NUGGET.get(), "platinum_nugget");
        itemShapeless(ModTags.Items.RUBY_BLOCK, ItemRegistry.RUBY.get(), "ruby");
        itemShapeless(ModTags.Items.SAPPHIRE_BLOCK, ItemRegistry.SAPPHIRE.get(), "sapphire");
        itemShapeless(ModTags.Items.SILVER_BLOCK, ItemRegistry.SILVER_INGOT.get(), "silver_ingot");
        itemShapeless(ModTags.Items.SILVER_INGOT, ItemRegistry.SILVER_NUGGET.get(), "silver_nugget");
        itemShapeless(ModTags.Items.TIN_BLOCK, ItemRegistry.TIN_INGOT.get(), "tin_ingot");
        itemShapeless(ModTags.Items.TIN_INGOT, ItemRegistry.TIN_NUGGET.get(), "tin_nugget");
        itemShapeless(ModTags.Items.TOPAZ_BLOCK, ItemRegistry.TOPAZ.get(), "topaz");

        itemSmelting(ModTags.Items.BRONZE_DUST, ItemRegistry.BRONZE_INGOT.get(), "bronze_ingot_with_dust");
        itemSmelting(ModTags.Items.COPPER_DUST, Items.COPPER_INGOT, "copper_ingot_with_dust");
        itemSmelting(ModTags.Items.LEAD_DUST, ItemRegistry.LEAD_INGOT.get(), "lead_ingot_with_dust");
        itemSmelting(ModTags.Items.PLATINUM_DUST, ItemRegistry.PLATINUM_INGOT.get(), "platinum_ingot_with_dust");
        itemSmelting(ModTags.Items.SILVER_DUST, ItemRegistry.SILVER_INGOT.get(), "silver_ingot_with_dust");
        itemSmelting(ModTags.Items.TIN_DUST, ItemRegistry.TIN_INGOT.get(), "tin_ingot_with_dust");
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
