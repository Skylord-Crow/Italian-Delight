package net.crow.italiandelight.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.crow.italiandelight.ItalianDelightMain;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.crow.italiandelight.modifiers.BiomeModifiers;

import java.util.Optional;

public class BiomeInit
{
    public static DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, ItalianDelightMain.MODID);

    public static RegistryObject<Codec<BiomeModifiers>> ADD_FEATURES_BY_FILTER = BIOME_MODIFIER_SERIALIZERS.register("add_features_by_filter", () ->
            RecordCodecBuilder.create(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("allowed_biomes").forGetter(BiomeModifiers::allowedBiomes),
                    Biome.LIST_CODEC.optionalFieldOf("denied_biomes").orElse(Optional.empty()).forGetter(BiomeModifiers::deniedBiomes),
                    Codec.FLOAT.optionalFieldOf("min_temperature").orElse(Optional.empty()).forGetter(BiomeModifiers::minimumTemperature),
                    Codec.FLOAT.optionalFieldOf("max_temperature").orElse(Optional.empty()).forGetter(BiomeModifiers::maximumTemperature),
                    PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(BiomeModifiers::features),
                    GenerationStep.Decoration.CODEC.fieldOf("step").forGetter(BiomeModifiers::step)
            ).apply(builder, BiomeModifiers::new)));
}