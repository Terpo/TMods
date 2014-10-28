package org.terpo.tmods.gui;

import org.lwjgl.opengl.GL11;
import org.terpo.tmods.inventory.ContainerStamper;
import org.terpo.tmods.tileentity.TileEntityStamper;

import com.google.common.collect.ObjectArrays;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)	
public class GuiStamper extends GuiContainer
{

	private static final ResourceLocation stamperGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");
	private TileEntityStamper teStamper;
	
	public GuiStamper(InventoryPlayer invPlayer, TileEntityStamper tile)
	{
		super(new ContainerStamper(invPlayer, tile));
		this.teStamper = tile;
	}
	
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		String string;
		if(this.teStamper.hasCustomInventoryName())
		{
			string = this.teStamper.getInventoryName();
		}
		else
		{
			string = I18n.format(this.teStamper.getInventoryName(), new Object[0]);
		}
		this.fontRendererObj.drawString(string, this.xSize / 2 - this.fontRendererObj.getStringWidth(string), 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1,int par2, int par3)
	{
		GL11.glColor4f(1.0F,1.0F,1.0F,1.0F);
		this.mc.getTextureManager().bindTexture(stamperGuiTextures);
		int k = (this.width - xSize) / 2;
		int l = (this.height - ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;
		if(this.teStamper.isCrafting())
		{
			i1 = this.teStamper.getCraftTimeRemainingScaled(12);
			this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14 , i1 + 2);
		}
		
		i1 = this.teStamper.getCraftProgressScaled(24);
		this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
				
	}
	
	
}
