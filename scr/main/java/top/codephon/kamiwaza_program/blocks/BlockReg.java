package top.codephon.kamiwaza_program.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.codephon.kamiwaza_program.KamiwazaProgram;
import top.codephon.kamiwaza_program.fluid.FluidReg;

//方块注册
public class BlockReg {
    //和 物品 实体 实体属性 创造模式物品栏 等 大同小异
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, KamiwazaProgram.MOD_ID);

    //统一格式：public static final RegistryObject<Block> 字段名 = BLOCKS（主字段）.register("方块注册名", 方块所在类::new);
    //#方块字段名是 /setblock 显示的那个
    public static final RegistryObject<Block> wonderOre = BLOCKS.register("wonder_ore", WonderOre::new);

    public static final RegistryObject<Block> wonderBlock = BLOCKS.register("wonder_ingot_block", WonderIngotBlock::new);

    //注册流体对应的方块
    //格式：public static RegistryObject<LiquidBlock> 流体方块字段 = BLOCKS（方块主字段）.register("流体方块注册名",
    //     () -> new LiquidBlock(流体注册类.静态流体字段, Block.Properties.of().liquid()
    //           .noCollission().replaceable().noLootTable().strength(101.0F).sound(SoundType.EMPTY)));
    //其中.liquid()（是流体）.noLootTable()（破坏不掉落）.noCollission() （无碰撞）必加
    //   .replaceable()是可在该流体内放置方块  .sound(SoundType.EMPTY)是在流体中（非沉底）无脚步声 .strength(101.0F)一般是100或以上，（方块强度）
    public static RegistryObject<LiquidBlock> vegetOilBlock = BLOCKS.register("veget_oil_block",
            () -> new LiquidBlock(FluidReg.stillVegetOil, Block.Properties.of().liquid()
                    .noCollission().replaceable().noLootTable().strength(101.0F).sound(SoundType.EMPTY)));

}
