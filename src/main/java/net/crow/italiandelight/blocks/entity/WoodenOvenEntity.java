package net.crow.italiandelight.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.crow.italiandelight.init.BlockEntityInit;
import net.crow.italiandelight.screen.WoodenOvenMenu;

public class WoodenOvenEntity extends AbstractFurnaceBlockEntity {
    public WoodenOvenEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.WOODEN_OVEN.get(), pos, state, RecipeType.SMOKING);
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new WoodenOvenMenu(id, inventory, this, this.dataAccess);
    }


    @Override
    protected int getBurnDuration(ItemStack p_59786_) {
        return super.getBurnDuration(p_59786_) / 8;
    }


    public static void tick(Level level, BlockPos pos, BlockState state, WoodenOvenEntity pEntity) {
        if (level.isClientSide()) {
            return;
        }
    }

    @Override
    public Component getDefaultName() {
        return Component.translatable("Wooden Oven");
    }
}
