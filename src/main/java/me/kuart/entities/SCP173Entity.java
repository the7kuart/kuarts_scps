package me.kuart.entities;

import me.kuart.KuartsSCPs;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SCP173Entity extends Monster {
    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    protected boolean isAffectedByFluids() {
        return false;
    }

    @Override
    public boolean isAffectedByPotions() {
        return false;
    }





    public SCP173Entity(EntityType<? extends Monster> pEntityType, Level pLevel) {

        super(pEntityType, pLevel);
    }

    @Override
    public boolean isPersistenceRequired() {
        return true;
    }

    public static AttributeSupplier.Builder getSCPAttributes(){
        return Monster.createMonsterAttributes().add(Attributes.ARMOR_TOUGHNESS,2).add(Attributes.KNOCKBACK_RESISTANCE,10)
                .add(Attributes.ATTACK_DAMAGE,100).add(Attributes.MOVEMENT_SPEED,0.75D).add(Attributes.MAX_HEALTH,2000.0D).add(Attributes.FOLLOW_RANGE,100);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1,new SCP173FreezeWhenLookedAt(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(3, new MoveThroughVillageGoal(this, 1.0D, true, 4, ()->true));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));





        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3,new NearestAttackableTargetGoal<>(this, HumanEntity.class,false));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(5,new NearestAttackableTargetGoal<>(this, IronGolem.class,false));
        this.targetSelector.addGoal(6,new NearestAttackableTargetGoal<>(this, SnowGolem.class,false));

    }

    static class SCP173FreezeWhenLookedAt extends Goal {
        private final SCP173Entity scp173;
        @Nullable
        private LivingEntity target;

        public SCP173FreezeWhenLookedAt(SCP173Entity scp173) {
            this.scp173 = scp173;
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            double d0 = this.scp173.getAttributeValue(Attributes.FOLLOW_RANGE);
            AABB aabb = AABB.unitCubeFromLowerCorner(this.scp173.position()).inflate(d0, 10.0D, d0);
            List<? extends LivingEntity> list = Stream.concat(this.scp173.level.getEntitiesOfClass(PathfinderMob.class, aabb, EntitySelector.NO_SPECTATORS).stream(),this.scp173.level.getEntitiesOfClass(Player.class, aabb, EntitySelector.NO_SPECTATORS).stream()).collect(Collectors.toList());


            Iterator iterator = list.iterator();

            LivingEntity mob;
            while(true) {
                if (!iterator.hasNext()) {
                    return false;
                }

                mob = (LivingEntity)iterator.next();
                if(!(mob instanceof SCP173Entity))
                if(this.scp173.isLookingAtMe(mob)){

                    return true;
                }
            }






        }



        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void start() {
            this.scp173.getNavigation().stop();


        }







        /**
         * Keep ticking a continuous task that has already been started
         */



    }

    boolean isLookingAtMe(LivingEntity entity) {


            Vec3 vec3 = entity.getViewVector(1.0F).normalize();
            Vec3 vec31 = new Vec3(this.getX() - entity.getX(), this.getEyeY() - entity.getEyeY(), this.getZ() - entity.getZ());
            double d0 = vec31.length();
            vec31 = vec31.normalize();
            double d1 = vec3.dot(vec31);
            return d1 > 0.085D - 0.025D / d0 ? entity.hasLineOfSight(this) : false;

    }
}
