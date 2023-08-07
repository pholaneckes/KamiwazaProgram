package top.codephon.kamiwaza_program.items;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

//示例用的物品
public class KamiwazaShaker extends Item {
    public KamiwazaShaker() {
        super(new Properties().stacksTo(1));
    }

    //作用：当玩家潜行持该物品右击的时候切换 "close"标签的值 为 1 或 0；
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(player.isShiftKeyDown()){
            CompoundTag tag = player.getItemInHand(hand).getTag();
            tag.putFloat("close", tag.getFloat("close") == 1 ? 0 : 1);
        }
        return super.use(level, player, hand);
    }

    //作用：添加 "close"标签
    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean b) {
        if(!itemStack.hasTag()){
            itemStack.setTag(new CompoundTag());
        }
        if(itemStack.getTag().isEmpty()){
            itemStack.getTag().putFloat("close", 0);
        }
        super.inventoryTick(itemStack, level, entity, i, b);
    }

    public static boolean isOpen(ItemStack stack){
        return stack.getTag().getFloat("close") == 0;
    }
}
