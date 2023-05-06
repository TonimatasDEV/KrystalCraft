package net.tonimatasdev.krystalcraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, KrystalCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
            simpleItem(item);
        }

        for (RegistryObject<Item> tool : ModItems.TOOL_ITEMS.getEntries()) {
            handheldItem(tool);
        }

        for (RegistryObject<Item> armor : ModItems.ARMOR_ITEMS.getEntries()) {
            simpleItem(armor);
        }
    }

    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0", new ResourceLocation(KrystalCraft.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void handheldItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(), new ResourceLocation("item/handheld")).texture("layer0", new ResourceLocation(KrystalCraft.MOD_ID, "item/" + item.getId().getPath()));
    }
}

