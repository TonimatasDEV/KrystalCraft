package net.tonimatasmc.krystalcraft.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.tonimatasmc.krystalcraft.KrystalCraft;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class CoalCrusherScreen extends AbstractContainerScreen<CoalCrusherMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(KrystalCraft.MOD_ID, "textures/gui/coal_crusher_gui.png");

    public CoalCrusherScreen(CoalCrusherMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(@Nullable PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(Objects.requireNonNull(pPoseStack), x, y, 0, 0, imageWidth, imageHeight);

        if(menu.isCrafting()) {
            blit(pPoseStack, x + 102, y + 21, 190, 0, 23, menu.getScaledProgress());
            blit(pPoseStack, x + 55, y + 35, 176, 0, 14, menu.getScaledProgress());
        }
    }

    @Override
    public void render(@Nullable PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(Objects.requireNonNull(pPoseStack));
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}
