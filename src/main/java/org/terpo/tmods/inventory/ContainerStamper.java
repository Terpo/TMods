package org.terpo.tmods.inventory;

import org.terpo.tmods.tileentity.TileEntityStamper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;

public class ContainerStamper extends Container
{
	private TileEntityStamper	teStamper;
	private int					lastCraftTime;
	private int					lastCraftingTime;
	private int					lastItemCraftTime;

	public ContainerStamper(InventoryPlayer player, TileEntityStamper tileEntityStamper)
	{
		this.teStamper=tileEntityStamper;
		this.addSlotToContainer(new Slot(tileEntityStamper,0,56,17));
		this.addSlotToContainer(new Slot(tileEntityStamper,1,56,53));
		this.addSlotToContainer(new SlotFurnace(player.player,tileEntityStamper,2,116,35));
		
		int i=0;
		for(i=0; i<3; i++)
		{
			for(int j=0; j<9; j++)
			{
				this.addSlotToContainer(new Slot(player,j+i*9 + 9, 8+j*18, 84+i*18));
			}
		}
		
		for(i=0; i<9; i++)
		{
			this.addSlotToContainer(new Slot(player,i,8+i * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting craft)
	{
		super.addCraftingToCrafters(craft);
		craft.sendProgressBarUpdate(this, 0, this.teStamper.stamperCraftTime);
		craft.sendProgressBarUpdate(this, 1, this.teStamper.stamperCraftingTime);
		craft.sendProgressBarUpdate(this, 2, this.teStamper.currentCraftTicks);
	}

	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		for (int i = 0; i < this.crafters.size(); i++)
		{
			ICrafting craft = (ICrafting) this.crafters.get(i);
			if (this.lastCraftTime != this.teStamper.stamperCraftTime)
			{
				craft.sendProgressBarUpdate(this, 0, this.teStamper.stamperCraftTime);
			}

			if (this.lastCraftingTime != this.teStamper.stamperCraftingTime)
			{
				craft.sendProgressBarUpdate(this, 1, this.teStamper.stamperCraftingTime);
			}

			if (this.lastItemCraftTime != this.teStamper.currentCraftTicks)
			{
				craft.sendProgressBarUpdate(this, 2, this.teStamper.currentCraftTicks);
			}
		}
		this.lastCraftTime = this.teStamper.stamperCraftTime;
		this.lastCraftingTime = this.teStamper.stamperCraftingTime;
		this.lastItemCraftTime = this.teStamper.currentCraftTicks;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2)
	{
		if (par1 == 0)
		{
			this.teStamper.stamperCraftTime = par2;
		}

		if (par1 == 1)
		{
			this.teStamper.stamperCraftingTime = par2;
		}
		if (par1 == 2)
		{
			this.teStamper.currentCraftTicks = par2;
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.teStamper.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int par2)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 == 2)
			{
				if (!this.mergeItemStack(itemstack1, 3, 39, true))
					return null;
				slot.onSlotChange(itemstack1, itemstack);
			} 
			else
			{
				if (par2 != 1 && par2 != 0)
				{
					if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
					{
						if (!this.mergeItemStack(itemstack1, 0, 1, false))
							return null;
					} else
					{
						if (teStamper.isItemFuel(itemstack1))
						{
							if (!this.mergeItemStack(itemstack1, 1, 2, false))
								return null;
						} else
						{
							if (par2 >= 3 && par2 < 30)
							{
								if (!this.mergeItemStack(itemstack1, 30, 39, false))
									return null;
							} else
							{
								if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
								{
									return null;
								}
							}
						}
					}
				} 
				else
				{
					if (!this.mergeItemStack(itemstack1, 3, 39, false))
					{
						return null;
					}
				}
			}

			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}
			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}
			slot.onPickupFromSlot(player, itemstack1);
		}
		return itemstack;
	}
}
