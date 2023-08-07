package top.codephon.kamiwaza_program.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.codephon.kamiwaza_program.KamiwazaProgram;

//效果注册类
public class EffectReg {
    //和其他注册类似 主字段
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,KamiwazaProgram.MOD_ID);
    //格式：public static final RegistryObject<MobEffect> 效果字段名 = EFFECTS（主字段名）.register("效果注册名",
    //             () -> new 效果类(MobEffectCategory.类型, 0x粒子效果颜色RGB值));

    //MobEffectCategory中（的类型） BENEFICIAL是有益的 HARMFUL是有害的 NEUTRAL是中性效果
    public static final RegistryObject<MobEffect> energyRecharge = EFFECTS.register("energy_charge",
            ()-> new EnergyCharge(MobEffectCategory.BENEFICIAL,0xf1984b));
}

//欢迎新朋友加入数码训兽师，本服务器支持手机电脑都可以玩的，萌新需要新手礼包的话可以找Dec领取