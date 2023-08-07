package top.codephon.kamiwaza_program.items;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.codephon.kamiwaza_program.KamiwazaProgram;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ItemProp {
    //注册物品的Property（可以翻译成性质）
    @SubscribeEvent
    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {                        //此次是： 物品笺 世界 持该物品的实体 ？（未知）
        event.enqueueWork(() -> {                                                                   //命名为：
            //格式：ItemProperties.register(物品字段名.get, new ResourceLocation(modid, "Property性质名"), (itemStack, clientWorld, livingEntity, 最后一个未知随便命名之前版本都没有)
            ItemProperties.register(ItemReg.kamiwazaShaker.get(), new ResourceLocation(KamiwazaProgram.MOD_ID, "close"), (itemStack, clientWorld, livingEntity, i) -> {
                //返回的只能是 float类型 返回值是该Property性质的值
                //Property性质 的值 会一直获取

                //示例：获取物品的 "close" 标签 并（返回）赋值给上面定义的 Property性质
                if (itemStack.getTag() != null) {
                    return itemStack.getTag().getFloat("close");
                }
                //必须有个返回值
                return 0;
            });
        });
    }
}