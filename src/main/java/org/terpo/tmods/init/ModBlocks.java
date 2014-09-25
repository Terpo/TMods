package org.terpo.tmods.init;

import org.terpo.tmods.block.BlockStamper;
import org.terpo.tmods.block.BlockTMods;
import org.terpo.tmods.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{

	public static final BlockTMods	stamper	= new BlockStamper();

	public static void init()
	{
		GameRegistry.registerBlock(stamper, "stamper");
	}
}
