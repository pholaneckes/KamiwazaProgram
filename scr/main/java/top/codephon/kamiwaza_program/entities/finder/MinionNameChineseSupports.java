package top.codephon.kamiwaza_program.entities.finder;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

//中文支持，枚举项不可用汉字所以用ZH_加上汉字的Unicode编码，ZH_的作用是 枚举项字段不可以数字开头
//用 对应翻译本地化也可以，不过不适用于服务器，服务器本地化语言一般为英文，用从客户端发包的话太繁琐了，可能留下恶意漏洞，导致服务器发包收包频率过高造成服务器卡顿
public class MinionNameChineseSupports {
    public static String[] INZHS = new String[]{"ZH_52A0901F7CBE7075","ZH_4E5056687CBE7075", "ZH_62955F717CBE7075", "ZH_6F5C6C347CBE7075", "ZH_9EA6514B98CE7CBE7075", "ZH_55B75C047CBE7075", "ZH_63B47CBE7075", "ZH_5F397C277CBE7075", "ZH_5E7271E57CBE7075", "ZH_50658EAB7CBE7075", "ZH_8282594F7CBE7075", "ZH_7B147CBE7075", "ZH_8DF3821E7CBE7075", "ZH_583556347CBE7075", "ZH_523690207CBE7075", "ZH_63D259347CBE7075", "ZH_5C0F82397CBE7075", "ZH_6C4958217CBE7075", "ZH_78C177F37CBE7075", "ZH_5F5597F37CBE7075", "ZH_6C1454737CBE7075", "ZH_68A67CBE7075", "ZH_4EBA6C147CBE7075", "ZH_6E38620F7CBE7075", "ZH_6EDA52A87CBE7075", "ZH_533B62A47CBE7075", "ZH_706F6CE17CBE7075", "ZH_9A6F517D7CBE7075", "ZH_98CE62477CBE7075", "ZH_7CD652067CBE7075", "ZH_6DCB6D747CBE7075", "ZH_4FDD9C9C819C7CBE7075", "ZH_7F1361627CBE7075", "ZH_679559347CBE7075", "ZH_6CB970B87CBE7075", "ZH_630964697CBE7075", "ZH_8F6F7CBE7075", "ZH_8BCD51787CBE7075", "ZH_94A553197CBE7075", "ZH_6C349F9959347CBE7075", "ZH_5BFF53F87CBE7075", "ZH_573056FE7CBE7075", "ZH_52375B507CBE7075", "ZH_773C955C7CBE7075", "ZH_549655617CBE7075", "ZH_6F148BB27CBE7075", "ZH_8BB05FC67CBE7075", "ZH_59397CBE7075", "ZH_590D53707CBE7075", "ZH_53775C3A7CBE7075", "ZH_62987EB87CBE7075", "ZH_644764467CBE7075", "ZH_70B9706B7CBE7075", "ZH_526A52007CBE7075", "ZH_8D7791CD7CBE7075", "ZH_6A6176AE7CBE7075", "ZH_999965997CBE7075", "ZH_827A672F7CBE7075", "ZH_592972D77CBE7075", "ZH_7EF462A47CBE7075", "ZH_753594C37CBE7075", "ZH_657474067CBE7075", "ZH_65F6949F7CBE7075", "ZH_7F295C0F7CBE7075", "ZH_5F3A97E77CBE7075", "ZH_51B751BB7CBE7075", "ZH_75358F667CBE7075", "ZH_94BB59347CBE7075", "ZH_900F660E7CBE7075", "ZH_53CD5C047CBE7075", "ZH_505C6B627CBE7075", "ZH_635563497CBE7075", "ZH_975997F37CBE7075", "ZH_670D88C57CBE7075", "ZH_5FC370757CBE7075", "ZH_653E59277CBE7075", "ZH_966481ED7CBE7075"/*, "ZH_706B7BAD7CBE7075", "ZH_65CB8F6C67289A6C7CBE7075", "ZH_771F7A7A7CBE7075", "ZH_63A8571F673A7CBE7075", "ZH_520772477CBE7075", "ZH_593476D47CBE7075", "ZH_65FA8FBE666E6D1B7CBE7075"*/,"ZH_6C7A687F167A0B"};
    public enum MinZHSup implements StringRepresentable {
        ZH_52A0901F7CBE7075("TURBOMIN"),
        ZH_4E5056687CBE7075("GAKKIMIN"),
        ZH_62955F717CBE7075("EISHAMIN"),
        ZH_6F5C6C347CBE7075("DIVEMIN"),
        ZH_9EA6514B98CE7CBE7075("MICMIN"),
        ZH_55B75C047CBE7075("JETMIN"),
        ZH_63B47CBE7075("TSUKKOMIN"),
        ZH_5F397C277CBE7075("BANEMIN"),
        ZH_5E7271E57CBE7075("DRYMIN"),
        ZH_50658EAB7CBE7075("GYMMIN"),
        ZH_8282594F7CBE7075("RIZUMUMIN"),
        ZH_7B147CBE7075("PENMIN"),
        ZH_8DF3821E7CBE7075("DANCEMIN"),
        ZH_583556347CBE7075("GAGMIN"),
        ZH_523690207CBE7075("TONKMIN"),
        ZH_63D259347CBE7075("PLUGMIN"),
        ZH_5C0F82397CBE7075("BOATMIN"),
        ZH_6C4958217CBE7075("BURGEMIN"),
        ZH_78C177F37CBE7075("MAGNEMIN"),
        ZH_5F5597F37CBE7075("RECORDMIN"),
        ZH_6C1454737CBE7075("SUMERUMIN"),
        ZH_68A67CBE7075("YUMEMIN"),
        ZH_4EBA6C147CBE7075("MOTEMIN"),
        ZH_6E38620F7CBE7075("GAMEMIN"),
        ZH_6EDA52A87CBE7075("COROMIN"),
        ZH_533B62A47CBE7075("GAUZEMIN"),
        ZH_706F6CE17CBE7075("DENKYUMIN"),
        ZH_9A6F517D7CBE7075("ZUZUMIN"),
        ZH_98CE62477CBE7075("SENPUUMIN"),
        ZH_7CD652067CBE7075("SHUGAMIN"),
        ZH_6DCB6D747CBE7075("SHOWAMIN"),
        ZH_4FDD9C9C819C7CBE7075("RAPPUMIN"),
        ZH_7F1361627CBE7075("SLOWMIN"),
        ZH_679559347CBE7075("MAKURAMIN"),
        ZH_6CB970B87CBE7075("FATMIN"),
        ZH_630964697CBE7075("TEMOMIN"),
        ZH_8F6F7CBE7075("SOFTMIN"),
        ZH_8BCD51787CBE7075("JISHOMIN"),
        ZH_94A553197CBE7075("KAGIMIN"),
        ZH_6C349F9959347CBE7075("JAGUCHIMIN"),
        ZH_5BFF53F87CBE7075("SHARIMIN"),
        ZH_573056FE7CBE7075("MAPMIN"),
        ZH_52375B507CBE7075("BRUSHMIN"),
        ZH_773C955C7CBE7075("MEGANEMIN"),
        ZH_549655617CBE7075("CAFEMIN"),
        ZH_6F148BB27CBE7075("SPEECHMIN"),
        ZH_8BB05FC67CBE7075("MEMORYMIN"),
        ZH_59397CBE7075("CLIPMIN"),
        ZH_590D53707CBE7075("COPYMIN"),
        ZH_53775C3A7CBE7075("MEJAMIN"),
        ZH_62987EB87CBE7075("ORIGAMIN"),
        ZH_644764467CBE7075("YAJIROMIN"),
        ZH_70B9706B7CBE7075("CHAKKAMIN"),
        ZH_526A52007CBE7075("HASAMIN"),
        ZH_8D7791CD7CBE7075("LIFTMIN"),
        ZH_6A6176AE7CBE7075("KESHIGOMIN"),
        ZH_999965997CBE7075("SPICESMIN"),
        ZH_827A672F7CBE7075("ARTMIN"),
        ZH_592972D77CBE7075("TENGUMIN"),
        ZH_7EF462A47CBE7075("MENTEMIN"),
        ZH_753594C37CBE7075("BELLMIN"),
        ZH_657474067CBE7075("KATASUMIN"),
        ZH_65F6949F7CBE7075("CLOCKMIN"),
        ZH_7F295C0F7CBE7075("SMALLMIN"),
        ZH_5F3A97E77CBE7075("TAFUMIN"),
        ZH_51B751BB7CBE7075("FREEZEMIN"),
        ZH_75358F667CBE7075("RAILMIN"),
        ZH_94BB59347CBE7075("DORIRUMIN"),
        ZH_900F660E7CBE7075("SUKEMIN"),
        ZH_53CD5C047CBE7075("HANSHAMIN"),
        ZH_505C6B627CBE7075("STOPMIN"),
        ZH_635563497CBE7075("KYATCHIMIN"),
        ZH_975997F37CBE7075("MUTEMIN"),
        ZH_670D88C57CBE7075("FUKUMIN"),
        ZH_5FC370757CBE7075("HEARTMIN"),
        ZH_653E59277CBE7075("BIGMIN"),
        ZH_966481ED7CBE7075("DEODOMIN"),
        ZH_706B7BAD7CBE7075("ROCKETMIN"),
        ZH_65CB8F6C67289A6C7CBE7075("MERRYGOMIN"),
        ZH_771F7A7A7CBE7075("VACUUIMIN"),
        ZH_63A8571F673A7CBE7075("DOZERMIN"),
        ZH_520772477CBE7075("SLICERMIN"),
        ZH_593476D47CBE7075("METMIN"),
        ZH_65FA8FBE666E6D1B7CBE7075("WONDERPROMIN"),
        ZH_6C7A687F167A0B("SPECIAL1");
        private final String en;

        MinZHSup(String en){
            this.en = en;
        }
        @Override
        public String getSerializedName() {
            return null;
        }

        public @NotNull String getName() {
            return en;
        }
    }

    //字符串转换为 UNICODE编码
    public static String stringToUnicode(String str, boolean hasZH) {
        StringBuilder sb = new StringBuilder();
        char[] c = str.toCharArray();
        for (char value : c) {
            sb.append(Integer.toHexString(value));
        }
        return hasZH?"ZH_" + sb.toString().toUpperCase():sb.toString().toUpperCase();
    }

    public static String stringToUnicode(String str) {
        StringBuilder sb = new StringBuilder();
        char[] c = str.toCharArray();
        for (char value : c) {
            sb.append(Integer.toHexString(value));
        }
        return "ZH_" + sb.toString().toUpperCase();
    }
}