package top.codephon.kamiwaza_program.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import top.codephon.kamiwaza_program.KamiwazaProgram;

import static top.codephon.kamiwaza_program.items.ItemReg.*;

//这个与1.16.5注册的方式不同 创造模式物品栏成为了一个新的注册项
public class CreativeTabReg {
    //与物品注册大同小异 其它注册也是类似 如流体、方块、实体、容器等 后面MODID还是要换成自己的
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KamiwazaProgram.MOD_ID);

    //添加创造模式物品栏 name:填自己（给这一分类）取的名称
    public static final RegistryObject<CreativeModeTab> KWP_GROUP_TAB = CREATIVE_MODE_TABS.register("kwp_group", () -> CreativeModeTab.builder()
            //创建图标 模组物品为：物品字段名+.get() 原版的不用加.get()
            .icon(() -> kamiwazaFlash.get().getDefaultInstance())
            //调整创造模式物品栏名称 否则为空白 在 语言.json文件里 可修改
            .title(Component.translatable("itemGroup.kamiwaza_program.kwp_group"))
            //添加物品进该创造模式物品栏
            //格式：output.accept(物品字段名+.get());
            .displayItems((parameters, output) -> {
                output.accept(kamiwazaFlash.get());
                output.accept(kamiwazaShot.get());
                output.accept(turboCard.get());
                output.accept(wonderIngot.get());
                output.accept(wonderIngotBlockItem.get());
                output.accept(wonderOreItem.get());
            //构建
            }).build());
}
