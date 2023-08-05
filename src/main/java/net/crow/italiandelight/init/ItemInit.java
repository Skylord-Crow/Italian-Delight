package net.crow.italiandelight.init;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.crow.italiandelight.FoodValues;
import net.crow.italiandelight.ItalianDelightMain;
import umpaz.brewinandchewin.common.item.BoozeItem;


public class ItemInit {
    @SuppressWarnings("unused")

    // Helpers (Borrowed from Vectorwing)

    public static Item.Properties basicItem() {
        return new Item.Properties().tab(ItalianDelightMain.CREATIVE_TAB);
    }

    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food).tab(ItalianDelightMain.CREATIVE_TAB);
    }

    // General Deferred Declaration
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ItalianDelightMain.MOD_ID);
    // Item Init

    // Crop Drops
    public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes", () -> new Item(foodItem(FoodValues.GRAPE).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> OLIVES = ITEMS.register("olives", () -> new Item(foodItem(FoodValues.OLIVES).tab(ItalianDelightMain.CREATIVE_TAB)));
    //Crop Seeds
    public static final RegistryObject<Item> GRAPE_SEEDS = ITEMS.register("grape_seeds", () -> new ItemNameBlockItem(BlockInit.GRAPE_CROP.get(), basicItem()));
    public static final RegistryObject<Item> HERB_LEAVES = ITEMS.register("herb_leaves", () -> new ItemNameBlockItem(BlockInit.HERB_CROP.get(), foodItem(FoodValues.HERBS)));

    // Wines
    public static final RegistryObject<Item> GLOWBERRY_WINE = ITEMS.register("glowberry_wine", () -> new BoozeItem(1, 4, foodItem(FoodValues.GLOWBERRY_WINE)));
    public static final RegistryObject<Item> ROSE_WINE = ITEMS.register("rose_wine", () -> new BoozeItem(1, 3, foodItem(FoodValues.ROSE_WINE)));
    public static final RegistryObject<Item> HELLHOUND_WINE = ITEMS.register("hellhound_wine", () -> new BoozeItem(2, 5, foodItem(FoodValues.HELLHOUND_WINE).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> DRAGONBORN_WINE = ITEMS.register("dragonborn_wine", () -> new BoozeItem(3, 10, foodItem(FoodValues.DRAGONBORN_WINE)));
    public static final RegistryObject<Item> HASTING_WINE = ITEMS.register("hasting_wine", () -> new BoozeItem(2, 5, foodItem(FoodValues.HASTING_WINE)));
    public static final RegistryObject<Item> SWEETBERRY_WINE = ITEMS.register("sweetberry_wine", () -> new BoozeItem(1, 5, foodItem(FoodValues.SWEETBERRY_WINE)));

    // Dishes
    public static final RegistryObject<Item> BERRY_DELIGHT = ITEMS.register("berry_delight", () -> new Item(foodItem(FoodValues.BERRY_DELIGHT).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> PASTA_AL_TOMATO = ITEMS.register("pasta_al_tomato", () -> new Item(foodItem(FoodValues.PASTA_AL_TOMATO).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> PASTA_AL_PESTO = ITEMS.register("pasta_al_pesto", () -> new Item(foodItem(FoodValues.PASTA_AL_PESTO).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> RISOTTO_AL_SUGO = ITEMS.register("risotto_al_sugo", () -> new Item(foodItem(FoodValues.RISOTTO_AL_SUGO).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> RISOTTO_AL_FUNGHI = ITEMS.register("risotto_al_funghi", () -> new Item(foodItem(FoodValues.RISOTTO_AL_FUNGHI).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> TIRAMISU = ITEMS.register("tiramisu", () -> new Item(foodItem(FoodValues.TIRAMISU).tab(ItalianDelightMain.CREATIVE_TAB)));

    // Pizza
    public static final RegistryObject<Item> PIZZA_AL_PROSCIUTTO = ITEMS.register("pizza_al_prosciutto", () -> {
        return new BlockItem((Block) BlockInit.PIZZA_AL_PROSCIUTTO.get(), basicItem().stacksTo(1));
    });
    public static final RegistryObject<Item> PIZZA_AL_PROSCIUTTO_SLICE = ITEMS.register("pizza_al_prosciutto_slice", () -> new Item(foodItem(FoodValues.PIZZA_AL_PROSCIUTTO_SLICE).tab(ItalianDelightMain.CREATIVE_TAB)));

    // Ingredients
    public static final RegistryObject<Item> SALAMI = ITEMS.register("salami", () -> new Item(foodItem(FoodValues.SALAMI).tab(ItalianDelightMain.CREATIVE_TAB)));


    // Block Items
    public static final RegistryObject<Item> WILD_GRAPES = ITEMS.register("wild_grapes", () -> {
        return new BlockItem(BlockInit.WILD_GRAPES.get(), basicItem());});

    public static final RegistryObject<Item> WILD_HERBS = ITEMS.register("wild_herbs", () -> {
        return new BlockItem(BlockInit.WILD_HERBS.get(), basicItem());});

}