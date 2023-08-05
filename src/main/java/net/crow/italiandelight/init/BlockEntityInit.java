package net.crow.italiandelight.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.crow.italiandelight.ItalianDelightMain;
import net.crow.italiandelight.blocks.entity.WoodenOvenEntity;

public class BlockEntityInit {


    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ItalianDelightMain.MOD_ID);



    public static final RegistryObject<BlockEntityType<WoodenOvenEntity>> WOODEN_OVEN = BLOCK_ENTITY_TYPES.register("wooden_oven",
            () -> BlockEntityType.Builder.of(WoodenOvenEntity::new, BlockInit.WOODEN_OVEN.get()).build(null));
}
