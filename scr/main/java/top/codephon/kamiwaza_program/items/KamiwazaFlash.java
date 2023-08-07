package top.codephon.kamiwaza_program.items;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import top.codephon.kamiwaza_program.entities.mins.MinionEntity;

import java.util.List;

import static java.util.Comparator.comparing;
import static top.codephon.kamiwaza_program.tools.ModTools.getLookPos;
import static top.codephon.kamiwaza_program.tools.ModTools.sendChat;

//继承不要继承错 一定是minecraft下的
public class KamiwazaFlash extends Item {

    public KamiwazaFlash() {
        //.stacksTo(数量)是限制物品堆叠上限 后边也可以跟其他的 如.fireResistant()是不会被火焰烧毁
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        BlockPos lookPos = getLookPos(player);
        double x = lookPos.getX();
        double y = lookPos.getY();
        double z = lookPos.getZ();
        List<MinionEntity> entityList = level.getEntitiesOfClass(MinionEntity.class,
                new AABB(x - 1, y - 3, z - 1, x + 2, y + 2, z + 2));
        boolean b = entityList.stream().min(comparing(entity -> entity.distanceToSqr(x, y, z))).orElse(null) != null;
        if(level.isClientSide) {
            sendChat(player, Component.translatable("kwp.txt.searching_for_" + b).getString());
        }
        for (MinionEntity minion : entityList) {
            if (minion.isBugged()) {
                minion.removeEffect(MobEffects.INVISIBILITY);
            }
        }
        return super.use(level, player, hand);
    }

    //触发进度trigger的 "using_item"
    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        useOnContext.getPlayer().startUsingItem(useOnContext.getHand());
        return InteractionResult.CONSUME;
    }
    @Override
    public int getUseDuration(@NotNull ItemStack stack) {
        return 15;
    }

}
