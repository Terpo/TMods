package org.terpo.tmods.proxy;

import org.terpo.tmods.client.settings.KeyBindings;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;


public class ClientProxy extends CommonProxy
{

	@Override
	public void registerKeyBindings()
	{
		//Client register key binding		
		ClientRegistry.registerKeyBinding(KeyBindings.charge);
		ClientRegistry.registerKeyBinding(KeyBindings.release);
	}

}
