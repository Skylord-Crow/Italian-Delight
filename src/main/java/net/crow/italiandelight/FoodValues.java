package net.crow.italiandelight;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;

public class FoodValues {

    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes

    // Raw Crops
    public static final FoodProperties GRAPE = ((new FoodProperties.Builder()).nutrition(2).saturationMod(0.1f).build());
    public static final FoodProperties OLIVES = ((new FoodProperties.Builder()).nutrition(2).saturationMod(0.1f).build());
    public static final FoodProperties HERBS = ((new FoodProperties.Builder()).nutrition(1).saturationMod(0.1f).build());
    // Ingredients
    public static final FoodProperties RAW_SALAMI = ((new FoodProperties.Builder()).nutrition(1).saturationMod(0.2f).meat().build());
    public static final FoodProperties SALAMI = ((new FoodProperties.Builder().nutrition(4).saturationMod(0.7f).meat().build()));
    public static final FoodProperties SALAMI_SLICE = ((new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).build()));
    public static final FoodProperties PANETTONE = ((new FoodProperties.Builder().nutrition(4).saturationMod(0.5f).build()));
    public static final FoodProperties PANETONNE_SLICE = ((new FoodProperties.Builder().nutrition(1).saturationMod(0.3f).build()));
    public static final FoodProperties PANDORO_DOUGH = ((new FoodProperties.Builder().nutrition(1).saturationMod(0.1f).build()));
    public static final FoodProperties PANDORO_SLICE = ((new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).build()));
    // Dishes
    public static final FoodProperties BERRY_DELIGHT = ((new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).build()));
    public static final FoodProperties PASTA_AL_TOMATO = ((new FoodProperties.Builder()).nutrition(8).saturationMod(0.3f).build());
    public static final FoodProperties PASTA_AL_PESTO = ((new FoodProperties.Builder()).nutrition(8).saturationMod(0.3f).build());
    public static final FoodProperties RISOTTO_AL_SUGO = ((new FoodProperties.Builder()).nutrition(6).saturationMod(0.8f).build());
    public static final FoodProperties RISOTTO_AL_FUNGHI = ((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6f).build());
    public static final FoodProperties TIRAMISU = ((new FoodProperties.Builder()).nutrition(5).saturationMod(0.5f).build());
    public static final FoodProperties MOZZARELLA_PANINI = ((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3f).build());
    public static final FoodProperties MOZZARELLA_SALAD = ((new FoodProperties.Builder()).nutrition(5).saturationMod(0.3f).build());
    public static final FoodProperties PANDORO = ((new FoodProperties.Builder().nutrition(4).saturationMod(0.5f).build()));
    // Pizza
    public static final FoodProperties PIZZA_PROSCIUTTO_SLICE = ((new FoodProperties.Builder()).nutrition(5).saturationMod(0.6f).build());
    public static final FoodProperties PIZZA_FUNGHI_SLICE = ((new FoodProperties.Builder()).nutrition(3).saturationMod(0.5f).build());
    public static final FoodProperties PIZZA_MARGHERITA_SLICE = ((new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).build()));
    public static final FoodProperties PIZZA_DANTE_SLICE = ((new FoodProperties.Builder().nutrition(6).saturationMod(0.5f).build()));
    public static final FoodProperties PIZZA_DIAVOLA_SLICE = ((new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).build()));
    // Wine
    public static final FoodProperties GLOWBERRY_WINE = ((new FoodProperties.Builder()).nutrition(0).saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1600, 1), 1.0f).alwaysEat().build());
    public static final FoodProperties ROSE_WINE = ((new FoodProperties.Builder()).nutrition(0).saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1000, 1), 1.0f).alwaysEat().build());
    public static final FoodProperties HELLHOUND_WINE = ((new FoodProperties.Builder()).nutrition(0).saturationMod(0.8f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3400, 1), 1.0f).alwaysEat().build());
    public static final FoodProperties DRAGONBORN_WINE = ((new FoodProperties.Builder()).nutrition(0).saturationMod(0.8f).effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 7500, 1), 1.0f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 5200, 2), 1.0f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 7500, 2), 1.0f).alwaysEat().build());
    public static final FoodProperties HASTING_WINE = ((new FoodProperties.Builder()).nutrition(0).saturationMod(0.8f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 1), 1.0f).alwaysEat().build());
    public static final FoodProperties SWEETBERRY_WINE = ((new FoodProperties.Builder()).nutrition(0).saturationMod(0.8f).alwaysEat().build());
    public static final FoodProperties SPUMANTE = ((new FoodProperties.Builder()).nutrition(0).saturationMod(0.7f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 1), 1.0f).alwaysEat().build());

}
