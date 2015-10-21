package org.terpo.tmods.creativetab;

import org.terpo.tmods.init.ModItems;
import org.terpo.tmods.reference.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabTMods
{
	public static final CreativeTabs	TMods_TAB	= new CreativeTabs(
															Reference.MOD_ID
																	.toLowerCase())
													{
														@Override
														public Item getTabIconItem()
														{
															
															// returns a item,
															// item become
															// symbol
															return ModItems.pulverizedClay;
														}

														@Override
														public String getTranslatedTabLabel()
														{
															return Reference.MOD_NAME;

														}
													};
}
