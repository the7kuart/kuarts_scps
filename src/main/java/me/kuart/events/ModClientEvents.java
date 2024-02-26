package me.kuart.events;

import me.kuart.KuartsSCPs;
import me.kuart.client.models.SCP173Model;
import me.kuart.client.models.SCP939Model;
import me.kuart.client.renderer.HumanRenderer;
import me.kuart.client.renderer.SCP173Renderer;
import me.kuart.client.renderer.SCP939Renderer;
import me.kuart.init.EntityInit;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
@Mod.EventBusSubscriber(modid = KuartsSCPs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        // Some client setup code
        KuartsSCPs.LOGGER.info("HELLO FROM CLIENT SETUP");
        KuartsSCPs.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(EntityInit.SCP173.get(), SCP173Renderer::new);
        event.registerEntityRenderer(EntityInit.HUMAN.get(), HumanRenderer::new);
        event.registerEntityRenderer(EntityInit.SCP939.get(), SCP939Renderer::new);
    }
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(SCP173Model.LAYER_LOCATION,SCP173Model::createBodyLayer);
        event.registerLayerDefinition(SCP939Model.LAYER_LOCATION,SCP939Model::createBodyLayer);

    }
}
