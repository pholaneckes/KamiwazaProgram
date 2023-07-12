package top.codephon.kamiwaza_program.entities.finder;

import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import top.codephon.kamiwaza_program.entities.mins.MinionEntity;

import static top.codephon.kamiwaza_program.entities.EntityReg.turboMin;
import static top.codephon.kamiwaza_program.entities.finder.MinionAttributs.MinAttrys.*;
import static top.codephon.kamiwaza_program.items.ItemReg.turboCard;

public class MinionSetup {
    public static String[] minionListDown = new String[]{"turbomin", "gakkimin", "eishamin", "divemin", "micmin", "jetmin", "tsukkomin", "banemin", "drymin", "gymmin", "rizumumin", "penmin", "dancemin", "gagmin", "tonkmin", "plugmin", "boatmin", "burgemin", "magnemin", "recordmin", "sumerumin", "yumemin", "motemin", "gamemin", "coromin", "gauzemin", "denkyumin", "zuzumin", "senpuumin", "shugamin", "showamin", "rappumin", "slowmin", "makuramin", "fatmin", "temomin", "softmin", "jishomin", "kagimin", "jaguchimin", "sharimin", "mapmin", "brushmin", "meganemin", "cafemin", "speechmin", "memorymin", "clipmin", "copymin", "mejamin", "origamin", "yajiromin", "chakkamin", "hasamin", "liftmin", "keshigomin", "spicesmin", "artmin", "tengumin", "mentemin", "bellmin", "katasumin", "clockmin", "smallmin", "tafumin", "freezemin", "railmin", "dorirumin", "sukemin", "hanshamin", "stopmin", "kyatchimin", "mutemin", "fukumin", "heartmin", "bigmin", "deodomin" , "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none"};
    public static String[] minionListUp = new String[]{"TURBOMIN", "GAKKIMIN", "EISHAMIN", "DIVEMIN", "MICMIN", "JETMIN", "TSUKKOMIN", "BANEMIN", "DRYMIN", "GYMMIN", "RIZUMUMIN", "PENMIN", "DANCEMIN", "GAGMIN", "TONKMIN", "PLUGMIN", "BOATMIN", "BURGEMIN", "MAGNEMIN", "RECORDMIN", "SUMERUMIN", "YUMEMIN", "MOTEMIN", "GAMEMIN", "COROMIN", "GAUZEMIN", "DENKYUMIN", "ZUZUMIN", "SENPUUMIN", "SHUGAMIN", "SHOWAMIN", "RAPPUMIN", "SLOWMIN", "MAKURAMIN", "FATMIN", "TEMOMIN", "SOFTMIN", "JISHOMIN", "KAGIMIN", "JAGUCHIMIN", "SHARIMIN", "MAPMIN", "BRUSHMIN", "MEGANEMIN", "CAFEMIN", "SPEECHMIN", "MEMORYMIN", "CLIPMIN", "COPYMIN", "MEJAMIN", "ORIGAMIN", "YAJIROMIN", "CHAKKAMIN", "HASAMIN", "LIFTMIN", "KESHIGOMIN", "SPICESMIN", "ARTMIN", "TENGUMIN", "MENTEMIN", "BELLMIN", "KATASUMIN", "CLOCKMIN", "SMALLMIN", "TAFUMIN", "FREEZEMIN", "RAILMIN", "DORIRUMIN", "SUKEMIN", "HANSHAMIN", "STOPMIN", "KYATCHIMIN", "MUTEMIN", "FUKUMIN", "HEARTMIN", "BIGMIN", "DEODOMIN", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE", "NONE"};

    public enum MinSetUp implements StringRepresentable{
        TURBOMIN("Turbomin", SHIRISHIRI,"wiki.turbomin", turboCard.get(), turboMin.get());

        private final String name;
        private final MinionAttributs.MinAttrys minAttrys;
        private final String wiki;
        private final Item minCard;
        private final EntityType<? extends MinionEntity> min;
        MinSetUp(String name, MinionAttributs.MinAttrys minAttrys, String wiki, Item minCard, EntityType<? extends MinionEntity> min){
            this.name = name;
            this.minAttrys = minAttrys;
            this.wiki = wiki;
            this.minCard = minCard;
            this.min = min;
        }

        @Override
        public String getSerializedName() {
            return name;
        }

        public MinionAttributs.MinAttrys getAttry() {
            return minAttrys;
        }

        public String getWiki() {
            return wiki;
        }

        public Item getMinCard() {
            return minCard;
        }

        public EntityType<? extends MinionEntity> getMinET() {
            return min;
        }
    }

    public static boolean isEnglish(String str) {
        byte[] bytes = str.getBytes();
        int stringByteLength = bytes.length;
        int stringLength = str.length();
        return stringByteLength == stringLength;
    }
}
