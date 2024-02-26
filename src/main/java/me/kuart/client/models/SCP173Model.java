package me.kuart.client.models;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import me.kuart.KuartsSCPs;
import me.kuart.entities.SCP173Entity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class SCP173Model extends EntityModel<SCP173Entity> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(KuartsSCPs.MOD_ID, "scp173"), "main");
    private final ModelPart rightarm;
    private final ModelPart leftarm;
    private final ModelPart bb_main;

    public SCP173Model(ModelPart root) {
        this.rightarm = root.getChild("rightarm");
        this.leftarm = root.getChild("leftarm");
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition rightarm = partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(58, 62).addBox(9.0F, -25.0F, 1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 62).addBox(9.0F, -25.0F, 3.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 13).addBox(8.0F, -29.0F, 3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 13).addBox(8.0F, -29.0F, 1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 14).addBox(7.0F, -30.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(33, 2).addBox(7.0F, -30.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 57).addBox(6.0F, -30.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(33, 0).addBox(6.0F, -31.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 26).addBox(6.0F, -31.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 24).addBox(6.0F, -31.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 19).addBox(6.0F, -31.0F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 9).addBox(6.0F, -32.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(28, 13).addBox(4.0F, -32.0F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(4.0F, -32.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 5.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition leftarm = partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(63, 15).addBox(9.0F, -25.0F, 1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(62, 62).addBox(9.0F, -25.0F, 3.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 24).addBox(8.0F, -29.0F, 3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 0).addBox(8.0F, -29.0F, 1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 38).addBox(7.0F, -30.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(27, 37).addBox(7.0F, -30.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 58).addBox(6.0F, -30.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 39).addBox(6.0F, -31.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 37).addBox(6.0F, -31.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 38).addBox(6.0F, -31.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 37).addBox(6.0F, -31.0F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 59).addBox(6.0F, -32.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(29, 5).addBox(4.0F, -32.0F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 29).addBox(4.0F, -32.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(46, 62).addBox(-1.0F, -7.0F, 5.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-7.0F, -7.0F, -3.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(5.0F, -7.0F, -3.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(57, 0).addBox(-2.0F, -12.0F, 4.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(22, 55).addBox(-7.0F, -12.0F, -4.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(53, 20).addBox(4.0F, -12.0F, -4.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-4.0F, -12.0F, -5.0F, 8.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -16.0F, -4.0F, 10.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 13).addBox(-5.0F, -19.0F, -3.0F, 10.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(29, 0).addBox(-5.0F, -20.0F, -4.0F, 10.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(25, 24).addBox(-5.0F, -21.0F, -5.0F, 10.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(5, 2).addBox(-4.0F, -25.0F, -4.0F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(42, 44).addBox(-4.0F, -26.0F, -3.0F, 8.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 37).addBox(-4.0F, -29.0F, -2.0F, 8.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(31, 9).addBox(-4.0F, -33.0F, -1.0F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(50, 33).addBox(-2.0F, -36.0F, 1.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(43, 52).addBox(-3.0F, -39.0F, -1.0F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(23, 45).addBox(-3.0F, -42.0F, -1.0F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 48).addBox(-3.0F, -45.0F, -1.0F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(36, 20).addBox(-2.0F, -15.0F, 5.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 61).addBox(5.0F, -14.0F, -4.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(61, 8).addBox(-6.0F, -14.0F, -4.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(49, 32).addBox(-4.0F, -44.0F, 0.0F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(49, 32).addBox(3.0F, -44.0F, 0.0F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }



    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void setupAnim(SCP173Entity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }
}