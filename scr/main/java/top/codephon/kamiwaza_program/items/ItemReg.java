package top.codephon.kamiwaza_program.items;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.codephon.kamiwaza_program.KamiwazaProgram;
import top.codephon.kamiwaza_program.blocks.BlockReg;
import top.codephon.kamiwaza_program.fluid.FluidReg;
import top.codephon.kamiwaza_program.items.armor.WandaArmor;

import java.util.EnumMap;
import java.util.function.Supplier;

public class ItemReg {
    //与1.16.5没有区别 用于注册物品 最后的MOD_ID改成自己的
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KamiwazaProgram.MOD_ID);

    //格式（其一）是：public static final RegistryObject<Item> 物品字段名称 = ITEMS.register("物品注册名", 物品所在类::new);
    public static final RegistryObject<Item> kamiwazaShot = ITEMS.register("kamiwaza_shot", KamiwazaShot::new);

    public static final RegistryObject<Item> kamiwazaFlash = ITEMS.register("kamiwaza_flash", KamiwazaFlash::new);

    //记得注册
    public static final RegistryObject<Item> turboCard = ITEMS.register("turbo_card", KamiwazaCard::new);
    public static final RegistryObject<Item> wonderIngot = ITEMS.register("wonder_ingot", KamiwazaCommonItems::new);


    //注册装流体的桶
    //格式：前面部分同普通物品注册
    //     后面部分： () -> new BucketItem(流体注册类.静态流体字段, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    //其中.craftRemainder(Items.BUCKET)是使用（合成）后返回桶  .stacksTo(1)是不可堆叠
    public static RegistryObject<Item> vegetOilBucket = ItemReg.ITEMS.register("veget_oil_bucket",
            () -> new BucketItem(FluidReg.stillVegetOil, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    //方块所对应的物品的注册 必需
    //格式：public static final RegistryObject<Item> 物品字段名 = ITEMS.register("物品注册名",
    //            ()->new BlockItem(方块注册类.方块字段名.get(), new Item.Properties()));
    public static final RegistryObject<Item> wonderOreItem =
            ITEMS.register("wonder_ore",
                    ()->new BlockItem(BlockReg.wonderOre.get(),new Item.Properties()));

    public static final RegistryObject<Item> wonderIngotBlockItem =
            ITEMS.register("wonder_ingot_block",
                    ()->new BlockItem(BlockReg.wonderBlock.get(),new Item.Properties()));

    //可选
    //自定义装备属性
    //尽量属性不要过于不平衡，可以参考原版的  *方法名仅作参考
    static ArmorMaterial createWandaArmor(int durabi, int def){
        //实现这个 new
        return new ArmorMaterial() {
            //定义装备的耐久
            @Override
            public int getDurabilityForType(ArmorItem.Type type) {
                return durabi;

                //也可以
                //分为 头盔HELMET 胸甲CHESTPLATE 护腿LEGGINGS 和 鞋子BOOTS 四个部位
                //可以照搬这里的 更改 -> 后的数值即可
//                return switch (type) {
//                    case HELMET -> 570;
//                    case CHESTPLATE -> 900;
//                    case LEGGINGS -> 750;
//                    case BOOTS -> 540;
//                };
            }

            //定义装备的护甲值 （生存/冒险模式显示的 护甲值图标数量）
            @Override
            public int getDefenseForType(ArmorItem.Type type) {
                return def;

                //同上 也可以 分为 头盔HELMET 胸甲CHESTPLATE 护腿LEGGINGS 和 鞋子BOOTS 四个部位
//                return switch (type) {
//                    case HELMET, BOOTS -> 4;
//                    case CHESTPLATE -> 7;
//                    case LEGGINGS -> 5;
//                };
            }

            //附魔亲和度
            //数值越高越容易附魔到更好的附魔项 附魔项条数也会更容易更多
            @Override
            public int getEnchantmentValue() {
                return 10;
            }

            //装备装备时所播放的声音（音效）
            @Override
            public SoundEvent getEquipSound() {
                //return SoundEvents.EMPTY; 是不播放声音
                return SoundEvents.ARMOR_EQUIP_LEATHER;
            }

            //定义可以用什么材料来修复这个装备
            //return返回 Ingredient.of(物品（模组的加.get）);
            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(ItemReg.wonderIngot.get());
            }

            //对于Gecko的装备模型 这个什么用也没有
            //返回 "leather" "gold" "netherite" "iron" "diamond"都没有区别 ， 尽量不要返回这几个以外的 会报错FileNotFoundErrors
            @Override
            public String getName() {
                return "leather";
            }

            //盔甲韧性
            //参考 钻石甲0.0f 下届合金甲3.0f
            @Override
            public float getToughness() {
                return 2.0F;
            }

            //盔甲抗击退度 实际显示的是这里的数值×10
            //参考 钻石甲0.0f 下届合金甲0.1f
            @Override
            public float getKnockbackResistance() {
                return 0.05F;
            }
        };
    }

    //注册装备，分为 头盔HELMET 胸甲CHESTPLATE 护腿LEGGINGS 和 鞋子BOOTS 四个部位
    //格式：
    //public static final RegistryObject<装备物品类> 装备字段 = ITEMS.register("注册名",
    //()->new 装备物品类(上面的createXXXArmor(耐久，护甲值) 或放弃自定义延用原版的ArmorMaterials.材质,ArmorItem.Type.部位,new Item.Properties()));
    public static final RegistryObject<WandaArmor> wandaArmorHelmet = ITEMS.register("wanda_armor_helmet",
            () -> new WandaArmor(createWandaArmor(570,4), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<WandaArmor> wandaArmorChestplate = ITEMS.register("wanda_armor_chestplate",
            () -> new WandaArmor(createWandaArmor(900, 7), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<WandaArmor> wandaArmorLeggings = ITEMS.register("wanda_armor_leggings",
            () -> new WandaArmor(createWandaArmor(750,5), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<WandaArmor> wandaArmorBoots = ITEMS.register("wanda_armor_boots",
            () -> new WandaArmor(createWandaArmor(540,4), ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> kamiwazaShaker = ITEMS.register("kamiwaza_shaker", KamiwazaShaker::new);
    public static final RegistryObject<Item> wonderPane = ITEMS.register("wonder_pane", KamiwazaCommonItems::new);
    public static final RegistryObject<Item> kamiwazaFile = ITEMS.register("kamiwaza_file", KamiwazaFile::new);
    public static final RegistryObject<Item> gakkiCard = ITEMS.register("gakki_card", KamiwazaCard::new);
    public static final RegistryObject<Item> eishaCard = ITEMS.register("eisha_card", KamiwazaCard::new);
    public static final RegistryObject<Item> diveCard = ITEMS.register("dive_card", KamiwazaCard::new);
    public static final RegistryObject<Item> micCard = ITEMS.register("mic_card", KamiwazaCard::new);
    public static final RegistryObject<Item> jetCard = ITEMS.register("jet_card", KamiwazaCard::new);
    public static final RegistryObject<Item> tsukkoCard = ITEMS.register("tsukko_card", KamiwazaCard::new);
    public static final RegistryObject<Item> baneCard = ITEMS.register("bane_card", KamiwazaCard::new);
    public static final RegistryObject<Item> dryCard = ITEMS.register("dry_card", KamiwazaCard::new);
    public static final RegistryObject<Item> gymCard = ITEMS.register("gym_card", KamiwazaCard::new);
    public static final RegistryObject<Item> rizumuCard = ITEMS.register("rizumu_card", KamiwazaCard::new);
    public static final RegistryObject<Item> penCard = ITEMS.register("pen_card", KamiwazaCard::new);
    public static final RegistryObject<Item> danceCard = ITEMS.register("dance_card", KamiwazaCard::new);
    public static final RegistryObject<Item> gagCard = ITEMS.register("gag_card", KamiwazaCard::new);
    public static final RegistryObject<Item> tonkCard = ITEMS.register("tonk_card", KamiwazaCard::new);
    public static final RegistryObject<Item> plugCard = ITEMS.register("plug_card", KamiwazaCard::new);
    public static final RegistryObject<Item> boatCard = ITEMS.register("boat_card", KamiwazaCard::new);
    public static final RegistryObject<Item> burgeCard = ITEMS.register("burge_card", KamiwazaCard::new);
    public static final RegistryObject<Item> magneCard = ITEMS.register("magne_card", KamiwazaCard::new);
    public static final RegistryObject<Item> recordCard = ITEMS.register("record_card", KamiwazaCard::new);
    public static final RegistryObject<Item> sumeruCard = ITEMS.register("sumeru_card", KamiwazaCard::new);
    public static final RegistryObject<Item> yumeCard = ITEMS.register("yume_card", KamiwazaCard::new);
    public static final RegistryObject<Item> moteCard = ITEMS.register("mote_card", KamiwazaCard::new);
    public static final RegistryObject<Item> gameCard = ITEMS.register("game_card", KamiwazaCard::new);
    public static final RegistryObject<Item> coroCard = ITEMS.register("coro_card", KamiwazaCard::new);
    public static final RegistryObject<Item> gauzeCard = ITEMS.register("gauze_card", KamiwazaCard::new);
    public static final RegistryObject<Item> denkyuCard = ITEMS.register("denkyu_card", KamiwazaCard::new);
    public static final RegistryObject<Item> zuzuCard = ITEMS.register("zuzu_card", KamiwazaCard::new);
    public static final RegistryObject<Item> senpuuCard = ITEMS.register("senpuu_card", KamiwazaCard::new);
    public static final RegistryObject<Item> shugaCard = ITEMS.register("shuga_card", KamiwazaCard::new);
    public static final RegistryObject<Item> showaCard = ITEMS.register("showa_card", KamiwazaCard::new);
    public static final RegistryObject<Item> rappuCard = ITEMS.register("rappu_card", KamiwazaCard::new);
    public static final RegistryObject<Item> slowCard = ITEMS.register("slow_card", KamiwazaCard::new);
    public static final RegistryObject<Item> makuraCard = ITEMS.register("makura_card", KamiwazaCard::new);
    public static final RegistryObject<Item> fatCard = ITEMS.register("fat_card", KamiwazaCard::new);
    public static final RegistryObject<Item> temoCard = ITEMS.register("temo_card", KamiwazaCard::new);
    public static final RegistryObject<Item> softCard = ITEMS.register("soft_card", KamiwazaCard::new);
    public static final RegistryObject<Item> jishoCard = ITEMS.register("jisho_card", KamiwazaCard::new);
    public static final RegistryObject<Item> kagiCard = ITEMS.register("kagi_card", KamiwazaCard::new);
    public static final RegistryObject<Item> jaguchiCard = ITEMS.register("jaguchi_card", KamiwazaCard::new);
    public static final RegistryObject<Item> shariCard = ITEMS.register("shari_card", KamiwazaCard::new);
    public static final RegistryObject<Item> mapCard = ITEMS.register("map_card", KamiwazaCard::new);
    public static final RegistryObject<Item> brushCard = ITEMS.register("brush_card", KamiwazaCard::new);
    public static final RegistryObject<Item> meganeCard = ITEMS.register("megane_card", KamiwazaCard::new);
    public static final RegistryObject<Item> cafeCard = ITEMS.register("cafe_card", KamiwazaCard::new);
    public static final RegistryObject<Item> speechCard = ITEMS.register("speech_card", KamiwazaCard::new);
    public static final RegistryObject<Item> memoryCard = ITEMS.register("memory_card", KamiwazaCard::new);
    public static final RegistryObject<Item> clipCard = ITEMS.register("clip_card", KamiwazaCard::new);
    public static final RegistryObject<Item> copyCard = ITEMS.register("copy_card", KamiwazaCard::new);
    public static final RegistryObject<Item> mejaCard = ITEMS.register("meja_card", KamiwazaCard::new);
    public static final RegistryObject<Item> origaCard = ITEMS.register("origa_card", KamiwazaCard::new);
    public static final RegistryObject<Item> yajiroCard = ITEMS.register("yajiro_card", KamiwazaCard::new);
    public static final RegistryObject<Item> chakkaCard = ITEMS.register("chakka_card", KamiwazaCard::new);
    public static final RegistryObject<Item> hasaCard = ITEMS.register("hasa_card", KamiwazaCard::new);
    public static final RegistryObject<Item> liftCard = ITEMS.register("lift_card", KamiwazaCard::new);
    public static final RegistryObject<Item> keshigoCard = ITEMS.register("keshigo_card", KamiwazaCard::new);
    public static final RegistryObject<Item> spicesCard = ITEMS.register("spices_card", KamiwazaCard::new);
    public static final RegistryObject<Item> artCard = ITEMS.register("art_card", KamiwazaCard::new);
    public static final RegistryObject<Item> tenguCard = ITEMS.register("tengu_card", KamiwazaCard::new);
    public static final RegistryObject<Item> menteCard = ITEMS.register("mente_card", KamiwazaCard::new);
    public static final RegistryObject<Item> bellCard = ITEMS.register("bell_card", KamiwazaCard::new);
    public static final RegistryObject<Item> katasuCard = ITEMS.register("katasu_card", KamiwazaCard::new);
    public static final RegistryObject<Item> clockCard = ITEMS.register("clock_card", KamiwazaCard::new);
    public static final RegistryObject<Item> smallCard = ITEMS.register("small_card", KamiwazaCard::new);
    public static final RegistryObject<Item> tafuCard = ITEMS.register("tafu_card", KamiwazaCard::new);
    public static final RegistryObject<Item> freezeCard = ITEMS.register("freeze_card", KamiwazaCard::new);
    public static final RegistryObject<Item> railCard = ITEMS.register("rail_card", KamiwazaCard::new);
    public static final RegistryObject<Item> doriruCard = ITEMS.register("doriru_card", KamiwazaCard::new);
    public static final RegistryObject<Item> sukeCard = ITEMS.register("suke_card", KamiwazaCard::new);
    public static final RegistryObject<Item> hanshaCard = ITEMS.register("hansha_card", KamiwazaCard::new);
    public static final RegistryObject<Item> stopCard = ITEMS.register("stop_card", KamiwazaCard::new);
    public static final RegistryObject<Item> kyatchiCard = ITEMS.register("kyatchi_card", KamiwazaCard::new);
    public static final RegistryObject<Item> muteCard = ITEMS.register("mute_card", KamiwazaCard::new);
    public static final RegistryObject<Item> fukuCard = ITEMS.register("fuku_card", KamiwazaCard::new);
    public static final RegistryObject<Item> heartCard = ITEMS.register("heart_card", KamiwazaCard::new);
    public static final RegistryObject<Item> bigCard = ITEMS.register("big_card", KamiwazaCard::new);
    public static final RegistryObject<Item> deodoCard = ITEMS.register("deodo_card", KamiwazaCard::new);
}
