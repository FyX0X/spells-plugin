package dev.nitramnibus.spellsplugin.spells;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.jspecify.annotations.NonNull;

public class FireballSpell extends ProjectileSpell {

    @Override
    public void cast(@NonNull Player player) {
        super.cast(player);
        // do more stuff

        Bukkit.broadcastMessage(ChatColor.RED + "Casting Fireball");
    }

    @Override
    public @NonNull String getId() {
        return "fireball";
    }

    @Override
    public void onHit(ProjectileHitEvent event) {
        Bukkit.broadcastMessage(ChatColor.GOLD + "fireball onHit()");
    }

}
