package org.terpo.tmods.tileentity;

import org.terpo.tmods.block.BlockStamper;
import org.terpo.tmods.init.ModItems;
import org.terpo.tmods.reference.Names;
import org.terpo.tmods.util.LogHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityStamper extends TileEntityTMods implements ISidedInventory
// ISidedInventory is for automation purposes
{
	public static final int		craftTicks			= 128;
	public int					stamperCraftingTime;					// how long the Crafter can Craft from an specific item (not really needed)
	public int					currentCraftTicks	= 0;
	public int					stamperCraftTime;						// how long a item is in the stamper

	public static final int		updateTicks			= 16;

	public static final int[]	slotsTop			= new int[]
													{ 0 };
	public static final int[]	slotsButtom			= new int[]
													{ 2, 1 };
	public static final int[]	slotsSides			= new int[]
													{ 1 };

	private ItemStack[]			stamperItemStacks	= new ItemStack[3]; // 0 -> FUEl | 1 -> CRAFT | 2 -> OUTPUT
	private String				stamperName;

	public int					nbttest;

	public void stamperName(String string){
		this.stamperName = string;
	}
	

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);

		nbt.setShort("CraftTime", (short) this.stamperCraftingTime);
		nbt.setShort("CraftingTime", (short) this.stamperCraftingTime);
		NBTTagList taglist = new NBTTagList();
		for (int i = 0; i < this.stamperItemStacks.length; i++)
		{
			if (this.stamperItemStacks[i] != null)
			{
				NBTTagCompound tagCompound = new NBTTagCompound();
				tagCompound.setByte("Slot", (byte) i);
				this.stamperItemStacks[i].writeToNBT(tagCompound);
				taglist.appendTag(tagCompound);
			}
		}

		nbt.setTag("Items", taglist);
		if (this.hasCustomInventoryName())
		{
			nbt.setString("CostumName", this.stamperName);
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);

		// get a taglist of the nbtcompound
		NBTTagList taglist = nbt.getTagList("Items", 10);

		this.stamperItemStacks = new ItemStack[this.getSizeInventory()];
		for (int i = 0; i < taglist.tagCount(); i++)
		{
			NBTTagCompound tagCompound = taglist.getCompoundTagAt(i);
			byte slot = tagCompound.getByte("Slot");

			if (slot >= 0 && slot < this.stamperItemStacks.length)
			{
				this.stamperItemStacks[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
			}
		}

		this.stamperCraftingTime = nbt.getShort("CraftingTime");
		this.stamperCraftTime = nbt.getShort("CraftTime");

		this.currentCraftTicks = getItemCraftingTime(this.stamperItemStacks[1]); // how much ticks is the itemstack in slot 1

		if (nbt.hasKey("CustomName", 8))
		{
			this.stamperName = nbt.getString("CustomName"); // read stamper name from NBT
		}
		// this.nbttest = nbt.getInteger("nbttest");
		// LogHelper.info("NBTread");
		// LogHelper.info(this.nbttest);
	}

	@SideOnly(Side.CLIENT)
	public int getCraftProgressScaled(int time)
	{
		return this.stamperCraftTime * time / 200;
	}

	@SideOnly(Side.CLIENT)
	public int getCraftTimeRemainingScaled(int time)
	{
		if (this.currentCraftTicks == 0)
		{
			this.currentCraftTicks = 200;
		}
		return this.stamperCraftingTime * time / this.currentCraftTicks;
	}

	public boolean isCrafting()
	{
		return this.stamperCraftingTime > 0;
	}

	public void updateEntity()
	{
		boolean flagCrafting = this.stamperCraftingTime > 0;
		boolean flag1 = false;

		if (this.stamperCraftingTime > 0)
			--this.stamperCraftingTime;

		if (!this.worldObj.isRemote) // this.worldObj.isRemote -> true when client world
		{
			if (this.stamperCraftingTime == 0 && this.canCraft())
			{
				this.currentCraftTicks = this.stamperCraftingTime = getItemCraftingTime(this.stamperItemStacks[1]);

				if (this.stamperCraftingTime > 0)
				{
					flag1 = true;
					if (this.stamperItemStacks[1] != null)
					{
						--this.stamperItemStacks[1].stackSize; // decrease stacksize

						if (this.stamperItemStacks[1].stackSize == 0)
						{
							this.stamperItemStacks[1] = this.stamperItemStacks[1].getItem().getContainerItem(this.stamperItemStacks[1]);
						}
					}
				}
			}

			if (this.isCrafting() && this.canCraft())
			{
				++this.stamperCraftTime;
				if (this.stamperCraftTime == 200)
				{
					this.stamperCraftTime = 0;
					this.craftItem();
					flag1 = true;
				}
			} else
			{
				this.stamperCraftTime = 0;
			}
		}

		if (flagCrafting != this.stamperCraftingTime > 0)
		{
			flag1 = true;
			BlockStamper.updateBlockState(this.stamperCraftingTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}
		if (flag1)
		{
			this.markDirty();
		}

	}

	public boolean canCraft() // TODO set always to true, check RF State
	{
		if (this.stamperItemStacks[0] == null)
		{
			return false;
		} else
		{
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.stamperItemStacks[0]);
			if (itemstack == null)
				return false;
			if (this.stamperItemStacks[2] == null) // IMPORTANT
				return true;
			if (!this.stamperItemStacks[2].isItemEqual(itemstack))
				return false;

			int result = this.stamperItemStacks[2].stackSize + itemstack.stackSize;
			return result <= getInventoryStackLimit() && result <= this.stamperItemStacks[2].getMaxStackSize();
		}
	}

	public void craftItem()
	{
		if (this.canCraft())
		{
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.stamperItemStacks[0]);
			if (this.stamperItemStacks[2] == null)
			{
				this.stamperItemStacks[2] = itemstack.copy();
			} else if (this.stamperItemStacks[2].getItem() == itemstack.getItem())
			{
				this.stamperItemStacks[2].stackSize += itemstack.stackSize;
			}
			
			-- this.stamperItemStacks[0].stackSize;
			if(this.stamperItemStacks[0].stackSize <=0)
			{
				this.stamperItemStacks[0] = null;
			}
		}
	}

	public static int getItemCraftingTime(ItemStack itemstack)
	{
		if (itemstack == null)
			return 0;
		else
		{
			Item item = itemstack.getItem();

			if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
			{
				Block block = Block.getBlockFromItem(item);

				if (block == Blocks.dirt)
					return 200;
				if (block.getMaterial() == Material.wood)
					return 500;
			}

			if (item == ModItems.paperShovel)
			{
				return 1600;
			}

			if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("EMERALD"))
			{
				return 300;
			}
			return GameRegistry.getFuelValue(itemstack);
		}
	}

	public static boolean isItemFuel(ItemStack itemstack)
	{
		return getItemCraftingTime(itemstack) > 0;
	}

	// ISidedInventoryMethods
	@Override
	public int getSizeInventory()
	{
		return this.stamperItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot)
	{
		return this.stamperItemStacks[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int stacksize)
	{
		if (this.stamperItemStacks[slot] != null)
		{
			ItemStack itemstack;
			if (this.stamperItemStacks[slot].stackSize <= stacksize)
			{
				itemstack = this.stamperItemStacks[slot];
				this.stamperItemStacks[slot] = null;
				return itemstack;
			} else
			{
				itemstack = this.stamperItemStacks[slot].splitStack(stacksize);
				if (this.stamperItemStacks[slot].stackSize == 0)
					this.stamperItemStacks[slot] = null;
				return itemstack;
			}

		} else
		{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		if (this.stamperItemStacks[slot] != null)
		{
			ItemStack itemstack = this.stamperItemStacks[slot];
			this.stamperItemStacks[slot] = null;
			return itemstack;
		} else
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack)
	{
		this.stamperItemStacks[slot] = itemstack;

		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
		{
			itemstack.stackSize = this.getInventoryStackLimit();
		}

	}

	@Override
	public String getInventoryName()
	{
		if (this.hasCustomInventoryName())
			return this.stamperName;
		else
			return Names.Blocks.STAMPER;

	}

	@Override
	public boolean hasCustomInventoryName()
	{
		if (this.stamperName != null && this.stamperName.length() > 0)
			return true;
		else
			return false;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this)
			return false;
		else
			return player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;

	}

	@Override
	public void openInventory()
	{

	}

	@Override
	public void closeInventory()
	{

	}

	@Override
	public boolean isItemValidForSlot(int side, ItemStack itemstack)
	{
		if (side == 2)
			return false;
		else
		{
			if (side == 1)
				return isItemFuel(itemstack);
			else
				return true;
		}

	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) // for automation
	{
		if (side == 0)
			return this.slotsButtom;
		else if (side == 1)
			return this.slotsTop;
		else
			return this.slotsSides;
	}

	@Override
	public boolean canInsertItem(int side, ItemStack itemstack, int par3) // for automation
	{

		return this.isItemValidForSlot(side, itemstack);
	}

	@Override
	public boolean canExtractItem(int par1, ItemStack itemstack, int par3)
	{
		return (par3 != 0 || par1 != 1 || itemstack.getItem() == Items.bucket);
	}

}
