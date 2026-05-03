package com.kihua.speedchange;

import org.slf4j.Logger;

import com.kihua.speedchange.network.ToggleSpeedPayload;
import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

@Mod(SpeedChange.MODID)
public class SpeedChange {
    public static final String MODID = "speed_change";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SpeedChange(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerPayloadHandlers);
        SpeedAttachments.ATTACHMENT_TYPES.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Speed Change common setup complete");
    }

    private void registerPayloadHandlers(RegisterPayloadHandlersEvent event) {
        event.registrar("1").playToServer(ToggleSpeedPayload.TYPE, ToggleSpeedPayload.STREAM_CODEC, ToggleSpeedPayload::handle);
    }

    @SubscribeEvent
    public void onPlayerJoin(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof net.minecraft.server.level.ServerPlayer player && !event.getLevel().isClientSide()) {
            SpeedManager.reconcile(player);
        }
    }

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        if (event.getEntity() instanceof net.minecraft.server.level.ServerPlayer player) {
            player.setData(SpeedAttachments.SPEED_LEVEL, event.getOriginal().getData(SpeedAttachments.SPEED_LEVEL));
            SpeedManager.reconcile(player);
        }
    }
}
