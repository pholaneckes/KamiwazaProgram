package top.codephon.kamiwaza_program.keys;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.codephon.kamiwaza_program.KamiwazaProgram;
import top.codephon.kamiwaza_program.entities.Attri;
import top.codephon.kamiwaza_program.entities.EntityReg;
import top.codephon.kamiwaza_program.entities.mins.MinionEntity;
import top.codephon.kamiwaza_program.entities.mins.Turbomin;
import top.codephon.kamiwaza_program.items.KamiwazaCard;
import top.codephon.kamiwaza_program.items.KamiwazaShot;
import top.codephon.kamiwaza_program.network.NetworkRegHandler;
import top.codephon.kamiwaza_program.network.SendPack;
import top.codephon.kamiwaza_program.tools.Ways;

import static top.codephon.kamiwaza_program.events.JoinEvents.pubServerLevel;
import static top.codephon.kamiwaza_program.keys.MinKeyBending.*;
import static top.codephon.kamiwaza_program.tools.ModTools.getLookPos;
import static top.codephon.kamiwaza_program.tools.ModTools.sendChat;

//继续添加事件
@Mod.EventBusSubscriber(modid = KamiwazaProgram.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class keyListener {

    public static boolean ctrlPressed;

    @SubscribeEvent
    //这个表示仅在客户端执行，在服务器执行可能会报错
    @OnlyIn(Dist.CLIENT)
    //按下按键时触发的事件
    public static void pressKey(InputEvent.Key event){
        // 341 是 ctrl 的键位值
        //这个是判断是否按下了 ctrl 键 用于组合键位
        if(event.getKey() == 341){
            if(event.getAction() == 0){
                ctrlPressed = false;
            }else if(event.getAction() == 1){
                ctrlPressed = true;
            }
        }

        //这个判断为了防止BUG
        if (Minecraft.getInstance().screen == null) {
            //event.getKey()获取按下的键 如果是对应的（刚才注册的(用字段名.getKey().getValue())）就继续执行
            if (event.getKey() == SCAN_CARD.getKey().getValue()) {
                //event.getAction() 0是按下 1是松开 按键 （2是按下且松开，不推荐用）
                if(event.getAction() == 0){
                    //获取玩家
                    Player player = Minecraft.getInstance().player;
                    if(player != null){
                        NetworkRegHandler.CHANNEL.sendToServer(new SendPack(player.getUUID(), (short) 3));
                    }
                }
            }
            //前面的部分大同小异
            if (event.getKey() == ALISE_PROMIN.getKey().getValue()) {
                if(event.getAction() == 1){
                    Player player = Minecraft.getInstance().player;
                    if(player != null){
                        if(ctrlPressed){
                            NetworkRegHandler.CHANNEL.sendToServer(new SendPack(player.getUUID(), (short) 4));
                        }else {
                            NetworkRegHandler.CHANNEL.sendToServer(new SendPack(player.getUUID(), (short) 2));
                        }
                    }
                }
            }

            //作用：使用 カミ技能
            if(event.getKey() == USE_WAZA.getKey().getValue() && event.getAction() == 0){
                //获取玩家
                Player player = Minecraft.getInstance().player;
                if(player != null) {
                    //（之后的逻辑）当按下 ctrl 时选择自己 否则是准星对着的实体
                    if (ctrlPressed) {
            //网络发包 发包类.SimpleChannel字段名.sendToServer(new SendPack(传不了实体只能传实体UUID,包序号（一般short最合适）（,可能有的参数）));
                        NetworkRegHandler.CHANNEL.sendToServer(new SendPack(player.getUUID(),(short) 1,true));
                    } else {
                        NetworkRegHandler.CHANNEL.sendToServer(new SendPack(player.getUUID(),(short) 1,false));
                    }
                }
            }
        }
    }
}
