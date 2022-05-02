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

    public static final ForgeConfigSpec.ConfigValue<Integer> SAPPHIRE_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> SAPPHIRE_ORE_VEIN_SIZE;
    public static final ForgeConfigSpec.ConfigValue<Integer> SAPPHIRE_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SAPPHIRE_ORE_MAXIMUN_HEIGHT;

    public static final ForgeConfigSpec.ConfigValue<Integer> RUBY_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> RUBY_ORE_VEIN_SIZE;
    public static final ForgeConfigSpec.ConfigValue<Integer> RUBY_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> RUBY_ORE_MAXIMUN_HEIGHT;

    static {
        BUILDER.push("Configs for KrystalCraft");

        JADE_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Jade Ore Veins spawn per chunk!").define("Veins of Jade Ore Per Chunk", 6);
        JADE_ORE_VEIN_SIZE = BUILDER.comment("How many Jade Ore Blocks spawn in one Vein!").defineInRange("Vein Size of Jade Ore", 3, 1, 10);
        JADE_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Jade Ore", 30);
        JADE_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Jade Ore", 90);
        

        SILVER_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Silver Ore Veins spawn per chunk!").define("Veins of Silver Ore Per Chunk", 8);
        SILVER_ORE_VEIN_SIZE = BUILDER.comment("How many Silver Ore Blocks spawn in one Vein!").defineInRange("Vein Size of Silver Ore", 8, 1, 10);
        SILVER_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Silver Ore", 70);
        SILVER_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Silver Ore", 140);

        TOPAZ_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Topaz Ore Veins spawn per chunk!").define("Veins of Topaz Ore Per Chunk", 8);
        TOPAZ_ORE_VEIN_SIZE = BUILDER.comment("How many Topaz Ore Blocks spawn in one Vein!").defineInRange("Vein Size of Topaz Ore", 5, 1, 10);
        TOPAZ_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Topaz Ore", 40);
        TOPAZ_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Topaz Ore", 90);

        LEAD_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Lead Ore Veins spawn per chunk!").define("Veins of Lead Ore Per Chunk", 6);
        LEAD_ORE_VEIN_SIZE = BUILDER.comment("How many Lead Ore Blocks spawn in one Vein!").defineInRange("Vein of Lead Ore Size", 4, 1, 10);
        LEAD_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Lead Ore", 5);
        LEAD_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Lead Ore", 100);

        TIN_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Tin Ore Veins spawn per chunk!").define("Veins of Tin Per Chunk", 10);
        TIN_ORE_VEIN_SIZE = BUILDER.comment("How many Tin Ore Blocks spawn in one Vein!").defineInRange("Vein Size of Tin Ore", 9, 1, 10);
        TIN_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Tin Ore", 100);
        TIN_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Tin Ore", 200);

        PLATINUM_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Platinum Ore Veins spawn per chunk!").define("Veins of Platinum Ore Per Chunk", 4);
        PLATINUM_ORE_VEIN_SIZE = BUILDER.comment("How many Platinum Ore Blocks spawn in one Vein!").defineInRange("Vein Size of Platinum Ore", 2, 1, 10);
        PLATINUM_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Platinum Ore", 5);
        PLATINUM_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Platinum Ore", 90);

        SAPPHIRE_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Platinum Ore Veins spawn per chunk!").define("Veins of Platinum Ore Per Chunk", 5);
        SAPPHIRE_ORE_VEIN_SIZE = BUILDER.comment("How many Platinum Ore Blocks spawn in one Vein!").defineInRange("Vein Size of Platinum Ore", 3, 1, 10);
        SAPPHIRE_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Platinum Ore", 5);
        SAPPHIRE_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Platinum Ore", 100);

        RUBY_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Platinum Ore Veins spawn per chunk!").define("Veins of Platinum Ore Per Chunk", 4);
        RUBY_ORE_VEIN_SIZE = BUILDER.comment("How many Platinum Ore Blocks spawn in one Vein!").defineInRange("Vein Size of Platinum Ore", 5, 1, 10);
        RUBY_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Platinum Ore", 10);
        RUBY_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Platinum Ore", 90);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
