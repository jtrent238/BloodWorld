
package net.mcreator.bloodworld.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.bloodworld.block.BlockBlockBloodstoneCobble;
import net.mcreator.bloodworld.block.BlockBlockBloodStone;
import net.mcreator.bloodworld.ElementsBloodworldMod;

@ElementsBloodworldMod.ModElement.Tag
public class RecipeRecipeBloodstone extends ElementsBloodworldMod.ModElement {
	public RecipeRecipeBloodstone(ElementsBloodworldMod instance) {
		super(instance, 36);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockBlockBloodstoneCobble.block, (int) (1)), new ItemStack(BlockBlockBloodStone.block, (int) (1)),
				0F);
	}
}
