package top.codephon.kamiwaza_program.events;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.codephon.kamiwaza_program.KamiwazaProgram;
import top.codephon.kamiwaza_program.entities.mins.MinionEntity;

import static top.codephon.kamiwaza_program.events.TickEvents.doTick;

//事件基本都这样开头，注册Forge总线
@Mod.EventBusSubscriber(modid = KamiwazaProgram.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MinHurtEvents {
    @SubscribeEvent
    //LivingHurtEvent是实体受伤的事件，会在任何实体收到伤害时执行一次
    public static void MinHurt(LivingHurtEvent event) {
        //获取收到伤害的实体
        LivingEntity entity = event.getEntity();
        //判断是否是对应需要执行之后代码的实体
        if (entity instanceof MinionEntity) {
            //event.getAmount()：获取实体受到的伤害
            if (event.getAmount() >= 0.5) {
                //改变实体NBT标签以更变实体所渲染的贴图
                ((MinionEntity) entity).setEmotion("scared");
                //等待若干（12）游戏刻使贴图变回正常状态，runType是刚才设定的类型
                doTick(12, "changedEmoToNormal_scared", entity);
            }
        }
    }
}
