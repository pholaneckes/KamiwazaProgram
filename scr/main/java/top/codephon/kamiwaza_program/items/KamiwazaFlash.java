package top.codephon.kamiwaza_program.items;

import net.minecraft.world.item.Item;

//继承不要继承错 一定是minecraft下的
public class KamiwazaFlash extends Item {

    public KamiwazaFlash() {
        //.stacksTo(数量)是限制物品堆叠上限 后边也可以跟其他的 如.fireResistant()是不会被火焰烧毁
        super(new Properties().stacksTo(1));
    }

}
