package fr.mitoto.tplugin.factions;

import java.util.HashSet;

public class Rank {
    private String name;
    private int level;
    private final static HashSet<String> permissions = new HashSet<>();

    public Rank(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public HashSet getPermissions() {
        return permissions;
    }

}
