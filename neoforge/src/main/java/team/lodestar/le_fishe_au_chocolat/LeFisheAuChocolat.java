package team.lodestar.le_fishe_au_chocolat;


import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@Mod(Constants.MOD_ID)
public class LeFisheAuChocolat {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Constants.MOD_ID);

    public static final Holder<SoundEvent> CHOIR_OF_LE_FISHE = SOUND_EVENTS.register(
            "music_disc.coeur_du_fishe",
            SoundEvent::createVariableRangeEvent
    );

    public static final ResourceKey<JukeboxSong> CHOIR_OF_LE_FISHE_KEY =
            ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "coeur_du_fishe"));

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Constants.MOD_ID);

    public static final Supplier<Item> LE_FISHE_AU_CHOCOLAT = ITEMS.registerItem(
            "le_fishe_au_chocolat",
            LeFisheItem::new,
            new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.3F).build()).jukeboxPlayable(CHOIR_OF_LE_FISHE_KEY)
    );
    public static final Supplier<Item> LE_FISHE_AU_CHOCOLAT_COOKED = ITEMS.registerItem(
            "le_fishe_au_chocolat_grille",
            LeFisheItem::new,
            new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.3F).build()).jukeboxPlayable(CHOIR_OF_LE_FISHE_KEY)
    );

    public static final Supplier<Item> LE_SAUMON_AU_CHOCOLAT = ITEMS.registerItem(
            "le_saumon_au_chocolat",
            LeFisheItem::new,
            new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.3F).build()).jukeboxPlayable(CHOIR_OF_LE_FISHE_KEY)
    );

    public static final Supplier<Item> LE_SAUMON_AU_CHOCOLAT_COOKED = ITEMS.registerItem(
            "le_saumon_au_chocolat_grille",
            LeFisheItem::new,
            new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.3F).build()).jukeboxPlayable(CHOIR_OF_LE_FISHE_KEY)
    );

    public static final Supplier<Item> LE_FISHE_AU_CHOCOLAT_EXOTIC = ITEMS.registerItem(
            "le_fishe_exotique_au_chocolat",
            LeFisheItem::new,
            new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.3F).build()).jukeboxPlayable(CHOIR_OF_LE_FISHE_KEY)
    );

    public LeFisheAuChocolat(IEventBus eventBus) {

        CommonClass.init();

        SOUND_EVENTS.register(eventBus);
        ITEMS.register(eventBus);

        eventBus.addListener(this::buildContents);
    }

    @SubscribeEvent
    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(LE_FISHE_AU_CHOCOLAT.get());
            event.accept(LE_FISHE_AU_CHOCOLAT_COOKED.get());
            event.accept(LE_SAUMON_AU_CHOCOLAT.get());
            event.accept(LE_SAUMON_AU_CHOCOLAT_COOKED.get());
            event.accept(LE_FISHE_AU_CHOCOLAT_EXOTIC.get());
        }
    }
}