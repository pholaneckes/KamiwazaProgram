package top.codephon.kamiwaza_program.entities.mins.temp;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import top.codephon.kamiwaza_program.entities.mins.FactPromin;

public class Metmin extends FactPromin {
public Metmin(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, true, false);
}
}