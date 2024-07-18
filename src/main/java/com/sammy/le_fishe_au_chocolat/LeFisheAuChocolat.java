package com.sammy.le_fishe_au_chocolat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(LeFisheAuChocolat.MODID)
@Mod.EventBusSubscriber(modid = LeFisheAuChocolat.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LeFisheAuChocolat {

	public static final String MODID = "le_fishe_au_chocolat";

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

	public static final RegistryObject<SoundEvent> CHOIR_OF_LE_FISHE = SOUNDS.register("coeur_du_fishe", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("le_fishe_au_chocolat:coeur_du_fishe")));

	public static final RegistryObject<Item> LE_FISHE_AU_CHOCOLAT = ITEMS.register("le_fishe_au_chocolat", () ->
			new LeFisheItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.3F).build())));
	public static final RegistryObject<Item> LE_FISHE_AU_CHOCOLAT_COOKED = ITEMS.register("le_fishe_au_chocolat_grille", () ->
			new LeFisheItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(0.4F).build())));

	public static final RegistryObject<Item> LE_SAUMON_AU_CHOCOLAT = ITEMS.register("le_saumon_au_chocolat", () ->
			new LeFisheItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(0.3F).build())));
	public static final RegistryObject<Item> LE_SAUMON_AU_CHOCOLAT_COOKED = ITEMS.register("le_saumon_au_chocolat_grille", () ->
			new LeFisheItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(0.4F).build())));

	public static final RegistryObject<Item> LE_FISHE_AU_CHOCOLAT_EXOTIC = ITEMS.register("le_fishe_exotique_au_chocolat", () ->
			new LeFisheItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(0.4F).build())));

	public LeFisheAuChocolat() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		ITEMS.register(modBus);
		SOUNDS.register(modBus);
	}

	@SubscribeEvent
	public static void buildCreativeModeTabContents(BuildCreativeModeTabContentsEvent e) {
		if (e.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			e.accept(LE_FISHE_AU_CHOCOLAT);
			e.accept(LE_FISHE_AU_CHOCOLAT_COOKED);
			e.accept(LE_SAUMON_AU_CHOCOLAT);
			e.accept(LE_SAUMON_AU_CHOCOLAT_COOKED);
			e.accept(LE_FISHE_AU_CHOCOLAT_EXOTIC);
		}
	}
}