package net.mcreator.bloodworld;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class MCreatorItemFoodBloodSoup extends bloodworld.ModElement {

	@GameRegistry.ObjectHolder("bloodworld:itemfoodbloodsoup")
	public static final Item block = null;

	public MCreatorItemFoodBloodSoup(bloodworld instance) {
		super(instance);
		instance.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("bloodworld:itemfoodbloodsoup", "inventory"));
	}

	public static class ItemFoodCustom extends ItemFood {

		public ItemFoodCustom() {
			super(4, 0.3F, false);
			setUnlocalizedName("itemfoodbloodsoup");
			setRegistryName("itemfoodbloodsoup");
			setCreativeTab(MCreatorTabBloodWorld.tab);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}
	}
}
