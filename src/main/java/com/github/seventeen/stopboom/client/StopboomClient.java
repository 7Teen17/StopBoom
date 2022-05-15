package com.github.seventeen.stopboom.client;

import com.github.seventeen.stopboom.command.StopBoomCommandManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.dimension.DimensionType;

@Environment(EnvType.CLIENT)
public class StopboomClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        StopBoomCommandManager.createCommands();
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            Block block = world.getBlockState(hitResult.getBlockPos()).getBlock();
            if (block.equals(Blocks.BLACK_BED) || block.equals(Blocks.BLUE_BED) || block.equals(Blocks.BROWN_BED) || block.equals(Blocks.LIGHT_BLUE_BED) || block.equals(Blocks.CYAN_BED) || block.equals(Blocks.GRAY_BED) || block.equals(Blocks.GREEN_BED) || block.equals(Blocks.LIGHT_GRAY_BED) || block.equals(Blocks.LIME_BED) || block.equals(Blocks.MAGENTA_BED) || block.equals(Blocks.ORANGE_BED) || block.equals(Blocks.PINK_BED) || block.equals(Blocks.PURPLE_BED) || block.equals(Blocks.RED_BED) || block.equals(Blocks.WHITE_BED) || block.equals(Blocks.YELLOW_BED)) {
                if (world.getRegistryKey().getValue().equals(DimensionType.THE_NETHER_ID) || world.getRegistryKey().getValue().equals(DimensionType.THE_END_ID)) {
                    if (StopBoomCommandManager.isEnabled) {
                        MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.of("BOOM BLOCKED!!"));
                        return ActionResult.FAIL;
                    }
                }
            }
            return ActionResult.PASS;
        });
    }
}
