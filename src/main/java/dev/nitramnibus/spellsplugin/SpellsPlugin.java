package dev.nitramnibus.spellsplugin;

import dev.nitramnibus.spellsplugin.items.ItemRegistry;
import dev.nitramnibus.spellsplugin.items.MagicWandItem;
import dev.nitramnibus.spellsplugin.keys.PluginKeys;
import dev.nitramnibus.spellsplugin.listeners.SpellCastListener;
import dev.nitramnibus.spellsplugin.listeners.SpellHitListener;
import dev.nitramnibus.spellsplugin.recipes.RecipeLoader;
import dev.nitramnibus.spellsplugin.spells.FireballSpell;
import dev.nitramnibus.spellsplugin.spells.SpellRegistry;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class SpellsPlugin extends JavaPlugin {

    private final Logger logger = getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic
        logger.log(Level.INFO, "SpellsPlugin started :)");


        // 1. Initialize the keys
        PluginKeys.initialize(this);

        // 2. Build registries
        ItemRegistry itemRegistry = new ItemRegistry();
        itemRegistry.register(new MagicWandItem());
        // register other items...

        SpellRegistry spellRegistry = new SpellRegistry();
        spellRegistry.register(new FireballSpell());
        // register other spells...

        // 3. Load all Recipes
        RecipeLoader recipeLoader = new RecipeLoader(itemRegistry);
        recipeLoader.loadAllRecipes();

        // 4. Register Listeners
        getServer().getPluginManager().registerEvents(new SpellCastListener(itemRegistry, spellRegistry), this);
        getServer().getPluginManager().registerEvents(new SpellHitListener(spellRegistry), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
