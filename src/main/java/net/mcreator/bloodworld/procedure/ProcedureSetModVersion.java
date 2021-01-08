package net.mcreator.bloodworld.procedure;

import net.minecraft.world.World;

import net.mcreator.bloodworld.ElementsBloodworldMod;
import net.mcreator.bloodworld.BloodworldModVariables;
import net.mcreator.bloodworld.BloodworldMod;

import java.util.Map;

@ElementsBloodworldMod.ModElement.Tag
public class ProcedureSetModVersion extends ElementsBloodworldMod.ModElement {
	public ProcedureSetModVersion(ElementsBloodworldMod instance) {
		super(instance, 82);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SetModVersion!");
			return;
		}
		World world = (World) dependencies.get("world");
		BloodworldModVariables.MapVariables.get(world).MOD_VERSION = (String) BloodworldMod.VERSION;
		BloodworldModVariables.MapVariables.get(world).syncData(world);
	}
}
