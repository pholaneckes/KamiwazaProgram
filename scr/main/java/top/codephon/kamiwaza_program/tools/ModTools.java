package top.codephon.kamiwaza_program.tools;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import top.codephon.kamiwaza_program.screen.gui.MinionWikiInnerScreen;
import top.codephon.kamiwaza_program.screen.gui.MinionWikiScreen;

public class ModTools {
    public static int keepTime = 0;

    //快捷发送消息至玩家聊天栏（可本地化的文本）
    public static void sendChat(Player player, String string) {
        Component chat = Component.translatable(string);
        player.sendSystemMessage(chat);
    }

    //获取玩家看向的（方块）坐标
    public static BlockPos getLookPos(Player player){
        BlockHitResult hitResult = getPlayerPOVHitResult(player.level(), player, ClipContext.Fluid.SOURCE_ONLY);
        /**getPlayerPOVHitResult方法见：
         * @see net.minecraft.world.item.Item#getPlayerPOVHitResult(Level, Player, ClipContext.Fluid)*/
        return hitResult.getBlockPos();
    }

    public static String getBlockRegName(ServerLevel serverLevel, Player player){
        return serverLevel.getBlockState(getPlayerPOVHitResult(player.level(), player, ClipContext.Fluid.SOURCE_ONLY).getBlockPos()).getBlock().builtInRegistryHolder().key().location().getPath();
    }

    //protected方法用不了，就直接复制过来，不用理解意思
    public static BlockHitResult getPlayerPOVHitResult(Level level, Player player, ClipContext.Fluid fluid) {
        float f = player.getXRot();
        float f1 = player.getYRot();
        Vec3 vec3 = player.getEyePosition();
        float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = player.getBlockReach();
        Vec3 vec31 = vec3.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
        return level.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, fluid, player));
    }

    public static class OpenWikiInnerGui{
        public OpenWikiInnerGui(){
            Minecraft.getInstance().setScreen(new MinionWikiInnerScreen());
        }
    }
}
