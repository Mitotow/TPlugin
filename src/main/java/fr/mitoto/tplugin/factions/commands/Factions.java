package fr.mitoto.tplugin.factions.commands;

import fr.mitoto.tplugin.factions.Faction;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Factions implements CommandExecutor {
    private final String perm = "tPlugin.factions.admin";
    private final HashMap<String, Faction> factions = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        Player p = sender.getServer().getPlayer(sender.getName());
        assert p != null;

        if(strings.length < 1) {
            help(p);
            return false;
        }

        switch (strings[0]) {
            case "help":
                help(p);
                break;
            case "create":
                create(p, strings);
                break;
            case "list":
                list(p);
                break;
            default:
                help(p);
                break;
        }

        return false;
    }

    private void help(Player p) {
        p.sendMessage(ChatColor.BLUE + "--------------------------------------------------\n" + ChatColor.GOLD +
                "/factions create <name> - Create a faction with a given name\n" +
                "/factions description <description> - Set a faction description\n" +
                "/factions invite <player> - Invite a player in a faction\n" +
                "/factions kick <player> - Kick a player from a faction\n" +
                "/factions promote <player> - Promote a player from a faction\n" +
                "/factions demote <player> - Demote a player from a faction\n" +
                "/factions list - Get the list of all the factions of the server\n" +
                "/factions info <name> - Get the all information about a faction\n" +
                ChatColor.BLUE + "--------------------------------------------------\n");
    }

    private void create(Player p, String[] strings) {
        String name = strings[1];
        if(name == null) {
            p.sendMessage(ChatColor.RED + "/!\\ Vous devez préciser le nom de la faction");
            return;
        }
        factions.put(name, new Faction(name, p));
        p.sendMessage(ChatColor.GREEN + "Faction created with name \"" + name + "\"");
    }

    private void list(Player p) {
        StringBuilder message = new StringBuilder();
        message.append("&9--------------------------------------------------\n" + ChatColor.GOLD);
        for(Map.Entry<String, Faction> entry : factions.entrySet()) {
            message.append("&1" + entry.getKey()+" faction of &6"+entry.getValue().getMembers().size()+" &9members\n");
        }
        message.append("&9--------------------------------------------------\n");
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', message.toString()));
    }

}
