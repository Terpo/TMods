package org.terpo.tmods.init;

import net.minecraft.block.BlockDoor;

import org.terpo.tmods.block.*;
import org.terpo.tmods.handler.ConfigurationHandler;
import org.terpo.tmods.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{

	public static final BlockContainerTMods	stamper							= new BlockStamper(false);
	public static final BlockContainerTMods	stamperActive					= new BlockStamper(true);
	public static final BlockDoor	doorGlass					= new BlockDoorGlass();
	public static final BlockDoor	doorGlassStainedWhite		= new BlockDoorGlassStained(0);
	public static final BlockDoor	doorGlassStainedOrange		= new BlockDoorGlassStained(1);
	public static final BlockDoor	doorGlassStainedMagenta	= new BlockDoorGlassStained(2);
	public static final BlockDoor	doorGlassStainedLightBlue	= new BlockDoorGlassStained(3);
	public static final BlockDoor	doorGlassStainedYellow		= new BlockDoorGlassStained(4);
	public static final BlockDoor	doorGlassStainedLightGreen	= new BlockDoorGlassStained(5);
	public static final BlockDoor	doorGlassStainedPink		= new BlockDoorGlassStained(6);
	public static final BlockDoor	doorGlassStainedDarkGray	= new BlockDoorGlassStained(7);
	public static final BlockDoor	doorGlassStainedLightGray	= new BlockDoorGlassStained(8);
	public static final BlockDoor	doorGlassStainedCyan		= new BlockDoorGlassStained(9);
	public static final BlockDoor	doorGlassStainedPurple		= new BlockDoorGlassStained(10);
	public static final BlockDoor	doorGlassStainedBlue		= new BlockDoorGlassStained(11);
	public static final BlockDoor	doorGlassStainedBrown		= new BlockDoorGlassStained(12);
	public static final BlockDoor	doorGlassStainedGreen		= new BlockDoorGlassStained(13);
	public static final BlockDoor	doorGlassStainedRed		= new BlockDoorGlassStained(14);
	public static final BlockDoor	doorGlassStainedBlack		= new BlockDoorGlassStained(15);

	public static void init()
	{
		if(ConfigurationHandler.enableStamper)
		{
			GameRegistry.registerBlock(stamper, "stamper");
			GameRegistry.registerBlock(stamperActive, "stamperActive");
		}
		GameRegistry.registerBlock(doorGlass, "doorGlass");
		GameRegistry.registerBlock(doorGlassStainedWhite, "doorGlassStainedWhite");
		GameRegistry.registerBlock(doorGlassStainedOrange, "doorGlassStainedOrange");
		GameRegistry.registerBlock(doorGlassStainedMagenta, "doorGlassStainedMagenta");
		GameRegistry.registerBlock(doorGlassStainedLightBlue, "doorGlassStainedLightBlue");
		GameRegistry.registerBlock(doorGlassStainedYellow, "doorGlassStainedYellow");
		GameRegistry.registerBlock(doorGlassStainedLightGreen, "doorGlassStainedLightGreen");
		GameRegistry.registerBlock(doorGlassStainedPink, "doorGlassStainedPink");
		GameRegistry.registerBlock(doorGlassStainedDarkGray, "doorGlassStainedGray");
		GameRegistry.registerBlock(doorGlassStainedLightGray, "doorGlassStainedLightGray");
		GameRegistry.registerBlock(doorGlassStainedCyan, "doorGlassStainedCyan");
		GameRegistry.registerBlock(doorGlassStainedPurple, "doorGlassStainedPurple");
		GameRegistry.registerBlock(doorGlassStainedBlue, "doorGlassStainedBlue");
		GameRegistry.registerBlock(doorGlassStainedBrown, "doorGlassStainedBrown");
		GameRegistry.registerBlock(doorGlassStainedGreen, "doorGlassStainedGreen");
		GameRegistry.registerBlock(doorGlassStainedRed, "doorGlassStainedRed");
		GameRegistry.registerBlock(doorGlassStainedBlack, "doorGlassStainedBlack");
	}

}
