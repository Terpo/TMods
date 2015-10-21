package org.terpo.tmods.handler;

import java.io.File;

import org.terpo.tmods.reference.Reference;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler
{

	public static Configuration	configuration;
	public static boolean		enableStamper	= true;
	public static boolean		enableStamperRecipe	= true;
	
	public static void init(File configFile)
	{

		// create configuration object from configuration file
		if (configuration == null)
		{
			configuration = new Configuration(configFile);
			loadConfiguration();
		}

	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(
			ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
		{
			// resync configs
			loadConfiguration();
		}
	}

	private static void loadConfiguration()
	{

		enableStamper = configuration.getBoolean("enableStamper",
				Configuration.CATEGORY_GENERAL, true, "Disables the Stamper completly if false.");
		enableStamperRecipe = configuration.getBoolean("enableStamperRecipe",
				Configuration.CATEGORY_GENERAL, true, "Disables the crafting recipe of the Stamper if false.");
		if (configuration.hasChanged())
			configuration.save();

		/*
		 * try { //load configuration file configuration.load();
		 * 
		 * //load properties configValue = configuration.get("MyFirstCat",
		 * "configValue", true, "Commentary").getBoolean();
		 * 
		 * } catch(Exception e) { //log the exception } finally { //save the
		 * configuration file if(configuration.hasChanged())
		 * configuration.save(); }
		 */

	}
}
