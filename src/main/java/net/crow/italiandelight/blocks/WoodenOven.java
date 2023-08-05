package net.crow.italiandelight.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.crow.italiandelight.blocks.entity.WoodenOvenEntity;
import net.crow.italiandelight.init.BlockEntityInit;

import javax.annotation.Nullable;

public class WoodenOven extends AbstractFurnaceBlock{

    public WoodenOven(BlockBehaviour.Properties properties){
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WoodenOvenEntity(pos, state);
    }

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;{
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public static final BooleanProperty LIT = BlockStateProperties.LIT;{
        this.registerDefaultState((this.stateDefinition.any().setValue(LIT, false)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(LIT);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }


    /* BLOCK ENTITY STUFF */

    @Override
    public RenderShape getRenderShape(BlockState p_48727_) {
        return RenderShape.MODEL;
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_154640_, BlockState p_154641_, BlockEntityType<T> p_154642_) {
        return createFurnaceTicker(p_154640_, p_154642_, BlockEntityInit.WOODEN_OVEN.get());
    }


    @Override
    protected void openContainer(Level p_53631_, BlockPos p_53632_, Player p_53633_) {
        BlockEntity blockentity = p_53631_.getBlockEntity(p_53632_);
        if (blockentity instanceof WoodenOvenEntity) {
            p_53633_.openMenu((MenuProvider)blockentity);
            p_53633_.awardStat(Stats.INTERACT_WITH_FURNACE);
        }

    }


    @Override
    public void animateTick(BlockState p_222443_, Level p_222444_, BlockPos p_222445_, RandomSource p_222446_) {
        if (p_222443_.getValue(LIT)) {
            double d0 = (double)p_222445_.getX() + 0.5D;
            double d1 = (double)p_222445_.getY();
            double d2 = (double)p_222445_.getZ() + 0.5D;
            if (p_222446_.nextDouble() < 0.1D) {
                p_222444_.playLocalSound(d0, d1, d2, SoundEvents.SMOKER_SMOKE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }

            p_222444_.addParticle(ParticleTypes.SMOKE, d0, d1 + 1.1D, d2, 0.0D, 0.0D, 0.0D);
        }
    }

}
