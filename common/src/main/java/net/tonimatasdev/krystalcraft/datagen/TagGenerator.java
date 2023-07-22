package net.tonimatasdev.krystalcraft.datagen;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TagGenerator {
    private final String forgePath = "forge/src/generated/data/forge/tags/";
    private final String commonPath = "common/src/generated/data/krystalcraft/tags/";

    public TagGenerator() {
        Tag dusts = new Tag("dusts", true);
        dusts.add("bronze", List.of("bronze_dust"));
        dusts.add("copper", List.of("copper_dust"));
        dusts.add("diamond", List.of("diamond_dust"));
        dusts.add("emerald", List.of("emerald_dust"));
        dusts.add("iron", List.of("iron_dust"));
        dusts.add("jade", List.of("jade_dust"));
        dusts.add("lapis", List.of("lapis_dust"));
        dusts.add("lead", List.of("lead_dust"));
        dusts.add("platinum", List.of("platinum_dust"));
        dusts.add("ruby", List.of("ruby_dust"));
        dusts.add("sapphire", List.of("sapphire_dust"));
        dusts.add("silver", List.of("silver_dust"));
        dusts.add("tin", List.of("tin_dust"));
        dusts.add("topaz", List.of("topaz_dust"));
        dusts.gen();

        Tag gems = new Tag("gems", true);
        gems.add("jade", List.of("jade"));
        gems.add("ruby", List.of("ruby"));
        gems.add("sapphire", List.of("sapphire"));
        gems.add("topaz", List.of("topaz"));
        gems.gen();

        Tag ingots = new Tag("ingots", true);
        ingots.add("bronze", List.of("bronze_ingot"));
        ingots.add("lead", List.of("lead_ingot"));
        ingots.add("platinum", List.of("platinum_ingot"));
        ingots.add("tin", List.of("tin_ingot"));
        ingots.gen();

        Tag nuggets = new Tag("nuggets", true);
        nuggets.add("bronze", List.of("bronze_nugget"));
        nuggets.add("lead", List.of("lead_nugget"));
        nuggets.add("platinum", List.of("platinum_nugget"));
        nuggets.add("tin", List.of("tin_nugget"));
        nuggets.gen();

        Tag raw_materials = new Tag("raw_materials", true);
        raw_materials.add("diamond", List.of("diamond_dust"));
        raw_materials.add("emerald", List.of("emerald_dust"));
        raw_materials.add("jade", List.of("jade_dust"));
        raw_materials.add("lapis", List.of("lapis_dust"));
        raw_materials.add("lead", List.of("lead_dust"));
        raw_materials.add("platinum", List.of("platinum_dust"));
        raw_materials.add("ruby", List.of("ruby_dust"));
        raw_materials.add("sapphire", List.of("sapphire_dust"));
        raw_materials.add("silver", List.of("silver_dust"));
        raw_materials.add("tin", List.of("tin_dust"));
        raw_materials.add("topaz", List.of("topaz_dust"));
        raw_materials.gen();

        Tag storage_blocks = new Tag("storage_blocks", false);
        storage_blocks.add("bronze", List.of("bronze_block"));
        storage_blocks.add("jade", List.of("jade_block"));
        storage_blocks.add("lead", List.of("lead_block"));
        storage_blocks.add("platinum", List.of("platinum_block"));
        storage_blocks.add("ruby", List.of("ruby_block"));
        storage_blocks.add("sapphire", List.of("sapphire_block"));
        storage_blocks.add("silver", List.of("silver_block"));
        storage_blocks.add("tin", List.of("tin_block"));
        storage_blocks.add("topaz", List.of("topaz_block"));
        storage_blocks.gen();

        Tag ores = new Tag("ores", false);
        ores.add("experience", List.of("experience_ore", "deepslate_experience_ore"));
        ores.add("jade", List.of("jade_ore", "deepslate_jade_ore"));
        ores.add("lead", List.of("lead_ore", "deepslate_lead_ore"));
        ores.add("platinum", List.of("platinum_ore", "deepslate_platinum_ore"));
        ores.add("ruby", List.of("ruby_ore", "deepslate_ruby_ore"));
        ores.add("sapphire", List.of("sapphire_ore", "deepslate_sapphire_ore"));
        ores.add("silver", List.of("silver_ore", "deepslate_silver_ore"));
        ores.add("tin", List.of("tin_ore", "deepslate_tin_ore"));
        ores.add("topaz", List.of("topaz_ore", "deepslate_topaz_ore"));
        ores.gen();
    }

    public class Tag {
        private final List<String> objects;
        private final String tagName;
        private final boolean item;

        public Tag(String value, boolean item) {
            this.tagName = value;
            this.item = item;
            this.objects = new ArrayList<>();
        }

        @SuppressWarnings("ResultOfMethodCallIgnored")
        public void add(String material, List<String> values) {
            List<String> objects = values.stream().map(elemento -> "krystalcraft:" + elemento).collect(Collectors.toList());
            this.objects.addAll(objects);
            Map<String, Object> dataGen = new HashMap<>();
            dataGen.put("values", objects);

            if (item) {
                new File(commonPath + "items/" + tagName).mkdir();
                new File(forgePath + "items/" + tagName).mkdir();
                Main.write(forgePath + "items/" + tagName + "/" + material + ".json", dataGen);
                Main.write(commonPath + "items/" + tagName + "/"  + material + ".json", dataGen);
            } else {
                new File(commonPath + "blocks/" + tagName).mkdir();
                new File(forgePath + "blocks/" + tagName).mkdir();
                Main.write(forgePath + "blocks/" + tagName + "/"  + material + ".json", dataGen);
                Main.write(commonPath + "blocks/" + tagName + "/"  + material + ".json", dataGen);
            }

        }

        public void gen() {
            Map<String, Object> dataGen = new HashMap<>();
            dataGen.put("values", objects);

            if (item) {
                Main.write(forgePath + "items/" + tagName + ".json", dataGen);
                Main.write(commonPath + "items/" + tagName + ".json", dataGen);
            } else {
                Main.write(forgePath + "blocks/" + tagName + ".json", dataGen);
                Main.write(commonPath + "blocks/" + tagName + ".json", dataGen);
            }
        }
    }
}
