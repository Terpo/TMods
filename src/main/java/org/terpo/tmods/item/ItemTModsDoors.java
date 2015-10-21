package org.terpo.tmods.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.terpo.tmods.init.ModBlocks;
import org.terpo.tmods.reference.Names;

public class ItemTModsDoors extends ItemTMods
{
		public Block blockDoor = ModBlocks.doorGlass;
		
		public ItemTModsDoors(){
			super();
			this.maxStackSize = 16;
		}
		
		public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	    {
	        if (par7 != 1)
	        {
	            return false;
	        }
	        else
	        {
	            ++par5;
	            
	            if (player.canPlayerEdit(par4, par5, par6, par7, itemStack) && player.canPlayerEdit(par4, par5 + 1, par6, par7, itemStack))
	            {
	                if (!blockDoor.canPlaceBlockAt(world, par4, par5, par6))
	                {
	                    return false;
	                }
	                else
	                {
	                    int i1 = MathHelper.floor_double((double)((player.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
	                    placeDoorBlock(world, par4, par5, par6, i1, blockDoor);
	                    --itemStack.stackSize;
	                    return true;
	                }
	            }
	            else
	            {
	                return false;
	            }
	        }
	    }

	    public static void placeDoorBlock(World world, int x, int y, int z, int rotate, Block block)
	    {

	    	
	        byte b0 = 0;
	        byte b1 = 0;

	        if (rotate == 0)
	        {
	            b1 = 1;
	        }

	        if (rotate == 1)
	        {
	            b0 = -1;
	        }

	        if (rotate == 2)
	        {
	            b1 = -1;
	        }

	        if (rotate == 3)
	        {
	            b0 = 1;
	        }

	        int i1 = (world.getBlock(x - b0, y, z - b1).isNormalCube() ? 1 : 0) + (world.getBlock(x - b0, y + 1, z - b1).isNormalCube() ? 1 : 0);
	        int j1 = (world.getBlock(x + b0, y, z + b1).isNormalCube() ? 1 : 0) + (world.getBlock(x + b0, y + 1, z + b1).isNormalCube() ? 1 : 0);
	        boolean flag = world.getBlock(x - b0, y, z - b1) == block || world.getBlock(x - b0, y + 1, z - b1) == block;
	        boolean flag1 = world.getBlock(x + b0, y, z + b1) == block || world.getBlock(x + b0, y + 1, z + b1) == block;
	        boolean flag2 = false;

	        if (flag && !flag1)
	        {
	            flag2 = true;
	        }
	        else if (j1 > i1)
	        {
	            flag2 = true;
	        }

	        world.setBlock(x, y, z, block, rotate, 2);
	        world.setBlock(x, y + 1, z, block, 8 | (flag2 ? 1 : 0), 2);
	        world.notifyBlocksOfNeighborChange(x, y, z, block);
	        world.notifyBlocksOfNeighborChange(x, y + 1, z, block);
	    }
	
}
