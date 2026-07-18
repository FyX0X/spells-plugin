package dev.nitramnibus.spellsplugin.items;

import dev.nitramnibus.spellsplugin.keys.PluginKeys;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class MagicWandItem extends SpellCastingItem implements Craftable{

    @Override
    public ItemStack buildItemStack() {

        ItemStack magicWand = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);
        ItemMeta meta = magicWand.getItemMeta();

        if (meta == null) {
            return null;
        }

        meta.setItemName("Magic Wand");
        meta.setRarity(ItemRarity.RARE);
        meta.setLore(List.of("A magic tool that lets wizards cast numerous spells."));
        meta.setEnchantmentGlintOverride(true);
        magicWand.setItemMeta(meta);

        return magicWand;
    }

    @Override
    public @NonNull String getId() {
        return "magic_wand";
    }

    @Override
    public @NonNull Recipe getRecipe(NamespacedKey key) {
        ShapedRecipe recipe = new ShapedRecipe(key, create());
        recipe.shape("L", "S", "S");
        recipe.setIngredient('L', Material.LAPIS_LAZULI);
        recipe.setIngredient('S', Material.STICK);
        return recipe;
    }

    @Override
    public @NonNull String getSpellId() {
        return "fireball";
    }
}
