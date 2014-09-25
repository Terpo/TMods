package org.terpo.tmods.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityTMods extends TileEntity
{
	private ForgeDirection	orientation;

	public TileEntityTMods()
	{
		orientation = ForgeDirection.SOUTH;
	}

	public ForgeDirection getOrientation()
	{
		return orientation;
	}

	public void setOrientation(ForgeDirection orientation)
	{
		this.orientation = orientation;
	}

	public void setOrientation(int orientation)
	{
		this.orientation = ForgeDirection.getOrientation(orientation);
	}
}
