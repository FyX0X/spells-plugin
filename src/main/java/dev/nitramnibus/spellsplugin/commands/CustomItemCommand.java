package dev.nitramnibus.spellsplugin.commands;

import dev.nitramnibus.spellsplugin.items.CustomItem;
import dev.nitramnibus.spellsplugin.items.ItemRegistry;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CustomItemCommand implements CommandExecutor {

    private final ItemRegistry itemRegistry;


    public CustomItemCommand(ItemRegistry itemRegistry) {
        this.itemRegistry = itemRegistry;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (! (sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command.");
            return true;
        }

        if (args.length != 1) {
            return false;
        }

        CustomItem item = itemRegistry.getFromId(args[0]);
        if (item == null) {
            sender.sendMessage(ChatColor.RED + "That item does not exist.");
            return true;
        }

        player.sendMessage(ChatColor.GREEN + "Item successfully given.");
        player.getInventory().addItem(item.create());

        return true;
    }
}
