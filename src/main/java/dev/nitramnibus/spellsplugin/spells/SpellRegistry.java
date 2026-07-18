package dev.nitramnibus.spellsplugin.spells;

import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;

public class SpellRegistry {

    private final Map<String, Spell> spellMap = new HashMap<>();

    public void register(@NonNull Spell spell) {
        spellMap.put(spell.getId(), spell);
    }

    @NonNull
    public Spell get(@NonNull String id) {
        return spellMap.get(id);
    }

}
