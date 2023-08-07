package top.codephon.kamiwaza_program.events;

import net.minecraft.commands.CommandRuntimeException;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.codephon.kamiwaza_program.KamiwazaProgram;

import java.util.Objects;

//添加事件 后续（如按键绑定，只在客户端执行的）ServerLevel难以获取，这个是其中一种方便的（提前）获取方式
@Mod.EventBusSubscriber(modid = KamiwazaProgram.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class JoinEvents {
    //创建变量用于记录ServerLevel，这个变量一般不会发生变化
    public static ServerLevel pubServerLevel;
    @SubscribeEvent
    //当实体加入游戏时执行一次的事件
    public static void join(EntityJoinLevelEvent event){
        //获取Level
        Level level = event.getLevel();
        //判断这个Level是否是ServerLevel（防止获取到客户端的Level），加入世界时是否是玩家（加不加这句都可以），是的话保存起来
        if(level instanceof ServerLevel && event.getEntity() instanceof Player){
            pubServerLevel = (ServerLevel) level;
        }
    }
//    @SubscribeEvent
//    public static void ce(CommandEvent event){
//        String str = event.getParseResults().getReader().getString();
//        String canNotRun = "advancement";
//        if(str.contains(canNotRun)) {
//            throw new CommandRuntimeException(Component.translatable("You cannot ran " + str));
//        }
//    }
}
