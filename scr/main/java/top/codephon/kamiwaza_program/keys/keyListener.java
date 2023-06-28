package top.codephon.kamiwaza_program.keys;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import top.codephon.kamiwaza_program.KamiwazaProgram;
import top.codephon.kamiwaza_program.entities.EntityReg;
import top.codephon.kamiwaza_program.entities.mins.MinionEntity;
import top.codephon.kamiwaza_program.items.KamiwazaCard;
import top.codephon.kamiwaza_program.items.KamiwazaShot;
import top.codephon.kamiwaza_program.tools.Ways;

import static top.codephon.kamiwaza_program.entities.render.MinionModel.getMinName;
import static top.codephon.kamiwaza_program.events.JoinEvents.pubServerLevel;
import static top.codephon.kamiwaza_program.keys.MinKeyBending.*;
import static top.codephon.kamiwaza_program.tools.ModTools.getLookPos;
import static top.codephon.kamiwaza_program.tools.ModTools.sendChat;

@Mod.EventBusSubscriber(modid = KamiwazaProgram.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class keyListener {
    @SubscribeEvent
    public static void pressKey(InputEvent.Key event){
        if (Minecraft.getInstance().screen == null) {
            if (event.getKey() == SCAN_CARD.getKey().getValue()) {
                if(event.getAction() == 0){
                    Player player = Minecraft.getInstance().player;
                    if(player != null){
                        ItemStack shot = player.getItemInHand(InteractionHand.MAIN_HAND);
                        ItemStack card = player.getItemInHand(InteractionHand.OFF_HAND);
                        Item mainHand = shot.getItem();
                        Item offHand = card.getItem();
                        if(mainHand instanceof KamiwazaShot && offHand instanceof KamiwazaCard){
                            shot.getTag().putString("ScanName", offHand.builtInRegistryHolder().key().location().getPath().replaceAll("_card","min"));
                        }
                    }
                }
            }
            if (event.getKey() == ALISE_PROMIN.getKey().getValue()) {
                if(event.getAction() == 1){
                    Player player = Minecraft.getInstance().player;
                    if(player != null){
                        Item mainHand = player.getItemInHand(InteractionHand.MAIN_HAND).getItem();
                        Item offHand = player.getItemInHand(InteractionHand.OFF_HAND).getItem();
                        ItemStack shot;
                        if(mainHand instanceof KamiwazaShot){
                            shot = player.getItemInHand(InteractionHand.MAIN_HAND);
                        }else if(offHand instanceof KamiwazaShot){
                            shot = player.getItemInHand(InteractionHand.OFF_HAND);
                        }else {
                            sendChat(player, "kwp.txt.item_unfounded");
                            return;
                        }
                        if(!shot.getTag().getString("ScanName").equals("none")) {
                            EntityType<? extends MinionEntity> min = EntityReg.turboMin.get();
                            MinionEntity minion = min.spawn(pubServerLevel, null, player, getLookPos(player), MobSpawnType.MOB_SUMMONED, false, false);
                            sendChat(player, "kwp.txt.charge");
                            minion.tame(player);
                        }
                    }
                }
            }
        }
    }
}
