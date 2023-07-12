package top.codephon.kamiwaza_program.keys;

import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.codephon.kamiwaza_program.KamiwazaProgram;

//绑定按键的类
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT, modid = KamiwazaProgram.MOD_ID)
public class MinKeyBending extends KeyMapping {

    //"key.%s.%s"是本地化翻译文本名称（键） 每一个%s表示后续”，“之后的下一项
    public MinKeyBending(String description, int keyCode, String category) {
        super(String.format("key.%s.%s", KamiwazaProgram.MOD_ID, description), keyCode, category);
    }

    //统一格式： public static final KeyMapping （键位）字段名 = new MinKeyBending(名称，键值（可以自行搜索也可以问），模组（键位分类）名称)
    //                                                                              键位：如下列 79是O，89是Y
    public static final KeyMapping SCAN_CARD =
            new MinKeyBending("scan",  79 , Component.translatable("key.kwp").getString());
    public static final KeyMapping ALISE_PROMIN =
            new MinKeyBending("alise_promin", 89,Component.translatable("key.kwp").getString());

    //（74 是 J 键）
    public static final KeyMapping USE_WAZA =
            new MinKeyBending("use_waza", 74,Component.translatable("key.kwp").getString());

    //注册键位的事件
    //*统一格式：event.register(键位的字段名);
    @SubscribeEvent
    public static void regKey(RegisterKeyMappingsEvent event){
        event.register(SCAN_CARD);
        event.register(ALISE_PROMIN);
        event.register(USE_WAZA);
    }
}
