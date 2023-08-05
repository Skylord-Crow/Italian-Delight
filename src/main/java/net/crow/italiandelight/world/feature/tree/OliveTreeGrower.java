package net.crow.italiandelight.world.feature.tree;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;
import net.crow.italiandelight.world.feature.ModConfiguredFeatures;

public class OliveTreeGrower extends AbstractTreeGrower {


    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_, boolean p_222911_) {
        return ModConfiguredFeatures.OLIVE_TREE.getHolder().get();
    }
}
