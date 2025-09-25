package dev.tonimatas.krystalcraft.data;

import dev.tonimatas.krystalcraft.registry.ModBlocks;
import dev.tonimatas.krystalcraft.registry.ModItems;
import dev.tonimatas.krystalcraft.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        // Bronze
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_NUGGET, 9)
                .input(ModTags.Items.BRONZE_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.BRONZE_INGOTS))
                .offerTo(recipeExporter, "bronze_nugget_by_material_shapeless");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_INGOT)
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.BRONZE_NUGGETS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_NUGGET), FabricRecipeProvider.conditionsFromTag(ModTags.Items.BRONZE_NUGGETS))
                .offerTo(recipeExporter, "bronze_material_by_nugget_shaped");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_INGOT, 9)
                .input(ModTags.Items.BRONZE_BLOCKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BRONZE_BLOCK), FabricRecipeProvider.conditionsFromTag(ModTags.Items.BRONZE_BLOCKS))
                .offerTo(recipeExporter, "bronze_material_by_block_shapeless");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_HELMET)
                .pattern("000")
                .pattern("0 0")
                .input('0', ModTags.Items.BRONZE_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.BRONZE_INGOTS))
                .offerTo(recipeExporter, "bronze_helmet_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_CHESTPLATE)
                .pattern("0 0")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.BRONZE_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.BRONZE_INGOTS))
                .offerTo(recipeExporter, "bronze_chestplate_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_LEGGINGS)
                .pattern("000")
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.BRONZE_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.BRONZE_INGOTS))
                .offerTo(recipeExporter, "bronze_leggings_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BRONZE_BOOTS)
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.BRONZE_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.BRONZE_INGOTS))
                .offerTo(recipeExporter, "bronze_boots_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRONZE_BLOCK)
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.BRONZE_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.BRONZE_INGOTS))
                .offerTo(recipeExporter, "bronze_block_by_material_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_SWORD)
                .pattern("0")
                .pattern("0")
                .pattern("1")
                .input('0', ModTags.Items.BRONZE_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.BRONZE_INGOTS))
                .offerTo(recipeExporter, "bronze_sword_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_PICKAXE)
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .input('0', ModTags.Items.BRONZE_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.BRONZE_INGOTS))
                .offerTo(recipeExporter, "bronze_pickaxe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_AXE)
                .pattern("00")
                .pattern("01")
                .pattern(" 1")
                .input('0', ModTags.Items.BRONZE_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.BRONZE_INGOTS))
                .offerTo(recipeExporter, "bronze_axe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_SHOVEL)
                .pattern("0")
                .pattern("1")
                .pattern("1")
                .input('0', ModTags.Items.BRONZE_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.BRONZE_INGOTS))
                .offerTo(recipeExporter, "bronze_shovel_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_HOE)
                .pattern("00")
                .pattern(" 1")
                .pattern(" 1")
                .input('0', ModTags.Items.BRONZE_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BRONZE_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.BRONZE_INGOTS))
                .offerTo(recipeExporter, "bronze_hoe_shaped");
        offerSmelting(recipeExporter, List.of(ModItems.BRONZE_DUST), RecipeCategory.MISC, ModItems.BRONZE_INGOT, 0.5f, 200, "");
        offerBlasting(recipeExporter, List.of(ModItems.BRONZE_DUST), RecipeCategory.MISC, ModItems.BRONZE_INGOT, 0.5f, 100, "");

        // Lead
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEAD_NUGGET, 9)
                .input(ModTags.Items.LEAD_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LEAD_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.LEAD_INGOTS))
                .offerTo(recipeExporter, "lead_nugget_by_material_shapeless");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEAD_INGOT)
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.LEAD_NUGGETS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LEAD_NUGGET), FabricRecipeProvider.conditionsFromTag(ModTags.Items.LEAD_NUGGETS))
                .offerTo(recipeExporter, "lead_material_by_nugget_shaped");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEAD_INGOT, 9)
                .input(ModTags.Items.LEAD_BLOCKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.LEAD_BLOCK), FabricRecipeProvider.conditionsFromTag(ModTags.Items.LEAD_BLOCKS))
                .offerTo(recipeExporter, "lead_material_by_block_shapeless");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LEAD_HELMET)
                .pattern("000")
                .pattern("0 0")
                .input('0', ModTags.Items.LEAD_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LEAD_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.LEAD_INGOTS))
                .offerTo(recipeExporter, "lead_helmet_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LEAD_CHESTPLATE)
                .pattern("0 0")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.LEAD_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LEAD_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.LEAD_INGOTS))
                .offerTo(recipeExporter, "lead_chestplate_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LEAD_LEGGINGS)
                .pattern("000")
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.LEAD_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LEAD_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.LEAD_INGOTS))
                .offerTo(recipeExporter, "lead_leggings_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LEAD_BOOTS)
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.LEAD_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LEAD_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.LEAD_INGOTS))
                .offerTo(recipeExporter, "lead_boots_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEAD_BLOCK)
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.LEAD_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LEAD_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.LEAD_INGOTS))
                .offerTo(recipeExporter, "lead_block_by_material_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LEAD_SWORD)
                .pattern("0")
                .pattern("0")
                .pattern("1")
                .input('0', ModTags.Items.LEAD_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LEAD_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.LEAD_INGOTS))
                .offerTo(recipeExporter, "lead_sword_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LEAD_PICKAXE)
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .input('0', ModTags.Items.LEAD_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LEAD_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.LEAD_INGOTS))
                .offerTo(recipeExporter, "lead_pickaxe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LEAD_AXE)
                .pattern("00")
                .pattern("01")
                .pattern(" 1")
                .input('0', ModTags.Items.LEAD_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LEAD_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.LEAD_INGOTS))
                .offerTo(recipeExporter, "lead_axe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LEAD_SHOVEL)
                .pattern("0")
                .pattern("1")
                .pattern("1")
                .input('0', ModTags.Items.LEAD_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LEAD_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.LEAD_INGOTS))
                .offerTo(recipeExporter, "lead_shovel_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LEAD_HOE)
                .pattern("00")
                .pattern(" 1")
                .pattern(" 1")
                .input('0', ModTags.Items.LEAD_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.LEAD_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.LEAD_INGOTS))
                .offerTo(recipeExporter, "lead_hoe_shaped");
        offerSmelting(recipeExporter, List.of(ModItems.LEAD_DUST), RecipeCategory.MISC, ModItems.LEAD_INGOT, 0.5f, 200, "");
        offerBlasting(recipeExporter, List.of(ModItems.LEAD_DUST), RecipeCategory.MISC, ModItems.LEAD_INGOT, 0.5f, 100, "");
        offerSmelting(recipeExporter, List.of(ModItems.RAW_LEAD), RecipeCategory.MISC, ModItems.LEAD_INGOT, 0.5f, 200, "");
        offerBlasting(recipeExporter, List.of(ModItems.RAW_LEAD), RecipeCategory.MISC, ModItems.LEAD_INGOT, 0.5f, 100, "");

        // Tin
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIN_NUGGET, 9)
                .input(ModTags.Items.TIN_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TIN_INGOTS))
                .offerTo(recipeExporter, "tin_nugget_by_material_shapeless");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIN_INGOT)
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.TIN_NUGGETS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_NUGGET), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TIN_NUGGETS))
                .offerTo(recipeExporter, "tin_material_by_nugget_shaped");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIN_INGOT, 9)
                .input(ModTags.Items.TIN_BLOCKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TIN_BLOCK), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TIN_BLOCKS))
                .offerTo(recipeExporter, "tin_material_by_block_shapeless");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TIN_HELMET)
                .pattern("000")
                .pattern("0 0")
                .input('0', ModTags.Items.TIN_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TIN_INGOTS))
                .offerTo(recipeExporter, "tin_helmet_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TIN_CHESTPLATE)
                .pattern("0 0")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.TIN_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TIN_INGOTS))
                .offerTo(recipeExporter, "tin_chestplate_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TIN_LEGGINGS)
                .pattern("000")
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.TIN_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TIN_INGOTS))
                .offerTo(recipeExporter, "tin_leggings_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TIN_BOOTS)
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.TIN_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TIN_INGOTS))
                .offerTo(recipeExporter, "tin_boots_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_BLOCK)
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.TIN_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TIN_INGOTS))
                .offerTo(recipeExporter, "tin_block_by_material_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TIN_SWORD)
                .pattern("0")
                .pattern("0")
                .pattern("1")
                .input('0', ModTags.Items.TIN_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TIN_INGOTS))
                .offerTo(recipeExporter, "tin_sword_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TIN_PICKAXE)
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .input('0', ModTags.Items.TIN_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TIN_INGOTS))
                .offerTo(recipeExporter, "tin_pickaxe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TIN_AXE)
                .pattern("00")
                .pattern("01")
                .pattern(" 1")
                .input('0', ModTags.Items.TIN_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TIN_INGOTS))
                .offerTo(recipeExporter, "tin_axe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TIN_SHOVEL)
                .pattern("0")
                .pattern("1")
                .pattern("1")
                .input('0', ModTags.Items.TIN_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TIN_INGOTS))
                .offerTo(recipeExporter, "tin_shovel_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TIN_HOE)
                .pattern("00")
                .pattern(" 1")
                .pattern(" 1")
                .input('0', ModTags.Items.TIN_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TIN_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TIN_INGOTS))
                .offerTo(recipeExporter, "tin_hoe_shaped");
        offerSmelting(recipeExporter, List.of(ModItems.TIN_DUST), RecipeCategory.MISC, ModItems.TIN_INGOT, 0.5f, 200, "");
        offerBlasting(recipeExporter, List.of(ModItems.TIN_DUST), RecipeCategory.MISC, ModItems.TIN_INGOT, 0.5f, 100, "");
        offerSmelting(recipeExporter, List.of(ModItems.RAW_TIN), RecipeCategory.MISC, ModItems.TIN_INGOT, 0.5f, 200, "");
        offerBlasting(recipeExporter, List.of(ModItems.RAW_TIN), RecipeCategory.MISC, ModItems.TIN_INGOT, 0.5f, 100, "");

        // Platinum
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PLATINUM_NUGGET, 9)
                .input(ModTags.Items.PLATINUM_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PLATINUM_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.PLATINUM_INGOTS))
                .offerTo(recipeExporter, "platinum_nugget_by_material_shapeless");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PLATINUM_INGOT)
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.PLATINUM_NUGGETS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PLATINUM_NUGGET), FabricRecipeProvider.conditionsFromTag(ModTags.Items.PLATINUM_NUGGETS))
                .offerTo(recipeExporter, "platinum_material_by_nugget_shaped");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PLATINUM_INGOT, 9)
                .input(ModTags.Items.PLATINUM_BLOCKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.PLATINUM_BLOCK), FabricRecipeProvider.conditionsFromTag(ModTags.Items.PLATINUM_BLOCKS))
                .offerTo(recipeExporter, "platinum_material_by_block_shapeless");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PLATINUM_HELMET)
                .pattern("000")
                .pattern("0 0")
                .input('0', ModTags.Items.PLATINUM_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PLATINUM_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.PLATINUM_INGOTS))
                .offerTo(recipeExporter, "platinum_helmet_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PLATINUM_CHESTPLATE)
                .pattern("0 0")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.PLATINUM_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PLATINUM_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.PLATINUM_INGOTS))
                .offerTo(recipeExporter, "platinum_chestplate_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PLATINUM_LEGGINGS)
                .pattern("000")
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.PLATINUM_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PLATINUM_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.PLATINUM_INGOTS))
                .offerTo(recipeExporter, "platinum_leggings_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PLATINUM_BOOTS)
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.PLATINUM_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PLATINUM_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.PLATINUM_INGOTS))
                .offerTo(recipeExporter, "platinum_boots_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLATINUM_BLOCK)
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.PLATINUM_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PLATINUM_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.PLATINUM_INGOTS))
                .offerTo(recipeExporter, "platinum_block_by_material_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PLATINUM_SWORD)
                .pattern("0")
                .pattern("0")
                .pattern("1")
                .input('0', ModTags.Items.PLATINUM_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PLATINUM_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.PLATINUM_INGOTS))
                .offerTo(recipeExporter, "platinum_sword_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PLATINUM_PICKAXE)
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .input('0', ModTags.Items.PLATINUM_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PLATINUM_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.PLATINUM_INGOTS))
                .offerTo(recipeExporter, "platinum_pickaxe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PLATINUM_AXE)
                .pattern("00")
                .pattern("01")
                .pattern(" 1")
                .input('0', ModTags.Items.PLATINUM_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PLATINUM_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.PLATINUM_INGOTS))
                .offerTo(recipeExporter, "platinum_axe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PLATINUM_SHOVEL)
                .pattern("0")
                .pattern("1")
                .pattern("1")
                .input('0', ModTags.Items.PLATINUM_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PLATINUM_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.PLATINUM_INGOTS))
                .offerTo(recipeExporter, "platinum_shovel_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PLATINUM_HOE)
                .pattern("00")
                .pattern(" 1")
                .pattern(" 1")
                .input('0', ModTags.Items.PLATINUM_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.PLATINUM_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.PLATINUM_INGOTS))
                .offerTo(recipeExporter, "platinum_hoe_shaped");
        offerSmelting(recipeExporter, List.of(ModItems.PLATINUM_DUST), RecipeCategory.MISC, ModItems.PLATINUM_INGOT, 0.5f, 200, "");
        offerBlasting(recipeExporter, List.of(ModItems.PLATINUM_DUST), RecipeCategory.MISC, ModItems.PLATINUM_INGOT, 0.5f, 100, "");
        offerSmelting(recipeExporter, List.of(ModItems.RAW_PLATINUM), RecipeCategory.MISC, ModItems.PLATINUM_INGOT, 0.5f, 200, "");
        offerBlasting(recipeExporter, List.of(ModItems.RAW_PLATINUM), RecipeCategory.MISC, ModItems.PLATINUM_INGOT, 0.5f, 100, "");

        // Silver
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILVER_NUGGET, 9)
                .input(ModTags.Items.SILVER_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SILVER_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SILVER_INGOTS))
                .offerTo(recipeExporter, "silver_nugget_by_material_shapeless");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILVER_INGOT)
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.SILVER_NUGGETS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SILVER_NUGGET), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SILVER_NUGGETS))
                .offerTo(recipeExporter, "silver_material_by_nugget_shaped");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILVER_INGOT, 9)
                .input(ModTags.Items.SILVER_BLOCKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SILVER_BLOCK), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SILVER_BLOCKS))
                .offerTo(recipeExporter, "silver_material_by_block_shapeless");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SILVER_HELMET)
                .pattern("000")
                .pattern("0 0")
                .input('0', ModTags.Items.SILVER_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SILVER_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SILVER_INGOTS))
                .offerTo(recipeExporter, "silver_helmet_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SILVER_CHESTPLATE)
                .pattern("0 0")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.SILVER_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SILVER_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SILVER_INGOTS))
                .offerTo(recipeExporter, "silver_chestplate_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SILVER_LEGGINGS)
                .pattern("000")
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.SILVER_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SILVER_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SILVER_INGOTS))
                .offerTo(recipeExporter, "silver_leggings_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SILVER_BOOTS)
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.SILVER_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SILVER_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SILVER_INGOTS))
                .offerTo(recipeExporter, "silver_boots_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_BLOCK)
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.SILVER_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SILVER_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SILVER_INGOTS))
                .offerTo(recipeExporter, "silver_block_by_material_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SILVER_SWORD)
                .pattern("0")
                .pattern("0")
                .pattern("1")
                .input('0', ModTags.Items.SILVER_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SILVER_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SILVER_INGOTS))
                .offerTo(recipeExporter, "silver_sword_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SILVER_PICKAXE)
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .input('0', ModTags.Items.SILVER_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SILVER_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SILVER_INGOTS))
                .offerTo(recipeExporter, "silver_pickaxe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SILVER_AXE)
                .pattern("00")
                .pattern("01")
                .pattern(" 1")
                .input('0', ModTags.Items.SILVER_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SILVER_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SILVER_INGOTS))
                .offerTo(recipeExporter, "silver_axe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SILVER_SHOVEL)
                .pattern("0")
                .pattern("1")
                .pattern("1")
                .input('0', ModTags.Items.SILVER_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SILVER_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SILVER_INGOTS))
                .offerTo(recipeExporter, "silver_shovel_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SILVER_HOE)
                .pattern("00")
                .pattern(" 1")
                .pattern(" 1")
                .input('0', ModTags.Items.SILVER_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SILVER_INGOT), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SILVER_INGOTS))
                .offerTo(recipeExporter, "silver_hoe_shaped");
        offerSmelting(recipeExporter, List.of(ModItems.SILVER_DUST), RecipeCategory.MISC, ModItems.SILVER_INGOT, 0.5f, 200, "");
        offerBlasting(recipeExporter, List.of(ModItems.SILVER_DUST), RecipeCategory.MISC, ModItems.SILVER_INGOT, 0.5f, 100, "");
        offerSmelting(recipeExporter, List.of(ModItems.RAW_SILVER), RecipeCategory.MISC, ModItems.SILVER_INGOT, 0.5f, 200, "");
        offerBlasting(recipeExporter, List.of(ModItems.RAW_SILVER), RecipeCategory.MISC, ModItems.SILVER_INGOT, 0.5f, 100, "");

        // Jade
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JADE, 9)
                .input(ModTags.Items.JADE_BLOCKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.JADE_BLOCK), FabricRecipeProvider.conditionsFromTag(ModTags.Items.JADE_BLOCKS))
                .offerTo(recipeExporter, "jade_material_by_block_shapeless");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.JADE_HELMET)
                .pattern("000")
                .pattern("0 0")
                .input('0', ModTags.Items.JADE_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.JADE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.JADE_GEMS))
                .offerTo(recipeExporter, "jade_helmet_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.JADE_CHESTPLATE)
                .pattern("0 0")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.JADE_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.JADE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.JADE_GEMS))
                .offerTo(recipeExporter, "jade_chestplate_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.JADE_LEGGINGS)
                .pattern("000")
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.JADE_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.JADE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.JADE_GEMS))
                .offerTo(recipeExporter, "jade_leggings_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.JADE_BOOTS)
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.JADE_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.JADE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.JADE_GEMS))
                .offerTo(recipeExporter, "jade_boots_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_BLOCK)
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.JADE_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.JADE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.JADE_GEMS))
                .offerTo(recipeExporter, "jade_block_by_material_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.JADE_SWORD)
                .pattern("0")
                .pattern("0")
                .pattern("1")
                .input('0', ModTags.Items.JADE_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.JADE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.JADE_GEMS))
                .offerTo(recipeExporter, "jade_sword_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.JADE_PICKAXE)
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .input('0', ModTags.Items.JADE_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.JADE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.JADE_GEMS))
                .offerTo(recipeExporter, "jade_pickaxe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.JADE_AXE)
                .pattern("00")
                .pattern("01")
                .pattern(" 1")
                .input('0', ModTags.Items.JADE_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.JADE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.JADE_GEMS))
                .offerTo(recipeExporter, "jade_axe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.JADE_SHOVEL)
                .pattern("0")
                .pattern("1")
                .pattern("1")
                .input('0', ModTags.Items.JADE_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.JADE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.JADE_GEMS))
                .offerTo(recipeExporter, "jade_shovel_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.JADE_HOE)
                .pattern("00")
                .pattern(" 1")
                .pattern(" 1")
                .input('0', ModTags.Items.JADE_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.JADE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.JADE_GEMS))
                .offerTo(recipeExporter, "jade_hoe_shaped");

        // Topaz
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TOPAZ, 9)
                .input(ModTags.Items.TOPAZ_BLOCKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.TOPAZ_BLOCK), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TOPAZ_BLOCKS))
                .offerTo(recipeExporter, "topaz_material_by_block_shapeless");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TOPAZ_HELMET)
                .pattern("000")
                .pattern("0 0")
                .input('0', ModTags.Items.TOPAZ_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TOPAZ), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TOPAZ_GEMS))
                .offerTo(recipeExporter, "topaz_helmet_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TOPAZ_CHESTPLATE)
                .pattern("0 0")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.TOPAZ_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TOPAZ), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TOPAZ_GEMS))
                .offerTo(recipeExporter, "topaz_chestplate_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TOPAZ_LEGGINGS)
                .pattern("000")
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.TOPAZ_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TOPAZ), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TOPAZ_GEMS))
                .offerTo(recipeExporter, "topaz_leggings_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TOPAZ_BOOTS)
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.TOPAZ_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TOPAZ), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TOPAZ_GEMS))
                .offerTo(recipeExporter, "topaz_boots_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOPAZ_BLOCK)
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.TOPAZ_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TOPAZ), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TOPAZ_GEMS))
                .offerTo(recipeExporter, "topaz_block_by_material_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOPAZ_SWORD)
                .pattern("0")
                .pattern("0")
                .pattern("1")
                .input('0', ModTags.Items.TOPAZ_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TOPAZ), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TOPAZ_GEMS))
                .offerTo(recipeExporter, "topaz_sword_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOPAZ_PICKAXE)
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .input('0', ModTags.Items.TOPAZ_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TOPAZ), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TOPAZ_GEMS))
                .offerTo(recipeExporter, "topaz_pickaxe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOPAZ_AXE)
                .pattern("00")
                .pattern("01")
                .pattern(" 1")
                .input('0', ModTags.Items.TOPAZ_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TOPAZ), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TOPAZ_GEMS))
                .offerTo(recipeExporter, "topaz_axe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOPAZ_SHOVEL)
                .pattern("0")
                .pattern("1")
                .pattern("1")
                .input('0', ModTags.Items.TOPAZ_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TOPAZ), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TOPAZ_GEMS))
                .offerTo(recipeExporter, "topaz_shovel_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOPAZ_HOE)
                .pattern("00")
                .pattern(" 1")
                .pattern(" 1")
                .input('0', ModTags.Items.TOPAZ_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TOPAZ), FabricRecipeProvider.conditionsFromTag(ModTags.Items.TOPAZ_GEMS))
                .offerTo(recipeExporter, "topaz_hoe_shaped");

        // Ruby
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY, 9)
                .input(ModTags.Items.RUBY_BLOCKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.RUBY_BLOCK), FabricRecipeProvider.conditionsFromTag(ModTags.Items.RUBY_BLOCKS))
                .offerTo(recipeExporter, "ruby_material_by_block_shapeless");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_HELMET)
                .pattern("000")
                .pattern("0 0")
                .input('0', ModTags.Items.RUBY_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBY), FabricRecipeProvider.conditionsFromTag(ModTags.Items.RUBY_GEMS))
                .offerTo(recipeExporter, "ruby_helmet_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_CHESTPLATE)
                .pattern("0 0")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.RUBY_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBY), FabricRecipeProvider.conditionsFromTag(ModTags.Items.RUBY_GEMS))
                .offerTo(recipeExporter, "ruby_chestplate_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_LEGGINGS)
                .pattern("000")
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.RUBY_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBY), FabricRecipeProvider.conditionsFromTag(ModTags.Items.RUBY_GEMS))
                .offerTo(recipeExporter, "ruby_leggings_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_BOOTS)
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.RUBY_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBY), FabricRecipeProvider.conditionsFromTag(ModTags.Items.RUBY_GEMS))
                .offerTo(recipeExporter, "ruby_boots_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK)
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.RUBY_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBY), FabricRecipeProvider.conditionsFromTag(ModTags.Items.RUBY_GEMS))
                .offerTo(recipeExporter, "ruby_block_by_material_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_SWORD)
                .pattern("0")
                .pattern("0")
                .pattern("1")
                .input('0', ModTags.Items.RUBY_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBY), FabricRecipeProvider.conditionsFromTag(ModTags.Items.RUBY_GEMS))
                .offerTo(recipeExporter, "ruby_sword_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE)
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .input('0', ModTags.Items.RUBY_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBY), FabricRecipeProvider.conditionsFromTag(ModTags.Items.RUBY_GEMS))
                .offerTo(recipeExporter, "ruby_pickaxe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_AXE)
                .pattern("00")
                .pattern("01")
                .pattern(" 1")
                .input('0', ModTags.Items.RUBY_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBY), FabricRecipeProvider.conditionsFromTag(ModTags.Items.RUBY_GEMS))
                .offerTo(recipeExporter, "ruby_axe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_SHOVEL)
                .pattern("0")
                .pattern("1")
                .pattern("1")
                .input('0', ModTags.Items.RUBY_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBY), FabricRecipeProvider.conditionsFromTag(ModTags.Items.RUBY_GEMS))
                .offerTo(recipeExporter, "ruby_shovel_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_HOE)
                .pattern("00")
                .pattern(" 1")
                .pattern(" 1")
                .input('0', ModTags.Items.RUBY_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RUBY), FabricRecipeProvider.conditionsFromTag(ModTags.Items.RUBY_GEMS))
                .offerTo(recipeExporter, "ruby_hoe_shaped");

        // Sapphire
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SAPPHIRE, 9)
                .input(ModTags.Items.SAPPHIRE_BLOCKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SAPPHIRE_BLOCK), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SAPPHIRE_BLOCKS))
                .offerTo(recipeExporter, "sapphire_material_by_block_shapeless");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAPPHIRE_HELMET)
                .pattern("000")
                .pattern("0 0")
                .input('0', ModTags.Items.SAPPHIRE_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SAPPHIRE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SAPPHIRE_GEMS))
                .offerTo(recipeExporter, "sapphire_helmet_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAPPHIRE_CHESTPLATE)
                .pattern("0 0")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.SAPPHIRE_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SAPPHIRE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SAPPHIRE_GEMS))
                .offerTo(recipeExporter, "sapphire_chestplate_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAPPHIRE_LEGGINGS)
                .pattern("000")
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.SAPPHIRE_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SAPPHIRE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SAPPHIRE_GEMS))
                .offerTo(recipeExporter, "sapphire_leggings_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SAPPHIRE_BOOTS)
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ModTags.Items.SAPPHIRE_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SAPPHIRE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SAPPHIRE_GEMS))
                .offerTo(recipeExporter, "sapphire_boots_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_BLOCK)
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.SAPPHIRE_GEMS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SAPPHIRE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SAPPHIRE_GEMS))
                .offerTo(recipeExporter, "sapphire_block_by_material_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SAPPHIRE_SWORD)
                .pattern("0")
                .pattern("0")
                .pattern("1")
                .input('0', ModTags.Items.SAPPHIRE_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SAPPHIRE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SAPPHIRE_GEMS))
                .offerTo(recipeExporter, "sapphire_sword_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SAPPHIRE_PICKAXE)
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .input('0', ModTags.Items.SAPPHIRE_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SAPPHIRE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SAPPHIRE_GEMS))
                .offerTo(recipeExporter, "sapphire_pickaxe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SAPPHIRE_AXE)
                .pattern("00")
                .pattern("01")
                .pattern(" 1")
                .input('0', ModTags.Items.SAPPHIRE_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SAPPHIRE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SAPPHIRE_GEMS))
                .offerTo(recipeExporter, "sapphire_axe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SAPPHIRE_SHOVEL)
                .pattern("0")
                .pattern("1")
                .pattern("1")
                .input('0', ModTags.Items.SAPPHIRE_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SAPPHIRE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SAPPHIRE_GEMS))
                .offerTo(recipeExporter, "sapphire_shovel_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SAPPHIRE_HOE)
                .pattern("00")
                .pattern(" 1")
                .pattern(" 1")
                .input('0', ModTags.Items.SAPPHIRE_GEMS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SAPPHIRE), FabricRecipeProvider.conditionsFromTag(ModTags.Items.SAPPHIRE_GEMS))
                .offerTo(recipeExporter, "sapphire_hoe_shaped");

        // Copper
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COPPER_NUGGET, 9)
                .input(ConventionalItemTags.COPPER_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.COPPER_INGOTS))
                .offerTo(recipeExporter, "copper_nugget_by_material_shapeless");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.COPPER_INGOT)
                .pattern("000")
                .pattern("000")
                .pattern("000")
                .input('0', ModTags.Items.COPPER_NUGGETS)
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.COPPER_INGOTS))
                .offerTo(recipeExporter, "copper_material_by_nugget_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_HELMET)
                .pattern("000")
                .pattern("0 0")
                .input('0', ConventionalItemTags.COPPER_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.COPPER_INGOTS))
                .offerTo(recipeExporter, "copper_helmet_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_CHESTPLATE)
                .pattern("0 0")
                .pattern("000")
                .pattern("000")
                .input('0', ConventionalItemTags.COPPER_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.COPPER_INGOTS))
                .offerTo(recipeExporter, "copper_chestplate_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_LEGGINGS)
                .pattern("000")
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ConventionalItemTags.COPPER_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.COPPER_INGOTS))
                .offerTo(recipeExporter, "copper_leggings_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.COPPER_BOOTS)
                .pattern("0 0")
                .pattern("0 0")
                .input('0', ConventionalItemTags.COPPER_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.COPPER_INGOTS))
                .offerTo(recipeExporter, "copper_boots_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SWORD)
                .pattern("0")
                .pattern("0")
                .pattern("1")
                .input('0', ConventionalItemTags.COPPER_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.COPPER_INGOTS))
                .offerTo(recipeExporter, "copper_sword_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE)
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .input('0', ConventionalItemTags.COPPER_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.COPPER_INGOTS))
                .offerTo(recipeExporter, "copper_pickaxe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_AXE)
                .pattern("00")
                .pattern("01")
                .pattern(" 1")
                .input('0', ConventionalItemTags.COPPER_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.COPPER_INGOTS))
                .offerTo(recipeExporter, "copper_axe_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL)
                .pattern("0")
                .pattern("1")
                .pattern("1")
                .input('0', ConventionalItemTags.COPPER_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.COPPER_INGOTS))
                .offerTo(recipeExporter, "copper_shovel_shaped");
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HOE)
                .pattern("00")
                .pattern(" 1")
                .pattern(" 1")
                .input('0', ConventionalItemTags.COPPER_INGOTS)
                .input('1', ConventionalItemTags.WOODEN_RODS)
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.COPPER_INGOTS))
                .offerTo(recipeExporter, "copper_hoe_shaped");
        offerSmelting(recipeExporter, List.of(ModItems.COPPER_DUST), RecipeCategory.MISC, Items.COPPER_INGOT, 0.5f, 200, "");
        offerBlasting(recipeExporter, List.of(ModItems.COPPER_DUST), RecipeCategory.MISC, Items.COPPER_INGOT, 0.5f, 100, "");

        // Other
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BATTERY)
                .pattern("010")
                .pattern("101")
                .pattern("010")
                .input('0', ConventionalItemTags.GOLD_INGOTS)
                .input('1', ConventionalItemTags.REDSTONE_DUSTS)
                .criterion(FabricRecipeProvider.hasItem(Items.GOLD_INGOT), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.GOLD_INGOTS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COMBINING_STATION)
                .pattern("000")
                .pattern("212")
                .pattern("111")
                .input('0', ConventionalItemTags.WOODEN_RODS)
                .input('1', ConventionalItemTags.COBBLESTONES)
                .input('2', ConventionalItemTags.PLAYER_WORKSTATIONS_FURNACES)
                .criterion(FabricRecipeProvider.hasItem(Items.FURNACE), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.PLAYER_WORKSTATIONS_FURNACES))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COMBINING_FACTORY)
                .pattern("010")
                .pattern("323")
                .pattern("010")
                .input('0', ConventionalItemTags.IRON_INGOTS)
                .input('1', ConventionalItemTags.STORAGE_BLOCKS_IRON)
                .input('2', ModBlocks.COMBINING_STATION)
                .input('3', ModItems.BATTERY)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.COMBINING_STATION), FabricRecipeProvider.conditionsFromItem(ModBlocks.COMBINING_STATION))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CRUSHING_STATION)
                .pattern("000")
                .pattern("232")
                .pattern("111")
                .input('0', ConventionalItemTags.WOODEN_RODS)
                .input('1', ConventionalItemTags.COBBLESTONES)
                .input('2', ConventionalItemTags.IRON_INGOTS)
                .input('3', ConventionalItemTags.STORAGE_BLOCKS_IRON)
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_BLOCK), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.STORAGE_BLOCKS_IRON))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CRUSHING_FACTORY)
                .pattern("010")
                .pattern("323")
                .pattern("010")
                .input('0', ConventionalItemTags.IRON_INGOTS)
                .input('1', ConventionalItemTags.STORAGE_BLOCKS_IRON)
                .input('2', ModBlocks.CRUSHING_STATION)
                .input('3', ModItems.BATTERY)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.CRUSHING_STATION), FabricRecipeProvider.conditionsFromItem(ModBlocks.CRUSHING_STATION))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CUTTING_FACTORY)
                .pattern("010")
                .pattern("323")
                .pattern("010")
                .input('0', ConventionalItemTags.IRON_INGOTS)
                .input('1', ConventionalItemTags.STORAGE_BLOCKS_IRON)
                .input('2', ModBlocks.CUTTING_STATION)
                .input('3', ModItems.BATTERY)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.CUTTING_STATION), FabricRecipeProvider.conditionsFromItem(ModBlocks.CUTTING_STATION))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COMBUSTION_GENERATOR)
                .pattern("010")
                .pattern("323")
                .pattern("010")
                .input('0', ConventionalItemTags.IRON_INGOTS)
                .input('1', ConventionalItemTags.STORAGE_BLOCKS_IRON)
                .input('2', ConventionalItemTags.PLAYER_WORKSTATIONS_FURNACES)
                .input('3', ModItems.BATTERY)
                .criterion(FabricRecipeProvider.hasItem(Items.FURNACE), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.PLAYER_WORKSTATIONS_FURNACES))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CUTTING_STATION)
                .pattern("000")
                .pattern("234")
                .pattern("111")
                .input('0', ConventionalItemTags.WOODEN_RODS)
                .input('1', ConventionalItemTags.COBBLESTONES)
                .input('2', ConventionalItemTags.EMPTY_BUCKETS)
                .input('3', ModTags.Items.DIAMOND_RAW_MATERIALS)
                .input('4', ConventionalItemTags.IRON_INGOTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.RAW_DIAMOND), FabricRecipeProvider.conditionsFromTag(ModTags.Items.DIAMOND_RAW_MATERIALS))
                .offerTo(recipeExporter);
    }
}
