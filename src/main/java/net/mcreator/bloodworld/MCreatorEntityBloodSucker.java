package net.mcreator.bloodworld;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import java.util.Random;
import java.util.HashMap;

public class MCreatorEntityBloodSucker extends bloodworld.ModElement {

	public static final int ENTITYID = 1;
	public static final int ENTITYID_RANGED = 2;

	public MCreatorEntityBloodSucker(bloodworld instance) {
		super(instance);
		instance.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("bloodworld", "entitybloodsucker"), ENTITYID).name("entitybloodsucker").tracker(64, 1, true)
				.egg(-3407872, -6750208).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("bloodworld:biomebloodwood")),
				Biome.REGISTRY.getObject(new ResourceLocation("hell")),};
		EntityRegistry.addSpawn(EntityCustom.class, 20, 3, 30, EnumCreatureType.MONSTER, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelBloodSucker(), 0.5f) {

				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("bloodworld:textures/entitybloodsucker.png");
				}
			};
		});
	}

	public static class EntityCustom extends EntityMob {

		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 5;
			this.isImmuneToFire = true;
			setNoAI(!true);
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
			this.tasks.addTask(4, new EntityAILeapAtTarget(this, (float) 0.8));
			this.tasks.addTask(5, new EntityAIPanic(this, 1.2));
			this.targetTasks.addTask(6, new EntityAIHurtByTarget(this, false));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(MCreatorItemDropOfBlood.block, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof EntityPotion)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onCollideWithPlayer(EntityPlayer entity) {
			super.onCollideWithPlayer(entity);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				MCreatorEntityBloodSuckerPlayerCollidesWithThisMob.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}

		protected void dropRareDrop(int par1) {
			this.dropItem(new ItemStack(MCreatorItemDropOfBlood.block, (int) (1)).getItem(), 1);
		}

		public void onLivingUpdate() {
			super.onLivingUpdate();
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			Random random = this.rand;
			if (true)
				for (int l = 0; l < 4; ++l) {
					double d0 = (double) ((float) i + random.nextFloat());
					double d1 = (double) ((float) j + random.nextFloat());
					double d2 = (double) ((float) k + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = ((double) random.nextFloat() - 0.5D) * 0.5D;
					double d4 = ((double) random.nextFloat() - 0.5D) * 0.5D;
					double d5 = ((double) random.nextFloat() - 0.5D) * 0.5D;
					world.spawnParticle(EnumParticleTypes.REDSTONE, d0, d1, d2, d3, d4, d5);
				}
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class ModelBloodSucker extends ModelBase {

		private final ModelRenderer bone;

		public ModelBloodSucker() {
			textureWidth = 64;
			textureHeight = 64;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -8.0F, -8.0F, 5, 5, 16, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 21, -6.0F, -7.0F, -7.0F, 13, 1, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 6, 5.0F, -8.0F, -8.0F, 3, 3, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -7.0F, -8.0F, -8.0F, 3, 3, 3, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 23, 0.0F, -5.0F, -11.0F, 1, 1, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 26, 26, -2.0F, -4.0F, -4.0F, 1, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 22, 23, 2.0F, -4.0F, -4.0F, 1, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 18, 23, 2.0F, -4.0F, -1.0F, 1, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 14, 23, 2.0F, -4.0F, 2.0F, 1, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 10, 23, 2.0F, -4.0F, 5.0F, 1, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 12, 5, -2.0F, -4.0F, 5.0F, 1, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 12, 0, -2.0F, -4.0F, 2.0F, 1, 4, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 11, 11, -2.0F, -4.0F, -1.0F, 1, 4, 1, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			bone.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
