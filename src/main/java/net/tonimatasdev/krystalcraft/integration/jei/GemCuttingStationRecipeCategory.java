package net.tonimatasdev.krystalcraft.integration.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.block.ModBlocks;
import net.tonimatasdev.krystalcraft.item.ModItems;
import net.tonimatasdev.krystalcraft.recipe.GemCuttingStationRecipe;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class GemCuttingStationRecipeCategory implements IRecipeCategory<GemCuttingStationRecipe> {
    private final IDrawable background;
    private final IDrawable icon;

    public GemCuttingStationRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(new ResourceLocation(KrystalCraft.MOD_ID, "textures/gui/gem_cutting_station_gui.png"), 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.GEM_CUTTING_STATION.get()));
    }

    @Override
    public @NotNull RecipeType<GemCuttingStationRecipe> getRecipeType() {
        return JEIKrystalCraftModPlugin.GEM_CUTTING;
    }

    @Override
    public @Nonnull Component getTitle() {
        return Component.literal("Gem Cutting Station");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull GemCuttingStationRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 34, 40).addIngredients(Ingredient.of(ModItems.SET_WATER_BOTTLES.get()));
        builder.addSlot(RecipeIngredientRole.INPUT, 57, 18).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 103, 18).addIngredients(Ingredient.of(ModItems.GEM_CUTTER_TOOL.get()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 60).addItemStack(recipe.getOutput());
    }
}
