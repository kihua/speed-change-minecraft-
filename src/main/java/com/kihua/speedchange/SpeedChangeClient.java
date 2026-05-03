package com.kihua.speedchange;

import com.kihua.speedchange.network.ToggleSpeedPayload;
import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.network.PacketDistributor;
import org.lwjgl.glfw.GLFW;

@Mod(value = SpeedChange.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = SpeedChange.MODID, value = Dist.CLIENT)
public class SpeedChangeClient {
    private static final KeyMapping TOGGLE_SPEED = new KeyMapping(
            "key.speed_change.toggle_speed",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_V,
            "key.categories.speed_change"
    );
    private static int speedLevel;
    private static final int MAX_LEVEL = 4;

    public SpeedChangeClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        SpeedChange.LOGGER.info("Speed Change client setup complete");
    }

    @SubscribeEvent
    static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(TOGGLE_SPEED);
    }

    @SubscribeEvent
    static void onClientTick(ClientTickEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) {
            speedLevel = 0;
            return;
        }

        while (TOGGLE_SPEED.consumeClick()) {
            speedLevel++;
            if (speedLevel > MAX_LEVEL) {
                speedLevel = 0;
            }
            PacketDistributor.sendToServer(new ToggleSpeedPayload());
        }
    }

    @SubscribeEvent
    static void onRenderGui(RenderGuiEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null || minecraft.options.hideGui) {
            return;
        }

        GuiGraphics guiGraphics = event.getGuiGraphics();
        int bonus = speedLevel * 100;
        Component text = Component.translatable("hud.speed_change.level", bonus);
        int textWidth = minecraft.font.width(text);
        int x = guiGraphics.guiWidth() - textWidth - 8;
        int y = guiGraphics.guiHeight() - 20;
        guiGraphics.drawString(minecraft.font, text, x, y, 0xFFFFFF, true);
    }
}
