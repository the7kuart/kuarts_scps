package me.kuart.events;

import me.kuart.KuartsSCPs;
import me.kuart.entities.HumanEntity;
import me.kuart.entities.SCP173Entity;
import me.kuart.entities.SCP939Entity;
import me.kuart.init.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = KuartsSCPs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event){
        event.enqueueWork(()->{

        });
    }

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event){

        event.put(EntityInit.SCP173.get(), SCP173Entity.getSCPAttributes().build());
        event.put(EntityInit.HUMAN.get(), HumanEntity.getHumanAttributes().build());
        event.put(EntityInit.SCP939.get(), SCP939Entity.getSCPAttributes().build());
    }
}
