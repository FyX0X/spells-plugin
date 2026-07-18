package dev.nitramnibus.spellsplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class SpellsPlugin extends JavaPlugin {

    private final Logger logger = getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic
        logger.log(Level.INFO, "SpellsPlugin started :)");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
