package net.crow.italiandelight;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Configuration {

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;
    public static final String CATEGORY_SETTINGS = "settings";
    public static ForgeConfigSpec.BooleanValue GENERATE_WILD_GRAPES;
    public static ForgeConfigSpec.IntValue CHANCE_WILD_GRAPES;
    public static ForgeConfigSpec.BooleanValue GENERATE_WILD_HERBS;
    public static ForgeConfigSpec.IntValue CHANCE_WILD_HERBS;
    public static final String CATEGORY_CLIENT = "client";

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        COMMON_BUILDER.comment("Farming").push("farming");
        COMMON_BUILDER.comment("Wild Grape generation").push("wild_grapes");
        CHANCE_WILD_GRAPES =
                COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.").defineInRange("chance", 100, 0, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();
        COMMON_BUILDER.comment("Wild Herb generation").push("wild_herbs");
        CHANCE_WILD_HERBS =
                COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.").defineInRange("chance", 100, 0, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();

    }
}
