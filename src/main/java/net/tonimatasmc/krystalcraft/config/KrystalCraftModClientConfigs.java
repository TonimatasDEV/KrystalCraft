package net.tonimatasmc.krystalcraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class KrystalCraftModClientConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Configs for KrystalCraft");

        // HERE DEFINE YOUR CONFIGS

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
