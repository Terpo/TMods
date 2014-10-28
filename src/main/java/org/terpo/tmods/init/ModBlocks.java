package org.terpo.tmods.init;

import net.minecraft.block.BlockDoor;

import org.terpo.tmods.block.*;
import org.terpo.tmods.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{

	public static final BlockContainerTMods	stamper							= new BlockStamper(false);
	public static final BlockContainerTMods	stamperActive					= new BlockStamper(true);
	public static final BlockDoor	doorGlassBlock					= new BlockDoorGlass();
	public static final BlockDoor	doorGlassStainedWhiteBlock		= new BlockDoorGlassStained(0);
	public static final BlockDoor	doorGlassStainedOrangeBlock		= new BlockDoorGlassStained(1);
	public static final BlockDoor	doorGlassStainedMagentaBlock	= new BlockDoorGlassStained(2);
	public static final BlockDoor	doorGlassStainedLightBlueBlock	= new BlockDoorGlassStained(3);
	public static final BlockDoor	doorGlassStainedYellowBlock		= new BlockDoorGlassStained(4);
	public static final BlockDoor	doorGlassStainedLightGreenBlock	= new BlockDoorGlassStained(5);
	public static final BlockDoor	doorGlassStainedPinkBlock		= new BlockDoorGlassStained(6);
	public static final BlockDoor	doorGlassStainedDarkGrayBlock	= new BlockDoorGlassStained(7);
	public static final BlockDoor	doorGlassStainedLightGrayBlock	= new BlockDoorGlassStained(8);
	public static final BlockDoor	doorGlassStainedCyanBlock		= new BlockDoorGlassStained(9);
	public static final BlockDoor	doorGlassStainedPurpleBlock		= new BlockDoorGlassStained(10);
	public static final BlockDoor	doorGlassStainedBlueBlock		= new BlockDoorGlassStained(11);
	public static final BlockDoor	doorGlassStainedBrownBlock		= new BlockDoorGlassStained(12);
	public static final BlockDoor	doorGlassStainedGreenBlock		= new BlockDoorGlassStained(13);
	public static final BlockDoor	doorGlassStainedRedBlock		= new BlockDoorGlassStained(14);
	public static final BlockDoor	doorGlassStainedBlackBlock		= new BlockDoorGlassStained(15);

	public static void init()
	{
		GameRegistry.registerBlock(stamper, "stamper");
		GameRegistry.registerBlock(stamperActive, "stamperActive");
		GameRegistry.registerBlock(doorGlassBlock, "doorGlass");
		GameRegistry.registerBlock(doorGlassStainedWhiteBlock, "doorGlassStainedWhite");
		GameRegistry.registerBlock(doorGlassStainedOrangeBlock, "doorGlassStainedOrange");
		GameRegistry.registerBlock(doorGlassStainedMagentaBlock, "doorGlassStainedMagenta");
		GameRegistry.registerBlock(doorGlassStainedLightBlueBlock, "doorGlassStainedLightBlue");
		GameRegistry.registerBlock(doorGlassStainedYellowBlock, "doorGlassStainedYellow");
		GameRegistry.registerBlock(doorGlassStainedLightGreenBlock, "doorGlassStainedLightGreen");
		GameRegistry.registerBlock(doorGlassStainedPinkBlock, "doorGlassStainedPink");
		GameRegistry.registerBlock(doorGlassStainedDarkGrayBlock, "doorGlassStainedGray");
		GameRegistry.registerBlock(doorGlassStainedLightGrayBlock, "doorGlassStainedLightGray");
		GameRegistry.registerBlock(doorGlassStainedCyanBlock, "doorGlassStainedCyan");
		GameRegistry.registerBlock(doorGlassStainedPurpleBlock, "doorGlassStainedPurple");
		GameRegistry.registerBlock(doorGlassStainedBlueBlock, "doorGlassStainedBlue");
		GameRegistry.registerBlock(doorGlassStainedBrownBlock, "doorGlassStainedBrown");
		GameRegistry.registerBlock(doorGlassStainedGreenBlock, "doorGlassStainedGreen");
		GameRegistry.registerBlock(doorGlassStainedRedBlock, "doorGlassStainedRed");
		GameRegistry.registerBlock(doorGlassStainedBlackBlock, "doorGlassStainedBlack");
	}

}
