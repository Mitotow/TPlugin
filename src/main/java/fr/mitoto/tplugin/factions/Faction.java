package fr.mitoto.tplugin.factions;

import org.bukkit.Color;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

public class Faction {
    private String name;
    private UUID chief;
    private static final HashSet<UUID> ltns = new HashSet<>();
    private static final HashSet<UUID> members = new HashSet<>();


    public Faction(String name, Player chief) {
        this.name = name;
        this.chief = chief.getUniqueId();
        members.add(chief.getUniqueId());
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet getMembers() {
        return this.members;
    }

    public void addMember(Player p) {
        this.members.add(p.getUniqueId());
    }

    public boolean removeMember(Player p) {
        if(!ltns.contains(p.getUniqueId()))
            return false;
        this.members.remove(p.getUniqueId());
        return true;
    }

    public void setChief(Player p) {
        this.chief = p.getUniqueId();
    }

    public boolean addLtns(Player p) {
        if(ltns.size() > 3) {
            return false;
        }

        ltns.add(p.getUniqueId());

        return true;
    }

    public boolean removeLtns(Player p) {
        if(!ltns.contains(p.getUniqueId()))
            return false;

        ltns.remove(p.getUniqueId());

        return true;
    }

}
