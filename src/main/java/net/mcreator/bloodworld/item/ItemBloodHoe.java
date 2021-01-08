
package net.mcreator.bloodworld.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.bloodworld.ElementsBloodworldMod;

import java.util.Set;
import java.util.HashMap;

@ElementsBloodworldMod.ModElement.Tag
public class ItemBloodHoe extends ElementsBloodworldMod.ModElement {
	@GameRegistry.ObjectHolder("bloodworld:blood_hoe")
	public static final Item block = null;
	public ItemBloodHoe(ElementsBloodworldMod instance) {
		super(instance, 59);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemHoe(EnumHelper.addToolMaterial("BLOOD_HOE", 8, 1741, 14f, 0f, 56)) {
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("hoe", 8);
				return ret.keySet();
			}
		}.setUnlocalizedName("blood_hoe").setRegistryName("blood_hoe").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("bloodworld:blood_hoe", "inventory"));
	}
}
