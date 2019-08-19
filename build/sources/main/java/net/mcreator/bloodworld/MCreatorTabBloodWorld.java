package net.mcreator.bloodworld;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

public class MCreatorTabBloodWorld extends bloodworld.ModElement {

	public MCreatorTabBloodWorld(bloodworld instance) {
		super(instance);
	}

	public static CreativeTabs tab = new CreativeTabs("tabtabbloodworld") {

		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(MCreatorBlockBloodLog.block, (int) (1));
		}

		@SideOnly(Side.CLIENT)
		public boolean hasSearchBar() {
			return false;
		}
	};
}
