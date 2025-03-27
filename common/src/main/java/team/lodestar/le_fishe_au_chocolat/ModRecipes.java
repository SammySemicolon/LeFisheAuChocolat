package team.lodestar.le_fishe_au_chocolat;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import team.lodestar.le_fishe_au_chocolat.platform.Services;

public class ModRecipes {
    public static JsonObject LE_FISHE_AU_CHOCOLAT_RECIPE = null;
    public static JsonObject LE_FISHE_AU_CHOCOLAT_COOKED_RECIPE = null;
    public static JsonObject LE_SAUMON_AU_CHOCOLAT_RECIPE = null;
    public static JsonObject LE_SAUMON_AU_CHOCOLAT_COOKED_RECIPE = null;
    public static JsonObject LE_FISHE_AU_CHOCOLAT_EXOTIC_RECIPE = null;

    public static void init() {
        LE_FISHE_AU_CHOCOLAT_RECIPE = createAuChocolateRecipe(ResourceLocation.withDefaultNamespace("cod"), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "le_fishe_au_chocolat"));
        LE_FISHE_AU_CHOCOLAT_COOKED_RECIPE = createAuChocolateRecipe(ResourceLocation.withDefaultNamespace("cooked_cod"), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "le_fishe_au_chocolat_grille"));
        LE_SAUMON_AU_CHOCOLAT_RECIPE = createAuChocolateRecipe(ResourceLocation.withDefaultNamespace("salmon"), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "le_saumon_au_chocolat"));
        LE_SAUMON_AU_CHOCOLAT_COOKED_RECIPE = createAuChocolateRecipe(ResourceLocation.withDefaultNamespace("cooked_salmon"), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "le_saumon_au_chocolat_grille"));
        LE_FISHE_AU_CHOCOLAT_EXOTIC_RECIPE = createAuChocolateRecipe(ResourceLocation.withDefaultNamespace("tropical_fish"), ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "le_fishe_exotique_au_chocolat"));
    }

    public static JsonObject createAuChocolateRecipe(ResourceLocation fishID, ResourceLocation chocolatFishID) {
        JsonObject json = new JsonObject();

        if (Services.PLATFORM.isModLoaded("create")) {
            json.addProperty("type", ResourceLocation.fromNamespaceAndPath("create", "filling").toString());

            JsonArray ingredientList = new JsonArray();
            JsonObject fishIngredient = new JsonObject();
            fishIngredient.addProperty("item", fishID.toString());
            ingredientList.add(fishIngredient);
            JsonObject chocolateIngredient = new JsonObject();
            chocolateIngredient.addProperty("type", "fluid_stack");
            chocolateIngredient.addProperty("amount", 250);
            chocolateIngredient.addProperty("fluid", ResourceLocation.fromNamespaceAndPath("create", "chocolate").toString());
            ingredientList.add(chocolateIngredient);
            json.add("ingredients", ingredientList);

            JsonArray resultList = new JsonArray();
            JsonObject chocolatFishResult = new JsonObject();
            chocolatFishResult.addProperty("id", chocolatFishID.toString());
            resultList.add(chocolatFishResult);
            json.add("results", resultList);
        }
        else {
            json.addProperty("type", ResourceLocation.withDefaultNamespace("crafting_shaped").toString());

            JsonArray pattern = new JsonArray();
            pattern.add(" Y ");
            pattern.add("YXY");
            pattern.add(" Y ");
            json.add("pattern", pattern);

            JsonObject keyList = new JsonObject();
            JsonObject fishKey = new JsonObject();
            fishKey.addProperty("item", fishID.toString());
            keyList.add("X", fishKey);
            JsonObject cocoaKey = new JsonObject();
            cocoaKey.addProperty("item", ResourceLocation.withDefaultNamespace("cocoa_beans").toString());
            keyList.add("Y", cocoaKey);
            json.add("key", keyList);

            JsonObject result = new JsonObject();
            result.addProperty("id", chocolatFishID.toString());
            result.addProperty("count", 1);
            json.add("result", result);
        }

        return json;
    }
}
