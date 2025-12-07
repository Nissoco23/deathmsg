package com.nissoco.deathmsg;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    private static final double RADIUS = 100.0;

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player dead = event.getEntity();
        Location deathLoc = dead.getLocation();

        String msg = event.getDeathMessage();
        event.setDeathMessage(null);

        dead.setGameMode(GameMode.SPECTATOR);

        if (msg == null) return;

        for (Player p : dead.getWorld().getPlayers()) {
            if (p.equals(dead)) continue;

            if (p.getLocation().distanceSquared(deathLoc) <= RADIUS * RADIUS) {
                p.sendMessage(msg);
                p.sendMessage(ChatColor.YELLOW + dead.name().toString() + " left the game");
            }

        }
    }
}
