package net.tonimatasmc.krystalcraft.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.tonimatasmc.krystalcraft.KrystalCraft;
import net.tonimatasmc.krystalcraft.item.ModItems;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, KrystalCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_LAPIS.get());
        simpleItem(ModItems.RAW_DIAMOND.get());
        simpleItem(ModItems.RAW_EMERALD.get());
        simpleItem(ModItems.RAW_REDSTONE.get());
        simpleItem(ModItems.DIAMOND_DUST.get());
        simpleItem(ModItems.EMERALD_DUST.get());
        simpleItem(ModItems.IRON_DUST.get());

        simpleItem(ModItems.BRONZE_INGOT.get());
        simpleItem(ModItems.BRONZE_DUST.get());
        simpleItem(ModItems.BRONZE_NUGGET.get());
        simpleItem(ModItems.BRONZE_HELMET.get());
        simpleItem(ModItems.BRONZE_CHESTPLATE.get());
        simpleItem(ModItems.BRONZE_LEGGINGS.get());
        simpleItem(ModItems.BRONZE_BOOTS.get());

        handheldItem(ModItems.BRONZE_SWORD.get());
        handheldItem(ModItems.BRONZE_PICKAXE.get());
        handheldItem(ModItems.BRONZE_AXE.get());
        handheldItem(ModItems.BRONZE_SHOVEL.get());
        handheldItem(ModItems.BRONZE_HOE.get());

        simpleItem(ModItems.LEAD_INGOT.get());
        simpleItem(ModItems.LEAD_DUST.get());
        simpleItem(ModItems.LEAD_NUGGET.get());
        simpleItem(ModItems.LEAD_HELMET.get());
        simpleItem(ModItems.LEAD_CHESTPLATE.get());
        simpleItem(ModItems.LEAD_LEGGINGS.get());
        simpleItem(ModItems.LEAD_BOOTS.get());
        simpleItem(ModItems.RAW_LEAD.get());

        handheldItem(ModItems.LEAD_SWORD.get());
        handheldItem(ModItems.LEAD_PICKAXE.get());
        handheldItem(ModItems.LEAD_AXE.get());
        handheldItem(ModItems.LEAD_SHOVEL.get());
        handheldItem(ModItems.LEAD_HOE.get());

        simpleItem(ModItems.PLATINUM_INGOT.get());
        simpleItem(ModItems.PLATINUM_DUST.get());
        simpleItem(ModItems.PLATINUM_NUGGET.get());
        simpleItem(ModItems.PLATINUM_HELMET.get());
        simpleItem(ModItems.PLATINUM_CHESTPLATE.get());
        simpleItem(ModItems.PLATINUM_LEGGINGS.get());
        simpleItem(ModItems.PLATINUM_BOOTS.get());
        simpleItem(ModItems.RAW_PLATINUM.get());

        handheldItem(ModItems.PLATINUM_SWORD.get());
        handheldItem(ModItems.PLATINUM_PICKAXE.get());
        handheldItem(ModItems.PLATINUM_AXE.get());
        handheldItem(ModItems.PLATINUM_SHOVEL.get());
        handheldItem(ModItems.PLATINUM_HOE.get());

        simpleItem(ModItems.TIN_INGOT.get());
        simpleItem(ModItems.TIN_DUST.get());
        simpleItem(ModItems.TIN_NUGGET.get());
        simpleItem(ModItems.TIN_HELMET.get());
        simpleItem(ModItems.TIN_CHESTPLATE.get());
        simpleItem(ModItems.TIN_LEGGINGS.get());
        simpleItem(ModItems.TIN_BOOTS.get());
        simpleItem(ModItems.RAW_TIN.get());

        handheldItem(ModItems.TIN_SWORD.get());
        handheldItem(ModItems.TIN_PICKAXE.get());
        handheldItem(ModItems.TIN_AXE.get());
        handheldItem(ModItems.TIN_SHOVEL.get());
        handheldItem(ModItems.TIN_HOE.get());

        simpleItem(ModItems.SILVER_INGOT.get());
        simpleItem(ModItems.SILVER_DUST.get());
        simpleItem(ModItems.SILVER_NUGGET.get());
        simpleItem(ModItems.SILVER_HELMET.get());
        simpleItem(ModItems.SILVER_CHESTPLATE.get());
        simpleItem(ModItems.SILVER_LEGGINGS.get());
        simpleItem(ModItems.SILVER_BOOTS.get());
        simpleItem(ModItems.RAW_SILVER.get());

        handheldItem(ModItems.SILVER_SWORD.get());
        handheldItem(ModItems.SILVER_PICKAXE.get());
        handheldItem(ModItems.SILVER_AXE.get());
        handheldItem(ModItems.SILVER_SHOVEL.get());
        handheldItem(ModItems.SILVER_HOE.get());

        simpleItem(ModItems.SAPPHIRE.get());
        simpleItem(ModItems.SAPPHIRE_DUST.get());
        simpleItem(ModItems.SAPPHIRE_HELMET.get());
        simpleItem(ModItems.SAPPHIRE_CHESTPLATE.get());
        simpleItem(ModItems.SAPPHIRE_LEGGINGS.get());
        simpleItem(ModItems.SAPPHIRE_BOOTS.get());
        simpleItem(ModItems.RAW_SAPPHIRE.get());

        handheldItem(ModItems.SAPPHIRE_SWORD.get());
        handheldItem(ModItems.SAPPHIRE_PICKAXE.get());
        handheldItem(ModItems.SAPPHIRE_AXE.get());
        handheldItem(ModItems.SAPPHIRE_SHOVEL.get());
        handheldItem(ModItems.SAPPHIRE_HOE.get());

        simpleItem(ModItems.RUBY.get());
        simpleItem(ModItems.RUBY_DUST.get());
        simpleItem(ModItems.RUBY_HELMET.get());
        simpleItem(ModItems.RUBY_CHESTPLATE.get());
        simpleItem(ModItems.RUBY_LEGGINGS.get());
        simpleItem(ModItems.RUBY_BOOTS.get());
        simpleItem(ModItems.RAW_RUBY.get());

        handheldItem(ModItems.RUBY_SWORD.get());
        handheldItem(ModItems.RUBY_PICKAXE.get());
        handheldItem(ModItems.RUBY_AXE.get());
        handheldItem(ModItems.RUBY_SHOVEL.get());
        handheldItem(ModItems.RUBY_HOE.get());

        simpleItem(ModItems.JADE.get());
        simpleItem(ModItems.JADE_DUST.get());
        simpleItem(ModItems.JADE_HELMET.get());
        simpleItem(ModItems.JADE_CHESTPLATE.get());
        simpleItem(ModItems.JADE_LEGGINGS.get());
        simpleItem(ModItems.JADE_BOOTS.get());
        simpleItem(ModItems.JADE_HORSE_ARMOR.get());
        simpleItem(ModItems.RAW_JADE.get());

        handheldItem(ModItems.JADE_SWORD.get());
        handheldItem(ModItems.JADE_PICKAXE.get());
        handheldItem(ModItems.JADE_AXE.get());
        handheldItem(ModItems.JADE_SHOVEL.get());
        handheldItem(ModItems.JADE_HOE.get());

        simpleItem(ModItems.COPPER_NUGGET.get());
        simpleItem(ModItems.COPPER_DUST.get());
        simpleItem(ModItems.COPPER_HELMET.get());
        simpleItem(ModItems.COPPER_CHESTPLATE.get());
        simpleItem(ModItems.COPPER_LEGGINGS.get());
        simpleItem(ModItems.COPPER_BOOTS.get());

        handheldItem(ModItems.COPPER_SWORD.get());
        handheldItem(ModItems.COPPER_PICKAXE.get());
        handheldItem(ModItems.COPPER_AXE.get());
        handheldItem(ModItems.COPPER_SHOVEL.get());
        handheldItem(ModItems.COPPER_HOE.get());

        simpleItem(ModItems.TOPAZ.get());
        simpleItem(ModItems.TOPAZ_DUST.get());
        simpleItem(ModItems.TOPAZ_HELMET.get());
        simpleItem(ModItems.TOPAZ_CHESTPLATE.get());
        simpleItem(ModItems.TOPAZ_LEGGINGS.get());
        simpleItem(ModItems.TOPAZ_BOOTS.get());
        simpleItem(ModItems.RAW_TOPAZ.get());

        handheldItem(ModItems.TOPAZ_SWORD.get());
        handheldItem(ModItems.TOPAZ_PICKAXE.get());
        handheldItem(ModItems.TOPAZ_AXE.get());
        handheldItem(ModItems.TOPAZ_SHOVEL.get());
        handheldItem(ModItems.TOPAZ_HOE.get());

    }

    private void simpleItem(Item item) {
        withExistingParent(Objects.requireNonNull(item.getRegistryName()).getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(KrystalCraft.MOD_ID, "item/" + item.getRegistryName().getPath()));
    }

    private void handheldItem(Item item) {
        withExistingParent(Objects.requireNonNull(item.getRegistryName()).getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(KrystalCraft.MOD_ID, "item/" + item.getRegistryName().getPath()));
    }
}

