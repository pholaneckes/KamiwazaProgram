package top.codephon.kamiwaza_program.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.codephon.kamiwaza_program.entities.EntityReg;
import top.codephon.kamiwaza_program.entities.render.MinionRender;

//实体渲染的注册
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        //格式：event.registerEntityRenderer(实体注册类.实体字段名.get(), 实体渲染所在类::new);
        //（实体最容易报错的地方）
        event.registerEntityRenderer(EntityReg.turboMin.get(), MinionRender::new);
    }
}
