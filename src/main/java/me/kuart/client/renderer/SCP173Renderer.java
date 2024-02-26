package me.kuart.client.renderer;

import me.kuart.KuartsSCPs;
import me.kuart.client.models.SCP173Model;
import me.kuart.entities.SCP173Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SCP173Renderer extends MobRenderer<SCP173Entity,SCP173Model> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(KuartsSCPs.MOD_ID,"textures/entities/scp173.png");
    public SCP173Renderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SCP173Model(pContext.bakeLayer(SCP173Model.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SCP173Entity pEntity) {
        return TEXTURE;
    }
}
