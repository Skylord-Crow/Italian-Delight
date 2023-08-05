package net.crow.italiandelight.world;

import net.crow.italiandelight.ItalianDelightMain;
import net.crow.italiandelight.init.BlockInit;
import net.crow.italiandelight.Configuration;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.crow.italiandelight.init.BiomeFeaturesInit;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.world.WildCropGeneration;
import vectorwing.farmersdelight.common.world.configuration.WildCropConfiguration;

import java.util.List;

public class WildCropGen extends WildCropGeneration {

    public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_GRAPES;
    public static Holder<ConfiguredFeature<WildCropConfiguration, ?>> FEATURE_PATCH_WILD_HERBS;


    public static Holder<PlacedFeature> PATCH_WILD_GRAPES;
    public static Holder<PlacedFeature> PATCH_WILD_HERBS;

    public static void registerWildCropGeneration() {
        FEATURE_PATCH_WILD_GRAPES = register((new ResourceLocation("italian_delight", "patch_wild_herbs")), (Feature)(Feature)BiomeFeaturesInit.WILD_CROP.get(),
                wildCropConfig(BlockInit.WILD_HERBS.get(), Blocks.DEAD_BUSH, BlockPredicate.matchesTag(BLOCK_BELOW, ModTags.TERRAIN)));
        FEATURE_PATCH_WILD_HERBS = register((new ResourceLocation("italian_delight", "patch_wild_grapes")), BiomeFeaturesInit.WILD_CROP.get(),
                wildCropConfig(BlockInit.WILD_GRAPES.get(), Blocks.BAMBOO, BlockPredicate.matchesBlocks(BLOCK_BELOW, List.of(Blocks.GRASS_BLOCK, Blocks.DIRT,
                        Blocks.COARSE_DIRT, Blocks.PODZOL))));

        PATCH_WILD_GRAPES =
                registerPlacement(new ResourceLocation("italian_delight", "patch_wild_grapes"), FEATURE_PATCH_WILD_GRAPES,
                        (RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_GRAPES.get())), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        PATCH_WILD_HERBS =
                registerPlacement(new ResourceLocation("italian_delight", "patch_wild_herbs"), FEATURE_PATCH_WILD_HERBS,
                        (RarityFilter.onAverageOnceEvery(Configuration.CHANCE_WILD_HERBS.get())), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    }

    static Holder<PlacedFeature> registerPlacement(ResourceLocation id, Holder<? extends ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
        return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, id, new PlacedFeature(Holder.hackyErase(feature), List.of(modifiers)));
    }

    protected static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> register(ResourceLocation id, F feature, FC featureConfig) {
        return register((Registry)BuiltinRegistries.CONFIGURED_FEATURE, (ResourceLocation)id, (Object)(new ConfiguredFeature(feature, featureConfig)));
    }

    private static <V extends T, T> Holder<V> register(Registry<T> registry, ResourceLocation id, V value) {
        return (Holder<V>) BuiltinRegistries.register(registry, id, value);
    }
}
