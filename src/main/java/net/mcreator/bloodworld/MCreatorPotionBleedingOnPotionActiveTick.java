package net.mcreator.bloodworld;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.HashMap;

public class MCreatorPotionBleedingOnPotionActiveTick extends bloodworld.ModElement {

	public MCreatorPotionBleedingOnPotionActiveTick(bloodworld instance) {
		super(instance);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorPotionBleedingOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorPotionBleedingOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 0.5);
		if (entity instanceof EntityPlayer && !world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Your bleading... Use a bandage to stop the bleading."), (true));
		}
		bloodworldVariables.isBleeding = (boolean) (true);
	}
}
