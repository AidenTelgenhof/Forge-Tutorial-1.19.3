package net.aiden.tutorialmod.entity;

import net.aiden.tutorialmod.TutorialMod;
import net.aiden.tutorialmod.entity.custom.OrangeManEntity;
import net.aiden.tutorialmod.entity.custom.TigerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<EntityType<TigerEntity>> TIGER =
            ENTITY_TYPES.register("tiger",
                    () -> EntityType.Builder.of(TigerEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(TutorialMod.MOD_ID, "tiger").toString()));

    public static final RegistryObject<EntityType<OrangeManEntity>> ORANGE_MAN =
            ENTITY_TYPES.register("orange_man",
                    () -> EntityType.Builder.of(OrangeManEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.5f)
                            .build(new ResourceLocation(TutorialMod.MOD_ID, "orange_man").toString()));

    public static void register (IEventBus eventBus) {
        ENTITY_TYPES.register((eventBus));
    }
}
