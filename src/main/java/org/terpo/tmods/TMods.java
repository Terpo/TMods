package org.terpo.tmods;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="TMods",name="TMods", version="1.7.10-1.0")

public class TMods {
	
	@Mod.Instance("TMods")
	public static TMods instance;
	
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Modconfig, Items, Blocks
	}
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event){
		//GUIS, TEs, Recipes
	}
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}

}
