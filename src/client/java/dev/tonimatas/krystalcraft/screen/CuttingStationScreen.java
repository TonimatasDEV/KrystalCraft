package dev.tonimatas.krystalcraft.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.tonimatas.krystalcraft.KrystalCraft;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CuttingStationScreen extends HandledScreen<CuttingStationScreenHandler> {
    public static final Identifier TEXTURE = Identifier.of(KrystalCraft.MOD_ID, "textures/gui/cutting_station.png");
    public static final Identifier LOADER_TEXTURE = Identifier.of(KrystalCraft.MOD_ID, "textures/gui/overlay/loader.png");

    public CuttingStationScreen(CuttingStationScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundHeight = this.backgroundHeight + 14;
        this.playerInventoryTitleY = this.playerInventoryTitleY + 14;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        if (handler.isCrafting()) {
            context.drawTexture(LOADER_TEXTURE, x + 85, y + 45, 0, 0, 6, handler.getScaledLoader(), 6, 13);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
