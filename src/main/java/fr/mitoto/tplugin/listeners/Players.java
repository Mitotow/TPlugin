package fr.mitoto.tplugin.listeners;

import net.minecraft.server.network.PlayerConnection;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Players implements Listener {
    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage(ChatColor.GOLD + e.getPlayer().getDisplayName() + ChatColor.GREEN + " vient de se connecter !");
    }

    @EventHandler
    private void onPlayerLeave(PlayerQuitEvent e) {
        e.setQuitMessage(ChatColor.GOLD + e.getPlayer().getDisplayName() + ChatColor.RED + " vient de se déconnecter !");
    }
}
