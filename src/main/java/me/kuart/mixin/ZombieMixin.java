package me.kuart.mixin;

import me.kuart.entities.HumanEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Zombie.class)
public class ZombieMixin {

    private Zombie self(){
        return (Zombie) (Object) this;
    }
    @Inject(method = "addBehaviourGoals()V", at = @At("TAIL"))
    private void regGoals(CallbackInfo ci){

        self().targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(self(), HumanEntity.class, true));
    }
}
