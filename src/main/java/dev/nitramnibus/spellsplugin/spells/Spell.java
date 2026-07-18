package dev.nitramnibus.spellsplugin.spells;

import org.bukkit.entity.Player;
import org.jspecify.annotations.NonNull;

public abstract class Spell {

    public abstract void cast(@NonNull Player player);

    @NonNull
    public abstract String getId();

}
