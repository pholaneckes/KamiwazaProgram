package top.codephon.kamiwaza_program;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.codephon.kamiwaza_program.entities.EntityReg;
import top.codephon.kamiwaza_program.items.CreativeTabReg;
import top.codephon.kamiwaza_program.items.ItemReg;

//和1.16.5大同小异
//这个是主类 下面的 modid 换成自己的（与mods.toml里的保持一致）
@Mod("kamiwaza_program")
@Mod.EventBusSubscriber(modid = "kamiwaza_program")
public class KamiwazaProgram {
    public static final String MOD_ID = "kamiwaza_program";
    public KamiwazaProgram(){
        //Forge注册的总线
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //注册物品
        ItemReg.ITEMS.register(modEventBus);
        //注册创造模式物品栏
        CreativeTabReg.CREATIVE_MODE_TABS.register(modEventBus);
        //注册实体 *
        EntityReg.ENTITIES.register(modEventBus);
        //这个是后续必须的 注册事件
        MinecraftForge.EVENT_BUS.register(this);
    }
}
