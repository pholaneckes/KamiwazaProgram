package top.codephon.kamiwaza_program.screen.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.codephon.kamiwaza_program.items.KamiwazaShaker;

import static top.codephon.kamiwaza_program.items.KamiwazaShaker.isOpen;

//渲染HUD事件
@Mod.EventBusSubscriber
public class RenderHUDEvent {
    @SubscribeEvent
    //仅客户端
    @OnlyIn(Dist.CLIENT)
    public static void onRenderGameOverlayPost(RenderGuiOverlayEvent event) {
        //获取一些必要参数（如宽 高）
        int width = event.getWindow().getGuiScaledWidth();
        int height = event.getWindow().getGuiScaledHeight();
        int halfWidth = width /2 ;
        int halfHeight = height /2;
        Minecraft minecraft = Minecraft.getInstance();
        GuiGraphics guiGraphics = event.getGuiGraphics();
        //渲染的条件
        if (minecraft.player != null) {
            //获取玩家
            Player player = minecraft.player;
            //解释：当手持KamiwazaShaker物品时 且"close"为0时渲染该HUD
            ItemStack shaker;
            if(player.getItemInHand(InteractionHand.OFF_HAND).getItem() instanceof KamiwazaShaker){
                shaker = player.getItemInHand(InteractionHand.OFF_HAND);
            }else if( player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof KamiwazaShaker){
                shaker = player.getItemInHand(InteractionHand.MAIN_HAND);
            }else {
                return;
            }
            if(isOpen(shaker)) {
                //格式： 某HUD hud = new 该HUD();
                //hud.render(guiGraphics, halfHeight（半屏幕高）, halfWidth（半屏幕宽）, 0（parTick）)
                ShakerShowOutHUD hud = new ShakerShowOutHUD();
                hud.render(guiGraphics,halfHeight,halfWidth,0);
            }
        }
    }
}
