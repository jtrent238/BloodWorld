package net.mcreator.bloodworld;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.potion.Potion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.Block;

import java.util.function.Supplier;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

@Mod(modid = bloodworld.MODID, version = bloodworld.VERSION)
public class bloodworld implements IFuelHandler, IWorldGenerator {

	public static final String MODID = "bloodworld";
	public static final String VERSION = "1.0.0.0";
	@SidedProxy(clientSide = "net.mcreator.bloodworld.ClientProxybloodworld", serverSide = "net.mcreator.bloodworld.CommonProxybloodworld")
	public static CommonProxybloodworld proxy;
	@Instance(MODID)
	public static bloodworld instance;
	public final List<ModElement> elements = new ArrayList<>();
	public final List<Supplier<Block>> blocks = new ArrayList<>();
	public final List<Supplier<Item>> items = new ArrayList<>();
	public final List<Supplier<Biome>> biomes = new ArrayList<>();
	public final List<Supplier<EntityEntry>> entities = new ArrayList<>();
	public final List<Supplier<Potion>> potions = new ArrayList<>();

	public bloodworld() {
		FluidRegistry.enableUniversalBucket();
		elements.add(new MCreatorTabBloodWorld(this));
		elements.add(new MCreatorBlockBloodLog(this));
		elements.add(new MCreatorBlockBloodLeaves(this));
		elements.add(new MCreatorBlockBloodStone(this));
		elements.add(new MCreatorBlockBloodSoil(this));
		elements.add(new MCreatorDimBloodWorld(this));
		elements.add(new MCreatorBiomeBloodWood(this));
		elements.add(new MCreatorFluidBlood(this));
		elements.add(new MCreatorBlockBloodFlower(this));
		elements.add(new MCreatorBlockBloodDrop(this));
		elements.add(new MCreatorRecipeBloodBlock(this));
		elements.add(new MCreatorRecipeBloodDrop(this));
		elements.add(new MCreatorItemFoodBloodSoup(this));
		elements.add(new MCreatorBlockBloodFlower2(this));
		elements.add(new MCreatorBlockBloodWoodPlanks(this));
		elements.add(new MCreatorRecipeBloodWoodPlanks(this));
		elements.add(new MCreatorItemBloodWoodStick(this));
		elements.add(new MCreatorRecipeBloodWoodStick(this));
		elements.add(new MCreatorPotionBleeding(this));
		elements.add(new MCreatorEntityBloodSucker(this));
		elements.add(new MCreatorPotionBleedingOnPotionActiveTick(this));
		elements.add(new MCreatorItemBloodOrb(this));
		elements.add(new MCreatorEntityBloodSuckerPlayerCollidesWithThisMob(this));
		elements.add(new MCreatorItemBandage(this));
		elements.add(new MCreatorItemDropOfBlood(this));
		elements.add(new MCreatorRecipeBloodDrop2(this));
		elements.add(new MCreatorRecipeBloodDrop3(this));
		elements.add(new MCreatorRecipeBloodDropSoup(this));
		elements.add(new MCreatorBlockCrustedBlood(this));
		elements.add(new MCreatorFluidBloodUpdateTick(this));
		elements.add(new MCreatorFuelBlood(this));
		elements.add(new MCreatorOverlayBleeding(this));
		elements.add(new MCreatorBlockBloodStoneBrick(this));
		elements.add(new MCreatorRecipeBloodstoneBrick(this));
		elements.add(new MCreatorBlockBloodstoneCobble(this));
		elements.add(new MCreatorRecipeBloodstone(this));
		elements.add(new MCreatorBlockBloodBlossom(this));
		elements.add(new MCreatorBlockBloodGrass(this));
		elements.add(new MCreatorPlantBloodshroom0(this));
		elements.add(new MCreatorGUIBloodPurifier(this));
		elements.add(new MCreatorBlockBloodPurifier(this));
		elements.add(new MCreatorBlockBloodPurifierOnBlockRightClicked(this));
		elements.add(new MCreatorBlockBloodPurifierUpdateTick(this));
		elements.add(new MCreatorItemPurfiedBlood(this));
		elements.add(new MCreatorPlantBloodReeds(this));
		elements.add(new MCreatorItemBloodReedsRightClickedOnBlock(this));
		elements.add(new MCreatorItemBloodReeds(this));
	}

	@Override
	public int getBurnTime(ItemStack fuel) {
		for (ModElement element : elements) {
			int ret = element.addFuel(fuel);
			if (ret != 0)
				return ret;
		}
		return 0;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator cg, IChunkProvider cp) {
		elements.forEach(element -> element.generateWorld(random, chunkX * 16, chunkZ * 16, world, world.provider.getDimension(), cg, cp));
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(blocks.stream().map(Supplier::get).toArray(Block[]::new));
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(items.stream().map(Supplier::get).toArray(Item[]::new));
	}

	@SubscribeEvent
	public void registerBiomes(RegistryEvent.Register<Biome> event) {
		event.getRegistry().registerAll(biomes.stream().map(Supplier::get).toArray(Biome[]::new));
	}

	@SubscribeEvent
	public void registerEntities(RegistryEvent.Register<EntityEntry> event) {
		event.getRegistry().registerAll(entities.stream().map(Supplier::get).toArray(EntityEntry[]::new));
	}

	@SubscribeEvent
	public void registerPotions(RegistryEvent.Register<Potion> event) {
		event.getRegistry().registerAll(potions.stream().map(Supplier::get).toArray(Potion[]::new));
	}

	@SubscribeEvent
	public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		elements.forEach(element -> element.registerModels(event));
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		GameRegistry.registerFuelHandler(this);
		GameRegistry.registerWorldGenerator(this, 5);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		elements.forEach(element -> element.preInit(event));
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		elements.forEach(element -> element.init(event));
		proxy.init(event);
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		elements.forEach(element -> element.serverLoad(event));
	}

	public static class GuiHandler implements IGuiHandler {

		@Override
		public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			if (id == MCreatorGUIBloodPurifier.GUIID)
				return new MCreatorGUIBloodPurifier.GuiContainerMod(world, x, y, z, player);
			return null;
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			if (id == MCreatorGUIBloodPurifier.GUIID)
				return new MCreatorGUIBloodPurifier.GuiWindow(world, x, y, z, player);
			return null;
		}
	}

	public static class ModElement {

		public static bloodworld instance;

		public ModElement(bloodworld instance) {
			this.instance = instance;
		}

		public void init(FMLInitializationEvent event) {
		}

		public void preInit(FMLPreInitializationEvent event) {
		}

		public void generateWorld(Random random, int posX, int posZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		}

		public void serverLoad(FMLServerStartingEvent event) {
		}

		public void registerModels(ModelRegistryEvent event) {
		}

		public int addFuel(ItemStack fuel) {
			return 0;
		}
	}
}
