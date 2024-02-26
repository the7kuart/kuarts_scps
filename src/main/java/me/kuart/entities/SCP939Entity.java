package me.kuart.entities;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class SCP939Entity extends Monster {
    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(SCP939Entity.class, EntityDataSerializers.BOOLEAN);

    public boolean playingAmbientSound = false;
    public final AnimationState talkAnimState = new AnimationState();


    public final AnimationState attackAnimState = new AnimationState();
    private int attackAnimationTimeout = 0;

    public SCP939Entity(EntityType<? extends SCP939Entity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }





    public static AttributeSupplier.Builder getSCPAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.ATTACK_DAMAGE,5).add(Attributes.MOVEMENT_SPEED,0.5D).add(Attributes.MAX_HEALTH,20.0D).add(Attributes.FOLLOW_RANGE,40);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING,false);
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false){
            @Override
            public void stop() {
                ((SCP939Entity)this.mob).setAttacking(false);
                super.stop();

            }

            @Override
            protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
                double d0 = this.getAttackReachSqr(pEnemy);
                if (pDistToEnemySqr <= d0 && this.getTicksUntilNextAttack() <= 0) {
                    ((SCP939Entity)this.mob).setAttacking(true);
                    this.resetAttackCooldown();
                    this.mob.swing(InteractionHand.MAIN_HAND);
                    this.mob.doHurtTarget(pEnemy);
                }
            }
        });
        this.goalSelector.addGoal(3, new MoveThroughVillageGoal(this, 1.0D, true, 4, ()->true));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));





        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3,new NearestAttackableTargetGoal<>(this, HumanEntity.class,false));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(5,new NearestAttackableTargetGoal<>(this, IronGolem.class,false));
        this.targetSelector.addGoal(6,new NearestAttackableTargetGoal<>(this, SnowGolem.class,false));

    }

    public void setAttacking(boolean attacking){
        this.entityData.set(ATTACKING,attacking);
    }
    public boolean isAttacking(){
        return this.entityData.get(ATTACKING);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.VILLAGER_AMBIENT;

    }

    @Override
    public void playAmbientSound() {
        super.playAmbientSound();
        this.playingAmbientSound = true;
    }



    @Override
    public void tick() {

        if(this.playingAmbientSound){
            talkAnimState.startIfStopped(tickCount);
            this.playingAmbientSound = false;
        }else if(talkAnimState.getAccumulatedTime() > 500){
            talkAnimState.stop();
        }

        if(this.isAttacking()){

            attackAnimState.startIfStopped(this.tickCount);
        }

        if(!this.isAttacking()){
            if(attackAnimState.getAccumulatedTime() > 500){
                attackAnimState.stop();
            }

        }
        super.tick();
    }
}
