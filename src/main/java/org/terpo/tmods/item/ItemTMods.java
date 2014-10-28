package org.terpo.tmods.item;

import org.terpo.tmods.creativetab.CreativeTabTMods;
import org.terpo.tmods.reference.Reference;
import org.terpo.tmods.util.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemTMods extends Item
{

	public ItemTMods()
	{
		super();
		this.setCreativeTab(CreativeTabTMods.TMods_TAB);
		this.setNoRepair();
	}

	@Override
	public String getUnlocalizedName()
	{
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":",
				getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		//LogHelper.info("######## ITEM ########");
		//LogHelper.info(super.getUnlocalizedName());
		//LogHelper.info(getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
		//LogHelper.info(String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":",
		//		getUnwrappedUnlocalizedName(super.getUnlocalizedName())));
		//LogHelper.info("######## ITEMEND ########");
		
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":",
				getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName()
				.substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

}
