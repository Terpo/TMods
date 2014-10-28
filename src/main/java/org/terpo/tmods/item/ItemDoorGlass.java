package org.terpo.tmods.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.terpo.tmods.init.ModBlocks;
import org.terpo.tmods.reference.Names;

public class ItemDoorGlass extends ItemTModsDoors
{
	public ItemDoorGlass(){
		super();
		this.maxStackSize = 16;
		setUnlocalizedName(Names.Items.DOORGLASSITEM);
		this.blockDoor = ModBlocks.doorGlassBlock;
	}   
}
