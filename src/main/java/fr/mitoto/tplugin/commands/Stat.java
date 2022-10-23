package fr.mitoto.tplugin.commands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Stat implements CommandExecutor, Listener {
    private static Inventory inv;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        Player p = sender.getServer().getPlayer(sender.getName());
        if(p == null) {
            sender.sendMessage(ChatColor.RED + "/!\\ Impossible d'executer la commande");
            return false;
        }

        inv = Bukkit.createInventory(null, 9, "Player Stats");

        initItems(p);

        p.openInventory(inv);

        return false;
    }

    private ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    private void initItems(final Player p) {
        final int deaths = p.getStatistic(Statistic.DEATHS);
        final int mobKills = p.getStatistic(Statistic.MOB_KILLS);
        final int playerKills = p.getStatistic(Statistic.PLAYER_KILLS);

        inv.addItem(createGuiItem(Material.PLAYER_HEAD, "KILLS", "Nombre de mobs tués : ", Integer.toString(mobKills), "Nombre de joueurs tués : ", Integer.toString(playerKills)));
        inv.addItem(createGuiItem(Material.SKELETON_SKULL, "MORTS", "Nombre de morts : ", Integer.toString(deaths)));
    }

    @EventHandler
    private void onInventoryClick(InventoryClickEvent e) {
        if(e.getInventory().equals(inv)) {
            e.setCancelled(true);
        }
    }

}
