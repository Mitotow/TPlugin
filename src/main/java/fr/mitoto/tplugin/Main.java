package fr.mitoto.tplugin;

import fr.mitoto.tplugin.commands.*;
import fr.mitoto.tplugin.factions.commands.Factions;
import fr.mitoto.tplugin.listeners.Players;
import fr.mitoto.tplugin.utils.commands.SimpleCommand;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_19_R1.CraftServer;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Enable");

        // Event Handler
        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvents(new Freeze(), this);
        pluginManager.registerEvents(new Stat(), this);
        pluginManager.registerEvents(new Players(), this);

        // Comand Handler
        createCommand(new SimpleCommand(
                "broadcast add",
                "envoyer un message à tout le serveur",
                new Broadcast(),
                "tplugin.broadcast",
                "bc"
        ));

        createCommand(new SimpleCommand(
                "invsee",
                "regarder l'inventaire d'un joueur",
                new Invsee(),
                "tplugin.invsee",
                ""
        ));

        createCommand(new SimpleCommand(
                "vanish",
                "se rendre invisible",
                new Vanish(),
                "tplugin.vanish",
                ""
        ));

        createCommand(new SimpleCommand(
                "stats",
                "récupérer les stats du joueur",
                new Stat(),
                "",
                ""
        ));

        createCommand(new SimpleCommand(
                "freeze",
                "empêcher un joueur de bouger",
                new Freeze(),
                "TPlugin.freeze",
                ""
        ));

        createCommand(new SimpleCommand(
                "factions",
                "gestion des factions",
                new Factions(),
                "TPlugin.factions",
                ""
        ));
    }

    @Override
    public void onDisable() {
        getLogger().info("Disable");
    }

    public void createCommand(SimpleCommand command) {
        CraftServer server = (CraftServer) getServer();
        server.getCommandMap().register(getName(), command);
    }

}
