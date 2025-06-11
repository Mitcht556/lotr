/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.MenuProvider
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.PickaxeItem
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
 *  net.minecraft.world.level.storage.loot.LootParams$Builder
 *  net.minecraft.world.phys.BlockHitResult
 */
package net.mcreator.dragonball.block;

import java.util.Collections;
import java.util.List;
import net.mcreator.dragonball.block.entity.GravitydeviceBlockEntity;
import net.mcreator.dragonball.procedures.GravitydeviceOnBlockRightClickedProcedure;
import net.mcreator.dragonball.procedures.GravitydeviceRedstoneOnProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
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
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;

public class GravitydeviceBlock
extends Block
implements EntityBlock {
    public GravitydeviceBlock() {
        super(BlockBehaviour.Properties.m_284310_().m_60918_(SoundType.f_56743_).m_60913_(1.0f, 10.0f).m_60999_());
    }

    public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }

    public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
        Item item = player.m_150109_().m_36056_().m_41720_();
        if (item instanceof PickaxeItem) {
            PickaxeItem tieredItem = (PickaxeItem)item;
            return tieredItem.m_43314_().m_6604_() >= 1;
        }
        return false;
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
        world.m_186460_(pos, (Block)this, 2);
    }

    public void m_213897_(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        super.m_213897_(blockstate, world, pos, random);
        int x = pos.m_123341_();
        int y = pos.m_123342_();
        int z = pos.m_123343_();
        GravitydeviceRedstoneOnProcedure.execute((LevelAccessor)world, x, y, z);
        world.m_186460_(pos, (Block)this, 2);
    }

    public InteractionResult m_6227_(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
        super.m_6227_(blockstate, world, pos, entity, hand, hit);
        int x = pos.m_123341_();
        int y = pos.m_123342_();
        int z = pos.m_123343_();
        double hitX = hit.m_82450_().f_82479_;
        double hitY = hit.m_82450_().f_82480_;
        double hitZ = hit.m_82450_().f_82481_;
        Direction direction = hit.m_82434_();
        GravitydeviceOnBlockRightClickedProcedure.execute((LevelAccessor)world, x, y, z, (Entity)entity);
        return InteractionResult.SUCCESS;
    }

    public MenuProvider m_7246_(BlockState state, Level worldIn, BlockPos pos) {
        MenuProvider menuProvider;
        BlockEntity tileEntity = worldIn.m_7702_(pos);
        return tileEntity instanceof MenuProvider ? (menuProvider = (MenuProvider)tileEntity) : null;
    }

    public BlockEntity m_142194_(BlockPos pos, BlockState state) {
        return new GravitydeviceBlockEntity(pos, state);
    }

    public boolean m_8133_(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
        super.m_8133_(state, world, pos, eventID, eventParam);
        BlockEntity blockEntity = world.m_7702_(pos);
        return blockEntity == null ? false : blockEntity.m_7531_(eventID, eventParam);
    }
}

