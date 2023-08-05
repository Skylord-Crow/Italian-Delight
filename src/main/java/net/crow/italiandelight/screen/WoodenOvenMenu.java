package net.crow.italiandelight.screen;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipeType;

public class WoodenOvenMenu extends AbstractFurnaceMenu{



    public WoodenOvenMenu(int id, Inventory inventory) {
        super(MenuType.SMOKER, RecipeType.SMOKING, RecipeBookType.SMOKER, id, inventory);
    }

    public WoodenOvenMenu(int id, Inventory inventory, Container container, ContainerData data) {
        super(MenuType.SMOKER, RecipeType.SMOKING, RecipeBookType.SMOKER, id, inventory, container, data);
    }
}