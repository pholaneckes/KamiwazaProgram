package top.codephon.kamiwaza_program.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.codephon.kamiwaza_program.KamiwazaProgram;

public class ItemReg {
    //与1.16.5没有区别 用于注册物品 最后的MOD_ID改成自己的
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KamiwazaProgram.MOD_ID);

    //格式（其一）是：public static final RegistryObject<Item> 物品字段名称 = ITEMS.register("物品注册名", 物品所在类::new);
    public static final RegistryObject<Item> kamiwazaShot = ITEMS.register("kamiwaza_shot", KamiwazaShot::new);

    public static final RegistryObject<Item> kamiwazaFlash = ITEMS.register("kamiwaza_flash", KamiwazaFlash::new);

    public static final RegistryObject<Item> turboCard = ITEMS.register("turbo_card", KamiwazaCard::new);
}
