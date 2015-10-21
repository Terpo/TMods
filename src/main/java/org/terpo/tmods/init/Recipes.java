package org.terpo.tmods.init;


import org.terpo.tmods.handler.ConfigurationHandler;
import org.terpo.tmods.reference.Names;

import cofh.api.modhelpers.ThermalExpansionHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes
{
	public static void init()
	{
		/*################
		 * Ore Dictionary
		 #################*/
		
		//Hardened Clay
		OreDictionary.registerOre("blockStainedHardenedClay",     new ItemStack(Blocks.stained_hardened_clay, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("blockClayHardened",     Blocks.hardened_clay);

		
		//OreDictionary
		//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.paperShovel)," s "," t "," t ",'s', new ItemStack(Items.paper),'t', "logWood"));
		//GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.stamper), "logWood","blockClayHardened"));
		
	
		//grass recipe
		GameRegistry.addRecipe(new ItemStack(Blocks.grass)," g "," d ","   ",'g',new ItemStack(Blocks.tallgrass,1,1),'d',new ItemStack(Blocks.dirt));
		
		//clay recipe
		GameRegistry.addRecipe(new ItemStack(Items.clay_ball,8),"gqs","gws","gds",'g', new ItemStack(Blocks.gravel),'q',new ItemStack(Items.quartz),'d',new ItemStack(Blocks.dirt),'w',new ItemStack(Items.water_bucket),'s',new ItemStack(Blocks.sand));
		
		/*################
		 * Clay processing
		 #################*/
		
		//manual
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.pulverizedClay, 4), "blockStainedHardenedClay",new ItemStack(ModItems.quartzMortar,1,OreDictionary.WILDCARD_VALUE)));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pulverizedClay, 4),new ItemStack(Blocks.hardened_clay),new ItemStack(ModItems.quartzMortar,1,OreDictionary.WILDCARD_VALUE));		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.clay_ball,4), new ItemStack(ModItems.pulverizedClay), new ItemStack(ModItems.pulverizedClay), new ItemStack(ModItems.pulverizedClay), new ItemStack(ModItems.pulverizedClay), new ItemStack(Items.water_bucket));
		
		//CoFH 
		ThermalExpansionHelper.addPulverizerRecipe(5000, new ItemStack(Blocks.hardened_clay), new ItemStack(ModItems.pulverizedClay,4));
		ThermalExpansionHelper.addPulverizerRecipe(5000, new ItemStack(Blocks.stained_hardened_clay, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ModItems.pulverizedClay,4));
		ThermalExpansionHelper.addTransposerFill(5000, new ItemStack(ModItems.pulverizedClay), new ItemStack(Items.clay_ball), new FluidStack(1,250), false);
	
		/*####################
		 * machines and items
		 #####################*/
		
		//Stamper
		//GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.stamper), new ItemStack(ModItems.paperShovel), new ItemStack(ModItems.paperShovel));
		//GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.stamper), "logWood","blockClayHardened"));
		//GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.stamper), "logWood","blockClayHardened"));
		if(ConfigurationHandler.enableStamperRecipe)
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.stamper),"wpw","pgp","wpw",'g', "gearIron",'w', "plankWood",'p',new ItemStack(Blocks.piston)));
		
		
		//Paper Shovel
		//GameRegistry.addRecipe(new ItemStack(ModItems.paperShovel)," s "," t "," t ",'s', new ItemStack(Items.paper),'t', new ItemStack(Items.stick));
		
		//Quartz Mortar
		GameRegistry.addRecipe(new ItemStack(ModItems.quartzMortar),"  t","sqs","sss",'s', new ItemStack(Blocks.stone),'t', new ItemStack(Items.stick),'q', new ItemStack(Items.quartz));
		
		//Glass Door
		GameRegistry.addRecipe(new ItemStack(ModItems.doorGlassItem)," gg"," gg", " gg",'g',new ItemStack(Blocks.glass_pane));
				
		//Stained Glass Door
		for (int i=0; i<16; i++){
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.doorGlassStainedItem,1,i), new ItemStack(ModItems.doorGlassItem) ,Names.Colors.DYE[i]));
			for(int j=0; j<16;j++)
				if(i!=j)
					GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.doorGlassStainedItem,1,i), new ItemStack(ModItems.doorGlassStainedItem,1,j) ,Names.Colors.DYE[i]));
		}
		
		
	}
}
