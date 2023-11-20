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

    // Helpers

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
    public static final RegistryObject<Item> DRAGONBORN_WINE = ITEMS.register("dragonborn_wine", () -> new BoozeItem(2, 5, foodItem(FoodValues.DRAGONBORN_WINE)));
    public static final RegistryObject<Item> HASTING_WINE = ITEMS.register("hasting_wine", () -> new BoozeItem(2, 5, foodItem(FoodValues.HASTING_WINE)));
    public static final RegistryObject<Item> SWEETBERRY_WINE = ITEMS.register("sweetberry_wine", () -> new BoozeItem(1, 5, foodItem(FoodValues.SWEETBERRY_WINE)));
    public static final RegistryObject<Item> SPUMANTE = ITEMS.register("spumante", () -> new BoozeItem(1, 3,foodItem(FoodValues.SPUMANTE)));
    // Dishes
    public static final RegistryObject<Item> BERRY_DELIGHT = ITEMS.register("berry_delight", () -> new Item(foodItem(FoodValues.BERRY_DELIGHT).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> PASTA_AL_TOMATO = ITEMS.register("pasta_al_tomato", () -> new Item(foodItem(FoodValues.PASTA_AL_TOMATO).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> PASTA_AL_PESTO = ITEMS.register("pasta_al_pesto", () -> new Item(foodItem(FoodValues.PASTA_AL_PESTO).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> RISOTTO_AL_SUGO = ITEMS.register("risotto_al_sugo", () -> new Item(foodItem(FoodValues.RISOTTO_AL_SUGO).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> RISOTTO_AL_FUNGHI = ITEMS.register("risotto_al_funghi", () -> new Item(foodItem(FoodValues.RISOTTO_AL_FUNGHI).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> TIRAMISU = ITEMS.register("tiramisu", () -> new Item(foodItem(FoodValues.TIRAMISU).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> MOZZARELLA_PANINI = ITEMS.register("mozzarella_panini", () -> new Item(foodItem(FoodValues.MOZZARELLA_PANINI).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> MOZZARELLA_SALAD = ITEMS.register("mozzarella_salad", () -> new Item(foodItem(FoodValues.MOZZARELLA_SALAD).tab(ItalianDelightMain.CREATIVE_TAB)));

    public static final RegistryObject<Item> PANDORO = ITEMS.register("pandoro", () -> new Item(basicItem()));

    // Pizza
    public static final RegistryObject<Item> PIZZA_PROSCIUTTO_RAW = ITEMS.register("pizza_prosciutto_raw",
            () -> new Item(basicItem()));
    public static final RegistryObject<Item> PIZZA_PROSCIUTTO = ITEMS.register("pizza_prosciutto", () -> {
        return new BlockItem((Block) BlockInit.PIZZA_PROSCIUTTO.get(), basicItem());});
    public static final RegistryObject<Item> PIZZA_PROSCIUTTO_SLICE = ITEMS.register("pizza_prosciutto_slice",
            () -> new Item(foodItem(FoodValues.PIZZA_PROSCIUTTO_SLICE).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> PIZZA_FUNGHI_RAW = ITEMS.register("pizza_funghi_raw",
            () -> new Item(basicItem()));
    public static final RegistryObject<Item> PIZZA_FUNGHI = ITEMS.register("pizza_funghi", () -> {
        return new BlockItem((Block) BlockInit.PIZZA_FUNGHI.get(), basicItem());});
    public static final RegistryObject<Item> PIZZA_FUNGHI_SLICE = ITEMS.register("pizza_funghi_slice",
            () -> new Item(foodItem(FoodValues.PIZZA_FUNGHI_SLICE).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> PIZZA_MARGHERITA_RAW = ITEMS.register("pizza_margherita_raw",
            () -> new Item(basicItem()));
    public static final RegistryObject<Item> PIZZA_MARGHERITA = ITEMS.register("pizza_margherita", () -> {
        return new BlockItem((Block) BlockInit.PIZZA_MARGHERITA.get(), basicItem());});
    public static final RegistryObject<Item> PIZZA_MARGHERITA_SLICE = ITEMS.register("pizza_margherita_slice",
            () -> new Item(foodItem(FoodValues.PIZZA_MARGHERITA_SLICE).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> PIZZA_DANTE_RAW = ITEMS.register("pizza_dante_raw",
            () -> new Item(basicItem()));
    public static final RegistryObject<Item> PIZZA_DANTE = ITEMS.register("pizza_dante", () -> {
        return new BlockItem((Block) BlockInit.PIZZA_DANTE.get(), basicItem());});
    public static final RegistryObject<Item> PIZZA_DANTE_SLICE = ITEMS.register("pizza_dante_slice",
            () -> new Item(foodItem(FoodValues.PIZZA_DANTE_SLICE).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> PIZZA_DIAVOLA_RAW = ITEMS.register("pizza_diavola_raw",
            () -> new Item(basicItem()));
    public static final RegistryObject<Item> PIZZA_DIAVOLA = ITEMS.register("pizza_diavola", () -> {
        return new BlockItem((Block) BlockInit.PIZZA_DIAVOLA.get(), basicItem());});
    public static final RegistryObject<Item> PIZZA_DIAVOLA_SLICE = ITEMS.register("pizza_diavola_slice",
            () -> new Item(foodItem(FoodValues.PIZZA_DIAVOLA_SLICE).tab(ItalianDelightMain.CREATIVE_TAB)));
    // Ingredients
    public static final RegistryObject<Item> RAW_SALAMI = ITEMS.register("salami_raw", () -> new Item(foodItem(FoodValues.RAW_SALAMI).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> SALAMI = ITEMS.register("salami", () -> new Item(foodItem(FoodValues.SALAMI).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> SALAMI_SLICE = ITEMS.register("salami_slice", () -> new Item(foodItem(FoodValues.SALAMI_SLICE).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> PANETTONE = ITEMS.register("panettone", () -> new Item(foodItem(FoodValues.PANETTONE).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> PANETTONE_SLICES = ITEMS.register("panettone_slice", () -> new Item(foodItem(FoodValues.PANETONNE_SLICE).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> PANDORO_DOUGH = ITEMS.register("pandoro_dough", () -> new Item(foodItem(FoodValues.PANDORO_DOUGH).tab(ItalianDelightMain.CREATIVE_TAB)));
    public static final RegistryObject<Item> PANDORO_SLICE = ITEMS.register("pandoro_slice", () -> new Item(foodItem(FoodValues.PANDORO_SLICE).tab(ItalianDelightMain.CREATIVE_TAB)));



    // Block Items
    public static final RegistryObject<Item> WILD_GRAPES = ITEMS.register("wild_grapes", () -> {
        return new BlockItem(BlockInit.WILD_GRAPES.get(), basicItem());});

    public static final RegistryObject<Item> WILD_HERBS = ITEMS.register("wild_herbs", () -> {
        return new BlockItem(BlockInit.WILD_HERBS.get(), basicItem());});

}