package top.codephon.kamiwaza_program.screen.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Overlay;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.codephon.kamiwaza_program.KamiwazaProgram;

//仅客户端
@OnlyIn(Dist.CLIENT)
//实现 Renderable
public class ShakerShowOutHUD implements Renderable {
    //贴图
    private static final ResourceLocation TEX =
            new ResourceLocation(KamiwazaProgram.MOD_ID,"textures/gui/shaker_mixing_promin.png");
    //这两段不变
    private final Minecraft minecraft;
    public ShakerShowOutHUD(){
        this.minecraft = Minecraft.getInstance();
    }

    //用render方法渲染
    @Override
    public void render(GuiGraphics guiGraphics, int height, int width, float par) {
        //初始化
        guiGraphics.setColor(1,1,1,1);
        //添加贴图
        //格式：guiGraphics.blit(贴图，X坐标，Y坐标，图片起始X坐标（一般0），图片起始Y坐标（一般0），
        //图片终止X坐标（一般同宽），图片终止Y坐标（一般同高），宽，高);
        guiGraphics.blit(TEX,width-48,height-80,0,0,96,144,96,144);
        //添加渲染文字
        //格式：guiGraphics.drawString(this.minecraft.font， 文本， X位置坐标，Y位置坐标，颜色（0X颜色RGB色号）;
        guiGraphics.drawString(this.minecraft.font,Component.translatable("kwp.hud.shaker").getString(),
                width-42,height-75,0Xff8c29);
    }
}
