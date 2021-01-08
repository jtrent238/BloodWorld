
package net.mcreator.bloodworld.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.bloodworld.ElementsBloodworldMod;

import java.util.Set;
import java.util.HashMap;

import com.google.common.collect.Multimap;

@ElementsBloodworldMod.ModElement.Tag
public class ItemBloodSword extends ElementsBloodworldMod.ModElement {
	@GameRegistry.ObjectHolder("bloodworld:blood_sword")
	public static final Item block = null;
	public ItemBloodSword(ElementsBloodworldMod instance) {
		super(instance, 57);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSword(EnumHelper.addToolMaterial("BLOOD_SWORD", 8, 1741, 14f, 4f, 56)) {
			@Override
			public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot slot) {
				Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(slot);
				if (slot == EntityEquipmentSlot.MAINHAND) {
					multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
							new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) this.getAttackDamage(), 0));
					multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
							new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -3, 0));
				}
				return multimap;
			}

			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("sword", 8);
				return ret.keySet();
			}
		}.setUnlocalizedName("blood_sword").setRegistryName("blood_sword").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("bloodworld:blood_sword", "inventory"));
	}
}
