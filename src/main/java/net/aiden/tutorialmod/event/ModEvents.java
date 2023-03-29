package net.aiden.tutorialmod.event;

import net.aiden.tutorialmod.TutorialMod;
import net.aiden.tutorialmod.entity.ModEntities;
import net.aiden.tutorialmod.entity.custom.OrangeManEntity;
import net.aiden.tutorialmod.entity.custom.TigerEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TIGER.get(), TigerEntity.setAttributes());
        event.put(ModEntities.ORANGE_MAN.get(), OrangeManEntity.setAttributes());
    }
}
