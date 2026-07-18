package dev.nitramnibus.spellsplugin.listeners;

import dev.nitramnibus.spellsplugin.items.ItemRegistry;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.inventory.BlockInventoryHolder;

import java.util.Random;

public class LootListener implements Listener {

    private final ItemRegistry itemRegistry;
    private Random random = new Random();



    public LootListener(ItemRegistry itemRegistry) {
        this.itemRegistry = itemRegistry;
    }

    @EventHandler(ignoreCancelled = true)
    public void onLootGenerate(LootGenerateEvent event) {
        Bukkit.broadcastMessage("onLootGenerate");
        if (!(event.getInventoryHolder() instanceof BlockInventoryHolder blockInventoryHolder)) {
            return;
        }

        // small proba to have healing stick
        if (random.nextFloat() < 0.3f) {
            Bukkit.broadcastMessage("success");
            blockInventoryHolder.getInventory().addItem(itemRegistry.getFromId("healing_stick").create());
        } else {
            Bukkit.broadcastMessage("onLootGenerate: fail");
        }
    }

}
