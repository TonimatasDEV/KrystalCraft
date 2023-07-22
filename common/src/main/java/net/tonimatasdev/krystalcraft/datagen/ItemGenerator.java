package net.tonimatasdev.krystalcraft.datagen;

import java.util.HashMap;
import java.util.Map;

public class ItemGenerator {

    public ItemGenerator() {
        set("bronze", false, true, true, true, true, false, true, false);
        set("copper", false, false, true, true, true, false, true, false);
        set("jade", true, false, true, true, true, true, false, true);
        set("lead", false, true, true, true, true, true, true, false);
        set("platinum", false, true, true, true, true, true, true, false);
        set("ruby", true, false, true, true, true, true, false, false);
        set("sapphire", true, false, true, true, true, true, false, false);
        set("silver", false, true, true, true, true, true, true, false);
        set("tin", false, true, true, true, true, true, true, false);
        set("topaz", true, false, true, true, true, true, false, false);

        item("diamond_dust", false);
        item("emerald_dust", false);
        item("gem_cutter_tool", false);
        item("grinding_gear", false);
        item("iron_dust", false);
        item("lapis_dust", false);
        item("raw_diamond", false);
        item("raw_emerald", false);
        item("raw_lapis", false);
        item("raw_redstone", false);
        item("set_water_bottles", false);
    }

    private void set(String material, boolean item, boolean ingot, boolean armor, boolean tools, boolean dust, boolean raw, boolean nugget, boolean horse_armor) {
        if (item) {
            item(material, false);
        }

        if (ingot) {
            item(material + "_ingot", false);
        }

        if (armor) {
            item(material + "_helmet", false);
            item(material + "_chestplate", false);
            item(material + "_leggings", false);
            item(material + "_boots", false);
        }

        if (tools) {
            item(material + "_sword", true);
            item(material + "_pickaxe", true);
            item(material + "_axe", true);
            item(material + "_shovel", true);
            item(material + "_hoe", true);
        }

        if (dust) {
            item(material + "_dust", false);
        }

        if (raw) {
            item("raw_" + material, false);
        }

        if (nugget) {
            item(material + "_nugget", false);
        }

        if (horse_armor) {
            item(material + "_horse_armor", false);
        }
    }

    private void item(String value, boolean handheld) {
        Map<String, Object> itemJson = new HashMap<>();

        if (handheld) {
            itemJson.put("parent", "minecraft:item/handheld");
        } else {
            itemJson.put("parent", "minecraft:item/generated");
        }

        Map<String, String> textures = new HashMap<>();
        textures.put("layer0", "krystalcraft:item/" + value);
        itemJson.put("textures", textures);

        Main.write("common/src/generated/assets/krystalcraft/models/item/" + value + ".json", itemJson);
    }
}
