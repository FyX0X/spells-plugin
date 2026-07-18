package dev.nitramnibus.spellsplugin.spells;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.jspecify.annotations.NonNull;

public class FireballSpell extends ProjectileSpell {

    private static final double DAMAGE = 5.0;
    private static final float EXPLOSION_POWER = 1.f;

    @Override
    public @NonNull String getId() {
        return "fireball";
    }

    @Override
    public void cast(@NonNull Player player) {
        super.cast(player);
        // do more stuff

        Bukkit.broadcastMessage(ChatColor.RED + "Casting Fireball");
    }

    @Override
    public int getCooldownTicks() {
        return 30;
    }

    @Override
    public void onHit(ProjectileHitEvent event) {
        Bukkit.broadcastMessage(ChatColor.GOLD + "fireball onHit()");
        Projectile projectile = event.getEntity();
        Player player = (Player) projectile.getShooter();

        if (event.getHitEntity() instanceof LivingEntity target) {
            target.damage(DAMAGE, player);
        }

        Location location = projectile.getLocation();
        projectile.getWorld().createExplosion(location, EXPLOSION_POWER, true);
    }

}
