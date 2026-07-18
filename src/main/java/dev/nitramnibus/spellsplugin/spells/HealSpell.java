package dev.nitramnibus.spellsplugin.spells;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jspecify.annotations.NonNull;

public class HealSpell extends Spell {


    @Override
    public @NonNull String getId() {
        return "heal";
    }

    @Override
    public void cast(@NonNull Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 10, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INSTANT_HEALTH, 1, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 30, 0));
    }

    @Override
    public int getCooldownTicks() {
        return 100;
    }
}
