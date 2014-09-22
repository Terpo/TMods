package org.terpo.tmods;

import org.terpo.tmods.handler.ConfigurationHandler;
import org.terpo.tmods.init.ModBlocks;
import org.terpo.tmods.init.ModItems;
import org.terpo.tmods.proxy.IProxy;
import org.terpo.tmods.reference.Reference;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.MOD_ID,name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory=Reference.GUI_FACTORY_CLASS)

public class TMods {
	
	@Mod.Instance(Reference.MOD_ID)
	public static TMods instance;
	
	@SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS,serverSide=Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Modconfig, Items, Blocks
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		
		ModItems.init();
		ModBlocks.init();
	}
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event){
		//GUIS, TEs, Recipes
	}
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}

}
