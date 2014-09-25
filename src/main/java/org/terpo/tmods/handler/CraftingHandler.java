package org.terpo.tmods.handler;

import net.minecraft.item.ItemStack;

import org.terpo.tmods.init.ModItems;
import org.terpo.tmods.item.ItemPulverizedClay;
import org.terpo.tmods.item.ItemQuartzMortar;
import org.terpo.tmods.util.LogHelper;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;


public class CraftingHandler 
{

	@SubscribeEvent
    public void onItemCraftedEvent(PlayerEvent.ItemCraftedEvent event)
    {
        if (event.crafting.getItem() instanceof ItemPulverizedClay)
        {
        	 for(int i=0; i<event.craftMatrix.getSizeInventory();i++){
        		 ItemStack itemStack = event.craftMatrix.getStackInSlot(i); 
        		 if (itemStack != null)
        			 if(itemStack.getItem() instanceof ItemQuartzMortar){			    
        			        itemStack.setItemDamage(itemStack.getItemDamage() + 1);
        			        if(itemStack.getItemDamage()<itemStack.getMaxDamage())
        			        	itemStack.stackSize=2;
        			 }
        				
        	 }
        }
    }
	
}
