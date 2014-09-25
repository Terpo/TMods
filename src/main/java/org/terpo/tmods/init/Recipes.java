package org.terpo.tmods.init;


import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes
{
	public static void init()
	{
		//register Ore Dictionary
		//Hardened Clay
		OreDictionary.registerOre("blockStainedHardenedClay",     new ItemStack(Blocks.stained_hardened_clay, 1, OreDictionary.WILDCARD_VALUE));
		
		//VANILLA
		//output ItemStack, TopRow"sss", MiddleRow" s ", BottomRow"ttt",Token 's', ItemStack for Token s, Token 't', ItemStack for Token t
		//ex.: GameRegistry.addRecipe(new ItemStack(ModItems.paperShovel)," s "," t "," t ",'s', new ItemStack(Items.paper),'t', new ItemStack(Items.stick));
		
		//Paper Shovel
		GameRegistry.addRecipe(new ItemStack(ModItems.paperShovel)," s "," t "," t ",'s', new ItemStack(Items.paper),'t', new ItemStack(Items.stick));
		
		//Quartz Mortar
		GameRegistry.addRecipe(new ItemStack(ModItems.quartzMortar),"  t","sqs","sss",'s', new ItemStack(Blocks.stone),'t', new ItemStack(Items.stick),'q', new ItemStack(Items.quartz));
		
		
		//output Itemstack, input ItemStacks (up to 9 different)
		//ex.: GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.stamper),new ItemStack(ModItems.paperShovel),new ItemStack(ModItems.paperShovel));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.stamper), new ItemStack(ModItems.paperShovel), new ItemStack(ModItems.paperShovel));
		
		
		OreDictionary.registerOre("blockClayHardened",     Blocks.hardened_clay);
		
		//OreDictionary
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.paperShovel)," s "," t "," t ",'s', new ItemStack(Items.paper),'t', "logWood"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.stamper), "logWood","blockClayHardened"));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.pulverizedClay, 4), "blockStainedHardenedClay",new ItemStack(ModItems.quartzMortar,1,OreDictionary.WILDCARD_VALUE)));
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pulverizedClay, 4),new ItemStack(Blocks.hardened_clay),new ItemStack(ModItems.quartzMortar,1,OreDictionary.WILDCARD_VALUE));
		
		
		//TEEST
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.stamper), "logWood","blockClayHardened"));
			
		
	}
}
