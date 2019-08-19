package net.mcreator.bloodworld;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.Minecraft;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class MCreatorPotionBleeding extends bloodworld.ModElement {

	@GameRegistry.ObjectHolder("bloodworld:potionbleeding")
	public static final Potion potion = null;

	public MCreatorPotionBleeding(bloodworld instance) {
		super(instance);
		instance.potions.add(() -> new PotionCustom());
	}

	public static class PotionCustom extends Potion {

		private final ResourceLocation potionIcon;

		public PotionCustom() {
			super(true, -1);
			setRegistryName("potionbleeding");
			setPotionName("effect.potionbleeding");
			potionIcon = new ResourceLocation("bloodworld:textures/itemblooddrop.png");
		}

		@Override
		public boolean isInstant() {
			return false;
		}

		@Override
		public List<ItemStack> getCurativeItems() {
			List<ItemStack> ret = new ArrayList<>();
			ret.add(new ItemStack(MCreatorItemBandage.block, (int) (1)));
			return ret;
		}

		@Override
		public boolean shouldRenderInvText(PotionEffect effect) {
			return true;
		}

		@Override
		public boolean shouldRenderHUD(PotionEffect effect) {
			return true;
		}

		@Override
		public void performEffect(EntityLivingBase entity, int amplifier) {
			World world = entity.world;
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				MCreatorPotionBleedingOnPotionActiveTick.executeProcedure($_dependencies);
			}
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
			if (mc.currentScreen != null) {
				mc.getTextureManager().bindTexture(potionIcon);
				Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
			}
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
			mc.getTextureManager().bindTexture(potionIcon);
			Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
