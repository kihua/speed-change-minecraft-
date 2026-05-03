package com.kihua.speedchange.network;

import com.kihua.speedchange.SpeedChange;
import com.kihua.speedchange.SpeedManager;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ToggleSpeedPayload() implements CustomPacketPayload {
    public static final Type<ToggleSpeedPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SpeedChange.MODID, "toggle_speed"));
    public static final StreamCodec<FriendlyByteBuf, ToggleSpeedPayload> STREAM_CODEC = StreamCodec.unit(new ToggleSpeedPayload());

    @Override
    public Type<ToggleSpeedPayload> type() {
        return TYPE;
    }

    public static void handle(ToggleSpeedPayload payload, IPayloadContext context) {
        if (context.player() instanceof net.minecraft.server.level.ServerPlayer serverPlayer) {
            context.enqueueWork(() -> SpeedManager.cycle(serverPlayer));
        }
    }
}
