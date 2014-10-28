package org.terpo.tmods.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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
		this.blockDoor = ModBlocks.doorGlassStainedWhiteBlock;
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
            	case 0 : this.blockDoor = ModBlocks.doorGlassStainedWhiteBlock; break;
            	case 1 : this.blockDoor = ModBlocks.doorGlassStainedOrangeBlock; break;
            	case 2 : this.blockDoor = ModBlocks.doorGlassStainedMagentaBlock; break;
            	case 3 : this.blockDoor = ModBlocks.doorGlassStainedLightBlueBlock; break;
            	case 4 : this.blockDoor = ModBlocks.doorGlassStainedYellowBlock; break;
            	case 5 : this.blockDoor = ModBlocks.doorGlassStainedLightGreenBlock; break;
            	case 6 : this.blockDoor = ModBlocks.doorGlassStainedPinkBlock; break;
            	case 7 : this.blockDoor = ModBlocks.doorGlassStainedDarkGrayBlock; break;
            	case 8 : this.blockDoor = ModBlocks.doorGlassStainedLightGrayBlock; break;
            	case 9 : this.blockDoor = ModBlocks.doorGlassStainedCyanBlock; break;
            	case 10 : this.blockDoor = ModBlocks.doorGlassStainedPurpleBlock; break;
            	case 11 : this.blockDoor = ModBlocks.doorGlassStainedBlueBlock; break;
            	case 12 : this.blockDoor = ModBlocks.doorGlassStainedBrownBlock; break;
            	case 13 : this.blockDoor = ModBlocks.doorGlassStainedGreenBlock; break;
            	case 14 : this.blockDoor = ModBlocks.doorGlassStainedRedBlock; break;
            	case 15 : this.blockDoor = ModBlocks.doorGlassStainedBlackBlock; break;
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
}
