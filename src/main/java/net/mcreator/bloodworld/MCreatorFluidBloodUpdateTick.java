package net.mcreator.bloodworld;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import java.util.HashMap;

public class MCreatorFluidBloodUpdateTick extends bloodworld.ModElement {

	public MCreatorFluidBloodUpdateTick(bloodworld instance) {
		super(instance);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorFluidBloodUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorFluidBloodUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorFluidBloodUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorFluidBloodUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == MCreatorFluidBlood.block.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), MCreatorBlockCrustedBlood.block.getDefaultState(), 3);
		}
	}
}
