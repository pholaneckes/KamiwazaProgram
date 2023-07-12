package top.codephon.kamiwaza_program.entities.mins;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class FactPromin extends MinionEntity{
    protected FactPromin(EntityType<? extends TamableAnimal> type, Level worldIn, boolean fly, boolean attackable) {
        super(type, worldIn, fly, attackable);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverWorld, DifficultyInstance difficultyInstance, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag tag) {
        this.getEntityData().set(ISBUGGED,false);
        this.removeEffect(MobEffects.INVISIBILITY);
        return super.finalizeSpawn(serverWorld, difficultyInstance, spawnType, spawnGroupData, tag);
    }
}
