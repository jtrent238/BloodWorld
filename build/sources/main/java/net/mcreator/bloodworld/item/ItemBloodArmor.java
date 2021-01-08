
package net.mcreator.bloodworld.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.bloodworld.ElementsBloodworldMod;

@ElementsBloodworldMod.ModElement.Tag
public class ItemBloodArmor extends ElementsBloodworldMod.ModElement {
	@GameRegistry.ObjectHolder("bloodworld:blood_armorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("bloodworld:blood_armorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("bloodworld:blood_armorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("bloodworld:blood_armorboots")
	public static final Item boots = null;
	public ItemBloodArmor(ElementsBloodworldMod instance) {
		super(instance, 65);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("BLOOD_ARMOR", "bloodworld:blood", 60, new int[]{8, 24, 20, 8}, 36,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("blood_armorhelmet")
				.setRegistryName("blood_armorhelmet").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("blood_armorbody")
				.setRegistryName("blood_armorbody").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("blood_armorlegs")
				.setRegistryName("blood_armorlegs").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("blood_armorboots")
				.setRegistryName("blood_armorboots").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("bloodworld:blood_armorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("bloodworld:blood_armorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("bloodworld:blood_armorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("bloodworld:blood_armorboots", "inventory"));
	}
}
