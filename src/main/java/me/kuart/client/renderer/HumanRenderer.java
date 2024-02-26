package me.kuart.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import me.kuart.KuartsSCPs;
import me.kuart.client.models.SCP173Model;
import me.kuart.entities.HumanEntity;
import me.kuart.entities.SCP173Entity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.resources.ResourceLocation;

public class HumanRenderer extends MobRenderer<HumanEntity, PlayerModel<HumanEntity>> {
    boolean pUseSlimModel = false;
    private static final ResourceLocation TEXTURE = new ResourceLocation(KuartsSCPs.MOD_ID,"textures/entities/human.png");
    public HumanRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PlayerModel<>(pContext.bakeLayer(ModelLayers.PLAYER),false), 0.5f);
        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel(pContext.bakeLayer(pUseSlimModel ? ModelLayers.PLAYER_SLIM_INNER_ARMOR : ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(pContext.bakeLayer(pUseSlimModel ? ModelLayers.PLAYER_SLIM_OUTER_ARMOR : ModelLayers.PLAYER_OUTER_ARMOR))));
        this.addLayer(new ArrowLayer<>(pContext, this));
        this.addLayer(new CustomHeadLayer<>(this, pContext.getModelSet(), pContext.getItemInHandRenderer()));
        this.addLayer(new ElytraLayer<>(this, pContext.getModelSet()));
        this.addLayer(new SpinAttackEffectLayer<>(this, pContext.getModelSet()));
        this.addLayer(new BeeStingerLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(HumanEntity pEntity) {
        return TEXTURE;
    }

    @Override
    protected void scale(HumanEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {

        pMatrixStack.scale(0.9375F, 0.9375F, 0.9375F);
    }
}
