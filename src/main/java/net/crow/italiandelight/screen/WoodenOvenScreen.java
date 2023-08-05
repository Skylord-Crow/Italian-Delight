package net.crow.italiandelight.screen;

import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.SmokingRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class WoodenOvenScreen extends AbstractFurnaceScreen<WoodenOvenMenu> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/screens/ovenwood.png");

    public WoodenOvenScreen(WoodenOvenMenu menu, Inventory inventory, Component component) {
        super(menu, new SmokingRecipeBookComponent(), inventory, component, TEXTURE);
    }
}
