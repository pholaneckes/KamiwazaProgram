package top.codephon.kamiwaza_program.entities.mins.temp;

import top.codephon.kamiwaza_program.entities.mins.MinionEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
public class Denkyumin extends MinionEntity {
public Denkyumin(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, false, false);
}
}