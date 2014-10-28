package org.terpo.tmods.init;

import org.terpo.tmods.util.LogHelper;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.event.FMLInterModComms;

public class IMC
{
	/*public static void init()
	{
		addPulverizedClayRecipe(new ItemStack(ModItems.pulverizedClay),new ItemStack(Items.clay_ball));
	}
	
	public static void addPulverizedClayRecipe(ItemStack itemIn, ItemStack itemOut1) {
		NBTTagCompound toSend = new NBTTagCompound();
		toSend.setTag("input", new NBTTagCompound());
		toSend.setTag("output", new NBTTagCompound());

		itemIn.writeToNBT(toSend.getCompoundTag("input"));
		itemOut1.writeToNBT(toSend.getCompoundTag("output"));
		FMLInterModComms.sendMessage("ThermalExpansion", "PulverizerRecipe", toSend);
	}*/
}
