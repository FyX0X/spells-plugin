package dev.nitramnibus.spellsplugin.items;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.jspecify.annotations.NonNull;

public interface Craftable {

    @NonNull Recipe getRecipe(NamespacedKey key);

}
