package net.tonimatasdev.krystalcraft.compat.jei;

/*
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
import net.tonimatasdev.krystalcraft.recipe.CuttingStationRecipe;
import net.tonimatasdev.krystalcraft.registry.ModBlocks;
import net.tonimatasdev.krystalcraft.registry.ModItems;
import org.jetbrains.annotations.NotNull;

public class CuttingStationRecipeCategory implements IRecipeCategory<CuttingStationRecipe> {
    private final IDrawable background;
    private final IDrawable icon;

    public CuttingStationRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(new ResourceLocation(KrystalCraft.MOD_ID, "textures/gui/gem_cutting_station_gui.png"), 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CUTTING_STATION.get()));
    }

    @Override
    public @NotNull RecipeType<CuttingStationRecipe> getRecipeType() {
        return JEIKrystalCraftModPlugin.CUTTING_STATION;
    }

    @Override
    public @NotNull Component getTitle() {
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
    public void setRecipe(IRecipeLayoutBuilder builder, CuttingStationRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 34, 40).addIngredients(Ingredient.of(ModItems.SET_WATER_BOTTLES.get()));
        builder.addSlot(RecipeIngredientRole.INPUT, 57, 18).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 103, 18).addIngredients(Ingredient.of(ModItems.GEM_CUTTER_TOOL.get()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 60).addItemStack(recipe.getOutput());
    }
}
*/