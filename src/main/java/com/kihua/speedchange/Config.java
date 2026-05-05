package com.kihua.speedchange;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.DoubleValue SPEED_INCREMENT = BUILDER
            .comment("Speed boost added per level (default: 0.1)")
            .defineInRange("speed_increment", 0.1, 0.01, 10.0);

    public static final ModConfigSpec.IntValue MAX_LEVEL = BUILDER
            .comment("Maximum number of speed boost levels (default: 4)")
            .defineInRange("max_level", 4, 1, 20);

    static final ModConfigSpec SPEC = BUILDER.build();
}
