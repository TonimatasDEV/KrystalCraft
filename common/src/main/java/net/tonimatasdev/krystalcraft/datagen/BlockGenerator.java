package net.tonimatasdev.krystalcraft.datagen;

import java.util.HashMap;
import java.util.Map;

public class BlockGenerator {

    public BlockGenerator() {
        basic("silver_block");
        basic("silver_ore");
        basic("deepslate_silver_ore");
        basic("jade_block");
        basic("jade_ore");
        basic("deepslate_jade_ore");
        basic("topaz_block");
        basic("topaz_ore");
        basic("deepslate_topaz_ore");
        basic("lead_block");
        basic("lead_ore");
        basic("deepslate_lead_ore");
        basic("tin_block");
        basic("tin_ore");
        basic("deepslate_tin_ore");
        basic("platinum_block");
        basic("platinum_ore");
        basic("deepslate_platinum_ore");
        basic("sapphire_block");
        basic("sapphire_ore");
        basic("deepslate_sapphire_ore");
        basic("ruby_block");
        basic("ruby_ore");
        basic("deepslate_ruby_ore");
        basic("experience_ore");
        basic("deepslate_experience_ore");
        basic("bronze_block");

        onlyItem("combining_station");
        onlyItem("crushing_station");
        onlyItem("cutting_station");
    }

    private void basic(String value) {
        model(value);
        blockState(value);
    }

    private void model(String value) {
        Map<String, Object> dataGen = new HashMap<>();
        Map<String, String> textures = new HashMap<>();
        dataGen.put("parent", "minecraft:block/cube_all");
        textures.put("all", "krystalcraft:block/" + value);
        dataGen.put("textures", textures);

        onlyItem(value);

        Main.write("common/src/generated/assets/krystalcraft/models/block/" + value + ".json", dataGen);
    }

    private void blockState(String value) {
        Map<String, Map<String, Map<String, String>>> dataGen = new HashMap<>();
        Map<String, Map<String, String>> variant = new HashMap<>();
        Map<String, String> thing = new HashMap<>();
        thing.put("model", "krystalcraft:block/" + value);
        variant.put("", thing);
        dataGen.put("variants", variant);

        Main.write("common/src/generated/assets/krystalcraft/blockstates/" + value + ".json", dataGen);
    }

    private void onlyItem(String value) {
        Map<String, String> dataGen = new HashMap<>();
        dataGen.put("parent", "krystalcraft:block/" + value);

        Main.write("common/src/generated/assets/krystalcraft/models/item/" + value + ".json", dataGen);
    }
}
