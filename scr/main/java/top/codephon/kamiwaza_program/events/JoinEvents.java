package top.codephon.kamiwaza_program.events;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.codephon.kamiwaza_program.KamiwazaProgram;

@Mod.EventBusSubscriber(modid = KamiwazaProgram.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class JoinEvents {
    public static ServerLevel pubServerLevel;
    @SubscribeEvent
    public static void join(EntityJoinLevelEvent event){
        Level level = event.getLevel();
        if(level instanceof ServerLevel){
            pubServerLevel = (ServerLevel) level;
        }
    }
}
