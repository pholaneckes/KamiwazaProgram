package top.codephon.kamiwaza_program.items;

import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.jetbrains.annotations.NotNull;
import top.codephon.kamiwaza_program.screen.gui.MinionWikiScreen;

import static top.codephon.kamiwaza_program.screen.gui.MinionWikiScreen.doSearch;

public class KamiwazaFile extends Item {
    public KamiwazaFile() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        //只在客户端打开GUI（界面），在服务器打开会导致服务器崩溃
        if(level.isClientSide){
            doSearch = false;
            DistExecutor.safeCallWhenOn(Dist.CLIENT,()-> OpenWikiGui::new);
        }
        return super.use(level, player, hand);
    }

    //打开GUI（界面）
    public static class OpenWikiGui{
        public OpenWikiGui(){
            Minecraft.getInstance().setScreen(new MinionWikiScreen());
        }
    }

}
