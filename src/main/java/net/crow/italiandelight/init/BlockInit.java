package net.crow.italiandelight.init;

import net.crow.italiandelight.blocks.pizza.PizzaDiavolaBlock;
import net.crow.italiandelight.blocks.pizza.PizzaFunghiBlock;
import net.crow.italiandelight.blocks.pizza.PizzaDanteBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.crow.italiandelight.ItalianDelightMain;
import net.crow.italiandelight.blocks.*;
import net.crow.italiandelight.blocks.pizza.PizzaProsciuttoBlock;
import net.crow.italiandelight.world.feature.tree.OliveTreeGrower;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class BlockInit {


    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ItalianDelightMain.MOD_ID);


    //Wild Crops
    public static final RegistryObject<Block> WILD_GRAPES = BLOCKS.register("wild_grapes",
            () -> new WildCropBlock(MobEffects.CONFUSION, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_HERBS = BLOCKS.register("wild_herbs",
            () -> new WildCropBlock(MobEffects.MOVEMENT_SPEED, 10, Block.Properties.copy(Blocks.TALL_GRASS)));


    //Raw Crops
    public static final RegistryObject<Block> GRAPE_CROP = BLOCKS.register("grape_crop",
            () -> new GrapeCrop(Block.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> HERB_CROP = BLOCKS.register("herb_crop",
            () -> new HerbCrop(Block.Properties.copy(Blocks.WHEAT)));

    //Olive Stuff
    public static final RegistryObject<Block> OLIVE_SAPLING = registerBlock("olive_sapling", () -> new SaplingBlock(new OliveTreeGrower(), Properties.copy(Blocks.OAK_SAPLING)), ItalianDelightMain.CREATIVE_TAB);
    public static final RegistryObject<Block> OLIVE_LOG = registerBlock("olive_log", () -> new OliveLogBlock(Properties.copy(Blocks.OAK_LOG)), ItalianDelightMain.CREATIVE_TAB);
    public static final RegistryObject<Block> OLIVE_WOOD = registerBlock("olive_wood", () -> new OliveLogBlock(Properties.copy(Blocks.OAK_WOOD)), ItalianDelightMain.CREATIVE_TAB);
    public static final RegistryObject<Block> STRIPPED_OLIVE_LOG = registerBlock("stripped_olive_log", () -> new OliveLogBlock(Properties.copy(Blocks.STRIPPED_OAK_LOG)), ItalianDelightMain.CREATIVE_TAB);
    public static final RegistryObject<Block> STRIPPED_OLIVE_WOOD = registerBlock("stripped_olive_wood", () -> new OliveLogBlock(Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ItalianDelightMain.CREATIVE_TAB);
    public static final RegistryObject<Block> OLIVE_LEAVES = registerBlock("olive_leaves", () -> new OliveLeavesBlock(Properties.copy(Blocks.OAK_LEAVES)){
        //Makes it flammable
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        //How Flammable is it?z
        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 30;
        }

        //How likely is it to spread fire?
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 60;
        }

    }, ItalianDelightMain.CREATIVE_TAB);
    public static final RegistryObject<Block> OLIVE_PLANKS = registerBlock("olive_planks", () -> new Block(Properties.copy(Blocks.OAK_PLANKS)) {
        //Makes it flammable
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        //How Flammable is it?
        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 5;
        }

        //How likely is it to spread fire?
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 20;
        }

    }, ItalianDelightMain.CREATIVE_TAB);

// Pizza Stuff
    public static final RegistryObject<Block> PIZZA_PROSCIUTTO = BLOCKS.register("pizza_prosciutto", () -> new PizzaProsciuttoBlock(Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> PIZZA_FUNGHI = BLOCKS.register("pizza_funghi", () -> new PizzaFunghiBlock(Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> PIZZA_MARGHERITA = BLOCKS.register("pizza_margherita", () -> new PizzaDanteBlock(Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> PIZZA_DANTE = BLOCKS.register("pizza_dante", () -> new PizzaDanteBlock(Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> PIZZA_DIAVOLA = BLOCKS.register("pizza_diavola", () -> new PizzaDiavolaBlock(Properties.copy(Blocks.CAKE)));
// Oven Stuff
    public static final RegistryObject<Block> WOODEN_OVEN = registerBlock("wooden_oven", () -> new WoodenOven(Properties.copy(Blocks.SMOKER)), ItalianDelightMain.CREATIVE_TAB);

// Helpers
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;

    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

}