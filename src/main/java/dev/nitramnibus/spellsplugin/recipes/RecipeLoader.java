package dev.nitramnibus.spellsplugin.recipes;

import dev.nitramnibus.spellsplugin.items.Craftable;
import dev.nitramnibus.spellsplugin.items.CustomItem;
import dev.nitramnibus.spellsplugin.items.ItemRegistry;
import dev.nitramnibus.spellsplugin.keys.PluginKeys;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;

public class RecipeLoader {

    private final ItemRegistry itemRegistry;

    public RecipeLoader(ItemRegistry itemRegistry) {
        this.itemRegistry = itemRegistry;
    }

    public void loadAllRecipes() {
        for (CustomItem item : itemRegistry.getAllItems()) {
            if (item instanceof Craftable craftable) {
                NamespacedKey key = PluginKeys.fromString(item.getId() + "_recipe");
                Bukkit.addRecipe(craftable.getRecipe(key));
            }
        }

    }

}
