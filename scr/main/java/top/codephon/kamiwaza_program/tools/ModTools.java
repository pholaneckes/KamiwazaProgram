package top.codephon.kamiwaza_program.tools;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

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

    //protected方法用不了，就直接复制过来，不用理解意思
    public static BlockHitResult getPlayerPOVHitResult(Level p_41436_, Player p_41437_, ClipContext.Fluid p_41438_) {
        float f = p_41437_.getXRot();
        float f1 = p_41437_.getYRot();
        Vec3 vec3 = p_41437_.getEyePosition();
        float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = p_41437_.getBlockReach();
        Vec3 vec31 = vec3.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
        return p_41436_.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, p_41438_, p_41437_));
    }
}
