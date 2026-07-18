package dev.nitramnibus.spellsplugin.spells;

import org.bukkit.entity.Player;
import org.jspecify.annotations.NonNull;

public abstract class Spell {

    public abstract @NonNull String getId();
    public abstract void cast(@NonNull Player player);

}
