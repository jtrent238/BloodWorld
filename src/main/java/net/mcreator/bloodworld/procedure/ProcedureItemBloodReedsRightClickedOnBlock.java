package net.mcreator.bloodworld.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.entity.item.EntityItem;

import net.mcreator.bloodworld.block.BlockPlantBloodReeds;
import net.mcreator.bloodworld.ElementsBloodworldMod;

import java.util.Map;

@ElementsBloodworldMod.ModElement.Tag
public class ProcedureItemBloodReedsRightClickedOnBlock extends ElementsBloodworldMod.ModElement {
	public ProcedureItemBloodReedsRightClickedOnBlock(ElementsBloodworldMod instance) {
		super(instance, 46);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ItemBloodReedsRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ItemBloodReedsRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ItemBloodReedsRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ItemBloodReedsRightClickedOnBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(BlockPlantBloodReeds.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(BlockPlantBloodReeds.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(BlockPlantBloodReeds.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(BlockPlantBloodReeds.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(BlockPlantBloodReeds.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
		}
	}
}
