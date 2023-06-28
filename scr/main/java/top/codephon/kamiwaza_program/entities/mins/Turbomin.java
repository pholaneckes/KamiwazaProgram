package top.codephon.kamiwaza_program.entities.mins;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

//自己大类中的一类或一种
public class Turbomin extends MinionEntity {
    public Turbomin(EntityType<? extends TamableAnimal> type, Level worldIn) {
        //不可飞行，不可攻击
        super(type, worldIn, false, false);
    }
}
