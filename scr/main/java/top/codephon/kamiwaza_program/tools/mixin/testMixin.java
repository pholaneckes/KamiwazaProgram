package top.codephon.kamiwaza_program.tools.mixin;

import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

/*
@Mixin(Recipe.class)
public interface testMixin<C extends Container> {
    /**
     * @author pholaneckes
     * @reason libs

    @Overwrite
    default NonNullList<ItemStack> getRemainingItems (C p_44004_) {
        NonNullList<ItemStack> nonnulllist = NonNullList.withSize(p_44004_.getContainerSize(), ItemStack.EMPTY);
        for(int i = 0; i < nonnulllist.size(); ++i) {
            ItemStack ist = p_44004_.getItem(i);
            ItemStack item = new ItemStack(ist.getItem(),1);
            if (ist.getTag() != null && ist.hasTag() && ist.getTag().getInt("crafted_left_times") > 0 && ist.getCount() == 1) {
                item.setTag(ist.getTag());
                item.getTag().putInt("crafted_left_times", item.getTag().getInt("crafted_left_times") - 1);
            }else {
                item = ist.getCraftingRemainingItem();
            }
            if (ist.hasCraftingRemainingItem()) {
                nonnulllist.set(i, item);
            }
        }
        return nonnulllist;
    }
}
*/

