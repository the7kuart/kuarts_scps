package me.kuart.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import me.kuart.KuartsSCPs;
import me.kuart.client.anims.SCP939Animation;
import me.kuart.entities.SCP939Entity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SCP939Model extends HierarchicalModel<SCP939Entity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(KuartsSCPs.MOD_ID, "scp939"), "main");
    private final ModelPart body;
    protected final ModelPart rightHindLeg;
    protected final ModelPart leftHindLeg;
    protected final ModelPart rightFrontLeg;
    protected final ModelPart leftFrontLeg;

    public SCP939Model(ModelPart root) {
        this.body = root.getChild("body");
        this.rightHindLeg = root().getChild("rightbackleg");
        this.leftHindLeg = root().getChild("leftbackleg");
        this.rightFrontLeg = root().getChild("rightfrontleg");
        this.leftFrontLeg = root().getChild("leftfrontleg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(48, 0).addBox(-6.0F, -22.0F, -21.0F, 12.0F, 9.0F, 6.0F, new CubeDeformation(0.5F))
                .texOffs(36, 62).addBox(-5.0F, -21.0F, -15.0F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition tailent_r1 = body.addOrReplaceChild("tailent_r1", CubeListBuilder.create().texOffs(0, 48).addBox(-7.0F, -23.0F, 23.0F, 14.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition back_r1 = body.addOrReplaceChild("back_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -23.0F, 4.0F, 14.0F, 8.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition front_r1 = body.addOrReplaceChild("front_r1", CubeListBuilder.create().texOffs(0, 28).addBox(-7.0F, -23.0F, -4.0F, 14.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(72, 29).addBox(-5.0F, -22.0F, -9.0F, 10.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -6.0F));

        PartDefinition headtop = head.addOrReplaceChild("headtop", CubeListBuilder.create().texOffs(0, 62).addBox(-5.0F, -22.0F, -23.0F, 10.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(36, 36).addBox(-6.0F, -20.7F, -25.5F, 12.0F, 4.0F, 12.0F, new CubeDeformation(-0.4F))
                .texOffs(-3, 97).addBox(5.0F, -17.7F, -24.5F, 0.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(-3, 97).mirror().addBox(-5.0F, -17.7F, -24.5F, 0.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(72, 41).addBox(-6.0F, -19.0F, -20.0F, 12.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head2_r1 = headtop.addOrReplaceChild("head2_r1", CubeListBuilder.create().texOffs(0, 72).addBox(-6.0F, -26.5F, 0.0F, 12.0F, 3.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition headtslope_r1 = headtop.addOrReplaceChild("headtslope_r1", CubeListBuilder.create().texOffs(78, 0).addBox(-5.0F, 0.5F, -31.8F, 10.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition headbottom = head.addOrReplaceChild("headbottom", CubeListBuilder.create().texOffs(-2, 97).addBox(-4.8F, -1.9239F, -9.6173F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(-2, 97).mirror().addBox(4.8F, -1.9239F, -9.6173F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(59, 19).addBox(-5.0F, 0.0F, -10.0F, 10.0F, 1.0F, 9.0F, new CubeDeformation(0.2F))
                .texOffs(38, 29).addBox(-6.0F, -0.5F, -6.0F, 12.0F, 2.0F, 5.0F, new CubeDeformation(-0.3F))
                .texOffs(42, 52).addBox(-5.0F, 0.8F, -10.0F, 10.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -14.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition rightbackleg = body.addOrReplaceChild("rightbackleg", CubeListBuilder.create().texOffs(16, 80).addBox(0.0F, 12.0F, -1.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.8F))
                .texOffs(71, 53).addBox(-1.0F, 15.0F, -5.0F, 6.0F, 3.0F, 9.0F, new CubeDeformation(-0.8F))
                .texOffs(11, 90).addBox(0.4F, 15.0F, -8.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(-11.0F, -17.0F, 28.0F, 0.0F, 0.3054F, 0.0F));

        PartDefinition cube_r1 = rightbackleg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(97, 26).addBox(1.0F, 2.5F, -5.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(-2.0F, 12.0F, -6.0F, 0.1329F, 0.173F, 0.023F));

        PartDefinition cube_r2 = rightbackleg.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(97, 90).addBox(1.0F, 2.0F, -3.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(-2.0F, 13.0F, -5.0F, -0.1329F, 0.173F, -0.023F));

        PartDefinition cube_r3 = rightbackleg.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(50, 87).addBox(1.0F, 2.0F, -2.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(-2.0F, 13.0F, -5.0F, 0.0F, 0.1745F, 0.0F));

        PartDefinition cube_r4 = rightbackleg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(88, 18).addBox(1.4F, 3.0F, -2.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(-1.0F, 12.0F, -11.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r5 = rightbackleg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(90, 5).addBox(1.4F, 2.8F, -2.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(-1.0F, 12.0F, -7.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r6 = rightbackleg.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(97, 97).addBox(1.0F, 1.2F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(1.0F, 14.0F, -10.0F, 0.176F, -0.1289F, -0.0229F));

        PartDefinition cube_r7 = rightbackleg.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(10, 98).addBox(1.0F, 2.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(1.0F, 13.0F, -7.0F, -0.22F, -0.1278F, 0.0285F));

        PartDefinition cube_r8 = rightbackleg.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(61, 90).addBox(1.0F, 2.0F, -2.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(1.0F, 13.0F, -6.0F, 0.0F, -0.1309F, 0.0F));

        PartDefinition cube_r9 = rightbackleg.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 80).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(1.0F, 7.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r10 = rightbackleg.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(74, 77).addBox(-1.0F, -3.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, -0.0003F, -0.2178F, 0.0077F));

        PartDefinition leftbackleg = body.addOrReplaceChild("leftbackleg", CubeListBuilder.create().texOffs(16, 80).mirror().addBox(-4.0F, 12.0F, -1.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.8F)).mirror(false)
                .texOffs(71, 53).mirror().addBox(-5.0F, 15.0F, -5.0F, 6.0F, 3.0F, 9.0F, new CubeDeformation(-0.8F)).mirror(false)
                .texOffs(11, 90).mirror().addBox(-3.4F, 15.0F, -8.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(11.0F, -17.0F, 28.0F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r11 = leftbackleg.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(74, 77).mirror().addBox(-3.0F, -3.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -0.0003F, 0.2178F, -0.0077F));

        PartDefinition cube_r12 = leftbackleg.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(97, 97).mirror().addBox(-4.0F, 1.2F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 14.0F, -10.0F, 0.176F, 0.1289F, 0.0229F));

        PartDefinition cube_r13 = leftbackleg.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(61, 90).mirror().addBox(-4.0F, 2.0F, -2.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, -6.0F, 0.0F, 0.1309F, 0.0F));

        PartDefinition cube_r14 = leftbackleg.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(10, 98).mirror().addBox(-4.0F, 2.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 13.0F, -7.0F, -0.22F, 0.1278F, -0.0285F));

        PartDefinition cube_r15 = leftbackleg.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(90, 5).mirror().addBox(-4.4F, 2.8F, -2.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(1.0F, 12.0F, -7.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r16 = leftbackleg.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(88, 18).mirror().addBox(-4.4F, 3.0F, -2.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(1.0F, 12.0F, -11.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r17 = leftbackleg.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(97, 26).mirror().addBox(-4.0F, 2.5F, -5.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(2.0F, 12.0F, -6.0F, 0.1329F, -0.173F, -0.023F));

        PartDefinition cube_r18 = leftbackleg.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(97, 90).mirror().addBox(-4.0F, 2.0F, -3.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(2.0F, 13.0F, -5.0F, -0.1329F, -0.173F, 0.023F));

        PartDefinition cube_r19 = leftbackleg.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(50, 87).mirror().addBox(-4.0F, 2.0F, -2.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(2.0F, 13.0F, -5.0F, 0.0F, -0.1745F, 0.0F));

        PartDefinition cube_r20 = leftbackleg.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 80).mirror().addBox(-3.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.5F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 7.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition rightfrontleg = body.addOrReplaceChild("rightfrontleg", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.0F, -19.0F, -1.0F, 0.1855F, 0.3435F, 0.0631F));

        PartDefinition cube_r21 = rightfrontleg.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(46, 95).addBox(-2.1104F, -3.0971F, -11.2355F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(1.8589F, 16.4383F, -14.7611F, -0.0415F, 0.177F, -0.0382F));

        PartDefinition cube_r22 = rightfrontleg.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(73, 94).addBox(-2.0868F, -1.0959F, -9.3693F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(1.8589F, 16.4383F, -14.7611F, -0.3072F, 0.1691F, -0.0836F));

        PartDefinition cube_r23 = rightfrontleg.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(80, 65).addBox(-2.1655F, -1.8182F, -7.923F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(1.8589F, 16.4383F, -14.7611F, -0.1745F, 0.1745F, -0.0612F));

        PartDefinition cube_r24 = rightfrontleg.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(85, 86).addBox(-1.746F, -4.1461F, -11.973F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(1.3589F, 16.4383F, -14.7611F, 0.0388F, -0.1694F, -0.0019F));

        PartDefinition cube_r25 = rightfrontleg.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(86, 73).addBox(-1.746F, 0.0311F, -10.2822F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(1.3589F, 16.4383F, -14.7611F, -0.4411F, -0.1694F, -0.0019F));

        PartDefinition cube_r26 = rightfrontleg.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(79, 10).addBox(-1.746F, -1.8182F, -8.2833F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F))
                .texOffs(59, 65).addBox(-3.146F, -1.8182F, -5.2833F, 6.0F, 3.0F, 9.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(1.3589F, 16.4383F, -14.7611F, -0.1793F, -0.1694F, -0.0019F));

        PartDefinition cube_r27 = rightfrontleg.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 94).addBox(-1.2885F, -1.5166F, -4.0504F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(4.3589F, 15.4383F, -14.7611F, -0.1959F, -0.8005F, 0.1813F));

        PartDefinition cube_r28 = rightfrontleg.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(96, 65).addBox(-0.9563F, -1.8182F, -7.08F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(-0.6411F, 17.4383F, -10.7611F, -0.2753F, -0.8091F, 0.159F));

        PartDefinition cube_r29 = rightfrontleg.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(23, 94).addBox(-0.9589F, -0.6383F, -8.7196F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(-0.6411F, 17.4383F, -10.7611F, -0.5188F, -0.7981F, 0.1968F));

        PartDefinition cube_r30 = rightfrontleg.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(87, 94).addBox(-0.9589F, -3.361F, -11.4057F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(1.3589F, 16.4383F, -14.7611F, -0.0148F, -0.4291F, 0.0237F));

        PartDefinition cube_r31 = rightfrontleg.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(96, 81).addBox(-0.9589F, -0.1513F, -9.7196F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(1.3589F, 16.4383F, -14.7611F, -0.4267F, -0.418F, 0.0782F));

        PartDefinition cube_r32 = rightfrontleg.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(92, 48).addBox(-0.9563F, -1.8182F, -8.08F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(1.3589F, 16.4383F, -14.7611F, -0.1982F, -0.4267F, 0.0486F));

        PartDefinition cube_r33 = rightfrontleg.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(50, 77).addBox(-3.146F, -2.8182F, -2.2833F, 6.0F, 4.0F, 6.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(1.3589F, 16.4383F, -14.7611F, 0.1534F, -0.1791F, 0.0604F));

        PartDefinition cube_r34 = rightfrontleg.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(34, 74).addBox(-1.6424F, 1.9963F, 3.1437F, 4.0F, 19.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-3.0F, 1.0F, 1.0F, -0.9994F, -0.2572F, -0.0216F));

        PartDefinition cube_r35 = rightfrontleg.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.0F, 1.0F, -0.0003F, -0.2178F, 0.0077F));

        PartDefinition leftfrontleg = body.addOrReplaceChild("leftfrontleg", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0F, -19.0F, -1.0F, 0.1855F, -0.3435F, -0.0631F));

        PartDefinition cube_r36 = leftfrontleg.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(46, 95).mirror().addBox(-0.8896F, -3.0971F, -11.2355F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(-1.8589F, 16.4383F, -14.7611F, -0.0415F, -0.177F, 0.0382F));

        PartDefinition cube_r37 = leftfrontleg.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(73, 94).mirror().addBox(-0.9132F, -1.0959F, -9.3693F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(-1.8589F, 16.4383F, -14.7611F, -0.3072F, -0.1691F, 0.0836F));

        PartDefinition cube_r38 = leftfrontleg.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(80, 65).mirror().addBox(-0.8345F, -1.8182F, -7.923F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(-1.8589F, 16.4383F, -14.7611F, -0.1745F, -0.1745F, 0.0612F));

        PartDefinition cube_r39 = leftfrontleg.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(79, 10).mirror().addBox(-1.254F, -1.8182F, -8.2833F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)).mirror(false)
                .texOffs(59, 65).mirror().addBox(-2.854F, -1.8182F, -5.2833F, 6.0F, 3.0F, 9.0F, new CubeDeformation(-0.8F)).mirror(false), PartPose.offsetAndRotation(-1.3589F, 16.4383F, -14.7611F, -0.1793F, 0.1694F, 0.0019F));

        PartDefinition cube_r40 = leftfrontleg.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(86, 73).mirror().addBox(-1.254F, 0.0311F, -10.2822F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(-1.3589F, 16.4383F, -14.7611F, -0.4411F, 0.1694F, 0.0019F));

        PartDefinition cube_r41 = leftfrontleg.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(85, 86).mirror().addBox(-1.254F, -4.1461F, -11.973F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(-1.3589F, 16.4383F, -14.7611F, 0.0388F, 0.1694F, 0.0019F));

        PartDefinition cube_r42 = leftfrontleg.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(92, 48).mirror().addBox(-2.0437F, -1.8182F, -8.08F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(-1.3589F, 16.4383F, -14.7611F, -0.1982F, 0.4267F, -0.0486F));

        PartDefinition cube_r43 = leftfrontleg.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(96, 81).mirror().addBox(-2.0411F, -0.1513F, -9.7196F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(-1.3589F, 16.4383F, -14.7611F, -0.4267F, 0.418F, -0.0782F));

        PartDefinition cube_r44 = leftfrontleg.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(87, 94).mirror().addBox(-2.0411F, -3.361F, -11.4057F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(-1.3589F, 16.4383F, -14.7611F, -0.0148F, 0.4291F, -0.0237F));

        PartDefinition cube_r45 = leftfrontleg.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 94).mirror().addBox(-1.7115F, -1.5166F, -4.0504F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(-4.3589F, 15.4383F, -14.7611F, -0.1959F, 0.8005F, -0.1813F));

        PartDefinition cube_r46 = leftfrontleg.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(96, 65).mirror().addBox(-2.0437F, -1.8182F, -7.08F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(0.6411F, 17.4383F, -10.7611F, -0.2753F, 0.8091F, -0.159F));

        PartDefinition cube_r47 = leftfrontleg.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(23, 94).mirror().addBox(-2.0411F, -0.6383F, -8.7196F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.9F)).mirror(false), PartPose.offsetAndRotation(0.6411F, 17.4383F, -10.7611F, -0.5188F, 0.7981F, -0.1968F));

        PartDefinition cube_r48 = leftfrontleg.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(50, 77).mirror().addBox(-2.854F, -2.8182F, -2.2833F, 6.0F, 4.0F, 6.0F, new CubeDeformation(-1.2F)).mirror(false), PartPose.offsetAndRotation(-1.3589F, 16.4383F, -14.7611F, 0.1534F, 0.1791F, -0.0604F));

        PartDefinition cube_r49 = leftfrontleg.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(34, 74).mirror().addBox(-2.3576F, 1.9963F, 3.1437F, 4.0F, 19.0F, 4.0F, new CubeDeformation(-0.5F)).mirror(false), PartPose.offsetAndRotation(3.0F, 1.0F, 1.0F, -0.9994F, 0.2572F, 0.0216F));

        PartDefinition cube_r50 = leftfrontleg.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -3.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 1.0F, 1.0F, -0.0003F, 0.2178F, -0.0077F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }


    @Override
    public void setupAnim(SCP939Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        root().getAllParts().forEach(ModelPart::resetPose);
        this.rightHindLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.35F * limbSwingAmount;
        this.leftHindLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.35F * limbSwingAmount;
        this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.35F * limbSwingAmount;
        this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.35F * limbSwingAmount;

        this.animate(entity.talkAnimState,SCP939Animation.talk,ageInTicks,1);
        this.animate(entity.attackAnimState,SCP939Animation.bite,ageInTicks,1.5F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return this.body;
    }


}
