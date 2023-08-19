package net.crow.italiandelight.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.crow.italiandelight.ItalianDelightMain;
import net.crow.italiandelight.init.BlockInit;
import vectorwing.farmersdelight.common.registry.ModBiomeFeatures;

public class ModConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, ItalianDelightMain.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> OLIVE_TREE =
            CONFIGURED_FEATURES.register("olive_tree",() ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(BlockInit.OLIVE_LOG.get()),
                            new GiantTrunkPlacer(5, 6, 3),
                            BlockStateProvider.simple(BlockInit.OLIVE_LEAVES.get()),
                            new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> WILD_GRAPES =
            CONFIGURED_FEATURES.register("wild_grapes", () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(32,6,2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.WILD_GRAPES.get()))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> WILD_HERBS =
            CONFIGURED_FEATURES.register("wild_herbs", () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(32,6,2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.WILD_HERBS.get()))))));

    public static void register(IEventBus eventBus) {CONFIGURED_FEATURES.register(eventBus);}
}
