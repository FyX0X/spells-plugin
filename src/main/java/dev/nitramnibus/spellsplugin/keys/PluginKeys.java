package dev.nitramnibus.spellsplugin.keys;

import dev.nitramnibus.spellsplugin.SpellsPlugin;
import org.bukkit.NamespacedKey;
import org.jspecify.annotations.NonNull;

public class PluginKeys {

    private static SpellsPlugin plugin;
    public static NamespacedKey ITEM_ID;
    public static NamespacedKey SPELL_ID;
    public static NamespacedKey SELECTED_SPELL_ID;

    public static void initialize(@NonNull SpellsPlugin plugin) {
        PluginKeys.plugin = plugin;
        ITEM_ID = fromString("item_id");
        SPELL_ID = fromString("spell_id");
        SELECTED_SPELL_ID = fromString("selected_spell_id");
    }

    public static NamespacedKey fromString(@NonNull String identifier) {
        return new NamespacedKey(plugin, identifier);
    }

    private PluginKeys() {}
}
