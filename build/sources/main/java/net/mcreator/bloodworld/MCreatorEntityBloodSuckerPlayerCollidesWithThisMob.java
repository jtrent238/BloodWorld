package net.mcreator.bloodworld;

import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import java.util.HashMap;

public class MCreatorEntityBloodSuckerPlayerCollidesWithThisMob extends bloodworld.ModElement {

	public MCreatorEntityBloodSuckerPlayerCollidesWithThisMob(bloodworld instance) {
		super(instance);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorEntityBloodSuckerPlayerCollidesWithThisMob!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MCreatorPotionBleeding.potion, (int) 6, (int) 1));
	}
}
