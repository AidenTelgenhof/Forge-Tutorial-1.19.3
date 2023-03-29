package net.aiden.tutorialmod.datagen;

import net.aiden.tutorialmod.block.ModBlocks;
import net.aiden.tutorialmod.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 9)
                .requires(ModBlocks.BLACK_OPAL_BLOCK.get())
                .unlockedBy("has_black_opal_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.BLACK_OPAL_BLOCK.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_OPAL_BLOCK.get())
                .define('B', ModItems.BLACK_OPAL.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .unlockedBy("has_black_opal", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.BLACK_OPAL.get()).build()))
                .save(consumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_BLACK_OPAL.get()), RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 1.0f, 200)
                .unlockedBy("has_raw_black_opal", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.RAW_BLACK_OPAL.get()).build()))
                .save(consumer, new ResourceLocation("smelting_black_opal"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.RAW_BLACK_OPAL.get()), RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 1.0f, 100)
                .unlockedBy("has_raw_black_opal", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.RAW_BLACK_OPAL.get()).build()))
                .save(consumer, new ResourceLocation("blasting_black_opal"));
    }
}
