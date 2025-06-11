/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.Container
 *  net.minecraft.world.Containers
 *  net.minecraft.world.MenuProvider
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.EntityBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.NoteBlockInstrument
 *  net.minecraft.world.level.storage.loot.LootParams$Builder
 */
package net.mcreator.dragonball.block;

import java.util.Collections;
import java.util.List;
import net.mcreator.dragonball.block.entity.KamilookoutblockBlockEntity;
import net.mcreator.dragonball.procedures.KamilookoutblockUpdateTickProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.storage.loot.LootParams;

public class KamilookoutblockBlock
extends Block
implements EntityBlock {
    public KamilookoutblockBlock() {
        super(BlockBehaviour.Properties.m_284310_().m_280658_(NoteBlockInstrument.BASEDRUM).m_60918_(SoundType.f_56742_).m_60913_(1.0f, 10.0f));
    }

    public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }

    public List<ItemStack> m_49635_(BlockState state, LootParams.Builder builder) {
        List dropsOriginal = super.m_49635_(state, builder);
        if (!dropsOriginal.isEmpty()) {
            return dropsOriginal;
        }
        return Collections.singletonList(new ItemStack((ItemLike)this, 1));
    }

    public void m_6807_(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.m_6807_(blockstate, world, pos, oldState, moving);
        world.m_186460_(pos, (Block)this, 20);
    }

    public void m_213897_(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        super.m_213897_(blockstate, world, pos, random);
        int x = pos.m_123341_();
        int y = pos.m_123342_();
        int z = pos.m_123343_();
        KamilookoutblockUpdateTickProcedure.execute((LevelAccessor)world, x, y, z);
        world.m_186460_(pos, (Block)this, 20);
    }

    public MenuProvider m_7246_(BlockState state, Level worldIn, BlockPos pos) {
        MenuProvider menuProvider;
        BlockEntity tileEntity = worldIn.m_7702_(pos);
        return tileEntity instanceof MenuProvider ? (menuProvider = (MenuProvider)tileEntity) : null;
    }

    public BlockEntity m_142194_(BlockPos pos, BlockState state) {
        return new KamilookoutblockBlockEntity(pos, state);
    }

    public boolean m_8133_(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
        super.m_8133_(state, world, pos, eventID, eventParam);
        BlockEntity blockEntity = world.m_7702_(pos);
        return blockEntity == null ? false : blockEntity.m_7531_(eventID, eventParam);
    }

    public void m_6810_(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.m_60734_() != newState.m_60734_()) {
            BlockEntity blockEntity = world.m_7702_(pos);
            if (blockEntity instanceof KamilookoutblockBlockEntity) {
                KamilookoutblockBlockEntity be = (KamilookoutblockBlockEntity)blockEntity;
                Containers.m_19002_((Level)world, (BlockPos)pos, (Container)be);
                world.m_46717_(pos, (Block)this);
            }
            super.m_6810_(state, world, pos, newState, isMoving);
        }
    }

    public boolean m_7278_(BlockState state) {
        return true;
    }

    public int m_6782_(BlockState blockState, Level world, BlockPos pos) {
        BlockEntity tileentity = world.m_7702_(pos);
        if (tileentity instanceof KamilookoutblockBlockEntity) {
            KamilookoutblockBlockEntity be = (KamilookoutblockBlockEntity)tileentity;
            return AbstractContainerMenu.m_38938_((Container)be);
        }
        return 0;
    }
}

