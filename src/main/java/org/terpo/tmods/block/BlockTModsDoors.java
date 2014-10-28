package org.terpo.tmods.block;

import java.util.Random;

import org.terpo.tmods.creativetab.CreativeTabTMods;
import org.terpo.tmods.init.ModItems;
import org.terpo.tmods.reference.Names;
import org.terpo.tmods.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockTModsDoors extends BlockDoor
{
	@SideOnly(Side.CLIENT)
	public IIcon[]	doorUpper;
	@SideOnly(Side.CLIENT)
	public IIcon[]	doorLower;

	public BlockTModsDoors(Material material)
	{
		super(material);
		this.setCreativeTab(CreativeTabTMods.TMods_TAB);
		this.setHardness(2.0f);
		this.setHarvestLevel("pickaxe", 1);
		this.setResistance(6.0F);
	}
	
	public BlockTModsDoors(){
		this(Material.wood);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":",
				getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}


	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.doorUpper = new IIcon[2];
		this.doorLower = new IIcon[2];
		this.doorUpper[0] = iconRegister.registerIcon(this.getUnlocalizedName()
				.substring(this.getUnlocalizedName().indexOf(".") + 1)
				+ "_upper");
		this.doorLower[0] = iconRegister.registerIcon(this.getUnlocalizedName()
				.substring(this.getUnlocalizedName().indexOf(".") + 1)
				+ "_lower");
		this.doorUpper[1] = new IconFlipped(this.doorUpper[0], true, false);
		this.doorLower[1] = new IconFlipped(this.doorLower[0], true, false);
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
	{
		return this.doorLower[0];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess blockAccess, int par2,int par3, int par4, int par5)
	{
		if (par5 != 1 && par5 != 0)
		{
			int i1 = this.func_150012_g(blockAccess, par2, par3, par4);
			int j1 = i1 & 3;
			boolean flag = (i1 & 4) != 0;
			boolean flag1 = false;
			boolean flag2 = (i1 & 8) != 0;

			if (flag)
			{
				if (j1 == 0 && par5 == 2)
				{
					flag1 = !flag1;
				} else if (j1 == 1 && par5 == 5)
				{
					flag1 = !flag1;
				} else if (j1 == 2 && par5 == 3)
				{
					flag1 = !flag1;
				} else if (j1 == 3 && par5 == 4)
				{
					flag1 = !flag1;
				}
			} else
			{
				if (j1 == 0 && par5 == 5)
				{
					flag1 = !flag1;
				} else if (j1 == 1 && par5 == 3)
				{
					flag1 = !flag1;
				} else if (j1 == 2 && par5 == 4)
				{
					flag1 = !flag1;
				} else if (j1 == 3 && par5 == 2)
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
	public Item getItemDropped(int metadata, Random rand,int fortune)
	{
		return ModItems.doorGlassItem;
	}
	
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }
}
