package me.kuart.datagen;

import me.kuart.KuartsSCPs;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.data.event.GatherDataEvent;

@Mod.EventBusSubscriber(modid = KuartsSCPs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KuartsSCPsDatagen {

    @SubscribeEvent
    public static void onDatagen(GatherDataEvent event) {

    }
}
