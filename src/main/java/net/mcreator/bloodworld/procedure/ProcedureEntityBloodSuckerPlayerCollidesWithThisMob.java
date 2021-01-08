package net.mcreator.bloodworld.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.bloodworld.potion.PotionPotionBleeding;
import net.mcreator.bloodworld.ElementsBloodworldMod;

import java.util.Map;

@ElementsBloodworldMod.ModElement.Tag
public class ProcedureEntityBloodSuckerPlayerCollidesWithThisMob extends ElementsBloodworldMod.ModElement {
	public ProcedureEntityBloodSuckerPlayerCollidesWithThisMob(ElementsBloodworldMod instance) {
		super(instance, 23);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure EntityBloodSuckerPlayerCollidesWithThisMob!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionPotionBleeding.potion, (int) 6, (int) 1));
	}
}
