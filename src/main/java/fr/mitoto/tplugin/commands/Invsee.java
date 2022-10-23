package fr.mitoto.tplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Invsee implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length < 1) {
            sender.sendMessage(ChatColor.RED + "/!\\ Vous devez préciser un joueur");
            return false;
        }

        Player target = sender.getServer().getPlayer(args[0]);
        Player executor = sender.getServer().getPlayer(sender.getName());

        if(executor == null) {
            sender.sendMessage(ChatColor.RED + "/!\\ Impossible de vous trouver sur le serveur");
            return false;
        }

        if(target == null) {
            sender.sendMessage(ChatColor.RED + "/!\\ Vous devez préciser un joueur qui est présent sur ce serveur");
            return false;
        }

        executor.openInventory(target.getInventory());

        return false;
    }

}
