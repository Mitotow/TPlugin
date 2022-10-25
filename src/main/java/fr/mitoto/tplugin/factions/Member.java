package fr.mitoto.tplugin.factions;

import org.bukkit.entity.Player;

public class Member {
    private final Player player;
    private Faction faction;
    private Rank rank;

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

    public boolean canKick() {
        return rank.getPermissions().contains("TPlugin.rank.kick");
    }

    public boolean canPromote() {
        return rank.getPermissions().contains("TPlugin.rank.promote");
    }

}
