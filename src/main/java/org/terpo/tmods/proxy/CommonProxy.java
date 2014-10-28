package org.terpo.tmods.proxy;

import org.terpo.tmods.reference.Names;
import org.terpo.tmods.tileentity.TileEntityStamper;

import cpw.mods.fml.common.registry.GameRegistry;

public abstract class CommonProxy implements IProxy
{
	public void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntityStamper.class, Names.Blocks.STAMPER);
	}
}
