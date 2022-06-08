package net.tonimatasmc.krystalcraft.event;

import net.minecraftforge.fml.common.Mod;
import net.tonimatasmc.krystalcraft.KrystalCraft;

@Mod.EventBusSubscriber(modid = KrystalCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    //@SubscribeEvent
    //public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
    //    event.getRegistry().registerAll();
    //}
//
    //@SuppressWarnings("deprecation")
    //@SubscribeEvent
    //public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
    //    Registry.register(Registry.RECIPE_TYPE, GemCuttingStationRecipe.Type.ID, GemCuttingStationRecipe.Type.INSTANCE);
    //    Registry.register(Registry.RECIPE_TYPE, CoalCrusherRecipe.Type.ID, CoalCrusherRecipe.Type.INSTANCE);
    //    Registry.register(Registry.RECIPE_TYPE, CoalCombinerRecipe.Type.ID, CoalCombinerRecipe.Type.INSTANCE);
    //}
}