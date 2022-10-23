package fr.mitoto.tplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Objects;

public class Vanish implements CommandExecutor {

    private final HashSet<Player> VanishPlayers = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        Objects.requireNonNull(sender.getServer().getPlayer(sender.getName())).setInvisible(true);
        Player p = sender.getServer().getPlayer(sender.getName());
        setVanish(p);
        return false;
    }

    private void setVanish(Player p) {
        if(VanishPlayers.contains(p)) {
            p.setInvisible(false);
            p.sendMessage(ChatColor.GREEN + "You are now" + ChatColor.GOLD + " Visible");
            VanishPlayers.remove(p);
            return;
        }

        p.setInvisible(true);
        p.sendMessage(ChatColor.GREEN + "You are now" + ChatColor.GOLD + " Invisible");
        VanishPlayers.add(p);
    }
}
