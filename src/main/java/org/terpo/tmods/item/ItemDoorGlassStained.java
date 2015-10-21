package org.terpo.tmods.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.terpo.tmods.init.ModBlocks;
import org.terpo.tmods.reference.Names;
import org.terpo.tmods.reference.Reference;
import org.terpo.tmods.util.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemDoorGlassStained extends ItemTModsDoors
{
	private IIcon[] dooricon; 
	public ItemDoorGlassStained()
	{
		super();
		this.maxStackSize = 16;
		setUnlocalizedName(Names.Items.DOORGLASSSTAINEDITEM);
		this.blockDoor = ModBlocks.doorGlassStainedWhite;
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int damageValue)
	{
		return damageValue;
	}
	

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		String name = "";

		switch (itemStack.getItemDamage())
		{
			case 0:
			{
				name = Names.Colors.COLORS[0];
				break;
			}
			case 1:
			{
				name = Names.Colors.COLORS[1];
				break;
			}
			case 2:
			{
				name = Names.Colors.COLORS[2];
				break;
			}
			case 3:
			{
				name = Names.Colors.COLORS[3];
				break;
			}
			case 4:
			{
				name = Names.Colors.COLORS[4];
				break;
			}
			case 5:
			{
				name = Names.Colors.COLORS[5];
				break;
			}
			case 6:
			{
				name = Names.Colors.COLORS[6];
				break;
			}
			case 7:
			{
				name = Names.Colors.COLORS[7];
				break;
			}
			case 8:
			{
				name = Names.Colors.COLORS[8];
				break;
			}
			case 9:
			{
				name = Names.Colors.COLORS[9];
				break;
			}
			case 10:
			{
				name = Names.Colors.COLORS[10];
				break;
			}
			case 11:
			{
				name = Names.Colors.COLORS[11];
				break;
			}
			case 12:
			{
				name = Names.Colors.COLORS[12];
				break;
			}
			case 13:
			{
				name = Names.Colors.COLORS[13];
				break;
			}
			case 14:
			{
				name = Names.Colors.COLORS[14];
				break;
			}
			case 15:
			{
				name = Names.Colors.COLORS[15];
				break;
			}
			default:
				name = Names.Colors.COLORS[0];
		}
		//LogHelper.info(super.getUnlocalizedName());
		//LogHelper.info(getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
		//LogHelper.info(String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":",
		//		getUnwrappedUnlocalizedName(super.getUnlocalizedName())));
		return super.getUnlocalizedName()+"_"+name;
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float clickx, float clicky, float clickz)
    {
		
        if (side != 1)
        {
            return false;
        }
        else
        {
            ++y;
            
            
            switch(itemStack.getItemDamage())
            {
            	case 0 : this.blockDoor = ModBlocks.doorGlassStainedWhite; break;
            	case 1 : this.blockDoor = ModBlocks.doorGlassStainedOrange; break;
            	case 2 : this.blockDoor = ModBlocks.doorGlassStainedMagenta; break;
            	case 3 : this.blockDoor = ModBlocks.doorGlassStainedLightBlue; break;
            	case 4 : this.blockDoor = ModBlocks.doorGlassStainedYellow; break;
            	case 5 : this.blockDoor = ModBlocks.doorGlassStainedLightGreen; break;
            	case 6 : this.blockDoor = ModBlocks.doorGlassStainedPink; break;
            	case 7 : this.blockDoor = ModBlocks.doorGlassStainedDarkGray; break;
            	case 8 : this.blockDoor = ModBlocks.doorGlassStainedLightGray; break;
            	case 9 : this.blockDoor = ModBlocks.doorGlassStainedCyan; break;
            	case 10 : this.blockDoor = ModBlocks.doorGlassStainedPurple; break;
            	case 11 : this.blockDoor = ModBlocks.doorGlassStainedBlue; break;
            	case 12 : this.blockDoor = ModBlocks.doorGlassStainedBrown; break;
            	case 13 : this.blockDoor = ModBlocks.doorGlassStainedGreen; break;
            	case 14 : this.blockDoor = ModBlocks.doorGlassStainedRed; break;
            	case 15 : this.blockDoor = ModBlocks.doorGlassStainedBlack; break;
            	default : this.blockDoor = Blocks.wooden_door; break;
            }
            if (player.canPlayerEdit(x, y, z, side, itemStack) && player.canPlayerEdit(x, y + 1, z, side, itemStack))
            {
                if (!blockDoor.canPlaceBlockAt(world, x, y, z))
                {
                    return false;
                }
                else
                {
                    int i1 = MathHelper.floor_double((double)((player.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
                    placeDoorBlock(world, x, y, z, i1, blockDoor);
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.dooricon = new IIcon[16];
		for(int i = 0; i<this.dooricon.length;i++)
			dooricon[i] = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1)+"_"+Names.Colors.COLORS[i]);
	}
	
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.dooricon[meta];
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
        return this.dooricon[meta];
    }
    

	@Override
	public void getSubItems (Item id, CreativeTabs tab, List list)
	{
		for (int i = 0; i < Names.Colors.COLORS.length; i++)
			list.add(new ItemStack(id, 1, i));
	}
}
