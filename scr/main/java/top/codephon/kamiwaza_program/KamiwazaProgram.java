package top.codephon.kamiwaza_program;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.codephon.kamiwaza_program.blocks.BlockReg;
import top.codephon.kamiwaza_program.effects.EffectReg;
import top.codephon.kamiwaza_program.effects.PotionReg;
import top.codephon.kamiwaza_program.entities.Attri;
import top.codephon.kamiwaza_program.entities.EntityReg;
import top.codephon.kamiwaza_program.fluid.FluidReg;
import top.codephon.kamiwaza_program.items.CreativeTabReg;
import top.codephon.kamiwaza_program.items.ItemReg;
import top.codephon.kamiwaza_program.network.NetworkRegHandler;


//和1.16.5大同小异
//这个是主类 下面的 modid 换成自己的（与mods.toml里的保持一致）
@Mod("kamiwaza_program")
@Mod.EventBusSubscriber(modid = "kamiwaza_program")
public class KamiwazaProgram {
    public static final String MOD_ID = "kamiwaza_program";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public KamiwazaProgram(){
        //Forge注册的总线
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //注册物品
        ItemReg.ITEMS.register(modEventBus);
        //注册创造模式物品栏
        CreativeTabReg.CREATIVE_MODE_TABS.register(modEventBus);
        //注册实体
        EntityReg.ENTITIES.register(modEventBus);
        //注册实体属性
        Attri.ATTRIBUTES.register(modEventBus);
        //注册Common(服务器 客户端)的
        modEventBus.addListener(this::onCommomSetup);
        //注册方块
        BlockReg.BLOCKS.register(modEventBus);
        //注册效果
        EffectReg.EFFECTS.register(modEventBus);
        //注册药水
        PotionReg.POTIONS.register(modEventBus);

        //注册流体
        FluidReg.FLUIDS.register(modEventBus);
        FluidReg.FLUID_TYPES.register(modEventBus);

        //这个是后续必须的 注册事件
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onCommomSetup(FMLCommonSetupEvent event){
        //注册发包
        NetworkRegHandler.registerMessage();

        event.enqueueWork(() -> {
            //生物生成规则
            SpawnPlacements.register(EntityReg.turboMin.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);
        });
    }
}
