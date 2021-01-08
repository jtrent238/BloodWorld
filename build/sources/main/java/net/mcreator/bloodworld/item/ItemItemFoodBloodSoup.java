
package net.mcreator.bloodworld.item;

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

import net.mcreator.bloodworld.creativetab.TabTabBloodWorld;
import net.mcreator.bloodworld.ElementsBloodworldMod;

@ElementsBloodworldMod.ModElement.Tag
public class ItemItemFoodBloodSoup extends ElementsBloodworldMod.ModElement {
	@GameRegistry.ObjectHolder("bloodworld:itemfoodbloodsoup")
	public static final Item block = null;
	public ItemItemFoodBloodSoup(ElementsBloodworldMod instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("bloodworld:itemfoodbloodsoup", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(4, 0.300000011920929f, false);
			setUnlocalizedName("itemfoodbloodsoup");
			setRegistryName("itemfoodbloodsoup");
			setCreativeTab(TabTabBloodWorld.tab);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}
	}
}
