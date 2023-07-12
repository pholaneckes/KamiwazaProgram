package top.codephon.kamiwaza_program.entities.mins;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import top.codephon.kamiwaza_program.entities.Attri;

//自己的实体大类
public class MinionEntity extends TamableAnimal implements GeoAnimatable {

    //可飞行
    protected boolean canfly;
    //可攻击
    protected boolean ableToAttack;
    //动作使用必须
    public AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);

    protected MinionEntity(EntityType<? extends TamableAnimal> type, Level worldIn, boolean fly, boolean attackable) {
        super(type, worldIn);
        this.canfly = fly;
        this.ableToAttack = attackable;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob ageable) {
        return null;
    }

    //注册动作的控制
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    //播放什么动作
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> animationState) {
        //if (animationState.isMoving() && playFlyingAnimation && canfly) {
        //    animationState.getController().setAnimation(new AnimationBuilder().addAnimation("flying", ILoopType.EDefaultLoopTypes.LOOP));
        //    return PlayState.CONTINUE;
        //}else

        //.isMoving()是移动中
        if(animationState.isMoving()){
            //animationName: 改成对应json的动作名
            animationState.getController().setAnimation(RawAnimation.begin().then("walking", Animation.LoopType.LOOP));
            //（继续）
            return PlayState.CONTINUE;
        }else {
            //更多的动作 else 处最好是闲置时的动作
            animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
    }

    //获取动作使用的必须
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    //必须 一般这样填就可以了
    @Override
    public double getTick(Object obj) {
        return ((Entity)obj).tickCount;
    }

    //创建实体属性 如移动速度（MOVEMENT_SPEED），攻击伤害（ATTACK_DAMAGE）等，最大生命值（MAX_HEALTH）是必须的
    public static AttributeSupplier.Builder createAttributes() {
                                                                                                                                              //为自己的实体添加实体属性 .add(实体属性类.属性字段名.get())
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.35F).add(Attributes.ATTACK_DAMAGE, 2.5D).add(Attributes.MAX_HEALTH, 100.0F).add(Attri.PROMIN_ENERGY.get());
    }

    //注册目标 addGoal后的第一项数字代表优先级0为最优先，其次是1，2，3，4....
    @Override
    protected void registerGoals() {
        super.registerGoals();
        //坐下 目标
        this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
        //跟随主人 目标
        this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1.6, 6.5F, 2.5F, canfly));
        //闲走 目标
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.25));
        //（允许）攻击目标
        if(ableToAttack) {
            //常规攻击 目标
            this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0, true));
            //攻击打过自己的生物 目标
            this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
            //攻击打过自己主人的目标 目标
            this.targetSelector.addGoal(3, new OwnerHurtByTargetGoal(this));
            //攻击主人打的目标 目标
            this.targetSelector.addGoal(4, new OwnerHurtTargetGoal(this));
        }
    }

    //添加实体标签（NBTtag） 不建议全写在一块，不整洁，这里是为了演示方便
    public static final EntityDataAccessor<String> EMOTION = SynchedEntityData.defineId(MinionEntity.class, EntityDataSerializers.STRING);
    //EntityDataAccessor<>里的可以改成其它的（支持的）数据类型，EntityDataSerializers.要与前面的同步
    public static final EntityDataAccessor<Boolean> ISBUGGED = SynchedEntityData.defineId(MinionEntity.class, EntityDataSerializers.BOOLEAN);
    //要对实体标签设置get与set方法，方便之后获取与更改
    public String getEmotion(){
        return this.getEntityData().get(EMOTION);
    }

    public void setEmotion(String emotion){
        this.getEntityData().set(EMOTION, emotion);
    }

    //Boolean类型get取名一般是 isXXX
    public boolean isBugged(){
        return this.getEntityData().get(ISBUGGED);
    }

    public void beBugged(Boolean bug){
        this.getEntityData().set(ISBUGGED,bug);
    }

    //定义数据与服务器同步

    @Override
    protected void defineSynchedData() {
        this.getEntityData().define(EMOTION,"normal");
        this.getEntityData().define(ISBUGGED,false);
        super.defineSynchedData();
    }


    //这个是生成时，自动默认添加设置的实体标签

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverWorld, DifficultyInstance difficultyInstance, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag tag) {
        this.getEntityData().set(EMOTION,"normal");
        this.getEntityData().set(ISBUGGED,true);
        this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,-1,0,false,true));
        return super.finalizeSpawn(serverWorld, difficultyInstance, spawnType, spawnGroupData, tag);
    }


    //这个用于退出时保存数据
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("min_emo",this.getEmotion());
        tag.putBoolean("min_bugged",this.isBugged());
    }


    //这个用于进入时读取数据
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.getEntityData().set(EMOTION, tag.getString("min_emo"));
        this.getEntityData().set(ISBUGGED, tag.getBoolean("min_bugged"));
    }
}
