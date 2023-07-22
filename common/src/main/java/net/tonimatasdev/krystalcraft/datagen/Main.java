package net.tonimatasdev.krystalcraft.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static final String path = "common/src/generated";
    public static final String forgePath = "forge/src/generated";

    public static void main(String[] args) {
        folders();
        new BlockGenerator();
        new ItemGenerator();
        new TagGenerator();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void folders() {
        new File(path + "/assets").mkdir();
        new File(path + "/assets/krystalcraft").mkdir();
        new File(path + "/assets/krystalcraft/blockstates").mkdir();
        new File(path + "/assets/krystalcraft/models").mkdir();
        new File(path + "/assets/krystalcraft/models/item").mkdir();
        new File(path + "/assets/krystalcraft/models/block").mkdir();

        new File(forgePath + "/data").mkdir();
        new File(forgePath + "/data/forge").mkdir();
        new File(forgePath + "/data/forge/tags").mkdir();
        new File(forgePath + "/data/forge/tags/blocks").mkdir();
        new File(forgePath + "/data/forge/tags/items").mkdir();

        new File(path + "/data").mkdir();
        new File(path + "/data/krystalcraft").mkdir();
        new File(path + "/data/krystalcraft/tags").mkdir();
        new File(path + "/data/krystalcraft/tags/blocks").mkdir();
        new File(path + "/data/krystalcraft/tags/items").mkdir();
    }

    public static void write(String filePath, Object jsonData) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(gson.toJson(jsonData));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
