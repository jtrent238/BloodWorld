package net.mcreator.bloodworld.procedure;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.bloodworld.ElementsBloodworldMod;
import net.mcreator.bloodworld.BloodworldModVariables;

import java.util.Map;

@ElementsBloodworldMod.ModElement.Tag
public class ProcedurePotionBleedingOnPotionActiveTick extends ElementsBloodworldMod.ModElement {
	public ProcedurePotionBleedingOnPotionActiveTick(ElementsBloodworldMod instance) {
		super(instance, 21);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PotionBleedingOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 0.5);
		BloodworldModVariables.isBleeding = (boolean) (true);
		if (entity instanceof EntityPlayer && !entity.world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Your bleading... Use a bandage to stop the bleading."), (true));
		}
	}
}
