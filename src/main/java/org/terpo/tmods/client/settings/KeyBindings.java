package org.terpo.tmods.client.settings;

import org.terpo.tmods.reference.Names;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class KeyBindings

{
	public static KeyBinding charge = new KeyBinding(Names.Keys.CHARGE, Keyboard.KEY_K,"key.categories.movement"); //Names.Keys.CATEGORY
	public static KeyBinding release = new KeyBinding(Names.Keys.RELEASE, Keyboard.KEY_J,"key.categories.movement");
}
