package org.terpo.tmods.init;

import org.terpo.tmods.item.ItemPaperShovel;
import org.terpo.tmods.item.ItemPulverizedClay;
import org.terpo.tmods.item.ItemQuartzMortar;
import org.terpo.tmods.item.ItemTMods;
import org.terpo.tmods.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{

	public static final ItemTMods	paperShovel	= new ItemPaperShovel();
	public static final ItemTMods	quartzMortar	= new ItemQuartzMortar();
	public static final ItemTMods	pulverizedClay	= new ItemPulverizedClay();

	public static void init()
	{
		GameRegistry.registerItem(paperShovel, "paperShovel");
		GameRegistry.registerItem(quartzMortar, "quartzMortar");
		GameRegistry.registerItem(pulverizedClay, "pulverizedClay");
	}

}
