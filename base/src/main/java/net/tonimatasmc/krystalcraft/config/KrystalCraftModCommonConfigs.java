package net.tonimatasmc.krystalcraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class KrystalCraftModCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> JADE_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> JADE_ORE_MAXIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SILVER_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SILVER_ORE_MAXIMUN_HEIGHT;

    public static final ForgeConfigSpec.ConfigValue<Integer> TOPAZ_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> TOPAZ_ORE_MAXIMUN_HEIGHT;

    public static final ForgeConfigSpec.ConfigValue<Integer> LEAD_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> LEAD_ORE_MAXIMUN_HEIGHT;

    public static final ForgeConfigSpec.ConfigValue<Integer> TIN_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> TIN_ORE_MAXIMUN_HEIGHT;

    public static final ForgeConfigSpec.ConfigValue<Integer> PLATINUM_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> PLATINUM_ORE_MAXIMUN_HEIGHT;

    public static final ForgeConfigSpec.ConfigValue<Integer> SAPPHIRE_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SAPPHIRE_ORE_MAXIMUN_HEIGHT;

    public static final ForgeConfigSpec.ConfigValue<Integer> RUBY_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> RUBY_ORE_MAXIMUN_HEIGHT;

    public static final ForgeConfigSpec.ConfigValue<Integer> EXPERIENCE_ORE_MINIMUN_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> EXPERIENCE_ORE_MAXIMUN_HEIGHT;

    static {
        BUILDER.push("Configs for KrystalCraft");

        JADE_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Jade Ore", -80);
        JADE_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Jade Ore", 80);

        SILVER_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Silver Ore", -80);
        SILVER_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Silver Ore", 80);

        TOPAZ_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Topaz Ore", -80);
        TOPAZ_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Topaz Ore", 80);

        LEAD_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Lead Ore", -80);
        LEAD_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Lead Ore", 80);

        TIN_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Tin Ore", -80);
        TIN_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Tin Ore", 80);

        PLATINUM_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Platinum Ore", -80);
        PLATINUM_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Platinum Ore", 80);

        SAPPHIRE_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Sapphire Ore", -80);
        SAPPHIRE_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Sapphire Ore", 80);

        RUBY_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Ruby Ore", -80);
        RUBY_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Ruby Ore", 80);

        EXPERIENCE_ORE_MINIMUN_HEIGHT = BUILDER.define("Minimum spawning height of Experience Ore", -80);
        EXPERIENCE_ORE_MAXIMUN_HEIGHT = BUILDER.define("Maximun spawning height of Experience Ore", 80);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
