
package net.mcreator.bloodworld.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.bloodworld.creativetab.TabTabBloodWorld;
import net.mcreator.bloodworld.ElementsBloodworldMod;

@ElementsBloodworldMod.ModElement.Tag
public class BlockBlockBloodSoil extends ElementsBloodworldMod.ModElement {
	@GameRegistry.ObjectHolder("bloodworld:blockbloodsoil")
	public static final Block block = null;
	public BlockBlockBloodSoil(ElementsBloodworldMod instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("blockbloodsoil"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("bloodworld:blockbloodsoil", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.GRASS);
			setUnlocalizedName("blockbloodsoil");
			setSoundType(SoundType.GROUND);
			setHarvestLevel("shovel", 1);
			setHardness(2F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabTabBloodWorld.tab);
		}

		@Override
		public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
				net.minecraftforge.common.IPlantable plantable) {
			return true;
		}
	}
}
