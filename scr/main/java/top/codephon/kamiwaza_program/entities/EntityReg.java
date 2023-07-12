package top.codephon.kamiwaza_program.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.codephon.kamiwaza_program.KamiwazaProgram;
import top.codephon.kamiwaza_program.entities.mins.Turbomin;
import top.codephon.kamiwaza_program.entities.mins.temp.*;

public class EntityReg {

    //实体的注册 主字段
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, KamiwazaProgram.MOD_ID);

    //注册单个实体
    //格式：public static final RegistryObject<EntityType<实体所在类>> 实体字段取名 =
    public static final RegistryObject<EntityType<Turbomin>> turboMin =
            //格式 ENTITIES（主字段）.register("实体注册名", ()->EntityType.Builder.of(实体所在类::new, MobCategory.实体类型)
            //实体类型有：MONSTER怪物 AMBIENT装饰环境的生物 如蝙蝠 AXOLOTLS蝾螈 UNDERGROUND_WATER_CREATURE地下水生物
            //WATER_CREATURE水生物 WATER_AMBIENT水下装饰环境的生物 如小丑鱼 MISC非生物 CREATURE不属于其它8项的
            ENTITIES.register("turbomin", ()->EntityType.Builder.of(Turbomin::new, MobCategory.CREATURE)
                    //sized:碰撞箱大小 底面边长,高度  .build(实体注册名，和上面的保持一致)
                    .sized(0.7f,1.1f).build("turbomin"));


    public static final RegistryObject<EntityType<Gakkimin>> gakkiMin =
            ENTITIES.register("gakkimin", ()->EntityType.Builder.of(Gakkimin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("gakkimin"));
    public static final RegistryObject<EntityType<Eishamin>> eishaMin =
            ENTITIES.register("eishamin", ()->EntityType.Builder.of(Eishamin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("eishamin"));
    public static final RegistryObject<EntityType<Divemin>> diveMin =
            ENTITIES.register("divemin", ()->EntityType.Builder.of(Divemin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("divemin"));
    public static final RegistryObject<EntityType<Micmin>> micMin =
            ENTITIES.register("micmin", ()->EntityType.Builder.of(Micmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("micmin"));
    public static final RegistryObject<EntityType<Jetmin>> jetMin =
            ENTITIES.register("jetmin", ()->EntityType.Builder.of(Jetmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("jetmin"));
    public static final RegistryObject<EntityType<Tsukkomin>> tsukkoMin =
            ENTITIES.register("tsukkomin", ()->EntityType.Builder.of(Tsukkomin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("tsukkomin"));
    public static final RegistryObject<EntityType<Banemin>> baneMin =
            ENTITIES.register("banemin", ()->EntityType.Builder.of(Banemin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("banemin"));
    public static final RegistryObject<EntityType<Drymin>> dryMin =
            ENTITIES.register("drymin", ()->EntityType.Builder.of(Drymin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("drymin"));
    public static final RegistryObject<EntityType<Gymmin>> gymMin =
            ENTITIES.register("gymmin", ()->EntityType.Builder.of(Gymmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("gymmin"));
    public static final RegistryObject<EntityType<Rizumumin>> rizumuMin =
            ENTITIES.register("rizumumin", ()->EntityType.Builder.of(Rizumumin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("rizumumin"));
    public static final RegistryObject<EntityType<Penmin>> penMin =
            ENTITIES.register("penmin", ()->EntityType.Builder.of(Penmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("penmin"));
    public static final RegistryObject<EntityType<Dancemin>> danceMin =
            ENTITIES.register("dancemin", ()->EntityType.Builder.of(Dancemin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("dancemin"));
    public static final RegistryObject<EntityType<Gagmin>> gagMin =
            ENTITIES.register("gagmin", ()->EntityType.Builder.of(Gagmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("gagmin"));
    public static final RegistryObject<EntityType<Tonkmin>> tonkMin =
            ENTITIES.register("tonkmin", ()->EntityType.Builder.of(Tonkmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("tonkmin"));
    public static final RegistryObject<EntityType<Plugmin>> plugMin =
            ENTITIES.register("plugmin", ()->EntityType.Builder.of(Plugmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("plugmin"));
    public static final RegistryObject<EntityType<Boatmin>> boatMin =
            ENTITIES.register("boatmin", ()->EntityType.Builder.of(Boatmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("boatmin"));
    public static final RegistryObject<EntityType<Burgemin>> burgeMin =
            ENTITIES.register("burgemin", ()->EntityType.Builder.of(Burgemin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("burgemin"));
    public static final RegistryObject<EntityType<Magnemin>> magneMin =
            ENTITIES.register("magnemin", ()->EntityType.Builder.of(Magnemin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("magnemin"));
    public static final RegistryObject<EntityType<Recordmin>> recordMin =
            ENTITIES.register("recordmin", ()->EntityType.Builder.of(Recordmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("recordmin"));
    public static final RegistryObject<EntityType<Sumerumin>> sumeruMin =
            ENTITIES.register("sumerumin", ()->EntityType.Builder.of(Sumerumin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("sumerumin"));
    public static final RegistryObject<EntityType<Yumemin>> yumeMin =
            ENTITIES.register("yumemin", ()->EntityType.Builder.of(Yumemin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("yumemin"));
    public static final RegistryObject<EntityType<Motemin>> moteMin =
            ENTITIES.register("motemin", ()->EntityType.Builder.of(Motemin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("motemin"));
    public static final RegistryObject<EntityType<Gamemin>> gameMin =
            ENTITIES.register("gamemin", ()->EntityType.Builder.of(Gamemin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("gamemin"));
    public static final RegistryObject<EntityType<Coromin>> coroMin =
            ENTITIES.register("coromin", ()->EntityType.Builder.of(Coromin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("coromin"));
    public static final RegistryObject<EntityType<Gauzemin>> gauzeMin =
            ENTITIES.register("gauzemin", ()->EntityType.Builder.of(Gauzemin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("gauzemin"));
    public static final RegistryObject<EntityType<Denkyumin>> denkyuMin =
            ENTITIES.register("denkyumin", ()->EntityType.Builder.of(Denkyumin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("denkyumin"));
    public static final RegistryObject<EntityType<Zuzumin>> zuzuMin =
            ENTITIES.register("zuzumin", ()->EntityType.Builder.of(Zuzumin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("zuzumin"));
    public static final RegistryObject<EntityType<Senpuumin>> senpuuMin =
            ENTITIES.register("senpuumin", ()->EntityType.Builder.of(Senpuumin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("senpuumin"));
    public static final RegistryObject<EntityType<Shugamin>> shugaMin =
            ENTITIES.register("shugamin", ()->EntityType.Builder.of(Shugamin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("shugamin"));
    public static final RegistryObject<EntityType<Showamin>> showaMin =
            ENTITIES.register("showamin", ()->EntityType.Builder.of(Showamin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("showamin"));
    public static final RegistryObject<EntityType<Rappumin>> rappuMin =
            ENTITIES.register("rappumin", ()->EntityType.Builder.of(Rappumin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("rappumin"));
    public static final RegistryObject<EntityType<Slowmin>> slowMin =
            ENTITIES.register("slowmin", ()->EntityType.Builder.of(Slowmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("slowmin"));
    public static final RegistryObject<EntityType<Makuramin>> makuraMin =
            ENTITIES.register("makuramin", ()->EntityType.Builder.of(Makuramin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("makuramin"));
    public static final RegistryObject<EntityType<Fatmin>> fatMin =
            ENTITIES.register("fatmin", ()->EntityType.Builder.of(Fatmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("fatmin"));
    public static final RegistryObject<EntityType<Temomin>> temoMin =
            ENTITIES.register("temomin", ()->EntityType.Builder.of(Temomin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("temomin"));
    public static final RegistryObject<EntityType<Softmin>> softMin =
            ENTITIES.register("softmin", ()->EntityType.Builder.of(Softmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("softmin"));
    public static final RegistryObject<EntityType<Jishomin>> jishoMin =
            ENTITIES.register("jishomin", ()->EntityType.Builder.of(Jishomin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("jishomin"));
    public static final RegistryObject<EntityType<Kagimin>> kagiMin =
            ENTITIES.register("kagimin", ()->EntityType.Builder.of(Kagimin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("kagimin"));
    public static final RegistryObject<EntityType<Jaguchimin>> jaguchiMin =
            ENTITIES.register("jaguchimin", ()->EntityType.Builder.of(Jaguchimin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("jaguchimin"));
    public static final RegistryObject<EntityType<Sharimin>> shariMin =
            ENTITIES.register("sharimin", ()->EntityType.Builder.of(Sharimin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("sharimin"));
    public static final RegistryObject<EntityType<Mapmin>> mapMin =
            ENTITIES.register("mapmin", ()->EntityType.Builder.of(Mapmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("mapmin"));
    public static final RegistryObject<EntityType<Brushmin>> brushMin =
            ENTITIES.register("brushmin", ()->EntityType.Builder.of(Brushmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("brushmin"));
    public static final RegistryObject<EntityType<Meganemin>> meganeMin =
            ENTITIES.register("meganemin", ()->EntityType.Builder.of(Meganemin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("meganemin"));
    public static final RegistryObject<EntityType<Cafemin>> cafeMin =
            ENTITIES.register("cafemin", ()->EntityType.Builder.of(Cafemin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("cafemin"));
    public static final RegistryObject<EntityType<Speechmin>> speechMin =
            ENTITIES.register("speechmin", ()->EntityType.Builder.of(Speechmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("speechmin"));
    public static final RegistryObject<EntityType<Memorymin>> memoryMin =
            ENTITIES.register("memorymin", ()->EntityType.Builder.of(Memorymin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("memorymin"));
    public static final RegistryObject<EntityType<Clipmin>> clipMin =
            ENTITIES.register("clipmin", ()->EntityType.Builder.of(Clipmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("clipmin"));
    public static final RegistryObject<EntityType<Copymin>> copyMin =
            ENTITIES.register("copymin", ()->EntityType.Builder.of(Copymin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("copymin"));
    public static final RegistryObject<EntityType<Mejamin>> mejaMin =
            ENTITIES.register("mejamin", ()->EntityType.Builder.of(Mejamin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("mejamin"));
    public static final RegistryObject<EntityType<Origamin>> origaMin =
            ENTITIES.register("origamin", ()->EntityType.Builder.of(Origamin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("origamin"));
    public static final RegistryObject<EntityType<Yajiromin>> yajiroMin =
            ENTITIES.register("yajiromin", ()->EntityType.Builder.of(Yajiromin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("yajiromin"));
    public static final RegistryObject<EntityType<Chakkamin>> chakkaMin =
            ENTITIES.register("chakkamin", ()->EntityType.Builder.of(Chakkamin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("chakkamin"));
    public static final RegistryObject<EntityType<Hasamin>> hasaMin =
            ENTITIES.register("hasamin", ()->EntityType.Builder.of(Hasamin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("hasamin"));
    public static final RegistryObject<EntityType<Liftmin>> liftMin =
            ENTITIES.register("liftmin", ()->EntityType.Builder.of(Liftmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("liftmin"));
    public static final RegistryObject<EntityType<Keshigomin>> keshigoMin =
            ENTITIES.register("keshigomin", ()->EntityType.Builder.of(Keshigomin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("keshigomin"));
    public static final RegistryObject<EntityType<Spicesmin>> spicesMin =
            ENTITIES.register("spicesmin", ()->EntityType.Builder.of(Spicesmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("spicesmin"));
    public static final RegistryObject<EntityType<Artmin>> artMin =
            ENTITIES.register("artmin", ()->EntityType.Builder.of(Artmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("artmin"));
    public static final RegistryObject<EntityType<Tengumin>> tenguMin =
            ENTITIES.register("tengumin", ()->EntityType.Builder.of(Tengumin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("tengumin"));
    public static final RegistryObject<EntityType<Mentemin>> menteMin =
            ENTITIES.register("mentemin", ()->EntityType.Builder.of(Mentemin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("mentemin"));
    public static final RegistryObject<EntityType<Bellmin>> bellMin =
            ENTITIES.register("bellmin", ()->EntityType.Builder.of(Bellmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("bellmin"));
    public static final RegistryObject<EntityType<Katasumin>> katasuMin =
            ENTITIES.register("katasumin", ()->EntityType.Builder.of(Katasumin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("katasumin"));
    public static final RegistryObject<EntityType<Clockmin>> clockMin =
            ENTITIES.register("clockmin", ()->EntityType.Builder.of(Clockmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("clockmin"));
    public static final RegistryObject<EntityType<Smallmin>> smallMin =
            ENTITIES.register("smallmin", ()->EntityType.Builder.of(Smallmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("smallmin"));
    public static final RegistryObject<EntityType<Tafumin>> tafuMin =
            ENTITIES.register("tafumin", ()->EntityType.Builder.of(Tafumin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("tafumin"));
    public static final RegistryObject<EntityType<Freezemin>> freezeMin =
            ENTITIES.register("freezemin", ()->EntityType.Builder.of(Freezemin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("freezemin"));
    public static final RegistryObject<EntityType<Railmin>> railMin =
            ENTITIES.register("railmin", ()->EntityType.Builder.of(Railmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("railmin"));
    public static final RegistryObject<EntityType<Dorirumin>> doriruMin =
            ENTITIES.register("dorirumin", ()->EntityType.Builder.of(Dorirumin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("dorirumin"));
    public static final RegistryObject<EntityType<Sukemin>> sukeMin =
            ENTITIES.register("sukemin", ()->EntityType.Builder.of(Sukemin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("sukemin"));
    public static final RegistryObject<EntityType<Hanshamin>> hanshaMin =
            ENTITIES.register("hanshamin", ()->EntityType.Builder.of(Hanshamin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("hanshamin"));
    public static final RegistryObject<EntityType<Stopmin>> stopMin =
            ENTITIES.register("stopmin", ()->EntityType.Builder.of(Stopmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("stopmin"));
    public static final RegistryObject<EntityType<Kyatchimin>> kyatchiMin =
            ENTITIES.register("kyatchimin", ()->EntityType.Builder.of(Kyatchimin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("kyatchimin"));
    public static final RegistryObject<EntityType<Mutemin>> muteMin =
            ENTITIES.register("mutemin", ()->EntityType.Builder.of(Mutemin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("mutemin"));
    public static final RegistryObject<EntityType<Fukumin>> fukuMin =
            ENTITIES.register("fukumin", ()->EntityType.Builder.of(Fukumin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("fukumin"));
    public static final RegistryObject<EntityType<Heartmin>> heartMin =
            ENTITIES.register("heartmin", ()->EntityType.Builder.of(Heartmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("heartmin"));
    public static final RegistryObject<EntityType<Bigmin>> bigMin =
            ENTITIES.register("bigmin", ()->EntityType.Builder.of(Bigmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("bigmin"));
    public static final RegistryObject<EntityType<Deodomin>> deodoMin =
            ENTITIES.register("deodomin", ()->EntityType.Builder.of(Deodomin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("deodomin"));

    public static final RegistryObject<EntityType<Rocketmin>> rocketMin =
            ENTITIES.register("rocketmin", ()->EntityType.Builder.of(Rocketmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("rocketmin"));

    public static final RegistryObject<EntityType<Merrygomin>> merrygoMin =
            ENTITIES.register("merrygomin", ()->EntityType.Builder.of(Merrygomin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("merrygomin"));

    public static final RegistryObject<EntityType<Vacuumin>> vacuuMin =
            ENTITIES.register("vacuumin", ()->EntityType.Builder.of(Vacuumin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("vacuumin"));

    public static final RegistryObject<EntityType<Dozermin>> dozerMin =
            ENTITIES.register("dozermin", ()->EntityType.Builder.of(Dozermin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("dozermin"));

    public static final RegistryObject<EntityType<Slicermin>> slicerMin =
            ENTITIES.register("slicermin", ()->EntityType.Builder.of(Slicermin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("slicermin"));

    public static final RegistryObject<EntityType<Metmin>> metMin =
            ENTITIES.register("metmin", ()->EntityType.Builder.of(Metmin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("metmin"));

    public static final RegistryObject<EntityType<WonderPromin>> wonderPromin =
            ENTITIES.register("wonder_promin", ()->EntityType.Builder.of(WonderPromin::new, MobCategory.CREATURE)
                    .sized(1f,1f).build("wonder_promin"));
}
