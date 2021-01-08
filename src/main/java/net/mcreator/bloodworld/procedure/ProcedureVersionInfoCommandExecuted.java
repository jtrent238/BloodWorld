package net.mcreator.bloodworld.procedure;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.bloodworld.ElementsBloodworldMod;
import net.mcreator.bloodworld.BloodworldMod;

import java.util.Map;

@ElementsBloodworldMod.ModElement.Tag
public class ProcedureVersionInfoCommandExecuted extends ElementsBloodworldMod.ModElement {
	public ProcedureVersionInfoCommandExecuted(ElementsBloodworldMod instance) {
		super(instance, 81);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure VersionInfoCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer && !entity.world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString("You are running version " + BloodworldMod.VERSION), (false));
		}
	}
}
