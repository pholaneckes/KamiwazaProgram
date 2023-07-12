package top.codephon.kamiwaza_program.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

//继承Block
public class WonderIngotBlock extends Block {
    public WonderIngotBlock() {
        //Properties.of() 后为可选内容
        //.mapColor(MapColor.?) 是在地图上显示的样式 .instrument(NoteBlockInstrument.?)是音符盒（放在该方块上面）的音色
        //.requiresCorrectToolForDrops()是要使用特定的工具采集才会掉落 见后面方块tag部分
        //.strength(浮点，浮点) 其中前者是方块的硬度（破坏消耗的时间） 后者是抗爆程度（例如石头是6.0）
        //还有其他的可以继续补充 本次不再演示
        super(Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().strength(11.7f, 730f));
    }
}
