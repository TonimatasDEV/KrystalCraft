package net.tonimatasdev.krystalcraft.data.providers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.tonimatasdev.krystalcraft.data.DataGenerator;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class TagProvider {
    public static String commonTagDir = DataGenerator.commonDataDir + "\\data\\krystalcraft\\tags";
    public static String fabricTagDir = DataGenerator.fabricDataDir + "\\data\\c\\tags";
    public static String forgeTagDir = DataGenerator.forgeDataDir + "\\data\\forge\\tags";

    public static void init() {
        new File(commonTagDir).mkdirs();
        new File(fabricTagDir).mkdirs();
        new File(forgeTagDir).mkdirs();

        Map<String, List<String>> tags = new HashMap<>();

        // Storage Blocks tags
        tags.put("jade", List.of("jade_block"));
        tags.put("lead", List.of("lead_block"));
        tags.put("platinum", List.of("platinum_block"));
        tags.put("ruby", List.of("ruby_block"));
        tags.put("sapphire", List.of("sapphire_block"));
        tags.put("silver", List.of("silver_block"));
        tags.put("tin", List.of("tin_block"));
        tags.put("topaz", List.of("topaz_block"));
        createTag("storage_blocks", true, tags);
        tags.clear();

        // Ores tags
        tags.put("jade", List.of("jade_ore", "deepslate_jade_ore"));
        tags.put("experience", List.of("experience_ore", "deepslate_experience_ore"));
        tags.put("lead", List.of("lead_ore", "deepslate_lead_ore"));
        tags.put("platinum", List.of("platinum_ore", "deepslate_platinum_ore"));
        tags.put("ruby", List.of("ruby_ore", "deepslate_ruby_ore"));
        tags.put("sapphire", List.of("sapphire_ore", "deepslate_sapphire_ore"));
        tags.put("silver", List.of("silver_ore", "deepslate_silver_ore"));
        tags.put("tin", List.of("tin_ore", "deepslate_tin_ore"));
        tags.put("topaz", List.of("topaz_ore", "deepslate_topaz_ore"));
        createTag("ores", true, tags);
        tags.clear();

        // Dusts tags
        tags.put("bronze", List.of("bronze_dust"));
        tags.put("copper", List.of("copper_dust"));
        tags.put("diamond", List.of("diamond_dust"));
        tags.put("emerald", List.of("emerald_dust"));
        tags.put("iron", List.of("iron_dust"));
        tags.put("jade", List.of("jade_dust"));
        tags.put("lapis", List.of("lapis_dust"));
        tags.put("lead", List.of("lead_dust"));
        tags.put("platinum", List.of("platinum_dust"));
        tags.put("ruby", List.of("ruby_dust"));
        tags.put("sapphire", List.of("sapphire_dust"));
        tags.put("silver", List.of("silver_dust"));
        tags.put("tin", List.of("tin_dust"));
        tags.put("topaz", List.of("topaz_dust"));
        createTag("dusts", false, tags);
        tags.clear();

        // Gems tags
        tags.put("jade", List.of("jade"));
        tags.put("ruby", List.of("ruby"));
        tags.put("sapphire", List.of("sapphire"));
        tags.put("topaz", List.of("topaz"));
        createTag("gems", false, tags);
        tags.clear();

        // Ingots tags
        tags.put("bronze", List.of("bronze_ingot"));
        tags.put("lead", List.of("lead_ingot"));
        tags.put("platinum", List.of("platinum_ingot"));
        tags.put("tin", List.of("tin_ingot"));
        createTag("ingots", false, tags);
        tags.clear();

        // Nuggets tags
        tags.put("bronze", List.of("bronze_nugget"));
        tags.put("lead", List.of("lead_nugget"));
        tags.put("platinum", List.of("platinum_nugget"));
        tags.put("tin", List.of("tin_nugget"));
        createTag("nuggets", false, tags);
        tags.clear();

        // Raw material tags
        tags.put("diamond", List.of("raw_diamond"));
        tags.put("emerald", List.of("raw_emerald"));
        tags.put("jade", List.of("raw_jade"));
        tags.put("lapis", List.of("raw_lapis"));
        tags.put("lead", List.of("raw_lead"));
        tags.put("platinum", List.of("raw_platinum"));
        tags.put("ruby", List.of("raw_ruby"));
        tags.put("sapphire", List.of("raw_sapphire"));
        tags.put("silver", List.of("raw_silver"));
        tags.put("tin", List.of("raw_tin"));
        tags.put("topaz", List.of("raw_topaz"));
        createTag("raw_materials", false, tags);
        tags.clear();
    }

    private static void createTag(String tag, boolean blocks, Map<String, List<String>> elements) {
        String type = blocks ? "blocks" : "items";
        
        new File(commonTagDir + "\\" + type + "\\" + tag).mkdirs();
        new File(fabricTagDir + "\\" + type + "\\" + tag).mkdirs();
        new File(forgeTagDir + "\\" + type + "\\" + tag).mkdirs();

        JsonObject json = new JsonObject();
        JsonArray jsonArray = new JsonArray();

        for (String element : elements.keySet()) {
            JsonObject subTag = new JsonObject();
            JsonArray subTagElements = new JsonArray();

            for (String subElement : elements.get(element)) {
                subTagElements.add("krystalcraft:" + subElement);
                jsonArray.add("krystalcraft:" + subElement);
            }

            subTag.add("values", subTagElements);

            DataGenerator.write(commonTagDir + "\\" + type + "\\" + tag + "\\" + element + ".json", subTag);
            DataGenerator.write(fabricTagDir + "\\" + type + "\\" + tag + "\\" + element + ".json", subTag);
            DataGenerator.write(forgeTagDir + "\\" + type + "\\" + tag + "\\" + element + ".json", subTag);
        }

        json.add("values", jsonArray);

        DataGenerator.write(commonTagDir + "\\" + type + "\\" + tag + ".json", json);
        DataGenerator.write(fabricTagDir + "\\" + type + "\\" + tag + ".json", json);
        DataGenerator.write(forgeTagDir + "\\" + type + "\\" + tag + ".json", json);

        if (blocks) {
            createTag(tag, false, elements);
        }
    }
}
