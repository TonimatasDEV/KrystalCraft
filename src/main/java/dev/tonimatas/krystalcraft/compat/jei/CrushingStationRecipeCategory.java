package dev.tonimatas.krystalcraft.compat.jei;


import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.recipe.CrushingRecipe;
import dev.tonimatas.krystalcraft.registry.ModBlocks;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class CrushingStationRecipeCategory implements IRecipeCategory<CrushingRecipe> {
    public final static Identifier TEXTURE = Identifier.of(KrystalCraft.MOD_ID, "textures/gui/crushing_station.png");
    private final IDrawable background;
    private final IDrawable icon;

    public CrushingStationRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 82);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CRUSHING_STATION));
    }

    @Override
    public @NotNull RecipeType<CrushingRecipe> getRecipeType() {
        return JEIKrystalCraftPlugin.CRUSHING;
    }

    @Override
    public @NotNull Text getTitle() {
        return Text.literal("Crushing");
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
    public void setRecipe(IRecipeLayoutBuilder builder, CrushingRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 79, 5).addIngredients(recipe.ingredient());
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 64).addIngredients(Ingredient.ofItems(Items.COAL));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 133, 34).addItemStack(recipe.result());
    }
}
