package me.kuart.init;

import me.kuart.KuartsSCPs;
import me.kuart.entities.HumanEntity;
import me.kuart.entities.SCP173Entity;
import me.kuart.entities.SCP939Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, KuartsSCPs.MOD_ID);

    public static final RegistryObject<EntityType<SCP173Entity>> SCP173 = ENTITIES.register("scp173",
            ()-> EntityType.Builder.of(SCP173Entity::new, MobCategory.MONSTER).sized(0.9f,3).build(new ResourceLocation(KuartsSCPs.MOD_ID,"scp173").toString()));
    public static final RegistryObject<EntityType<HumanEntity>> HUMAN = ENTITIES.register("human",
            ()-> EntityType.Builder.of(HumanEntity::new, MobCategory.CREATURE).sized(0.6F, 1.8F).build(new ResourceLocation(KuartsSCPs.MOD_ID,"human").toString()));

    public static final RegistryObject<EntityType<SCP939Entity>> SCP939 = ENTITIES.register("scp939",
            ()-> EntityType.Builder.of(SCP939Entity::new, MobCategory.MONSTER).sized(2f,0.9f).build(new ResourceLocation(KuartsSCPs.MOD_ID,"scp939").toString()));

}
