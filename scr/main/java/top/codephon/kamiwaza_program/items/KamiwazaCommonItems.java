package top.codephon.kamiwaza_program.items;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

//普通的物品，什么特殊功能也没有
public class KamiwazaCommonItems extends Item {
    public KamiwazaCommonItems() {
        super(new Properties().craftRemainder(Items.AIR));
    }

    @Override
    public void inventoryTick(ItemStack stack, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {
        super.inventoryTick(stack, p_41405_, p_41406_, p_41407_, p_41408_);
        if(stack.getTag() != null && stack.getTag().getInt("crafted_left_times") < 0){
            stack.shrink(stack.getItem().getMaxStackSize());
        }else {
            stack.setTag(new CompoundTag());
            stack.getTag().putInt("crafted_left_times",2);
        }
    }
}
