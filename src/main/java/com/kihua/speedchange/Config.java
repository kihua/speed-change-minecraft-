package com.kihua.speedchange;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.DoubleValue SPEED_INCREMENT = BUILDER
            .comment(
                    "Speed boost added per level. / 每级速度加成。",
                    "Each level adds this value to the player's base movement speed.",
                    "Example: 0.1 = +10% per level, 0.5 = +50% per level.",
                    "每级增加此值的移动速度（相对于基础速度的百分比）。",
                    "例如：0.1 = 每级 +10%，0.5 = 每级 +50%。",
                    "Range / 范围: 0.01 ~ 10.0",
                    "Default / 默认值: 0.1"
            )
            .defineInRange("speed_increment", 0.1, 0.01, 10.0);

    public static final ModConfigSpec.IntValue MAX_LEVEL = BUILDER
            .comment(
                    "Maximum number of speed boost levels. / 最大速度等级数。",
                    "After reaching this level, pressing the key again resets to 0 (normal speed).",
                    "The total max speed bonus = max_level × speed_increment.",
                    "达到此等级后，再次按下按键将重置为 0 级（正常速度）。",
                    "最大总速度加成 = max_level × speed_increment。",
                    "Range / 范围: 1 ~ 20",
                    "Default / 默认值: 4"
            )
            .defineInRange("max_level", 4, 1, 20);

    static final ModConfigSpec SPEC = BUILDER.build();
}
