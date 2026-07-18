package dev.nitramnibus.spellsplugin.items;

import dev.nitramnibus.spellsplugin.spells.SpellSource;
import org.bukkit.Material;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class HealingStickItem extends CustomItem implements SpellSource {
    @Override
    public @NonNull String getId() {
        return "healing_stick";
    }

    @Override
    protected ItemStack buildItemStack() {
        ItemStack healingStick = new ItemStack(Material.REDSTONE_TORCH);
        ItemMeta meta = healingStick.getItemMeta();

        if (meta == null) {
            return null;
        }

        meta.setItemName("Healing Stick");
        meta.setRarity(ItemRarity.RARE);
        meta.setLore(List.of("Let the power of life infuse you."));
        meta.setEnchantmentGlintOverride(true);
        healingStick.setItemMeta(meta);

        return healingStick;
    }

    @Override
    public @NonNull String getSpellId() {
        return "heal";
    }
}
