package net.aiden.tutorialmod.entity.client;

import net.aiden.tutorialmod.TutorialMod;
import net.aiden.tutorialmod.entity.custom.OrangeManEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class OrangeManModel extends GeoModel<OrangeManEntity> {
    @Override
    public ResourceLocation getModelResource(OrangeManEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/orange_man.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OrangeManEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/orange_man.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OrangeManEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "animations/orange_man.animation.json");
    }

    @Override
    public void setCustomAnimations(OrangeManEntity animatable, long instanceId, AnimationState<OrangeManEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }

    }
}
