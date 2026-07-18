package dev.nitramnibus.spellsplugin.listeners;

import dev.nitramnibus.spellsplugin.SpellsPlugin;
import dev.nitramnibus.spellsplugin.items.ItemRegistry;
import dev.nitramnibus.spellsplugin.keys.PluginKeys;
import dev.nitramnibus.spellsplugin.spells.ProjectileSpell;
import dev.nitramnibus.spellsplugin.spells.SpellRegistry;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.persistence.PersistentDataType;

public class SpellHitListener implements Listener {

    private final SpellRegistry spellRegistry;

    public SpellHitListener(SpellRegistry spellRegistry) {
        this.spellRegistry = spellRegistry;
    }

    @EventHandler(ignoreCancelled = true)
    public void onProjectileHit(ProjectileHitEvent event) {

        Projectile projectile = event.getEntity();
        if (!(projectile.getShooter() instanceof Player player)) return;

        String id = projectile.getPersistentDataContainer().get(PluginKeys.SPELL_ID, PersistentDataType.STRING);
        if  (id == null) return;
        ProjectileSpell spell = (ProjectileSpell) spellRegistry.get(id);
        spell.handleHit(event);
    }

}
