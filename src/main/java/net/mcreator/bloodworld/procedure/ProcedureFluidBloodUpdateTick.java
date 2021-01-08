package net.mcreator.bloodworld.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import net.mcreator.bloodworld.block.BlockFluidBlood;
import net.mcreator.bloodworld.block.BlockBlockCrustedBlood;
import net.mcreator.bloodworld.ElementsBloodworldMod;

import java.util.Map;

@ElementsBloodworldMod.ModElement.Tag
public class ProcedureFluidBloodUpdateTick extends ElementsBloodworldMod.ModElement {
	public ProcedureFluidBloodUpdateTick(ElementsBloodworldMod instance) {
		super(instance, 30);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FluidBloodUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FluidBloodUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FluidBloodUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FluidBloodUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockFluidBlood.block.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockBlockCrustedBlood.block.getDefaultState(), 3);
		}
	}
}
