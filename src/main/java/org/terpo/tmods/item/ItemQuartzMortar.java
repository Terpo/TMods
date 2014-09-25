package org.terpo.tmods.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.terpo.tmods.reference.Names;
import org.terpo.tmods.util.LogHelper;


public class ItemQuartzMortar extends ItemTMods
{
	public ItemQuartzMortar()
	{
		super();
		this.setUnlocalizedName(Names.Items.QUARTZ_MORTAR);
		this.maxStackSize = 1;
		this.setMaxDamage(16);
		
	}
	
    @Override
    public boolean getShareTag()
    {
        return true;
    }

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack){
		return false;
	}
	
	@Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
        ItemStack copiedStack = itemStack.copy();

        copiedStack.setItemDamage(copiedStack.getItemDamage() + 1);
        copiedStack.stackSize = 1;
        LogHelper.info("Crafted");
        
        return copiedStack;
    }	
	
}
