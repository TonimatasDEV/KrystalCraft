package net.tonimatasmc.krystalcraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class KrystalCraftModCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> JADE_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> JADE_ORE_VEIN_SIZE;

    public static final ForgeConfigSpec.ConfigValue<Integer> SILVER_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> SILVER_ORE_VEIN_SIZE;

    public static final ForgeConfigSpec.ConfigValue<Integer> TOPAZ_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> TOPAZ_ORE_VEIN_SIZE;

    public static final ForgeConfigSpec.ConfigValue<Integer> LEAD_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> LEAD_ORE_VEIN_SIZE;

    public static final ForgeConfigSpec.ConfigValue<Integer> TIN_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> TIN_ORE_VEIN_SIZE;

    static {
        BUILDER.push("Configs for KrystalCraft");

        JADE_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Jade Ore Veins spawn per chunk!").define("Veins Per Chunk", 3);
        JADE_ORE_VEIN_SIZE = BUILDER.comment("How many Jade Ore Blocks spawn in one Vein!").defineInRange("Vein Size", 3, 1, 2);

        SILVER_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Silver Ore Veins spawn per chunk!").define("Veins Per Chunk", 8);
        SILVER_ORE_VEIN_SIZE = BUILDER.comment("How many Silver Ore Blocks spawn in one Vein!").defineInRange("Vein Size", 8, 1, 8);

        TOPAZ_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Topaz Ore Veins spawn per chunk!").define("Veins Per Chunk", 5);
        TOPAZ_ORE_VEIN_SIZE = BUILDER.comment("How many Topaz Ore Blocks spawn in one Vein!").defineInRange("Vein Size", 5, 1, 5);

        LEAD_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Lead Ore Veins spawn per chunk!").define("Veins Per Chunk", 4);
        LEAD_ORE_VEIN_SIZE = BUILDER.comment("How many Lead Ore Blocks spawn in one Vein!").defineInRange("Vein Size", 4, 1, 4);

        TIN_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Lead Ore Veins spawn per chunk!").define("Veins Per Chunk", 7);
        TIN_ORE_VEIN_SIZE = BUILDER.comment("How many Lead Ore Blocks spawn in one Vein!").defineInRange("Vein Size", 7, 1, 7);


        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
