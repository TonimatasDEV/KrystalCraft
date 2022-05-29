package net.tonimatasmc.krystalcraft.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.tonimatasmc.krystalcraft.KrystalCraft;
import net.tonimatasmc.krystalcraft.block.ModBlocks;
import net.tonimatasmc.krystalcraft.recipe.CoalCombinerRecipe;

import javax.annotation.Nonnull;

@SuppressWarnings("removal")
public class CoalCombinerRecipeCategory implements IRecipeCategory<CoalCombinerRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(KrystalCraft.MOD_ID, "coal_combiner");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(KrystalCraft.MOD_ID, "textures/gui/coal_combiner_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public CoalCombinerRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 91);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ModBlocks.COAL_COMBINER.get()));
    }

    @Override
    @Nonnull
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    @Nonnull
    public Class<? extends CoalCombinerRecipe> getRecipeClass() {
        return CoalCombinerRecipe.class;
    }

    @Override
    @Nonnull
    public Component getTitle() {
        return new TextComponent("Coal Combiner");
    }

    @Override
    @Nonnull
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    @Nonnull
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull CoalCombinerRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 70, 15).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 88, 15).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.INPUT, 80, 48).addIngredients(Ingredient.of(Items.COAL));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 70).addItemStack(recipe.getResultItem());
    }
}