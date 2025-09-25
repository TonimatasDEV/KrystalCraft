package dev.tonimatas.krystalcraft.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.tonimatas.krystalcraft.recipe.input.CombiningRecipeInput;
import dev.tonimatas.krystalcraft.registry.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record CombiningRecipe(Ingredient ingredients, ItemStack result) implements Recipe<CombiningRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.ingredients);
        return list;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.COMBINING_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.COMBINING_RECIPE_TYPE;
    }

    @Override
    public boolean matches(CombiningRecipeInput input, World world) {
        if (world.isClient) {
            return false;
        }

        return ingredients.test(input.getStackInSlot(0)) && ingredients.test(input.getStackInSlot(1));
    }

    @Override
    public ItemStack craft(CombiningRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return result.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return result;
    }

    public static class Serializer implements RecipeSerializer<CombiningRecipe> {
        public static final MapCodec<CombiningRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredients").forGetter(CombiningRecipe::ingredients),
                ItemStack.CODEC.fieldOf("result").forGetter(CombiningRecipe::result)).apply(instance, CombiningRecipe::new));
        public static final PacketCodec<RegistryByteBuf, CombiningRecipe> STREAM_CODEC = PacketCodec.tuple(
                Ingredient.PACKET_CODEC, CombiningRecipe::ingredients,
                ItemStack.PACKET_CODEC, CombiningRecipe::result,
                CombiningRecipe::new);


        @Override
        public MapCodec<CombiningRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, CombiningRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}