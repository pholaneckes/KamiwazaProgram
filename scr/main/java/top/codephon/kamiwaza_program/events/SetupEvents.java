package top.codephon.kamiwaza_program.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.codephon.kamiwaza_program.entities.EntityReg;
import top.codephon.kamiwaza_program.entities.mins.Turbomin;

//注册创建实体属性
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SetupEvents {
    @SubscribeEvent
    public static void setupMCAttributes(EntityAttributeCreationEvent event) {
        //格式：event.put(实体注册类.实体字段名.get(), 实体所在类.createAttributes().build());
        event.put(EntityReg.turboMin.get(), Turbomin.createAttributes().build());
    }
}
