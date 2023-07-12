package top.codephon.kamiwaza_program.effects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.codephon.kamiwaza_program.KamiwazaProgram;

//药水注册类
public class PotionReg {
    //药水注册 包括 药水 滞留药水 喷溅药水 药水箭
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS,KamiwazaProgram.MOD_ID);
    //注册单种药水
    //格式：public static final RegistryObject<Potion> 药水字段名 = POTIONS.register("药水注册名",
    //             ()-> new Potion(new MobEffectInstance(EffectReg（效果注册类）.效果注册名.get(),时长（N游戏刻）,效果等级（默认为0）)));
    public static final RegistryObject<Potion> energyRechargePotion = POTIONS.register("energy_charge",
            ()-> new Potion(new MobEffectInstance(EffectReg.energyRecharge.get(),300,0)));


    //其中 药水和喷溅药水为N游戏刻 滞留药水为4/N游戏刻 药水箭为8/N游戏刻
}
