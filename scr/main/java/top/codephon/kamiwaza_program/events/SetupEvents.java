package top.codephon.kamiwaza_program.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.codephon.kamiwaza_program.entities.EntityReg;
import top.codephon.kamiwaza_program.entities.mins.Turbomin;
import top.codephon.kamiwaza_program.entities.mins.temp.*;

//注册创建实体属性
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SetupEvents {
    @SubscribeEvent
    public static void setupMCAttributes(EntityAttributeCreationEvent event) {
        //格式：event.put(实体注册类.实体字段名.get(), 实体所在类.createAttributes().build());
        event.put(EntityReg.turboMin.get(), Turbomin.createAttributes().build());

        if(1 + 1 != 2) {
            event.put(EntityReg.gakkiMin.get(), Gakkimin.createAttributes().build());
            event.put(EntityReg.eishaMin.get(), Eishamin.createAttributes().build());
            event.put(EntityReg.diveMin.get(), Divemin.createAttributes().build());
            event.put(EntityReg.micMin.get(), Micmin.createAttributes().build());
            event.put(EntityReg.jetMin.get(), Jetmin.createAttributes().build());
            event.put(EntityReg.tsukkoMin.get(), Tsukkomin.createAttributes().build());
            event.put(EntityReg.baneMin.get(), Banemin.createAttributes().build());
            event.put(EntityReg.dryMin.get(), Drymin.createAttributes().build());
            event.put(EntityReg.gymMin.get(), Gymmin.createAttributes().build());
            event.put(EntityReg.rizumuMin.get(), Rizumumin.createAttributes().build());
            event.put(EntityReg.penMin.get(), Penmin.createAttributes().build());
            event.put(EntityReg.danceMin.get(), Dancemin.createAttributes().build());
            event.put(EntityReg.gagMin.get(), Gagmin.createAttributes().build());
            event.put(EntityReg.tonkMin.get(), Tonkmin.createAttributes().build());
            event.put(EntityReg.plugMin.get(), Plugmin.createAttributes().build());
            event.put(EntityReg.boatMin.get(), Boatmin.createAttributes().build());
            event.put(EntityReg.burgeMin.get(), Burgemin.createAttributes().build());
            event.put(EntityReg.magneMin.get(), Magnemin.createAttributes().build());
            event.put(EntityReg.recordMin.get(), Recordmin.createAttributes().build());
            event.put(EntityReg.sumeruMin.get(), Sumerumin.createAttributes().build());
            event.put(EntityReg.yumeMin.get(), Yumemin.createAttributes().build());
            event.put(EntityReg.moteMin.get(), Motemin.createAttributes().build());
            event.put(EntityReg.gameMin.get(), Gamemin.createAttributes().build());
            event.put(EntityReg.coroMin.get(), Coromin.createAttributes().build());
            event.put(EntityReg.gauzeMin.get(), Gauzemin.createAttributes().build());
            event.put(EntityReg.denkyuMin.get(), Denkyumin.createAttributes().build());
            event.put(EntityReg.zuzuMin.get(), Zuzumin.createAttributes().build());
            event.put(EntityReg.senpuuMin.get(), Senpuumin.createAttributes().build());
            event.put(EntityReg.shugaMin.get(), Shugamin.createAttributes().build());
            event.put(EntityReg.showaMin.get(), Showamin.createAttributes().build());
            event.put(EntityReg.rappuMin.get(), Rappumin.createAttributes().build());
            event.put(EntityReg.slowMin.get(), Slowmin.createAttributes().build());
            event.put(EntityReg.makuraMin.get(), Makuramin.createAttributes().build());
            event.put(EntityReg.fatMin.get(), Fatmin.createAttributes().build());
            event.put(EntityReg.temoMin.get(), Temomin.createAttributes().build());
            event.put(EntityReg.softMin.get(), Softmin.createAttributes().build());
            event.put(EntityReg.jishoMin.get(), Jishomin.createAttributes().build());
            event.put(EntityReg.kagiMin.get(), Kagimin.createAttributes().build());
            event.put(EntityReg.jaguchiMin.get(), Jaguchimin.createAttributes().build());
            event.put(EntityReg.shariMin.get(), Sharimin.createAttributes().build());
            event.put(EntityReg.mapMin.get(), Mapmin.createAttributes().build());
            event.put(EntityReg.brushMin.get(), Brushmin.createAttributes().build());
            event.put(EntityReg.meganeMin.get(), Meganemin.createAttributes().build());
            event.put(EntityReg.cafeMin.get(), Cafemin.createAttributes().build());
            event.put(EntityReg.speechMin.get(), Speechmin.createAttributes().build());
            event.put(EntityReg.memoryMin.get(), Memorymin.createAttributes().build());
            event.put(EntityReg.clipMin.get(), Clipmin.createAttributes().build());
            event.put(EntityReg.copyMin.get(), Copymin.createAttributes().build());
            event.put(EntityReg.mejaMin.get(), Mejamin.createAttributes().build());
            event.put(EntityReg.origaMin.get(), Origamin.createAttributes().build());
            event.put(EntityReg.yajiroMin.get(), Yajiromin.createAttributes().build());
            event.put(EntityReg.chakkaMin.get(), Chakkamin.createAttributes().build());
            event.put(EntityReg.hasaMin.get(), Hasamin.createAttributes().build());
            event.put(EntityReg.liftMin.get(), Liftmin.createAttributes().build());
            event.put(EntityReg.keshigoMin.get(), Keshigomin.createAttributes().build());
            event.put(EntityReg.spicesMin.get(), Spicesmin.createAttributes().build());
            event.put(EntityReg.artMin.get(), Artmin.createAttributes().build());
            event.put(EntityReg.tenguMin.get(), Tengumin.createAttributes().build());
            event.put(EntityReg.menteMin.get(), Mentemin.createAttributes().build());
            event.put(EntityReg.bellMin.get(), Bellmin.createAttributes().build());
            event.put(EntityReg.katasuMin.get(), Katasumin.createAttributes().build());
            event.put(EntityReg.clockMin.get(), Clockmin.createAttributes().build());
            event.put(EntityReg.smallMin.get(), Smallmin.createAttributes().build());
            event.put(EntityReg.tafuMin.get(), Tafumin.createAttributes().build());
            event.put(EntityReg.freezeMin.get(), Freezemin.createAttributes().build());
            event.put(EntityReg.railMin.get(), Railmin.createAttributes().build());
            event.put(EntityReg.doriruMin.get(), Dorirumin.createAttributes().build());
            event.put(EntityReg.sukeMin.get(), Sukemin.createAttributes().build());
            event.put(EntityReg.hanshaMin.get(), Hanshamin.createAttributes().build());
            event.put(EntityReg.stopMin.get(), Stopmin.createAttributes().build());
            event.put(EntityReg.kyatchiMin.get(), Kyatchimin.createAttributes().build());
            event.put(EntityReg.muteMin.get(), Mutemin.createAttributes().build());
            event.put(EntityReg.fukuMin.get(), Fukumin.createAttributes().build());
            event.put(EntityReg.heartMin.get(), Heartmin.createAttributes().build());
            event.put(EntityReg.bigMin.get(), Bigmin.createAttributes().build());
            event.put(EntityReg.deodoMin.get(), Deodomin.createAttributes().build());

            event.put(EntityReg.rocketMin.get(), Stopmin.createAttributes().build());
            event.put(EntityReg.merrygoMin.get(), Kyatchimin.createAttributes().build());
            event.put(EntityReg.vacuuMin.get(), Mutemin.createAttributes().build());
            event.put(EntityReg.dozerMin.get(), Fukumin.createAttributes().build());
            event.put(EntityReg.slicerMin.get(), Heartmin.createAttributes().build());
            event.put(EntityReg.metMin.get(), Bigmin.createAttributes().build());
            event.put(EntityReg.wonderPromin.get(), Deodomin.createAttributes().build());
        }
    }
}
