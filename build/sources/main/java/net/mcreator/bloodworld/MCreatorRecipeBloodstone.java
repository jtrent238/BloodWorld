package net.mcreator.bloodworld;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

public class MCreatorRecipeBloodstone extends bloodworld.ModElement {

	public MCreatorRecipeBloodstone(bloodworld instance) {
		super(instance);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(MCreatorBlockBloodstoneCobble.block, (int) (1)), new ItemStack(MCreatorBlockBloodStone.block,
				(int) (1)), 1F);
	}
}
