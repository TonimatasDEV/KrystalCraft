package net.tonimatasmc.krystalcraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class KrystalCraftModCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> JADE_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> JADE_ORE_VEIN_SIZE;
    public static final ForgeConfigSpec.ConfigValue<Integer> JADE_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> JADE_ORE_MAXIMUN_HEIGHT;

    public static final ForgeConfigSpec.ConfigValue<Integer> SILVER_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> SILVER_ORE_VEIN_SIZE;
    public static final ForgeConfigSpec.ConfigValue<Integer> SILVER_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SILVER_ORE_MAXIMUN_HEIGHT;

    public static final ForgeConfigSpec.ConfigValue<Integer> TOPAZ_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> TOPAZ_ORE_VEIN_SIZE;
    public static final ForgeConfigSpec.ConfigValue<Integer> TOPAZ_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> TOPAZ_ORE_MAXIMUN_HEIGHT;

    public static final ForgeConfigSpec.ConfigValue<Integer> LEAD_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> LEAD_ORE_VEIN_SIZE;
    public static final ForgeConfigSpec.ConfigValue<Integer> LEAD_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> LEAD_ORE_MAXIMUN_HEIGHT;

    public static final ForgeConfigSpec.ConfigValue<Integer> TIN_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> TIN_ORE_VEIN_SIZE;
    public static final ForgeConfigSpec.ConfigValue<Integer> TIN_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> TIN_ORE_MAXIMUN_HEIGHT;

    public static final ForgeConfigSpec.ConfigValue<Integer> PLATINUM_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> PLATINUM_ORE_VEIN_SIZE;
    public static final ForgeConfigSpec.ConfigValue<Integer> PLATINUM_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> PLATINUM_ORE_MAXIMUN_HEIGHT;

    static {
        BUILDER.push("Configs for KrystalCraft");

        JADE_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Jade Ore Veins spawn per chunk!").define("Veins of Jade Ore Per Chunk", 3);
        JADE_ORE_VEIN_SIZE = BUILDER.comment("How many Jade Ore Blocks spawn in one Vein!").defineInRange("Vein Size of Jade Ore ", 3, 1, 2);
        JADE_ORE_MINIMUN_HEIGHT = BUILDER.comment().define("Minimum spawning height", 30);
        JADE_ORE_MAXIMUN_HEIGHT = BUILDER.comment().define("Maximun spawning height", 90);
        
        BUILDER.comment("----------------------------------------------------------------------");

        SILVER_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Silver Ore Veins spawn per chunk!").define("Veins of Silver Ore Per Chunk", 4);
        SILVER_ORE_VEIN_SIZE = BUILDER.comment("How many Silver Ore Blocks spawn in one Vein!").defineInRange("Vein Size of Silver Ore", 8, 1, 8);
        SILVER_ORE_MINIMUN_HEIGHT = BUILDER.comment().define("Minimum spawning height", 70);
        SILVER_ORE_MAXIMUN_HEIGHT = BUILDER.comment().define("Maximun spawning height", 140);

        BUILDER.comment("----------------------------------------------------------------------");

        TOPAZ_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Topaz Ore Veins spawn per chunk!").define("Veins of Topaz Ore Per Chunk", 4);
        TOPAZ_ORE_VEIN_SIZE = BUILDER.comment("How many Topaz Ore Blocks spawn in one Vein!").defineInRange("Vein Size of Topaz Ore", 5, 1, 5);
        TOPAZ_ORE_MINIMUN_HEIGHT = BUILDER.comment().define("Minimum spawning height", 40);
        TOPAZ_ORE_MAXIMUN_HEIGHT = BUILDER.comment().define("Maximun spawning height", 90);

        BUILDER.comment("----------------------------------------------------------------------");

        LEAD_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Lead Ore Veins spawn per chunk!").define("Veins of Lead Ore Per Chunk", 3);
        LEAD_ORE_VEIN_SIZE = BUILDER.comment("How many Lead Ore Blocks spawn in one Vein!").defineInRange("Vein of Lead Ore Size", 4, 1, 4);
        LEAD_ORE_MINIMUN_HEIGHT = BUILDER.comment().define("Minimum spawning height", 0);
        LEAD_ORE_MAXIMUN_HEIGHT = BUILDER.comment().define("Maximun spawning height", 100);

        BUILDER.comment("----------------------------------------------------------------------");

        TIN_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Tin Ore Veins spawn per chunk!").define("Veins of Tin Per Chunk", 4);
        TIN_ORE_VEIN_SIZE = BUILDER.comment("How many Tin Ore Blocks spawn in one Vein!").defineInRange("Vein Size of Tin", 9, 1, 10);
        TIN_ORE_MINIMUN_HEIGHT = BUILDER.comment().define("Minimum spawning height", 100);
        TIN_ORE_MAXIMUN_HEIGHT = BUILDER.comment().define("Maximun spawning height", 200);

        BUILDER.comment("----------------------------------------------------------------------");

        PLATINUM_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Platinum Ore Veins spawn per chunk!").define("Veins of Platinum Per Chunk", 2);
        PLATINUM_ORE_VEIN_SIZE = BUILDER.comment("How many Platinum Ore Blocks spawn in one Vein!").defineInRange("Vein Size of Platinum", 1, 1, 2);
        PLATINUM_ORE_MINIMUN_HEIGHT = BUILDER.comment().define("Minimum spawning height", 0);
        PLATINUM_ORE_MAXIMUN_HEIGHT = BUILDER.comment().define("Maximun spawning height", 90);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
