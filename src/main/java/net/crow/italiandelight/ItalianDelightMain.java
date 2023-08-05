package net.crow.italiandelight;

import com.mojang.logging.LogUtils;
import net.crow.italiandelight.init.*;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import net.crow.italiandelight.world.feature.ModConfiguredFeatures;
import net.crow.italiandelight.CommonSetup;

import javax.annotation.Nonnull;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ItalianDelightMain.MODID)
public class ItalianDelightMain
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "italian_delight";
    public static final String MOD_ID = "italian_delight";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab(ItalianDelightMain.MODID)
    {
        @Nonnull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BlockInit.WOODEN_OVEN.get());
        }
    };
    public ItalianDelightMain()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(CommonSetup::init);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BlockInit.BLOCKS.register(modEventBus);

        // Register the Deferred Register to the mod event bus so items get registered
        ItemInit.ITEMS.register(modEventBus);

        // Register the Deferred Register to the mod event bus so placed features get registered
        BiomeFeaturesInit.FEATURES.register(modEventBus);

        // Register the Deferred Register to the mod event bus so Biome Mods get registered
        BiomeInit.BIOME_MODIFIER_SERIALIZERS.register(modEventBus);

        // Register the Deferred Register to the mod event bus so tile entities get registered
        BlockEntityInit.BLOCK_ENTITY_TYPES.register(modEventBus);

        // Register the Deferred Register to the mod event bus so menus get registered
        MenuInit.MENUS.register(modEventBus);

        // Register the Deferred Register to the mod event bus so configs get registered
        ModConfiguredFeatures.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            //MenuScreens.register(MenuInit.WOODEN_OVEN_MENU.get(), WoodenOvenScreen::new);
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
