package org.terpo.tmods.proxy;

import org.terpo.tmods.TMods;
import org.terpo.tmods.handler.GuiHandler;
import org.terpo.tmods.reference.Names;
import org.terpo.tmods.reference.Reference;
import org.terpo.tmods.tileentity.TileEntityStamper;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy extends CommonProxy
{

	@Override
	public void registerKeyBindings()
	{
		// NOOP

	}

	public void registerNetworkStuff()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(TMods.instance, new GuiHandler());
	}

	/*public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityStamper.class, Reference.MOD_ID + Names.Blocks.STAMPER);
	}*/;

}
