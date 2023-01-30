package net.tonimatasdev.krystalcraft.util;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.tonimatasdev.krystalcraft.KrystalCraft;

import java.util.function.Consumer;

public class RecipeProviderUtils {
    public static void createResourceKit(TagKey<Item> resourceNugget, TagKey<Item> resource, String resourceName, Item ingot, Item sword, Item pickaxe, Item axe, Item shovel, Item hoe, Item helmet, Item chestplate, Item leggings, Item boots, Block block, InventoryChangeTrigger.TriggerInstance triggerInstance, Consumer<FinishedRecipe> finishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, sword)
                .define('0', resource)
                .define('1', Items.STICK)
                .pattern("0")
                .pattern("0")
                .pattern("1")
                .unlockedBy("has_" + resourceName + "_ingot", triggerInstance)
                .group(KrystalCraft.MOD_ID)
                .save(finishedRecipeConsumer, getResourceName(resourceName, "sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pickaxe)
                .define('0', resource)
                .define('1', Items.STICK)
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .unlockedBy("has_" + resourceName + "_ingot", triggerInstance)
                .group(KrystalCraft.MOD_ID)
                .save(finishedRecipeConsumer, getResourceName(resourceName, "pickaxe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, axe)
                .define('0', resource)
                .define('1', Items.STICK)
                .pattern("00")
                .pattern("01")
                .pattern(" 1")
                .unlockedBy("has_" + resourceName + "_ingot", triggerInstance)
                .group(KrystalCraft.MOD_ID)
                .save(finishedRecipeConsumer, getResourceName(resourceName, "axe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, shovel)
                .define('0', resource)
                .define('1', Items.STICK)
                .pattern("0")
                .pattern("1")
                .pattern("1")
                .unlockedBy("has_" + resourceName + "_ingot", triggerInstance)
                .group(KrystalCraft.MOD_ID)
                .save(finishedRecipeConsumer, getResourceName(resourceName, "shovel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, hoe)
                .define('0', resource)
                .define('1', Items.STICK)
                .pattern("00")
                .pattern(" 1")
                .pattern(" 1")
                .unlockedBy("has_" + resourceName + "_ingot", triggerInstance)
                .group(KrystalCraft.MOD_ID)
                .save(finishedRecipeConsumer, getResourceName(resourceName, "hoe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, helmet)
                .define('0', resource)
                .pattern("000")
                .pattern("0 0")
                .unlockedBy("has_" + resourceName + "_ingot", triggerInstance)
                .group(KrystalCraft.MOD_ID)
                .save(finishedRecipeConsumer, getResourceName(resourceName, "helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, chestplate)
                .define('0', resource)
                .pattern("0 0")
                .pattern("000")
                .pattern("000")
                .unlockedBy("has_" + resourceName + "_ingot", triggerInstance)
                .group(KrystalCraft.MOD_ID)
                .save(finishedRecipeConsumer, getResourceName(resourceName, "chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, leggings)
                .define('0', resource)
                .pattern("000")
                .pattern("0 0")
                .pattern("0 0")
                .unlockedBy("has_" + resourceName + "_ingot", triggerInstance)
                .group(KrystalCraft.MOD_ID)
                .save(finishedRecipeConsumer, getResourceName(resourceName, "leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, boots)
                .define('0', resource)
                .pattern("0 0")
                .pattern("0 0")
                .unlockedBy("has_" + resourceName + "_ingot", triggerInstance)
                .group(KrystalCraft.MOD_ID)
                .save(finishedRecipeConsumer, getResourceName(resourceName, "boots"));

        if (resourceNugget != null && ingot != null) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ingot)
                    .define('0', resourceNugget)
                    .pattern("000")
                    .pattern("000")
                    .pattern("000")
                    .unlockedBy("has_" + resourceName + "_nugget", triggerInstance)
                    .group(KrystalCraft.MOD_ID)
                    .save(finishedRecipeConsumer, getResourceName(resourceName, "ingot"));
        }

        if (block != null) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block)
                    .define('0', resource)
                    .pattern("000")
                    .pattern("000")
                    .pattern("000")
                    .unlockedBy("has_" + resourceName + "_ingot", triggerInstance)
                    .group(KrystalCraft.MOD_ID)
                    .save(finishedRecipeConsumer, getResourceName(resourceName, "block"));
        }
    }

    private static ResourceLocation getResourceName(String resourceName, String itemType) {
        return new ResourceLocation(KrystalCraft.MOD_ID, "shaped/" + resourceName + "/" + resourceName + "_" + itemType);
    }
}
