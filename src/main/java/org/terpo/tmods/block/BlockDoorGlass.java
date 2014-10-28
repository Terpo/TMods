package org.terpo.tmods.block;

import java.util.Random;

import org.terpo.tmods.creativetab.CreativeTabTMods;
import org.terpo.tmods.init.ModItems;
import org.terpo.tmods.reference.Names;
import org.terpo.tmods.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockDoorGlass extends BlockTModsDoors
{

	public BlockDoorGlass()
	{
		super(Material.glass);
		this.setCreativeTab(CreativeTabTMods.TMods_TAB);
		this.setBlockName(Names.Blocks.DOORGLASSBLOCK);
		this.setBlockTextureName(Names.Blocks.DOORGLASSBLOCK);
		this.setHardness(2.0f);
		this.setHarvestLevel("pickaxe", 1);
	}

	@Override
	public Item getItemDropped(int metadata, Random rand,int fortune)
	{
		return (metadata & 8) != 0 ? null : ModItems.doorGlassItem;
	}
	
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

}
