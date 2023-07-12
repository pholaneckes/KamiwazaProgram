package top.codephon.kamiwaza_program.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.codephon.kamiwaza_program.KamiwazaProgram;

//方块注册
public class BlockReg {
    //和 物品 实体 实体属性 创造模式物品栏 等 大同小异
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, KamiwazaProgram.MOD_ID);

    //统一格式：public static final RegistryObject<Block> 字段名 = BLOCKS（主字段）.register("方块注册名", 方块所在类::new);
    //#方块字段名是 /setblock 显示的那个
    public static final RegistryObject<Block> wonderOre = BLOCKS.register("wonder_ore", WonderOre::new);

    public static final RegistryObject<Block> wonderBlock = BLOCKS.register("wonder_ingot_block", WonderIngotBlock::new);

}
