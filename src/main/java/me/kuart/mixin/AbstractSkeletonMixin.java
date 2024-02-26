package me.kuart.mixin;

import me.kuart.entities.HumanEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractSkeleton.class)
public class AbstractSkeletonMixin {
    private AbstractSkeleton self(){
        return (AbstractSkeleton) (Object) this;
    }
    @Inject(method = "registerGoals()V", at = @At(value = "TAIL"))
    private void regGoals(CallbackInfo ci){

        self().targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(self(), HumanEntity.class, true));
    }
}
