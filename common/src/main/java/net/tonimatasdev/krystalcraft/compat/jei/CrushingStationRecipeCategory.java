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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.recipe.CrushingStationRecipe;
import net.tonimatasdev.krystalcraft.registry.ModBlocks;
import net.tonimatasdev.krystalcraft.registry.ModItems;
import org.jetbrains.annotations.NotNull;

public class CrushingStationRecipeCategory implements IRecipeCategory<CrushingStationRecipe> {
    public final static ResourceLocation TEXTURE = new ResourceLocation(KrystalCraft.MOD_ID, "textures/gui/coal_crusher_gui.png");
    private final IDrawable background;
    private final IDrawable icon;

    public CrushingStationRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 82);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CRUSHING_STATION.get()));
    }

    @Override
    public @NotNull RecipeType<CrushingStationRecipe> getRecipeType() {
        return JEIKrystalCraftModPlugin.CRUSHING_STATION;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.literal("Coal Crusher");
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
    public void setRecipe(IRecipeLayoutBuilder builder, CrushingStationRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 25, 34).addIngredients(Ingredient.of(ModItems.SET_WATER_BOTTLES.get()));
        builder.addSlot(RecipeIngredientRole.INPUT, 79, 5).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 79, 34).addIngredients(Ingredient.of(ModItems.GRINDING_GEAR.get()));
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 64).addIngredients(Ingredient.of(Items.COAL));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 133, 34).addItemStack(recipe.getOutput());
    }
}
*/