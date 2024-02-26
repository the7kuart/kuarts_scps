package me.kuart.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import me.kuart.KuartsSCPs;
import me.kuart.client.models.SCP173Model;
import me.kuart.client.models.SCP939Model;
import me.kuart.entities.SCP173Entity;
import me.kuart.entities.SCP939Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SCP939Renderer extends MobRenderer<SCP939Entity, SCP939Model> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(KuartsSCPs.MOD_ID,"textures/entities/scp939.png");
    public SCP939Renderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SCP939Model(pContext.bakeLayer(SCP939Model.LAYER_LOCATION)), 0.5f);
    }

    @Override
    protected void scale(SCP939Entity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        pMatrixStack.scale(0.9F, 0.9F, 0.9F);
    }

    @Override
    public ResourceLocation getTextureLocation(SCP939Entity pEntity) {
        return TEXTURE;
    }


}
