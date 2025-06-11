/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.NonNullList
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket
 *  net.minecraft.world.ContainerHelper
 *  net.minecraft.world.WorldlyContainer
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.ChestMenu
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraftforge.common.capabilities.Capability
 *  net.minecraftforge.common.capabilities.ForgeCapabilities
 *  net.minecraftforge.common.util.LazyOptional
 *  net.minecraftforge.items.IItemHandler
 *  net.minecraftforge.items.wrapper.SidedInvWrapper
 */
package net.mcreator.dragonball.block.entity;

import java.util.stream.IntStream;
import javax.annotation.Nullable;
import net.mcreator.dragonball.init.DragonballModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public class KamilookoutblockBlockEntity
extends RandomizableContainerBlockEntity
implements WorldlyContainer {
    private NonNullList<ItemStack> stacks = NonNullList.m_122780_((int)9, (Object)ItemStack.f_41583_);
    private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create((WorldlyContainer)this, (Direction[])Direction.values());

    public KamilookoutblockBlockEntity(BlockPos position, BlockState state) {
        super((BlockEntityType)DragonballModBlockEntities.KAMILOOKOUTBLOCK.get(), position, state);
    }

    public void m_142466_(CompoundTag compound) {
        super.m_142466_(compound);
        if (!this.m_59631_(compound)) {
            this.stacks = NonNullList.m_122780_((int)this.m_6643_(), (Object)ItemStack.f_41583_);
        }
        ContainerHelper.m_18980_((CompoundTag)compound, this.stacks);
    }

    public void m_183515_(CompoundTag compound) {
        super.m_183515_(compound);
        if (!this.m_59634_(compound)) {
            ContainerHelper.m_18973_((CompoundTag)compound, this.stacks);
        }
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.m_195640_((BlockEntity)this);
    }

    public CompoundTag m_5995_() {
        return this.m_187480_();
    }

    public int m_6643_() {
        return this.stacks.size();
    }

    public boolean m_7983_() {
        for (ItemStack itemstack : this.stacks) {
            if (itemstack.m_41619_()) continue;
            return false;
        }
        return true;
    }

    public Component m_6820_() {
        return Component.m_237113_((String)"kamilookoutblock");
    }

    public int m_6893_() {
        return 64;
    }

    public AbstractContainerMenu m_6555_(int id, Inventory inventory) {
        return ChestMenu.m_39255_((int)id, (Inventory)inventory);
    }

    public Component m_5446_() {
        return Component.m_237113_((String)"Kamilookoutblock");
    }

    protected NonNullList<ItemStack> m_7086_() {
        return this.stacks;
    }

    protected void m_6520_(NonNullList<ItemStack> stacks) {
        this.stacks = stacks;
    }

    public boolean m_7013_(int index, ItemStack stack) {
        return true;
    }

    public int[] m_7071_(Direction side) {
        return IntStream.range(0, this.m_6643_()).toArray();
    }

    public boolean m_7155_(int index, ItemStack stack, @Nullable Direction direction) {
        return this.m_7013_(index, stack);
    }

    public boolean m_7157_(int index, ItemStack stack, Direction direction) {
        return true;
    }

    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        if (!this.f_58859_ && facing != null && capability == ForgeCapabilities.ITEM_HANDLER) {
            return this.handlers[facing.ordinal()].cast();
        }
        return super.getCapability(capability, facing);
    }

    public void m_7651_() {
        super.m_7651_();
        for (LazyOptional<? extends IItemHandler> handler : this.handlers) {
            handler.invalidate();
        }
    }
}

