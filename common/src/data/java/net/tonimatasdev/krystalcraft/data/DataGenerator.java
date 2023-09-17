package net.tonimatasdev.krystalcraft.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.tonimatasdev.krystalcraft.data.providers.TagProvider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class DataGenerator {
    public static String projectDir = System.getProperty("user.dir");

    public static String commonDataDir = projectDir + "\\common\\src\\data\\resources";
    public static String fabricDataDir = projectDir + "\\fabric\\src\\data\\resources";
    public static String forgeDataDir = projectDir + "\\forge\\src\\data\\resources";

    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        new File(commonDataDir).delete();
        new File(fabricDataDir).delete();
        new File(forgeDataDir).delete();

        TagProvider.init();
    }

    public static void write(String file, JsonObject jsonObject) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(gson.toJson(jsonObject));
            System.out.println("JSON has been wrote correctly: " + file);
        } catch (IOException e) {
            System.err.println("Error on write JSON: " + e.getMessage());
        }

    }
}
