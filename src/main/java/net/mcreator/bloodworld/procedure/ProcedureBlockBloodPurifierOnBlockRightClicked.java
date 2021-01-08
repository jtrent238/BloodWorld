package net.mcreator.bloodworld.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.bloodworld.gui.GuiGUIBloodPurifier;
import net.mcreator.bloodworld.ElementsBloodworldMod;
import net.mcreator.bloodworld.BloodworldMod;

import java.util.Map;

@ElementsBloodworldMod.ModElement.Tag
public class ProcedureBlockBloodPurifierOnBlockRightClicked extends ElementsBloodworldMod.ModElement {
	public ProcedureBlockBloodPurifierOnBlockRightClicked(ElementsBloodworldMod instance) {
		super(instance, 42);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BlockBloodPurifierOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BlockBloodPurifierOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BlockBloodPurifierOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BlockBloodPurifierOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BlockBloodPurifierOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).openGui(BloodworldMod.instance, GuiGUIBloodPurifier.GUIID, world, x, y, z);
	}
}
