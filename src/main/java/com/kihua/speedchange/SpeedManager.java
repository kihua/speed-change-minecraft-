package com.kihua.speedchange;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public final class SpeedManager {
    private static final ResourceLocation SPEED_MODIFIER_ID = ResourceLocation.fromNamespaceAndPath(SpeedChange.MODID, "toggle_speed");
    private static final int MAX_LEVEL = 4;

    private SpeedManager() {
    }

    public static int getLevel(ServerPlayer player) {
        return player.getData(SpeedAttachments.SPEED_LEVEL);
    }

    public static int cycle(ServerPlayer player) {
        int level = getLevel(player) + 1;
        if (level > MAX_LEVEL) {
            level = 0;
        }
        player.setData(SpeedAttachments.SPEED_LEVEL, level);
        reconcile(player);
        int bonus = level * 100;
        player.displayClientMessage(Component.translatable("message.speed_change.level", bonus), true);
        return level;
    }

    public static void reconcile(ServerPlayer player) {
        AttributeInstance movementSpeed = player.getAttribute(Attributes.MOVEMENT_SPEED);
        if (movementSpeed == null) {
            return;
        }

        movementSpeed.removeModifier(SPEED_MODIFIER_ID);

        int level = getLevel(player);
        if (level > 0) {
            double value = level * 0.1;
            movementSpeed.addOrUpdateTransientModifier(new AttributeModifier(SPEED_MODIFIER_ID, value, AttributeModifier.Operation.ADD_VALUE));
        }
    }
}
