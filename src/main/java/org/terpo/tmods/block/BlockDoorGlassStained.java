package org.terpo.tmods.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import org.terpo.tmods.creativetab.CreativeTabTMods;
import org.terpo.tmods.init.ModItems;
import org.terpo.tmods.reference.Names;
import org.terpo.tmods.reference.Reference;
import org.terpo.tmods.util.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDoorGlassStained extends BlockTModsDoors
{
	private int meta;
	
	public BlockDoorGlassStained(int md)
	{
		super(Material.glass);
		this.setCreativeTab(CreativeTabTMods.TMods_TAB);
		this.setBlockName(Names.Blocks.DOORGLASSSTAINEDBLOCK);
		this.setBlockTextureName(Names.Blocks.DOORGLASSSTAINEDBLOCK);
		this.setHardness(2.0f);
		this.setHarvestLevel("pickaxe", 1);
		this.meta = md;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
	{
		return 1;
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune)
	{
		return (meta & 8) != 0 ? Item.getItemFromBlock(Blocks.air) : ModItems.doorGlassStainedItem;
	}

	@Override
	public int damageDropped(int meta)
	{
		return this.meta;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		
		if (side != 1 && side != 0)
		{
			int i1 = this.func_150012_g(blockAccess, x, y, z);
			int j1 = i1 & 3;
			boolean flag = (i1 & 4) != 0;
			boolean flag1 = false;
			boolean flag2 = (i1 & 8) != 0;

			if (flag)
			{
				if (j1 == 0 && side == 2)
				{
					flag1 = !flag1;
				} else if (j1 == 1 && side == 5)
				{
					flag1 = !flag1;
				} else if (j1 == 2 && side == 3)
				{
					flag1 = !flag1;
				} else if (j1 == 3 && side == 4)
				{
					flag1 = !flag1;
				}
			} else
			{
				if (j1 == 0 && side == 5)
				{
					flag1 = !flag1;
				} else if (j1 == 1 && side == 3)
				{
					flag1 = !flag1;
				} else if (j1 == 2 && side == 4)
				{
					flag1 = !flag1;
				} else if (j1 == 3 && side == 2)
				{
					flag1 = !flag1;
				}

				if ((i1 & 16) != 0)
				{
					flag1 = !flag1;
				}
			}

			return flag2 ? this.doorUpper[flag1 ? 1 : 0]
					: this.doorLower[flag1 ? 1 : 0];
		} else
		{
			return this.doorLower[0];
		}
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world,
			int x, int y, int z)
	{
		return new ItemStack(ModItems.doorGlassStainedItem, 1, meta);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return super.getUnlocalizedName()+"_"+ Names.Colors.COLORS[this.meta];
	}
}
