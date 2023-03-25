package net.tonimatasdev.krystalcraft.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.tonimatasdev.krystalcraft.KrystalCraft;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ORES = forgeTag("ores");
        public static final TagKey<Block> STORAGE_BLOCKS = forgeTag("storage_blocks");
        public static final TagKey<Block> EXPERIENCE_ORE = forgeTag("ores/experience");
        public static final TagKey<Block> JADE_ORE = forgeTag("ores/jade");
        public static final TagKey<Block> LEAD_ORE = forgeTag("ores/lead");
        public static final TagKey<Block> PLATINUM_ORE = forgeTag("ores/platinum");
        public static final TagKey<Block> RUBY_ORE = forgeTag("ores/ruby");
        public static final TagKey<Block> SAPPHIRE_ORE = forgeTag("ores/sapphire");
        public static final TagKey<Block> SILVER_ORE = forgeTag("ores/silver");
        public static final TagKey<Block> TIN_ORE = forgeTag("ores/tin");
        public static final TagKey<Block> TOPAZ_ORE = forgeTag("ores/topaz");
        public static final TagKey<Block> BRONZE_BLOCK = forgeTag("storage_blocks/bronze");
        public static final TagKey<Block> JADE_BLOCK = forgeTag("storage_blocks/jade");
        public static final TagKey<Block> LEAD_BLOCK = forgeTag("storage_blocks/lead");
        public static final TagKey<Block> PLATINUM_BLOCK = forgeTag("storage_blocks/platinum");
        public static final TagKey<Block> RUBY_BLOCK = forgeTag("storage_blocks/ruby");
        public static final TagKey<Block> SAPPHIRE_BLOCK = forgeTag("storage_blocks/sapphire");
        public static final TagKey<Block> SILVER_BLOCK = forgeTag("storage_blocks/silver");
        public static final TagKey<Block> TIN_BLOCK = forgeTag("storage_blocks/tin");
        public static final TagKey<Block> TOPAZ_BLOCK = forgeTag("storage_blocks/topaz");


        @SuppressWarnings("unused")
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(KrystalCraft.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> DUSTS = forgeTag("dusts");
        public static final TagKey<Item> GEMS = forgeTag("gems");
        public static final TagKey<Item> INGOTS = forgeTag("ingots");
        public static final TagKey<Item> NUGGETS = forgeTag("nuggets");
        public static final TagKey<Item> RAW_MATERIALS = forgeTag("raw_materials");
        public static final TagKey<Item> ORES = forgeTag("ores");
        public static final TagKey<Item> STORAGE_BLOCKS = forgeTag("storage_blocks");
        public static final TagKey<Item> BRONZE_DUST = forgeTag("dusts/bronze");
        public static final TagKey<Item> COPPER_DUST = forgeTag("dusts/copper");
        public static final TagKey<Item> JADE_DUST = forgeTag("dusts/jade");
        public static final TagKey<Item> LEAD_DUST = forgeTag("dusts/lead");
        public static final TagKey<Item> PLATINUM_DUST = forgeTag("dusts/platinum");
        public static final TagKey<Item> RUBY_DUST = forgeTag("dusts/ruby");
        public static final TagKey<Item> SAPPHIRE_DUST = forgeTag("dusts/sapphire");
        public static final TagKey<Item> SILVER_DUST = forgeTag("dusts/silver");
        public static final TagKey<Item> TIN_DUST = forgeTag("dusts/tin");
        public static final TagKey<Item> TOPAZ_DUST = forgeTag("dusts/topaz");
        public static final TagKey<Item> DIAMOND_DUST = forgeTag("dusts/diamond");
        public static final TagKey<Item> EMERALD_DUST = forgeTag("dusts/emerald");
        public static final TagKey<Item> LAPIS_DUST = forgeTag("dusts/lapis");
        public static final TagKey<Item> IRON_DUST = forgeTag("dusts/iron");
        public static final TagKey<Item> JADE_GEM = forgeTag("gems/jade");
        public static final TagKey<Item> RUBY_GEM = forgeTag("gems/ruby");
        public static final TagKey<Item> SAPPHIRE_GEM = forgeTag("gems/sapphire");
        public static final TagKey<Item> TOPAZ_GEM = forgeTag("gems/topaz");
        public static final TagKey<Item> BRONZE_INGOT = forgeTag("ingots/bronze");
        public static final TagKey<Item> LEAD_INGOT = forgeTag("ingots/lead");
        public static final TagKey<Item> PLATINUM_INGOT = forgeTag("ingots/platinum");
        public static final TagKey<Item> SILVER_INGOT = forgeTag("ingots/silver");
        public static final TagKey<Item> TIN_INGOT = forgeTag("ingots/tin");
        public static final TagKey<Item> BRONZE_NUGGETS = forgeTag("nuggets/bronze");
        public static final TagKey<Item> COPPER_NUGGETS = forgeTag("nuggets/copper");
        public static final TagKey<Item> LEAD_NUGGETS = forgeTag("nuggets/lead");
        public static final TagKey<Item> PLATINUM_NUGGETS = forgeTag("nuggets/platinum");
        public static final TagKey<Item> SILVER_NUGGETS = forgeTag("nuggets/silver");
        public static final TagKey<Item> TIN_NUGGETS = forgeTag("nuggets/tin");
        public static final TagKey<Item> EXPERIENCE_ORE = forgeTag("ores/experience");
        public static final TagKey<Item> JADE_ORE = forgeTag("ores/jade");
        public static final TagKey<Item> LEAD_ORE = forgeTag("ores/lead");
        public static final TagKey<Item> PLATINUM_ORE = forgeTag("ores/platinum");
        public static final TagKey<Item> RUBY_ORE = forgeTag("ores/ruby");
        public static final TagKey<Item> SAPPHIRE_ORE = forgeTag("ores/sapphire");
        public static final TagKey<Item> SILVER_ORE = forgeTag("ores/silver");
        public static final TagKey<Item> TIN_ORE = forgeTag("ores/tin");
        public static final TagKey<Item> TOPAZ_ORE = forgeTag("ores/topaz");
        public static final TagKey<Item> BRONZE_BLOCK = forgeTag("storage_blocks/bronze");
        public static final TagKey<Item> JADE_BLOCK = forgeTag("storage_blocks/jade");
        public static final TagKey<Item> LEAD_BLOCK = forgeTag("storage_blocks/lead");
        public static final TagKey<Item> PLATINUM_BLOCK = forgeTag("storage_blocks/platinum");
        public static final TagKey<Item> RUBY_BLOCK = forgeTag("storage_blocks/ruby");
        public static final TagKey<Item> SAPPHIRE_BLOCK = forgeTag("storage_blocks/sapphire");
        public static final TagKey<Item> SILVER_BLOCK = forgeTag("storage_blocks/silver");
        public static final TagKey<Item> TIN_BLOCK = forgeTag("storage_blocks/tin");
        public static final TagKey<Item> TOPAZ_BLOCK = forgeTag("storage_blocks/topaz");
        public static final TagKey<Item> JADE_RAW_MATERIAL = forgeTag("raw_materials/jade");
        public static final TagKey<Item> LEAD_RAW_MATERIAL = forgeTag("raw_materials/lead");
        public static final TagKey<Item> PLATINUM_RAW_MATERIAL = forgeTag("raw_materials/platinum");
        public static final TagKey<Item> RUBY_RAW_MATERIAL = forgeTag("raw_materials/ruby");
        public static final TagKey<Item> SAPPHIRE_RAW_MATERIAL = forgeTag("raw_materials/sapphire");
        public static final TagKey<Item> SILVER_RAW_MATERIAL = forgeTag("raw_materials/silver");
        public static final TagKey<Item> TIN_RAW_MATERIAL = forgeTag("raw_materials/tin");
        public static final TagKey<Item> TOPAZ_RAW_MATERIAL = forgeTag("raw_materials/topaz");
        public static final TagKey<Item> DIAMOND_RAW_MATERIAL = forgeTag("raw_materials/diamond");
        public static final TagKey<Item> EMERALD_RAW_MATERIAL = forgeTag("raw_materials/emerald");
        public static final TagKey<Item> LAPIS_RAW_MATERIAL = forgeTag("raw_materials/lapis");
        public static final TagKey<Item> REDSTONE_RAW_MATERIAL = forgeTag("raw_materials/lapis");

        @SuppressWarnings("unused")
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(KrystalCraft.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
