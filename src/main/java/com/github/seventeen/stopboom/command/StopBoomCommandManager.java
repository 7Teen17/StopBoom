package com.github.seventeen.stopboom.command;

import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class StopBoomCommandManager {
    public static boolean isEnabled = true;
    public static void createCommands() {
        ClientCommandManager.DISPATCHER.register(
                ClientCommandManager.literal("stopboom").then(
                        ClientCommandManager.literal("enable").executes(ctx -> {
                            isEnabled = true;
                            MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.of("Successfully enabled StopBoom!"));
                            return 1;
                        })
                ).then(ClientCommandManager.literal("disable").executes(ctx -> {
                    isEnabled = false;
                    MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.of("Successfully disabled StopBoom!"));
                    return 1;
                }))
        );
    }
}
