package org.terpo.tmods.client.handler;

import org.terpo.tmods.client.settings.KeyBindings;
import org.terpo.tmods.reference.Key;
import org.terpo.tmods.util.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler
{
	private static Key getPressedKeybinding()
	{
		if(KeyBindings.charge.isPressed())
			return Key.CHARGE;
		else if(KeyBindings.release.isPressed())
			return Key.RELEASE;
		return Key.UNKNOWN;
	}
	@SubscribeEvent
	public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
	{
		LogHelper.info(getPressedKeybinding());
	}

}
