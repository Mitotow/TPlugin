package fr.mitoto.tplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashSet;
import java.util.UUID;

public class Freeze implements CommandExecutor, Listener {
    private final static HashSet<UUID> freezePlayers = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(strings.length < 1) {
            sender.sendMessage(ChatColor.RED + "/!\\ Vous devez préciser un joueur");
            return false;
        }

        Player target = sender.getServer().getPlayer(strings[0]);

        if(target == null) {
            sender.sendMessage(ChatColor.RED + "/!\\ Vous devez préciser un joueur qui est présent sur ce serveur");
            return false;
        }

        if(freezePlayers.contains(target.getUniqueId())) {
            freezePlayers.remove(target.getUniqueId());
            sender.sendMessage(ChatColor.GREEN + target.getDisplayName() + " has been unfreeze");
        } else {
            freezePlayers.add(target.getUniqueId());
            sender.sendMessage(ChatColor.GREEN + target.getDisplayName() + " has been freeze");
        }

        return false;
    }

    @EventHandler (priority = EventPriority.HIGH)
    private void onPlayerMove(PlayerMoveEvent e) {
        if(freezePlayers.contains(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
        }
    }

}
