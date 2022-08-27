package net.tonimatasmc.krystalcraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class KrystalCraftModCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Configs for KrystalCraft");
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
