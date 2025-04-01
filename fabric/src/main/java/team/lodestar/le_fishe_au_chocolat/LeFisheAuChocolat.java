package team.lodestar.le_fishe_au_chocolat;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import java.util.function.Function;


public class LeFisheAuChocolat implements ModInitializer {

    public static final SoundEvent CHOIR_OF_LE_FISHE = registerSound("music_disc.coeur_du_fishe");
    public static final ResourceKey<JukeboxSong> CHOIR_OF_LE_FISHE_KEY =
            ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "coeur_du_fishe"));

    public static final Item LE_FISHE_AU_CHOCOLAT =
            registerItem("le_fishe_au_chocolat", Item::new, new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.3F).build()).jukeboxPlayable(CHOIR_OF_LE_FISHE_KEY));
    public static final Item LE_FISHE_AU_CHOCOLAT_COOKED =
            registerItem("le_fishe_au_chocolat_grille", Item::new, new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.4F).build()).jukeboxPlayable(CHOIR_OF_LE_FISHE_KEY));
    public static final Item LE_SAUMON_AU_CHOCOLAT =
            registerItem("le_saumon_au_chocolat", Item::new, new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.3F).build()).jukeboxPlayable(CHOIR_OF_LE_FISHE_KEY));
    public static final Item LE_SAUMON_AU_CHOCOLAT_COOKED =
            registerItem("le_saumon_au_chocolat_grille", Item::new, new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.4F).build()).jukeboxPlayable(CHOIR_OF_LE_FISHE_KEY));
    public static final Item LE_FISHE_AU_CHOCOLAT_EXOTIC =
            registerItem("le_fishe_exotique_au_chocolat", Item::new, new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.4F).build()).jukeboxPlayable(CHOIR_OF_LE_FISHE_KEY));

    private static SoundEvent registerSound(String id) {
        ResourceLocation identifier = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, id);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }

    public static Item registerItem(String name, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));

        settings = settings.setId(itemKey);
        Item item = itemFactory.apply(settings);

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    @Override
    public void onInitialize() {

        CommonClass.init();

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                .register((creativeTab) -> {
                    creativeTab.accept(LE_FISHE_AU_CHOCOLAT);
                    creativeTab.accept(LE_FISHE_AU_CHOCOLAT_COOKED);
                    creativeTab.accept(LE_SAUMON_AU_CHOCOLAT);
                    creativeTab.accept(LE_SAUMON_AU_CHOCOLAT_COOKED);
                    creativeTab.accept(LE_FISHE_AU_CHOCOLAT_EXOTIC);
                });
    }
}
