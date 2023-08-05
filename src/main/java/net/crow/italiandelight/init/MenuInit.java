package net.crow.italiandelight.init;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.crow.italiandelight.ItalianDelightMain;

public class MenuInit {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, ItalianDelightMain.MOD_ID);

    //public static final RegistryObject<MenuType<WoodenOvenMenu>> WOODEN_OVEN_MENU =
            //registerMenuType(WoodenOvenMenu::new, "wooden_oven");

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                 String name){
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

}
