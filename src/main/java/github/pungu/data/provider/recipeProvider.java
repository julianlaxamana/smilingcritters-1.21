package github.pungu.data.provider;

import java.util.concurrent.CompletableFuture;

import github.pungu.init.initialize;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.item.Items;

public class recipeProvider extends FabricRecipeProvider{
   public recipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture){
    super(output, registriesFuture);
   } 
   @Override
   public void generate(RecipeExporter exporter){
    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, initialize.SKIBIDI_WAND, 1).input('E', Items.STICK)
    .input('A', Items.NETHER_STAR)
    .input('B', Items.FIRE_CHARGE).pattern("B").pattern("A").pattern("E")
    .criterion(hasItem(initialize.SKIBIDI_WAND), conditionsFromItem(initialize.SKIBIDI_WAND)).offerTo(exporter);

    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, initialize.WIND_WAND, 1).input('E', Items.STICK)
    .input('A', Items.NETHER_STAR)
    .input('B', Items.WIND_CHARGE).pattern("B").pattern("A").pattern("E")
    .criterion(hasItem(initialize.WIND_WAND), conditionsFromItem(initialize.WIND_WAND)).offerTo(exporter);

    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, initialize.BARON_BUNNY, 1).input('E', Blocks.PUMPKIN).input('Q', Blocks.TNT)
    .input('A', Blocks.IRON_BLOCK)
    .pattern(" E ").pattern("AQA").pattern(" A ")
    .criterion(hasItem(initialize.SKIBIDI_WAND), conditionsFromItem(initialize.SKIBIDI_WAND)).offerTo(exporter);

   }
}
