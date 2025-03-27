package team.lodestar.le_fishe_au_chocolat.mixin;

import com.google.gson.JsonElement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.RecipeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.lodestar.le_fishe_au_chocolat.Constants;
import team.lodestar.le_fishe_au_chocolat.ModRecipes;

import java.util.Map;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {

    @Inject(method = "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V", at = @At("HEAD"))
    public void interceptApply(Map<ResourceLocation, JsonElement> object, ResourceManager resourceManager, ProfilerFiller profiler, CallbackInfo ci) {
        object.put(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "le_fishe_au_chocolat"), ModRecipes.LE_FISHE_AU_CHOCOLAT_RECIPE);
        object.put(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "le_fishe_au_chocolat_grille"), ModRecipes.LE_FISHE_AU_CHOCOLAT_COOKED_RECIPE);
        object.put(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "le_saumon_au_chocolat"), ModRecipes.LE_SAUMON_AU_CHOCOLAT_RECIPE);
        object.put(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "le_saumon_au_chocolat_grille"), ModRecipes.LE_SAUMON_AU_CHOCOLAT_COOKED_RECIPE);
        object.put(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "le_fishe_exotique_au_chocolat"), ModRecipes.LE_FISHE_AU_CHOCOLAT_EXOTIC_RECIPE);
    }

}
