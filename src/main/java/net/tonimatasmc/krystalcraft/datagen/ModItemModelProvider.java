package net.tonimatasmc.krystalcraft.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.tonimatasmc.krystalcraft.KrystalCraft;
import net.tonimatasmc.krystalcraft.item.ModItems;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, KrystalCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_LAPIS);
        simpleItem(ModItems.RAW_DIAMOND);
        simpleItem(ModItems.RAW_EMERALD);
        simpleItem(ModItems.RAW_REDSTONE);
        simpleItem(ModItems.DIAMOND_DUST);
        simpleItem(ModItems.EMERALD_DUST);
        simpleItem(ModItems.IRON_DUST);
        simpleItem(ModItems.BRONZE_INGOT);
        simpleItem(ModItems.BRONZE_DUST);
        simpleItem(ModItems.BRONZE_NUGGET);
        simpleItem(ModItems.BRONZE_HELMET);
        simpleItem(ModItems.BRONZE_CHESTPLATE);
        simpleItem(ModItems.BRONZE_LEGGINGS);
        simpleItem(ModItems.BRONZE_BOOTS);
        handheldItem(ModItems.BRONZE_SWORD);
        handheldItem(ModItems.BRONZE_PICKAXE);
        handheldItem(ModItems.BRONZE_AXE);
        handheldItem(ModItems.BRONZE_SHOVEL);
        handheldItem(ModItems.BRONZE_HOE);
        simpleItem(ModItems.LEAD_INGOT);
        simpleItem(ModItems.LEAD_DUST);
        simpleItem(ModItems.LEAD_NUGGET);
        simpleItem(ModItems.LEAD_HELMET);
        simpleItem(ModItems.LEAD_CHESTPLATE);
        simpleItem(ModItems.LEAD_LEGGINGS);
        simpleItem(ModItems.LEAD_BOOTS);
        simpleItem(ModItems.RAW_LEAD);
        handheldItem(ModItems.LEAD_SWORD);
        handheldItem(ModItems.LEAD_PICKAXE);
        handheldItem(ModItems.LEAD_AXE);
        handheldItem(ModItems.LEAD_SHOVEL);
        handheldItem(ModItems.LEAD_HOE);
        simpleItem(ModItems.PLATINUM_INGOT);
        simpleItem(ModItems.PLATINUM_DUST);
        simpleItem(ModItems.PLATINUM_NUGGET);
        simpleItem(ModItems.PLATINUM_HELMET);
        simpleItem(ModItems.PLATINUM_CHESTPLATE);
        simpleItem(ModItems.PLATINUM_LEGGINGS);
        simpleItem(ModItems.PLATINUM_BOOTS);
        simpleItem(ModItems.RAW_PLATINUM);
        handheldItem(ModItems.PLATINUM_SWORD);
        handheldItem(ModItems.PLATINUM_PICKAXE);
        handheldItem(ModItems.PLATINUM_AXE);
        handheldItem(ModItems.PLATINUM_SHOVEL);
        handheldItem(ModItems.PLATINUM_HOE);
        simpleItem(ModItems.TIN_INGOT);
        simpleItem(ModItems.TIN_DUST);
        simpleItem(ModItems.TIN_NUGGET);
        simpleItem(ModItems.TIN_HELMET);
        simpleItem(ModItems.TIN_CHESTPLATE);
        simpleItem(ModItems.TIN_LEGGINGS);
        simpleItem(ModItems.TIN_BOOTS);
        simpleItem(ModItems.RAW_TIN);
        handheldItem(ModItems.TIN_SWORD);
        handheldItem(ModItems.TIN_PICKAXE);
        handheldItem(ModItems.TIN_AXE);
        handheldItem(ModItems.TIN_SHOVEL);
        handheldItem(ModItems.TIN_HOE);
        simpleItem(ModItems.SILVER_INGOT);
        simpleItem(ModItems.SILVER_DUST);
        simpleItem(ModItems.SILVER_NUGGET);
        simpleItem(ModItems.SILVER_HELMET);
        simpleItem(ModItems.SILVER_CHESTPLATE);
        simpleItem(ModItems.SILVER_LEGGINGS);
        simpleItem(ModItems.SILVER_BOOTS);
        simpleItem(ModItems.RAW_SILVER);
        handheldItem(ModItems.SILVER_SWORD);
        handheldItem(ModItems.SILVER_PICKAXE);
        handheldItem(ModItems.SILVER_AXE);
        handheldItem(ModItems.SILVER_SHOVEL);
        handheldItem(ModItems.SILVER_HOE);
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.SAPPHIRE_DUST);
        simpleItem(ModItems.SAPPHIRE_HELMET);
        simpleItem(ModItems.SAPPHIRE_CHESTPLATE);
        simpleItem(ModItems.SAPPHIRE_LEGGINGS);
        simpleItem(ModItems.SAPPHIRE_BOOTS);
        simpleItem(ModItems.RAW_SAPPHIRE);
        handheldItem(ModItems.SAPPHIRE_SWORD);
        handheldItem(ModItems.SAPPHIRE_PICKAXE);
        handheldItem(ModItems.SAPPHIRE_AXE);
        handheldItem(ModItems.SAPPHIRE_SHOVEL);
        handheldItem(ModItems.SAPPHIRE_HOE);
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.RUBY_DUST);
        simpleItem(ModItems.RUBY_HELMET);
        simpleItem(ModItems.RUBY_CHESTPLATE);
        simpleItem(ModItems.RUBY_LEGGINGS);
        simpleItem(ModItems.RUBY_BOOTS);
        simpleItem(ModItems.RAW_RUBY);
        handheldItem(ModItems.RUBY_SWORD);
        handheldItem(ModItems.RUBY_PICKAXE);
        handheldItem(ModItems.RUBY_AXE);
        handheldItem(ModItems.RUBY_SHOVEL);
        handheldItem(ModItems.RUBY_HOE);
        simpleItem(ModItems.JADE);
        simpleItem(ModItems.JADE_DUST);
        simpleItem(ModItems.JADE_HELMET);
        simpleItem(ModItems.JADE_CHESTPLATE);
        simpleItem(ModItems.JADE_LEGGINGS);
        simpleItem(ModItems.JADE_BOOTS);
        simpleItem(ModItems.JADE_HORSE_ARMOR);
        simpleItem(ModItems.RAW_JADE);
        handheldItem(ModItems.JADE_SWORD);
        handheldItem(ModItems.JADE_PICKAXE);
        handheldItem(ModItems.JADE_AXE);
        handheldItem(ModItems.JADE_SHOVEL);
        handheldItem(ModItems.JADE_HOE);
        simpleItem(ModItems.COPPER_NUGGET);
        simpleItem(ModItems.COPPER_DUST);
        simpleItem(ModItems.COPPER_HELMET);
        simpleItem(ModItems.COPPER_CHESTPLATE);
        simpleItem(ModItems.COPPER_LEGGINGS);
        simpleItem(ModItems.COPPER_BOOTS);
        handheldItem(ModItems.COPPER_SWORD);
        handheldItem(ModItems.COPPER_PICKAXE);
        handheldItem(ModItems.COPPER_AXE);
        handheldItem(ModItems.COPPER_SHOVEL);
        handheldItem(ModItems.COPPER_HOE);
        simpleItem(ModItems.TOPAZ);
        simpleItem(ModItems.TOPAZ_DUST);
        simpleItem(ModItems.TOPAZ_HELMET);
        simpleItem(ModItems.TOPAZ_CHESTPLATE);
        simpleItem(ModItems.TOPAZ_LEGGINGS);
        simpleItem(ModItems.TOPAZ_BOOTS);
        simpleItem(ModItems.RAW_TOPAZ);
        handheldItem(ModItems.TOPAZ_SWORD);
        handheldItem(ModItems.TOPAZ_PICKAXE);
        handheldItem(ModItems.TOPAZ_AXE);
        handheldItem(ModItems.TOPAZ_SHOVEL);
        handheldItem(ModItems.TOPAZ_HOE);
        simpleItem(ModItems.GEM_CUTTER_TOOL);
        simpleItem(ModItems.SET_WATER_BOTTLES);
        simpleItem(ModItems.LAPIS_DUST);
    }

    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(Objects.requireNonNull(item.getId()).getPath(), new ResourceLocation("item/generated")).texture("layer0", new ResourceLocation(KrystalCraft.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void handheldItem(RegistryObject<Item> item) {
        withExistingParent(Objects.requireNonNull(item.getId()).getPath(), new ResourceLocation("item/handheld")).texture("layer0", new ResourceLocation(KrystalCraft.MOD_ID, "item/" + item.getId().getPath()));
    }
}

