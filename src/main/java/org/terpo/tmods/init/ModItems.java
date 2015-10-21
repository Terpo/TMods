package org.terpo.tmods.init;

import org.terpo.tmods.item.*;
import org.terpo.tmods.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{

	//public static final ItemTMods	paperShovel	= new ItemPaperShovel();
	public static final ItemTMods	quartzMortar	= new ItemQuartzMortar();
	public static final ItemTMods	pulverizedClay	= new ItemPulverizedClay();
	public static final ItemTMods	doorGlassItem	= new ItemDoorGlass();
	public static final ItemTMods	doorGlassStainedItem	= new ItemDoorGlassStained();
	
	public static void init()
	{
		//GameRegistry.registerItem(paperShovel, "paperShovel");
		GameRegistry.registerItem(quartzMortar, "quartzMortar");
		GameRegistry.registerItem(pulverizedClay, "pulverizedClay");
		GameRegistry.registerItem(doorGlassItem, "doorGlassItem");
		GameRegistry.registerItem(doorGlassStainedItem, "doorGlassStainedItem");
	}

}
