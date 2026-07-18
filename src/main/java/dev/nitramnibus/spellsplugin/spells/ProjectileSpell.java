package dev.nitramnibus.spellsplugin.spells;

import dev.nitramnibus.spellsplugin.keys.PluginKeys;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;
import org.jspecify.annotations.NonNull;

public abstract class ProjectileSpell extends Spell {

    private static final double PROJECTILE_SPEED = 3.5;

    @Override
    public void cast(@NonNull Player player) {
        Vector velocity = player.getEyeLocation().getDirection().multiply(PROJECTILE_SPEED);
        Projectile projectile = player.launchProjectile(Snowball.class, velocity);
        projectile.getPersistentDataContainer().set(
                PluginKeys.SPELL_ID, PersistentDataType.STRING, getId()
        );
    }

    public final void handleHit(ProjectileHitEvent event) {
        // TODO REFACTOR handleHit idMatches and spellHitListener
        if (!idMatches(event.getEntity())) return;
        onHit(event);
    }

    protected abstract void onHit(ProjectileHitEvent event);


    public boolean idMatches(Projectile projectile) {
        String id = projectile.getPersistentDataContainer().get(PluginKeys.SPELL_ID, PersistentDataType.STRING);
        if (id == null) {
            return false;
        }
        return id.equals(getId());
    }
}
