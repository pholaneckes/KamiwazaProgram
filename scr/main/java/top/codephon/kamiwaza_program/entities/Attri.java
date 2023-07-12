package top.codephon.kamiwaza_program.entities;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.codephon.kamiwaza_program.KamiwazaProgram;

//实体属性注册类
public class Attri {
    //实体属性的注册 主字段
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.Keys.ATTRIBUTES, KamiwazaProgram.MOD_ID);
    //注册单个实体属性
    //格式：public static final RegistryObject<Attribute> 实体属性字段取名 =
    public static final RegistryObject<Attribute> PROMIN_ENERGY =
            //格式 ATTRIBUTES（主字段）.register("实体属性注册名（Forge的）", ()->
            //new RangedAttribute("实体属性注册名翻译键（原版的）",默认值,最小接受值,最大接受值).setSyncable(是否同步（服务器与客户端），true或false)
            ATTRIBUTES.register("pro_energy",()->
                    new RangedAttribute("kwp.pro_energy",480,-1,512).setSyncable(true));
}
