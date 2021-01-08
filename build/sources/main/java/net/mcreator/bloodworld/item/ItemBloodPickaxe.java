
package net.mcreator.bloodworld.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.bloodworld.ElementsBloodworldMod;

import java.util.Set;
import java.util.HashMap;

@ElementsBloodworldMod.ModElement.Tag
public class ItemBloodPickaxe extends ElementsBloodworldMod.ModElement {
	@GameRegistry.ObjectHolder("bloodworld:blood_pickaxe")
	public static final Item block = null;
	public ItemBloodPickaxe(ElementsBloodworldMod instance) {
		super(instance, 55);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("BLOOD_PICKAXE", 8, 1741, 14f, 4f, 56)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 8);
				return ret.keySet();
			}
		}.setUnlocalizedName("blood_pickaxe").setRegistryName("blood_pickaxe").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("bloodworld:blood_pickaxe", "inventory"));
	}
}
