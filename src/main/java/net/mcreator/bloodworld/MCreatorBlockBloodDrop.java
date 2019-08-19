package net.mcreator.bloodworld;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.BlockRenderLayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

public class MCreatorBlockBloodDrop extends bloodworld.ModElement {

	@GameRegistry.ObjectHolder("bloodworld:blockblooddrop")
	public static final Block block = null;

	public MCreatorBlockBloodDrop(bloodworld instance) {
		super(instance);
		instance.blocks.add(() -> new BlockCustom());
		instance.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("bloodworld:blockblooddrop",
				"inventory"));
	}

	public static class BlockCustom extends Block {

		public BlockCustom() {
			super(Material.GROUND);
			setRegistryName("blockblooddrop");
			setUnlocalizedName("blockblooddrop");
			setSoundType(SoundType.GROUND);
			setHarvestLevel("shovel", 1);
			setHardness(2F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(MCreatorTabBloodWorld.tab);
		}

		@SideOnly(Side.CLIENT)
		@Override
		public BlockRenderLayer getBlockLayer() {
			return BlockRenderLayer.SOLID;
		}
	}
}
