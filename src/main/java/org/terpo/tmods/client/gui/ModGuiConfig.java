package org.terpo.tmods.client.gui;

import java.util.List;

import org.terpo.tmods.handler.ConfigurationHandler;
import org.terpo.tmods.reference.Reference;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class ModGuiConfig extends GuiConfig
{

	public ModGuiConfig(GuiScreen guiscreen)
	{
		super(guiscreen, new ConfigElement(
				ConfigurationHandler.configuration
						.getCategory(Configuration.CATEGORY_GENERAL))
				.getChildElements(), Reference.MOD_ID, false, false, GuiConfig
				.getAbridgedConfigPath(ConfigurationHandler.configuration
						.toString()));
	}

}
