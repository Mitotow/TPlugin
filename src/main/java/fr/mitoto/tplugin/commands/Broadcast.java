package fr.mitoto.tplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class Broadcast implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(strings.length < 1) {
            sender.sendMessage(ChatColor.RED + "/!\\ Vous ne pouvez pas envoyer de message vide");
            return false;
        }

        String message = String.join(" ", strings);
        message = ChatColor.translateAlternateColorCodes('&', message);

        Bukkit.broadcastMessage(message);

        return false;
    }

}
