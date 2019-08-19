package net.mcreator.bloodworld;

import net.minecraft.item.ItemStack;

public class MCreatorFuelBlood extends bloodworld.ModElement {

	public MCreatorFuelBlood(bloodworld instance) {
		super(instance);
	}

	@Override
	public int addFuel(ItemStack fuel) {
		if (fuel.getItem() == new ItemStack(MCreatorItemDropOfBlood.block, (int) (1)).getItem())
			return 2000;
		return 0;
	}
}
