package top.codephon.kamiwaza_program.events;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.codephon.kamiwaza_program.KamiwazaProgram;
import top.codephon.kamiwaza_program.entities.mins.MinionEntity;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = KamiwazaProgram.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TickEvents {

    //这个相当于等待几游戏刻后，继续特定的代码
    public static void doTick(int tickLong, String runType, Entity entity) {

        //建一个匿名内部类，也可以命名
        new Object() {
            boolean stopTick = false;
            private int ticks = 0;
            private int waitTicks;

            //这个方法只会在开始时执行一次
            public void start(int waitTicksIn) {
                //注册至Forge事件总线
                this.waitTicks = waitTicksIn;
                MinecraftForge.EVENT_BUS.register(this);
            }

            //TickEvent，每个游戏刻都会执行一次
            @SubscribeEvent
            public void tick(TickEvent.ServerTickEvent event) {
                //当运行的时间大于等于设定时间就会执行run()内的代码
                if (event.phase == TickEvent.Phase.END) {
                    this.ticks++;
                    if (this.ticks >= this.waitTicks && !stopTick) {
                        run();
                        stopTick = true;
                    }
                }
            }

            //（也可以换个方法名）
            private void run() {
                //判断实体是否是自己设定的特定类型实体
                if (entity instanceof MinionEntity minion) {
                    //筛选执行，使代码可以在多处运用，这个对于高频率执行的代码会出BUG，之后的视频会有解决的方法
                    if (Objects.equals(runType, "changedEmoToNormal_haha")) {
                        minion.setEmotion("normal");
                    } else if (Objects.equals(runType, "changedEmoToNormal_scared")) {
                        minion.setEmotion("normal");
                    }
                }
            }
        //运行时会直接调用该匿名内部类中的start()方法
        }.start(tickLong);
    }
}
