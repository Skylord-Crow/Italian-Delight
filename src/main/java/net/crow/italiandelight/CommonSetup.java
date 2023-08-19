package net.crow.italiandelight;

import net.crow.italiandelight.init.ItemInit;
//import net.crow.italiandelight.world.WildCropGen;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetup {

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            registerCompostables();
            //WildCropGen.registerWildCropGeneration();
        });
    }

        public static void registerCompostables(){
            // 30% chance
            ComposterBlock.COMPOSTABLES.put(ItemInit.GRAPE_SEEDS.get(), 0.3F);

            // 50% chance
            ComposterBlock.COMPOSTABLES.put(ItemInit.HERB_LEAVES.get(), 0.5F);

            // 65% chance
            ComposterBlock.COMPOSTABLES.put(ItemInit.GRAPES.get(), 0.65F);

            // 85% chance


            // 100% chance
        }
}
