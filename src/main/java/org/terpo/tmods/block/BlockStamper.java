package org.terpo.tmods.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.terpo.tmods.TMods;
import org.terpo.tmods.init.ModBlocks;
import org.terpo.tmods.reference.GuiID;
import org.terpo.tmods.reference.Names;
import org.terpo.tmods.reference.Names.Blocks;
import org.terpo.tmods.tileentity.TileEntityStamper;
import org.terpo.tmods.util.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStamper extends BlockContainerTMods
{
	private static boolean 	isWorking;
	private final boolean	isWorking2;

	@SideOnly(Side.CLIENT)
	private IIcon			top;
	private final Random	random	= new Random();

	public BlockStamper(boolean isActive)
	{
		super();
		isWorking = false;
		isWorking2 = isActive;
		this.setBlockName(Names.Blocks.STAMPER);
		this.setBlockTextureName(Names.Blocks.STAMPER);
	}

	public TileEntity createTileEntity(World world, int metadata)
	{
		return new TileEntityStamper();
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister)
	{
		this.blockIcon = iconregister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
		this.top = iconregister.registerIcon(isWorking ? this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "TopActive" : this
				.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "TopInactive");

	}

	public IIcon getIcon(int side, int meta)
	{
		if (side == 1)
			return top;
		return this.blockIcon;
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		player.openGui(TMods.instance, GuiID.STAMPER, world, x, y, z);
		return true;
	}

	public Item getItemDropped(int par1, Random random, int par3)
	{
		return Item.getItemFromBlock(ModBlocks.stamper);
	}

	public Item getItem(World world, int par2, int par3, int par4)
	{
		return Item.getItemFromBlock(ModBlocks.stamper);
	}

	@SideOnly(Side.CLIENT)
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.direction(world, x, y, z);

	}

	private void direction(World world, int x, int y, int z)
	{
		if (!world.isRemote)
		{
			Block direction = world.getBlock(x, y, z - 1);
			Block direction1 = world.getBlock(x, y, z + 1);
			Block direction2 = world.getBlock(x - 1, y, z);
			Block direction3 = world.getBlock(x + 1, y, z);
			byte byte0 = 3;
			// TODO find problems
			if (direction.func_149730_j() && !direction1.func_149730_j())
			{
				byte0 = 3;
			}

			if (direction1.func_149730_j() && direction1.func_149730_j())
			{
				byte0 = 2;
			}

			if (direction2.func_149730_j() && direction2.func_149730_j())
			{
				byte0 = 5;
			}

			if (direction3.func_149730_j() && direction3.func_149730_j())
			{
				byte0 = 4;
			}

			world.setBlockMetadataWithNotify(x, y, z, byte0, 2);
		}

	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack)
	{
		int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		switch (direction)
		{
			case 0:
				world.setBlockMetadataWithNotify(x, y, z, 2, 2);
				break;
			case 1:
				world.setBlockMetadataWithNotify(x, y, z, 5, 2);
				break;
			case 2:
				world.setBlockMetadataWithNotify(x, y, z, 3, 2);
				break;
			case 3:
				world.setBlockMetadataWithNotify(x, y, z, 4, 2);
				break;
			default:
				world.setBlockMetadataWithNotify(x, y, z, 2, 2);
				break;

		}
		if (itemstack.hasDisplayName())
		{
			 ((TileEntityStamper) world.getTileEntity(x, y,z)).stamperName(itemstack.getDisplayName());
		}

	}

	public static void updateBlockState(boolean working, World world, int x, int y, int z)
	{
		int direction = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		isWorking = true; 

		if (working)
		{
			world.setBlock(x, y, z, ModBlocks.stamper); // active stamper
		} else
		{
			world.setBlock(x, y, z, ModBlocks.stamper); // inactive stamper
		}

		isWorking = false; 

		world.setBlockMetadataWithNotify(x, y, z, direction, 2);

		if (tileentity != null)
		{
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity);
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta)
	{
		if (!isWorking)
		{
			TileEntityStamper testamper = (TileEntityStamper) world.getTileEntity(x, y, z);

			if (testamper != null)
			{
				for (int i = 0; i < testamper.getSizeInventory(); i++)

				{
					ItemStack itemstack = testamper.getStackInSlot(i);

					if (itemstack != null)
					{
						float xspread = this.random.nextFloat() * 0.6F + 0.1F; // creates
																				// velocity
																				// to
																				// dropped
																				// EntityItem
						float yspread = this.random.nextFloat() * 0.6F + 0.1F;
						float zspread = this.random.nextFloat() * 0.6F + 0.1F;

						while (itemstack.stackSize > 0)
						{
							int j = this.random.nextInt(21) + 10;

							if (j > itemstack.stackSize)
							{
								j = itemstack.stackSize; // groups items when
															// dropped
							}
							itemstack.stackSize -= j;
							EntityItem entityitem = new EntityItem(world, (double) (float) x + xspread, (double) (float) y + yspread, (double) (float) z
									+ zspread, new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

							if (itemstack.hasTagCompound())
							{
								entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
							}

							float velocity = 0.025F;
							entityitem.motionX = ((double) (float) this.random.nextGaussian() * velocity); // how
																											// the
																											// item
																											// drops
																											// from
																											// te
							entityitem.motionY = ((double) (float) this.random.nextGaussian() * velocity + 0.1F);
							entityitem.motionZ = ((double) (float) this.random.nextGaussian() * velocity);

							world.spawnEntityInWorld(entityitem); // spawns item
																	// in world
						}
					}
				}

				world.func_147453_f(x, y, z, block);
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}

	// Add Particles (howto)
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		if (this.isWorking2)
		{
			int direction = world.getBlockMetadata(x, y, z);
			float xx = (float) x + 0.5F;
			float yy = (float) y + random.nextFloat() * 6.0F / 16.0F;
			float zz = (float) z + 0.5F;
			float xx2 = random.nextFloat() * 0.3F;
			float zz2 = random.nextFloat() * 0.3F;

			switch (direction)
			{
				case 2:
					world.spawnParticle("smoke", (double) xx - zz2, (double) yy, (double) zz + xx2, 0.0F, 0.0F, 0.0F);
					world.spawnParticle("flame", (double) xx - zz2, (double) yy, (double) zz + xx2, 0.0F, 0.0F, 0.0F);
					break;
				case 3:
					world.spawnParticle("smoke", (double) xx - zz2, (double) yy, (double) zz + xx2, 0.0F, 0.0F, 0.0F);
					world.spawnParticle("flame", (double) xx - zz2, (double) yy, (double) zz + xx2, 0.0F, 0.0F, 0.0F);
					break;	
				case 4:
					world.spawnParticle("smoke", (double) xx - zz2, (double) yy, (double) zz + xx2, 0.0F, 0.0F, 0.0F);
					world.spawnParticle("flame", (double) xx - zz2, (double) yy, (double) zz + xx2, 0.0F, 0.0F, 0.0F);
					break;
				case 5:
					world.spawnParticle("smoke", (double) xx - zz2, (double) yy, (double) zz + xx2, 0.0F, 0.0F, 0.0F);
					world.spawnParticle("flame", (double) xx - zz2, (double) yy, (double) zz + xx2, 0.0F, 0.0F, 0.0F);
					break;
			}
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int par2)
	{
		return new TileEntityStamper();
	}

}
