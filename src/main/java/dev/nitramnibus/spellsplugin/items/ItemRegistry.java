package dev.nitramnibus.spellsplugin.items;

import dev.nitramnibus.spellsplugin.keys.PluginKeys;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class  ItemRegistry {

    private final Map<String, CustomItem> itemMap = new HashMap<>();

    public void register(@NonNull CustomItem item) {
        itemMap.put(item.getId(), item);
    }

    @Nullable
    public CustomItem getFromId(@NonNull String id) {
        return itemMap.get(id);
    }

    @Nullable
    public CustomItem getFromItemStack(@NonNull ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            return null;
        }
        String id = meta.getPersistentDataContainer().get(PluginKeys.ITEM_ID, PersistentDataType.STRING);

        return id == null ? null : getFromId(id);
    }

    @NonNull
    public Collection<CustomItem> getAllItems() {
        return itemMap.values();
    }

}
