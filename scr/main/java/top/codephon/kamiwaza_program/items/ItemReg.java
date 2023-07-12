package top.codephon.kamiwaza_program.items;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.codephon.kamiwaza_program.KamiwazaProgram;
import top.codephon.kamiwaza_program.blocks.BlockReg;

public class ItemReg {
    //与1.16.5没有区别 用于注册物品 最后的MOD_ID改成自己的
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KamiwazaProgram.MOD_ID);

    //格式（其一）是：public static final RegistryObject<Item> 物品字段名称 = ITEMS.register("物品注册名", 物品所在类::new);
    public static final RegistryObject<Item> kamiwazaShot = ITEMS.register("kamiwaza_shot", KamiwazaShot::new);

    public static final RegistryObject<Item> kamiwazaFlash = ITEMS.register("kamiwaza_flash", KamiwazaFlash::new);

    //记得注册
    public static final RegistryObject<Item> turboCard = ITEMS.register("turbo_card", KamiwazaCard::new);
    public static final RegistryObject<Item> wonderIngot = ITEMS.register("wonder_ingot", KamiwazaCommonItems::new);

    //方块所对应的物品的注册 必需
    //格式：public static final RegistryObject<Item> 物品字段名 = ITEMS.register("物品注册名",
    //            ()->new BlockItem(方块注册类.方块字段名.get(), new Item.Properties()));
    public static final RegistryObject<Item> wonderOreItem =
            ITEMS.register("wonder_ore",
                    ()->new BlockItem(BlockReg.wonderOre.get(),new Item.Properties()));

    public static final RegistryObject<Item> wonderIngotBlockItem =
            ITEMS.register("wonder_ingot_block",
                    ()->new BlockItem(BlockReg.wonderBlock.get(),new Item.Properties()));

    public static final RegistryObject<Item> wonderShaker = ITEMS.register("kamiwaza_shaker", KamiwazaCommonItems::new);
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
