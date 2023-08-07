package top.codephon.kamiwaza_program.entities.finder;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import top.codephon.kamiwaza_program.entities.mins.MinionEntity;

import static top.codephon.kamiwaza_program.entities.EntityReg.*;
import static top.codephon.kamiwaza_program.entities.finder.MinionAttrys.*;
import static top.codephon.kamiwaza_program.items.ItemReg.*;

public class MinionSetup {
    //一些用于记录的数组
    public static final String[] minionListDown = new String[]{"turbomin", "gakkimin", "eishamin", "divemin", "micmin", "jetmin", "tsukkomin", "banemin", "drymin", "gymmin", "rizumumin", "penmin", "dancemin", "gagmin", "tonkmin", "plugmin", "boatmin", "burgemin", "magnemin", "recordmin", "sumerumin", "yumemin", "motemin", "gamemin", "coromin", "gauzemin", "denkyumin", "zuzumin", "senpuumin", "shugamin", "showamin", "rappumin", "slowmin", "makuramin", "fatmin", "temomin", "softmin", "jishomin", "kagimin", "jaguchimin", "sharimin", "mapmin", "brushmin", "meganemin", "cafemin", "speechmin", "memorymin", "clipmin", "copymin", "mejamin", "origamin", "yajiromin", "chakkamin", "hasamin", "liftmin", "keshigomin", "spicesmin", "artmin", "tengumin", "mentemin", "bellmin", "katasumin", "clockmin", "smallmin", "tafumin", "freezemin", "railmin", "dorirumin", "sukemin", "hanshamin", "stopmin", "kyatchimin", "mutemin", "fukumin", "heartmin", "bigmin", "deodomin" , "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none"};
    public static final String[] minionListUp = new String[]{"TURBOMIN", "GAKKIMIN", "EISHAMIN", "DIVEMIN", "MICMIN", "JETMIN", "TSUKKOMIN", "BANEMIN", "DRYMIN", "GYMMIN", "RIZUMUMIN", "PENMIN", "DANCEMIN", "GAGMIN", "TONKMIN", "PLUGMIN", "BOATMIN", "BURGEMIN", "MAGNEMIN", "RECORDMIN", "SUMERUMIN", "YUMEMIN", "MOTEMIN", "GAMEMIN", "COROMIN", "GAUZEMIN", "DENKYUMIN", "ZUZUMIN", "SENPUUMIN", "SHUGAMIN", "SHOWAMIN", "RAPPUMIN", "SLOWMIN", "MAKURAMIN", "FATMIN", "TEMOMIN", "SOFTMIN", "JISHOMIN", "KAGIMIN", "JAGUCHIMIN", "SHARIMIN", "MAPMIN", "BRUSHMIN", "MEGANEMIN", "CAFEMIN", "SPEECHMIN", "MEMORYMIN", "CLIPMIN", "COPYMIN", "MEJAMIN", "ORIGAMIN", "YAJIROMIN", "CHAKKAMIN", "HASAMIN", "LIFTMIN", "KESHIGOMIN", "SPICESMIN", "ARTMIN", "TENGUMIN", "MENTEMIN", "BELLMIN", "KATASUMIN", "CLOCKMIN", "SMALLMIN", "TAFUMIN", "FREEZEMIN", "RAILMIN", "DORIRUMIN", "SUKEMIN", "HANSHAMIN", "STOPMIN", "KYATCHIMIN", "MUTEMIN", "FUKUMIN", "HEARTMIN", "BIGMIN", "DEODOMIN", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE"};

    public static final String[] minAvail = new String[]{"turbomin","lzh"};

    public enum MinSetUp implements StringRepresentable{
        TURBOMIN("Turbomin", SHIRISHIRI, turboCard.get(), turboMin.get(),true),
        GAKKIMIN("Gakkimin", SHIRISHIRI, gakkiCard.get(),gakkiMin.get(),true),
        EISHAMIN("Eishamin", SHIRISHIRI, eishaCard.get(),eishaMin.get(),true),
        DIVEMIN("Divemin", SHIRISHIRI, diveCard.get(),diveMin.get(),true),
        MICMIN("Micmin", SHIRISHIRI, micCard.get(),micMin.get(),true),
        JETMIN("Jetmin", SHIRISHIRI, jetCard.get(),jetMin.get(),true),
        TSUKKOMIN("Tsukkomin", SHIRISHIRI, tsukkoCard.get(),tsukkoMin.get(),true),
        BANEMIN("Banemin", SHIRISHIRI, baneCard.get(),baneMin.get(),true),
        DRYMIN("Drymin", SHIRISHIRI, dryCard.get(),dryMin.get(),true),
        GYMMIN("Gymmin", SHIRISHIRI, gymCard.get(),gymMin.get(),true),
        RIZUMUMIN("Rizumumin", SHIRISHIRI, rizumuCard.get(),rizumuMin.get(),true),
        PENMIN("Penmin", SHIRISHIRI, penCard.get(),penMin.get(),true),
        DANCEMIN("Dancemin", SHIRISHIRI, danceCard.get(),danceMin.get(),true),
        GAGMIN("Gagmin", SHIRISHIRI, gagCard.get(),gagMin.get(),true),
        TONKMIN("Tonkmin", WAKUWAKU, tonkCard.get(),tonkMin.get(),true),
        PLUGMIN("Plugmin", WAKUWAKU, plugCard.get(),plugMin.get(),true),
        BOATMIN("Boatmin", WAKUWAKU, boatCard.get(),boatMin.get(),true),
        BURGEMIN("Burgemin", WAKUWAKU, burgeCard.get(),burgeMin.get(),true),
        MAGNEMIN("Magnemin", WAKUWAKU, magneCard.get(),magneMin.get(),true),
        RECORDMIN("Recordmin", WAKUWAKU, recordCard.get(),recordMin.get(),true),
        SUMERUMIN("Sumerumin", WAKUWAKU, sumeruCard.get(),sumeruMin.get(),true),
        YUMEMIN("Yumemin", WAKUWAKU, yumeCard.get(),yumeMin.get(),true),
        MOTEMIN("Motemin", WAKUWAKU, moteCard.get(),moteMin.get(),false),
        GAMEMIN("Gamemin", WAKUWAKU, gameCard.get(),gameMin.get(),true),
        COROMIN("Coromin", WAKUWAKU, coroCard.get(),coroMin.get(),true),
        GAUZEMIN("Gauzemin", HOKKORI, gauzeCard.get(),gauzeMin.get(),false),
        DENKYUMIN("Denkyumin", HOKKORI, denkyuCard.get(),denkyuMin.get(),true),
        ZUZUMIN("Zuzumin", HOKKORI, zuzuCard.get(),zuzuMin.get(),true),
        SENPUUMIN("Senpuumin", HOKKORI, senpuuCard.get(),senpuuMin.get(),true),
        SHUGAMIN("Shugamin", HOKKORI, shugaCard.get(),shugaMin.get(),true),
        SHOWAMIN("Showamin", HOKKORI, showaCard.get(),showaMin.get(),true),
        RAPPUMIN("Rappumin", HOKKORI, rappuCard.get(),rappuMin.get(),true),
        SLOWMIN("Slowmin", HOKKORI, slowCard.get(),slowMin.get(),true),
        MAKURAMIN("Makuramin", HOKKORI, makuraCard.get(),makuraMin.get(),true),
        FATMIN("Fatmin", HOKKORI, fatCard.get(),fatMin.get(),true),
        TEMOMIN("Temomin", HOKKORI, temoCard.get(),temoMin.get(),true),
        SOFTMIN("Softmin", HOKKORI, softCard.get(),softMin.get(),false),
        JISHOMIN("Jishomin", KICCHIRI, jishoCard.get(),jishoMin.get(),true),
        KAGIMIN("Kagimin", KICCHIRI, kagiCard.get(),kagiMin.get(),true),
        JAGUCHIMIN("Jaguchimin", KICCHIRI, jaguchiCard.get(),jaguchiMin.get(),true),
        SHARIMIN("Sharimin", KICCHIRI, shariCard.get(),shariMin.get(),true),
        MAPMIN("Mapmin", KICCHIRI, mapCard.get(),mapMin.get(),true),
        BRUSHMIN("Brushmin", KICCHIRI, brushCard.get(),brushMin.get(),true),
        MEGANEMIN("Meganemin", KICCHIRI, meganeCard.get(),meganeMin.get(),true),
        CAFEMIN("Cafemin", KICCHIRI, cafeCard.get(),cafeMin.get(),false),
        SPEECHMIN("Speechmin", KICCHIRI, speechCard.get(),speechMin.get(),true),
        MEMORYMIN("Memorymin", KICCHIRI, memoryCard.get(),memoryMin.get(),true),
        CLIPMIN("Clipmin", KICCHIRI, clipCard.get(),clipMin.get(),true),
        COPYMIN("Copymin", KICCHIRI, copyCard.get(),copyMin.get(),true),
        MEJAMIN("Mejamin", KICCHIRI, mejaCard.get(),mejaMin.get(),true),
        ORIGAMIN("Origamin", KICCHIRI, origaCard.get(),origaMin.get(),true),
        YAJIROMIN("Yajiromin", KICCHIRI, yajiroCard.get(),yajiroMin.get(),true),
        CHAKKAMIN("Chakkamin", PUNPUN, chakkaCard.get(),chakkaMin.get(),true),
        HASAMIN("Hasamin", PUNPUN, hasaCard.get(),hasaMin.get(),false),
        LIFTMIN("Liftmin", PUNPUN, liftCard.get(),liftMin.get(),true),
        KESHIGOMIN("Keshigomin", PUNPUN, keshigoCard.get(),keshigoMin.get(),true),
        SPICESMIN("Spicesmin", PUNPUN, spicesCard.get(),spicesMin.get(),true),
        ARTMIN("artmin", PUNPUN, artCard.get(),artMin.get(),true),
        TENGUMIN("Tengumin", PUNPUN, tenguCard.get(),tenguMin.get(),true),
        MENTEMIN("Mentemin", PUNPUN, menteCard.get(),menteMin.get(),true),
        BELLMIN("Bellmin", PUNPUN, bellCard.get(),bellMin.get(),true),
        KATASUMIN("Katasumin", PUNPUN, katasuCard.get(),katasuMin.get(),false),
        CLOCKMIN("Clockmin", PUNPUN, clockCard.get(),clockMin.get(),true),
        SMALLMIN("Smallmin", PUNPUN, smallCard.get(),smallMin.get(),true),
        TAFUMIN("Tafumin", PUNPUN, tafuCard.get(),tafuMin.get(),true),
        FREEZEMIN("Freezemin", BURUBURU, freezeCard.get(),freezeMin.get(),true),
        RAILMIN("Railmin", BURUBURU, railCard.get(),railMin.get(),true),
        DORIRUMIN("Dorirumin", BURUBURU, doriruCard.get(),doriruMin.get(),true),
        SUKEMIN("Sukemin", BURUBURU, sukeCard.get(),sukeMin.get(),true),
        HANSHAMIN("Hanshamin", BURUBURU, hanshaCard.get(),hanshaMin.get(),true),
        STOPMIN("Stopmin", BURUBURU, stopCard.get(),stopMin.get(),true),
        KYATCHIMIN("Kyatchimin", BURUBURU, kyatchiCard.get(),kyatchiMin.get(),true),
        MUTEMIN("Mutemin", BURUBURU, muteCard.get(),muteMin.get(),false),
        FUKUMIN("Fukumin", BURUBURU, fukuCard.get(),fukuMin.get(),false),
        HEARTMIN("Heartmin", BURUBURU, heartCard.get(),heartMin.get(),true),
        BIGMIN("Bigmin", BURUBURU, bigCard.get(),bigMin.get(),true),
        DEODOMIN("Deodomin", BURUBURU, deodoCard.get(),deodoMin.get(),false),
        ROCKETMIN("Rocketmin", SHIRISHIRI, Items.AIR,rocketMin.get(),true),
        MERRYGOMIN("Merrygomin", WAKUWAKU, Items.AIR,merrygoMin.get(),true),
        VACUUIMIN("Vacuumin", HOKKORI, Items.AIR,vacuuMin.get(),true),
        DOZERMIN("Dozermin", KICCHIRI, Items.AIR,dozerMin.get(),true),
        SLICERMIN("Slicermin", PUNPUN, Items.AIR,slicerMin.get(),false),
        METMIN("Metmin", BURUBURU, Items.AIR,metMin.get(),true),
        WONDERPROMIN("WonderPromin", WONDER, Items.AIR,wonderPromin.get(),true),
        SPECIAL1("LZH",WONDER, kamiwazaFile.get(), wonderPromin.get(),true),
        NONE("None",NONE_ATTRIBUTE, Items.AIR, null ,null);

        private final String name;
        private final MinionAttrys minAttrys;
        private final Item minCard;
        private final EntityType<? extends MinionEntity> min;
        private final Boolean isMale;
        //构建方法 枚举项字段(名称，属性，对应的超能卡，注册的实体，性别)
        //作用：可以把 实体 ， 超能卡 ， 其属性与性别 等通过这种方式（枚举）关联起来
        MinSetUp(String name, MinionAttrys minAttrys, Item minCard, EntityType<? extends MinionEntity> min, Boolean isMale){
            this.name = name;
            this.minAttrys = minAttrys;
            this.minCard = minCard;
            this.min = min;
            this.isMale = isMale;
        }

        @Override
        public @NotNull String getSerializedName() {
            return name;
        }

        public MinionAttrys getAttry() {
            return minAttrys;
        }

        public Item getMinCard() {
            return minCard;
        }

        public Boolean isMale(){
            return isMale;
        }

        public EntityType<? extends MinionEntity> getMinET() {
            return min;
        }
    }

    //判断是否是英文
    public static boolean isEnglish(String str) {
        byte[] bytes = str.getBytes();
        int stringByteLength = bytes.length;
        int stringLength = str.length();
        return stringByteLength == stringLength;
    }
}
