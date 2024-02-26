package me.kuart.entities;


import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;


import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.jetbrains.annotations.Nullable;

public class HumanEntity extends PathfinderMob {
    public HumanEntity(EntityType<? extends HumanEntity> pEntityType, Level pLevel) {

        super(pEntityType, pLevel);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, -1.0F);
    }

    public static AttributeSupplier.Builder getHumanAttributes(){
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 1.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.175D)
                .add(Attributes.FOLLOW_RANGE, 48.0D).add(Attributes.ATTACK_SPEED).add(Attributes.LUCK).add(net.minecraftforge.common.ForgeMod.REACH_DISTANCE.get()).add(Attributes.ATTACK_KNOCKBACK).add(net.minecraftforge.common.ForgeMod.ATTACK_RANGE.get());
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0,new BreathAirGoal(this));
        this.goalSelector.addGoal(1,new FloatGoal(this));
        this.goalSelector.addGoal(2, new OpenDoorGoal(this,true));
        this.goalSelector.addGoal(3,new PanicGoal(this, 1.6D));
        this.goalSelector.addGoal(4,new AvoidEntityGoal<>(this, Monster.class, 16.0F, 1.6D, 1.4D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this,1));
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.PLAYER_HURT;
    }


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.VILLAGER_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PLAYER_DEATH;

    }

    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.PLAYER_SWIM;
    }
}
