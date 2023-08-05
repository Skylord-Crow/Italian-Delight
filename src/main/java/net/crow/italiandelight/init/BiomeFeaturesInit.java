package net.crow.italiandelight.init;

import net.crow.italiandelight.ItalianDelightMain;
import vectorwing.farmersdelight.common.world.configuration.WildCropConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.world.feature.WildCropFeature;
import vectorwing.farmersdelight.common.world.feature.WildRiceFeature;

public class BiomeFeaturesInit {

        public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, ItalianDelightMain.MODID);

        public static final RegistryObject<Feature<WildCropConfiguration>> WILD_CROP = FEATURES.register("wild_crop", () -> new WildCropFeature(WildCropConfiguration.CODEC));

}
