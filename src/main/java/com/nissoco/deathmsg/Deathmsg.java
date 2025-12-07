package com.nissoco.deathmsg;

import org.bukkit.plugin.java.JavaPlugin;

public final class Deathmsg extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Deathmsg has been disabled");
    }
}


