package dev.nitramnibus.spellsplugin.listeners;

import dev.nitramnibus.spellsplugin.items.ItemRegistry;
import dev.nitramnibus.spellsplugin.spells.Spell;
import dev.nitramnibus.spellsplugin.spells.SpellRegistry;
import dev.nitramnibus.spellsplugin.spells.SpellSource;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class SpellCastListener implements Listener {
    private final ItemRegistry itemRegistry;
    private final SpellRegistry spellRegistry;

    public SpellCastListener(ItemRegistry itemRegistry, SpellRegistry spellRegistry) {
        this.itemRegistry = itemRegistry;
        this.spellRegistry = spellRegistry;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) {
            return;
        }
        Action action = event.getAction();
        if (action != Action.RIGHT_CLICK_AIR && action != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        // detect if item can cast a spell
        ItemStack item = event.getItem();
        if (item == null) {
            return;
        }

        if (! (itemRegistry.getFromItemStack(item) instanceof SpellSource spellSource)) {
            return;
        }
        Player player = event.getPlayer();
        if (player.hasCooldown(item)) {
            return;
        }
        Spell spell = spellRegistry.getFromId(spellSource.getSpellId());
        spell.cast(player);
        player.setCooldown(item, spell.getCooldownTicks());


    }


}
