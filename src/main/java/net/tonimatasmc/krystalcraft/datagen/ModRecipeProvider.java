package net.tonimatasmc.krystalcraft.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.tonimatasmc.krystalcraft.item.ModItems;
import net.tonimatasmc.krystalcraft.util.ModTags;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> pFinishedConsumer) {
        ShapedRecipeBuilder.shaped(ModItems.BRONZE_AXE.get())
                .define('E', ModTags.Items.BRONZE_INGOT)
                .define('F', Items.STICK)
                .pattern("EE")
                .pattern("FE")
                .pattern("F ")
                .unlockedBy("has_bronze_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.BRONZE_INGOT.get()).build()))
                .save(pFinishedConsumer);

        //ShapedRecipeBuilder.shaped(ModItems.BRONZE_AXE.get())
        //        .define('0', ModTags.Items.BRONZE_INGOT)
        //        .define('1', Items.STICK)
        //        .pattern("00")
        //        .pattern("01")
        //        .pattern(" 1")
        //        .save(pFinishedConsumer);
//
        //ShapedRecipeBuilder.shaped(ModBlocks.BRONZE_BLOCK.get())
        //        .define('0', ModItems.BRONZE_INGOT.get())
        //        .pattern("000")
        //        .pattern("000")
        //        .pattern("000")
        //        .unlockedBy("has_bronze_ingot", inventoryTrigger(ItemPredicate.Builder.item()
        //                .of(ModItems.BRONZE_INGOT.get()).build()))
        //        .save(pFinishedConsumer);

        //ShapedRecipeBuilder.shaped(ModItems.BRONZE_BOOTS.get())
        //        .define('0', ModTags.Items.BRONZE_INGOT)
        //        .pattern("0 0")
        //        .pattern("0 0")
        //        .save(pFinishedConsumer);
//
        //ShapedRecipeBuilder.shaped(ModItems.BRONZE_CHESTPLATE.get())
        //        .define('0', ModTags.Items.BRONZE_INGOT)
        //        .pattern("0 0")
        //        .pattern("000")
        //        .pattern("000")
        //        .save(pFinishedConsumer);
//
        //ShapedRecipeBuilder.shaped(ModItems.BRONZE_HELMET.get())
        //        .define('0', ModTags.Items.BRONZE_INGOT)
        //        .pattern("000")
        //        .pattern("0 0")
        //        .save(pFinishedConsumer);
//
        //ShapedRecipeBuilder.shaped(ModItems.BRONZE_HOE.get())
        //        .define('0', ModTags.Items.BRONZE_INGOT)
        //        .define('1', Items.STICK)
        //        .pattern("00")
        //        .pattern(" 1")
        //        .pattern(" 1")
        //        .save(pFinishedConsumer);
//
        //ShapedRecipeBuilder.shaped(ModItems.BRONZE_HOE.get())
        //        .define('0', ModTags.Items.BRONZE_INGOT)
        //        .define('1', Items.STICK)
        //        .pattern("00")
        //        .pattern("1 ")
        //        .pattern("1 ")
        //        .save(pFinishedConsumer);
//
        //ShapedRecipeBuilder.shaped(ModItems.BRONZE_INGOT.get())
        //        .define('0', ModTags.Items.BRONZE_NUGGETS)
        //        .pattern("000")
        //        .pattern("000")
        //        .pattern("000")
        //        .save(pFinishedConsumer);
//
        //ShapedRecipeBuilder.shaped(ModItems.BRONZE_LEGGINGS.get())
        //        .define('0', ModTags.Items.BRONZE_INGOT)
        //        .pattern("000")
        //        .pattern("0 0")
        //        .pattern("0 0")
        //        .save(pFinishedConsumer);
//
        //ShapedRecipeBuilder.shaped(ModItems.BRONZE_PICKAXE.get())
        //        .define('0', ModTags.Items.BRONZE_INGOT)
        //        .define('1', Items.STICK)
        //        .pattern("000")
        //        .pattern(" 1 ")
        //        .pattern(" 1 ")
        //        .save(pFinishedConsumer);
    }
}
