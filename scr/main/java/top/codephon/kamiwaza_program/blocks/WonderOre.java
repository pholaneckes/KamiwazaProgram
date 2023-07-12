package top.codephon.kamiwaza_program.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

//更多的方块
public class WonderOre extends Block {
    public WonderOre() {
        super(Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().strength(9.3f, 210f));
    }
}
