
package net.mcreator.bloodworld.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

import net.mcreator.bloodworld.procedure.ProcedureFluidBloodUpdateTick;
import net.mcreator.bloodworld.ElementsBloodworldMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

@ElementsBloodworldMod.ModElement.Tag
public class BlockFluidBlood extends ElementsBloodworldMod.ModElement {
	@GameRegistry.ObjectHolder("bloodworld:fluidblood")
	public static final Block block = null;
	@GameRegistry.ObjectHolder("bloodworld:fluidblood")
	public static final Item item = null;
	private Fluid fluid;
	public BlockFluidBlood(ElementsBloodworldMod instance) {
		super(instance, 8);
		fluid = new Fluid("fluidblood", new ResourceLocation("bloodworld:blocks/blockliquidblood"),
				new ResourceLocation("bloodworld:blocks/blockliquidblood")).setLuminosity(0).setDensity(1000).setViscosity(1000).setGaseous(false);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockFluidClassic(fluid, Material.WATER) {
			@Override
			public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
				super.updateTick(world, pos, state, random);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					ProcedureFluidBloodUpdateTick.executeProcedure($_dependencies);
				}
				world.scheduleUpdate(new BlockPos(x, y, z), this, this.tickRate(world));
			}
		}.setUnlocalizedName("fluidblood").setRegistryName("fluidblood"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName("fluidblood"));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		ModelBakery.registerItemVariants(item);
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation("bloodworld:fluidblood", "fluidblood");
			}
		});
		ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation("bloodworld:fluidblood", "fluidblood");
			}
		});
	}
}
