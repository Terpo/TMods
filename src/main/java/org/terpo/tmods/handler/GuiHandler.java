package org.terpo.tmods.handler;

import org.terpo.tmods.gui.GuiStamper;
import org.terpo.tmods.inventory.ContainerStamper;
import org.terpo.tmods.reference.GuiID;
import org.terpo.tmods.tileentity.TileEntityStamper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{

	@Override
	//for storing information
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == GuiID.STAMPER)
		{
			TileEntityStamper teStamper = (TileEntityStamper)world.getTileEntity(x, y, z);
			return new ContainerStamper(player.inventory,teStamper);
		}
		return null;
	}

	@Override
	//for rendering
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == GuiID.STAMPER)
		{
			TileEntityStamper teStamper = (TileEntityStamper)world.getTileEntity(x, y, z);
			return new GuiStamper(player.inventory,teStamper);
		}
		return null;
	}

}
