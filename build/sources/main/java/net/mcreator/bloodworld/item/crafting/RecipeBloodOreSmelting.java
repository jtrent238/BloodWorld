
package net.mcreator.bloodworld.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.bloodworld.item.ItemBloodIngot;
import net.mcreator.bloodworld.block.BlockBloodOre;
import net.mcreator.bloodworld.ElementsBloodworldMod;

@ElementsBloodworldMod.ModElement.Tag
public class RecipeBloodOreSmelting extends ElementsBloodworldMod.ModElement {
	public RecipeBloodOreSmelting(ElementsBloodworldMod instance) {
		super(instance, 54);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockBloodOre.block, (int) (1)), new ItemStack(ItemBloodIngot.block, (int) (1)), 2.8F);
	}
}
