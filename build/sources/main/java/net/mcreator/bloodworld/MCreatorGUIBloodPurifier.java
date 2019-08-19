package net.mcreator.bloodworld;

import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Keyboard;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.GuiButton;

import java.util.HashMap;

public class MCreatorGUIBloodPurifier extends bloodworld.ModElement {

	public static int GUIID = 1;
	public static HashMap guiinventory = new HashMap();
	public static IInventory inventoryPurifer;
	public static IInventory inherited;

	public MCreatorGUIBloodPurifier(bloodworld instance) {
		super(instance);
	}

	public static class GuiContainerMod extends Container {

		World world;
		EntityPlayer entity;
		int x, y, z;

		public GuiContainerMod(World world, int x, int y, int z, EntityPlayer player) {
			this.world = world;
			this.entity = player;
			this.x = x;
			this.y = y;
			this.z = z;
			TileEntity ent = world.getTileEntity(new BlockPos(x, y, z));
			if (ent instanceof MCreatorBlockBloodPurifier.TileEntityCustom)
				inherited = (IInventory) ent;
			else
				inherited = new InventoryBasic("", true, 9);
			inventoryPurifer = new InventoryBasic("inventoryPurifer", true, 9);
			guiinventory.put("inventoryPurifer", inventoryPurifer);
			this.addSlotToContainer(new Slot(inventoryPurifer, 0, 17, 12) {
			});
			this.addSlotToContainer(new Slot(inventoryPurifer, 1, 35, 12) {
			});
			this.addSlotToContainer(new Slot(inventoryPurifer, 2, 53, 12) {
			});
			this.addSlotToContainer(new Slot(inventoryPurifer, 3, 17, 30) {
			});
			this.addSlotToContainer(new Slot(inventoryPurifer, 4, 35, 30) {
			});
			this.addSlotToContainer(new Slot(inventoryPurifer, 5, 53, 30) {
			});
			this.addSlotToContainer(new Slot(inventoryPurifer, 6, 107, 12) {

				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			});
			this.addSlotToContainer(new Slot(inventoryPurifer, 7, 125, 12) {

				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			});
			this.addSlotToContainer(new Slot(inventoryPurifer, 8, 143, 12) {

				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			});
			this.addSlotToContainer(new Slot(inventoryPurifer, 9, 107, 30) {

				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			});
			this.addSlotToContainer(new Slot(inventoryPurifer, 10, 125, 30) {

				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			});
			this.addSlotToContainer(new Slot(inventoryPurifer, 11, 143, 30) {

				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			});
			int si;
			int sj;
			for (si = 0; si < 3; ++si)
				for (sj = 0; sj < 9; ++sj)
					this.addSlotToContainer(new Slot(player.inventory, sj + (si + 1) * 9, 0 + 8 + sj * 18, 0 + 84 + si * 18));
			for (si = 0; si < 9; ++si)
				this.addSlotToContainer(new Slot(player.inventory, si, 0 + 8 + si * 18, 0 + 142));
		}

		@Override
		public boolean canInteractWith(EntityPlayer player) {
			return true;
		}

		@Override
		public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
			ItemStack itemstack = ItemStack.EMPTY;
			Slot slot = (Slot) this.inventorySlots.get(index);
			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();
				if (index < 12) {
					if (!this.mergeItemStack(itemstack1, 12, this.inventorySlots.size(), true)) {
						return ItemStack.EMPTY;
					}
				} else if (!this.mergeItemStack(itemstack1, 0, 12, false)) {
					if (index < 12 + 27) {
						if (!this.mergeItemStack(itemstack1, 12 + 27, this.inventorySlots.size(), true)) {
							return ItemStack.EMPTY;
						}
					} else {
						if (!this.mergeItemStack(itemstack1, 12, 12 + 27, false)) {
							return ItemStack.EMPTY;
						}
					}
					return ItemStack.EMPTY;
				}
				if (itemstack1.getCount() == 0) {
					slot.putStack(ItemStack.EMPTY);
				} else {
					slot.onSlotChanged();
				}
				if (itemstack1.getCount() == itemstack.getCount()) {
					return ItemStack.EMPTY;
				}
				slot.onTake(playerIn, itemstack1);
			}
			return itemstack;
		}

		@Override
		public boolean mergeItemStack(ItemStack itemstack, int from, int to, boolean reverse) {
			boolean mergeResult = false;
			int i = reverse ? to - 1 : from;
			int order = reverse ? -1 : 1;
			if (itemstack.isStackable()) {
				while ((!reverse && i < to || reverse && i >= from) && itemstack.getCount() > 0) {
					Slot slot = this.inventorySlots.get(i);
					ItemStack currstack = slot.getStack();
					if (!currstack.isEmpty()) {
						int maxsize = Math.min(slot.getSlotStackLimit(), itemstack.getMaxStackSize());
						int amount = Math.min(maxsize, itemstack.getCount());
						ItemStack reducedstack = itemstack.copy();
						reducedstack.setCount(amount);
						if (slot.isItemValid(reducedstack) && currstack.getItem().equals(itemstack.getItem())
								&& (!itemstack.getHasSubtypes() || itemstack.getItemDamage() == currstack.getItemDamage())
								&& ItemStack.areItemStackTagsEqual(itemstack, currstack)) {
							int currsize = currstack.getCount() + itemstack.getCount();
							if (currsize <= maxsize) {
								itemstack.setCount(0);
								currstack.setCount(currsize);
								slot.putStack(currstack);
								mergeResult = true;
							} else if (currstack.getCount() < maxsize) {
								itemstack.shrink(maxsize - currstack.getCount());
								currstack.setCount(maxsize);
								slot.putStack(currstack);
								mergeResult = true;
							}
						}
					}
					i += order;
				}
			}
			if (itemstack.getCount() > 0) {
				i = reverse ? to - 1 : from;
				while ((!reverse && i < to || reverse && i >= from) && itemstack.getCount() > 0) {
					Slot slot = this.inventorySlots.get(i);
					ItemStack currstack = slot.getStack();
					if (currstack.isEmpty()) {
						int maxsize = Math.min(slot.getSlotStackLimit(), itemstack.getMaxStackSize());
						int amount = Math.min(maxsize, itemstack.getCount());
						ItemStack reducedstack = itemstack.copy();
						reducedstack.setCount(amount);
						if (slot.isItemValid(reducedstack)) {
							currstack = itemstack.splitStack(amount);
							slot.putStack(currstack);
							mergeResult = true;
						}
					}
					i += order;
				}
			}
			return mergeResult;
		}

		public void onContainerClosed(EntityPlayer playerIn) {
			super.onContainerClosed(playerIn);
		}
	}

	public static class GuiWindow extends GuiContainer {

		World world;
		int x, y, z;
		EntityPlayer entity;

		public GuiWindow(World world, int x, int y, int z, EntityPlayer entity) {
			super(new GuiContainerMod(world, x, y, z, entity));
			this.world = world;
			this.x = x;
			this.y = y;
			this.z = z;
			this.entity = entity;
			this.xSize = 176;
			this.ySize = 166;
		}

		private static final ResourceLocation texture = new ResourceLocation("bloodworld:textures/guibloodpurifier.png");

		@Override
		public void drawScreen(int mouseX, int mouseY, float partialTicks) {
			this.drawDefaultBackground();
			super.drawScreen(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.mc.renderEngine.bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
			zLevel = 100.0F;
		}

		@Override
		protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
			try {
				super.mouseClicked(mouseX, mouseY, mouseButton);
			} catch (Exception ignored) {
			}
		}

		@Override
		public void updateScreen() {
			super.updateScreen();
		}

		@Override
		protected void keyTyped(char typedChar, int keyCode) {
			try {
				super.keyTyped(typedChar, keyCode);
			} catch (Exception ignored) {
			}
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		}

		@Override
		public void onGuiClosed() {
			super.onGuiClosed();
			Keyboard.enableRepeatEvents(false);
		}

		@Override
		public void initGui() {
			super.initGui();
			this.guiLeft = (this.width - 176) / 2;
			this.guiTop = (this.height - 166) / 2;
			Keyboard.enableRepeatEvents(true);
			this.buttonList.clear();
		}

		@Override
		protected void actionPerformed(GuiButton button) {
			MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
			World world = server.getWorld(entity.dimension);
		}

		@Override
		public boolean doesGuiPauseGame() {
			return false;
		}
	}
}
