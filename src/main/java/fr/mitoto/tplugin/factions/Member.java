package fr.mitoto.tplugin.factions;

import org.bukkit.entity.Player;

public class Member {
    private final Player player;
    private Faction faction;

    public Member(Player p, Faction fac) {
        this.player = p;
        this.faction = fac;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Faction getFaction() {
        return this.faction;
    }

    public void setFaction(Faction fac) {
        this.faction = fac;
    }

}
