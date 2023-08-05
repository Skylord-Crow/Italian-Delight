package net.crow.italiandelight.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.core.BlockPos;

import net.crow.italiandelight.init.BlockInit;

import javax.annotation.Nullable;

public class OliveLogBlock extends RotatedPillarBlock {

    public OliveLogBlock(Properties properties) {
        super(properties);
    }

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
        return 5;
    }

    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction action, boolean simulate){
        if(context.getItemInHand().getItem() instanceof AxeItem){
            if(state.is(BlockInit.OLIVE_LOG.get())){
                return BlockInit.STRIPPED_OLIVE_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS,state.getValue(RotatedPillarBlock.AXIS));
            }
            if(state.is(BlockInit.OLIVE_WOOD.get())){
                return BlockInit.STRIPPED_OLIVE_WOOD.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS,state.getValue(RotatedPillarBlock.AXIS));
            }
        }
        return super.getToolModifiedState(state, context,action, simulate);
    }



}
