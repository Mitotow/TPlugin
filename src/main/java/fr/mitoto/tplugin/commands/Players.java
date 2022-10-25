package fr.mitoto.tplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

public class Players implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        StringBuilder message = new StringBuilder();
        message.append("&9--------------------------------------------------\n&6");
        for(Player p : sender.getServer().getOnlinePlayers()) {
            message.append(p.getDisplayName() + "\n");
        }
        message.append("&9--------------------------------------------------");

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', String.valueOf(message)));

        return false;
    }

}
