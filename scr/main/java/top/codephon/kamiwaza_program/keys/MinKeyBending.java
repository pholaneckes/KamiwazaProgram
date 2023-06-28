package top.codephon.kamiwaza_program.keys;

import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.codephon.kamiwaza_program.KamiwazaProgram;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT, modid = KamiwazaProgram.MOD_ID)
public class MinKeyBending extends KeyMapping {
    public MinKeyBending(String description, int keyCode, String category) {
        super(String.format("key.%s.%s", KamiwazaProgram.MOD_ID, description), keyCode, category);
        KEY_BINDINGS.add(this);
    }

    public static final List<KeyMapping> KEY_BINDINGS = new ArrayList<>();
    public static final KeyMapping SCAN_CARD = new MinKeyBending("scan",  79 , Component.translatable("key.kwp").getString());
    public static final KeyMapping ALISE_PROMIN =new MinKeyBending("alise_promin", 89,Component.translatable("key.kwp").getString());

    @SubscribeEvent
    public static void RegKey(RegisterKeyMappingsEvent event){
        event.register(SCAN_CARD);
        event.register(ALISE_PROMIN);
    }
}
