package dev.tonimatas.krystalcraft.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.tonimatas.krystalcraft.recipe.input.SimpleRecipeInput;
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

public record CuttingRecipe(Ingredient ingredient, ItemStack result) implements Recipe<SimpleRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.ingredient);
        return list;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.CUTTING_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.CUTTING_RECIPE_TYPE;
    }

    @Override
    public boolean matches(SimpleRecipeInput input, World world) {
        if (world.isClient) {
            return false;
        }
        
        return ingredient.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(SimpleRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
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
    
    public static class Serializer implements RecipeSerializer<CuttingRecipe> {
        public static final MapCodec<CuttingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(CuttingRecipe::ingredient),
                ItemStack.CODEC.fieldOf("result").forGetter(CuttingRecipe::result)).apply(instance, CuttingRecipe::new));
        public static final PacketCodec<RegistryByteBuf, CuttingRecipe> STREAM_CODEC = PacketCodec.tuple(
                Ingredient.PACKET_CODEC, CuttingRecipe::ingredient,
                ItemStack.PACKET_CODEC, CuttingRecipe::result,
                CuttingRecipe::new);
        
        
        @Override
        public MapCodec<CuttingRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, CuttingRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}