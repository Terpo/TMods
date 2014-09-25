package org.terpo.tmods.util;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHelper
{
	public static void logAllOres(){
		//this method should be used in postInit
		for(String oreName : OreDictionary.getOreNames())
		{
			LogHelper.info(oreName);
			LogHelper.info(OreDictionary.getOres(oreName));
		}
	}
}
