package dev.nitramnibus.spellsplugin.items;

import dev.nitramnibus.spellsplugin.keys.PluginKeys;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jspecify.annotations.NonNull;

public abstract class CustomItem {

    abstract protected ItemStack buildItemStack();

    @NonNull
    public abstract String getId();

    @NonNull
    public final ItemStack create() {
        ItemStack item = buildItemStack();
        if (item == null) {
            throw new IllegalStateException("Could not build ItemStack with id: " + getId());
        }
        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            throw new IllegalStateException("Could not get ItemMeta of CustomItem: " + getId());
        }
        meta.getPersistentDataContainer().set(PluginKeys.ITEM_ID, PersistentDataType.STRING, getId());
        item.setItemMeta(meta);
        return item;
    }

    public boolean matches(@NonNull ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            return false;
        }

        String id = meta.getPersistentDataContainer().get(PluginKeys.ITEM_ID, PersistentDataType.STRING);
        return (id != null && id.equals(getId()));
    }

}
