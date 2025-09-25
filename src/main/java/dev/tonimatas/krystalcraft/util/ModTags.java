package dev.tonimatas.krystalcraft.util;

import net.fabricmc.fabric.api.tag.convention.v2.TagUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items {
        // Bronze
        public static TagKey<Item> BRONZE_INGOTS = register("ingots/bronze");
        public static TagKey<Item> BRONZE_NUGGETS = register("nuggets/bronze");
        public static TagKey<Item> BRONZE_DUSTS = register("dusts/bronze");
        public static TagKey<Item> BRONZE_BLOCKS = register("storage_blocks/bronze");

        // Jade
        public static TagKey<Item> JADE_RAW_MATERIALS = register("raw_materials/jade");
        public static TagKey<Item> JADE_GEMS = register("gems/jade");
        public static TagKey<Item> JADE_DUSTS = register("dusts/jade");
        public static TagKey<Item> JADE_BLOCKS = register("storage_blocks/jade");
        public static TagKey<Item> JADE_ORES = register("ores/jade");

        // Lead
        public static TagKey<Item> LEAD_RAW_MATERIALS = register("raw_materials/lead");
        public static TagKey<Item> LEAD_INGOTS = register("ingots/lead");
        public static TagKey<Item> LEAD_NUGGETS = register("nuggets/lead");
        public static TagKey<Item> LEAD_DUSTS = register("dusts/lead");
        public static TagKey<Item> LEAD_BLOCKS = register("storage_blocks/lead");
        public static TagKey<Item> LEAD_ORES = register("ores/lead");

        // Platinum
        public static TagKey<Item> PLATINUM_RAW_MATERIALS = register("raw_materials/platinum");
        public static TagKey<Item> PLATINUM_INGOTS = register("ingots/platinum");
        public static TagKey<Item> PLATINUM_NUGGETS = register("nuggets/platinum");
        public static TagKey<Item> PLATINUM_DUSTS = register("dusts/platinum");
        public static TagKey<Item> PLATINUM_BLOCKS = register("storage_blocks/platinum");
        public static TagKey<Item> PLATINUM_ORES = register("ores/platinum");

        // Ruby
        public static TagKey<Item> RUBY_RAW_MATERIALS = register("raw_materials/ruby");
        public static TagKey<Item> RUBY_GEMS = register("gems/ruby");
        public static TagKey<Item> RUBY_DUSTS = register("dusts/ruby");
        public static TagKey<Item> RUBY_BLOCKS = register("storage_blocks/ruby");
        public static TagKey<Item> RUBY_ORES = register("ores/ruby");

        // Sapphire
        public static TagKey<Item> SAPPHIRE_RAW_MATERIALS = register("raw_materials/sapphire");
        public static TagKey<Item> SAPPHIRE_GEMS = register("gems/sapphire");
        public static TagKey<Item> SAPPHIRE_DUSTS = register("dusts/sapphire");
        public static TagKey<Item> SAPPHIRE_BLOCKS = register("storage_blocks/sapphire");
        public static TagKey<Item> SAPPHIRE_ORES = register("ores/sapphire");

        // Platinum
        public static TagKey<Item> SILVER_RAW_MATERIALS = register("raw_materials/silver");
        public static TagKey<Item> SILVER_INGOTS = register("ingots/silver");
        public static TagKey<Item> SILVER_NUGGETS = register("nuggets/silver");
        public static TagKey<Item> SILVER_DUSTS = register("dusts/silver");
        public static TagKey<Item> SILVER_BLOCKS = register("storage_blocks/silver");
        public static TagKey<Item> SILVER_ORES = register("ores/silver");

        // Tin
        public static TagKey<Item> TIN_RAW_MATERIALS = register("raw_materials/tin");
        public static TagKey<Item> TIN_INGOTS = register("ingots/tin");
        public static TagKey<Item> TIN_NUGGETS = register("nuggets/tin");
        public static TagKey<Item> TIN_DUSTS = register("dusts/tin");
        public static TagKey<Item> TIN_BLOCKS = register("storage_blocks/tin");
        public static TagKey<Item> TIN_ORES = register("ores/tin");

        // Topaz
        public static TagKey<Item> TOPAZ_RAW_MATERIALS = register("raw_materials/topaz");
        public static TagKey<Item> TOPAZ_GEMS = register("gems/topaz");
        public static TagKey<Item> TOPAZ_DUSTS = register("dusts/topaz");
        public static TagKey<Item> TOPAZ_BLOCKS = register("storage_blocks/topaz");
        public static TagKey<Item> TOPAZ_ORES = register("ores/topaz");

        // Other
        public static TagKey<Item> COPPER_NUGGETS = register("nuggets/copper");
        public static TagKey<Item> COPPER_DUSTS = register("dusts/copper");
        public static TagKey<Item> DIAMOND_RAW_MATERIALS = register("raw_materials/diamond");
        public static TagKey<Item> DIAMOND_DUSTS = register("dusts/diamond");
        public static TagKey<Item> LAPIS_RAW_MATERIALS = register("raw_materials/lapis");
        public static TagKey<Item> LAPIS_DUSTS = register("dusts/lapis");
        public static TagKey<Item> EMERALD_RAW_MATERIALS = register("raw_materials/emerald");
        public static TagKey<Item> EMERALD_DUSTS = register("dusts/emerald");
        public static TagKey<Item> REDSTONE_RAW_MATERIALS = register("raw_materials/redstone");
        public static TagKey<Item> IRON_DUSTS = register("dusts/iron");
        public static TagKey<Item> EXPERIENCE_ORES = register("ores/experience");


        public static TagKey<Item> register(String tagId) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TagUtil.C_TAG_NAMESPACE, tagId));
        }
    }

    public static class Blocks {
        public static TagKey<Block> BRONZE_BLOCKS = register("storage_blocks/bronze");
        public static TagKey<Block> EXPERIENCE_ORES = register("ores/experience");
        public static TagKey<Block> JADE_BLOCKS = register("storage_blocks/jade");
        public static TagKey<Block> JADE_ORES = register("ores/jade");
        public static TagKey<Block> LEAD_BLOCKS = register("storage_blocks/lead");
        public static TagKey<Block> LEAD_ORES = register("ores/lead");
        public static TagKey<Block> PLATINUM_BLOCKS = register("storage_blocks/platinum");
        public static TagKey<Block> PLATINUM_ORES = register("ores/platinum");
        public static TagKey<Block> RUBY_BLOCKS = register("storage_blocks/ruby");
        public static TagKey<Block> RUBY_ORES = register("ores/ruby");
        public static TagKey<Block> SAPPHIRE_BLOCKS = register("storage_blocks/sapphire");
        public static TagKey<Block> SAPPHIRE_ORES = register("ores/sapphire");
        public static TagKey<Block> SILVER_BLOCKS = register("storage_blocks/silver");
        public static TagKey<Block> SILVER_ORES = register("ores/silver");
        public static TagKey<Block> TIN_BLOCKS = register("storage_blocks/tin");
        public static TagKey<Block> TIN_ORES = register("ores/tin");
        public static TagKey<Block> TOPAZ_BLOCKS = register("storage_blocks/topaz");
        public static TagKey<Block> TOPAZ_ORES = register("ores/topaz");

        public static TagKey<Block> register(String tagId) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TagUtil.C_TAG_NAMESPACE, tagId));
        }
    }
}
