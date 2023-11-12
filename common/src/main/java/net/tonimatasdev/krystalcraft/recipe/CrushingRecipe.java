package net.tonimatasdev.krystalcraft.recipe;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import dev.tonimatas.mythlib.util.RecipeUtils;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.tonimatasdev.krystalcraft.registry.ModRecipeSerializers;
import net.tonimatasdev.krystalcraft.registry.ModRecipes;
import org.jetbrains.annotations.NotNull;

public class CrushingRecipe implements Recipe<Container> {
    private final NonNullList<Ingredient> inputs;
    private final ItemStack output;

    public CrushingRecipe(NonNullList<Ingredient> inputs, ItemStack output) {
        this.inputs = inputs;
        this.output = output;
    }

    @Override
    public boolean matches(Container container, Level level) {
        return inputs.get(0).test(container.getItem(0));
    }

    @Override
    public @NotNull ItemStack assemble(Container container, RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(RegistryAccess registryAccess) {
        return this.output.copy();
    }

    public @NotNull ItemStack getOutput() {
        return this.output.copy();
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.CRUSHING_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return ModRecipes.CRUSHING.get();
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return this.inputs;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    //public static class Serializer implements RecipeSerializer<CrushingRecipe> { TODO: Finish port
    //    @Override
    //    public @NotNull CrushingRecipe fromJson(ResourceLocation id, JsonObject json) {
    //        final var ingredients = RecipeUtils.deserializeIngredients(GsonHelper.getAsJsonArray(json, "ingredients"));
    //        if (ingredients.isEmpty()) {
    //            throw new JsonParseException("No ingredients for Crushing");
    //        } else if (ingredients.size() > 1) {
    //            throw new JsonParseException("Too many ingredients for Crushing");
    //        } else {
    //            return new CrushingRecipe(id, ingredients, ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result")));
    //        }
    //    }
//
    //    @Override
    //    public @NotNull CrushingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
    //        final var ingredients = NonNullList.withSize(buf.readVarInt(), Ingredient.EMPTY);
    //        ingredients.replaceAll(ignored -> Ingredient.fromNetwork(buf));
    //        return new CrushingRecipe(id, ingredients, buf.readItem());
    //    }
//
    //    @Override
    //    public void toNetwork(FriendlyByteBuf buf, CrushingRecipe recipe) {
    //        buf.writeVarInt(recipe.inputs.size());
    //        recipe.inputs.forEach(entry -> entry.toNetwork(buf));
    //        buf.writeItem(recipe.output);
    //    }
    //}
}