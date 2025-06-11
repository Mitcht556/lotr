/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.LiquidBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.FlowingFluid
 *  net.minecraft.world.level.material.MapColor
 *  net.minecraft.world.level.material.PushReaction
 */
package net.mcreator.dragonball.block;

import net.mcreator.dragonball.init.DragonballModFluids;
import net.mcreator.dragonball.procedures.HealingwaterMobplayerCollidesBlockProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class Healingwater2Block
extends LiquidBlock {
    public Healingwater2Block() {
        super(() -> (FlowingFluid)DragonballModFluids.HEALINGWATER_2.get(), BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283864_).m_60978_(100.0f).m_60982_((bs, br, bp) -> true).m_60991_((bs, br, bp) -> true).m_60910_().m_222994_().m_278788_().m_278166_(PushReaction.DESTROY).m_60918_(SoundType.f_279557_).m_280170_());
    }

    public void m_7892_(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
        super.m_7892_(blockstate, world, pos, entity);
        HealingwaterMobplayerCollidesBlockProcedure.execute(entity);
    }
}

