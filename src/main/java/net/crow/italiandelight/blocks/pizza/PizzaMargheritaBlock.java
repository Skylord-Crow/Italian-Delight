package net.crow.italiandelight.blocks.pizza;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.crow.italiandelight.init.ItemInit;
import umpaz.brewinandchewin.common.block.PizzaBlock;


public class PizzaMargheritaBlock extends PizzaBlock {
    public PizzaMargheritaBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(SERVINGS, 3));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        return level.isClientSide && this.takeServing(level, pos, state, player, handIn).consumesAction() ? InteractionResult.SUCCESS : this.takeServing(level, pos, state, player, handIn);
    }



    private InteractionResult takeServing(Level level, BlockPos pos, BlockState state, Player player, InteractionHand handIn) {
        int servings = (Integer)state.getValue(SERVINGS);
        ItemStack heldStack = player.getItemInHand(handIn);
        if (!heldStack.isEmpty() && !heldStack.getItem().equals(ItemInit.PIZZA_MARGHERITA_SLICE.get())) {
            popResource(level, pos, new ItemStack((ItemLike)ItemInit.PIZZA_MARGHERITA_SLICE.get(), 1));
        } else if (heldStack.getItem().equals(ItemInit.PIZZA_MARGHERITA_SLICE.get()) && heldStack.getCount() < heldStack.getMaxStackSize()) {
            heldStack.setCount(heldStack.getCount() + 1);
        } else {
            player.setItemInHand(handIn, new ItemStack((ItemLike)ItemInit.PIZZA_MARGHERITA_SLICE.get()));
        }

        level.playSound((Player)null, pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
        if ((Integer)level.getBlockState(pos).getValue(SERVINGS) == 0) {
            level.destroyBlock(pos, false);
        } else if ((Integer)level.getBlockState(pos).getValue(SERVINGS) > 0) {
            level.setBlock(pos, (BlockState)state.setValue(SERVINGS, servings - 1), 3);
        }

        return InteractionResult.SUCCESS;
    }

}
