package org.terpo.tmods.block;

import org.terpo.tmods.creativetab.CreativeTabTMods;
import org.terpo.tmods.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;

public class BlockTMods extends Block
{
	public BlockTMods(Material material)
	{
		super(material);
		this.setCreativeTab(CreativeTabTMods.TMods_TAB);
		this.setResistance(6.0F);
	}

	public BlockTMods()
	{
		this(Material.iron);
	}

	@Override
	public String getUnlocalizedName()
	{
		return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":",
				getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon(this.getUnlocalizedName()
				.substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
}
