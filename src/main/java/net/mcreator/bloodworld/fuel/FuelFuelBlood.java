
package net.mcreator.bloodworld.fuel;

import net.minecraft.item.ItemStack;

import net.mcreator.bloodworld.item.ItemItemDropOfBlood;
import net.mcreator.bloodworld.ElementsBloodworldMod;

@ElementsBloodworldMod.ModElement.Tag
public class FuelFuelBlood extends ElementsBloodworldMod.ModElement {
	public FuelFuelBlood(ElementsBloodworldMod instance) {
		super(instance, 31);
	}

	@Override
	public int addFuel(ItemStack fuel) {
		if (fuel.getItem() == new ItemStack(ItemItemDropOfBlood.block, (int) (1)).getItem())
			return 2000;
		return 0;
	}
}
