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

        if(1 + 1 != 2) {
            event.registerEntityRenderer(EntityReg.gakkiMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.eishaMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.diveMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.micMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.jetMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.tsukkoMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.baneMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.dryMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.gymMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.rizumuMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.penMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.danceMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.gagMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.tonkMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.plugMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.boatMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.burgeMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.magneMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.recordMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.sumeruMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.yumeMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.moteMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.gameMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.coroMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.gauzeMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.denkyuMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.zuzuMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.senpuuMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.shugaMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.showaMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.rappuMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.slowMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.makuraMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.fatMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.temoMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.softMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.jishoMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.kagiMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.jaguchiMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.shariMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.mapMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.brushMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.meganeMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.cafeMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.speechMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.memoryMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.clipMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.copyMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.mejaMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.origaMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.yajiroMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.chakkaMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.hasaMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.liftMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.keshigoMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.spicesMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.artMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.tenguMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.menteMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.bellMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.katasuMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.clockMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.smallMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.tafuMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.freezeMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.railMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.doriruMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.sukeMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.hanshaMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.stopMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.kyatchiMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.muteMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.fukuMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.heartMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.bigMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.deodoMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.rocketMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.merrygoMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.vacuuMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.dozerMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.slicerMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.metMin.get(), MinionRender::new);
            event.registerEntityRenderer(EntityReg.wonderPromin.get(), MinionRender::new);
        }
    }
}
