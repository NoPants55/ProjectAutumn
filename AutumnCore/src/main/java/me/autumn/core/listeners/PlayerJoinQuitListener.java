package me.autumn.core.listeners;

import me.autumn.core.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore() && event.getJoinMessage().contains("joined the game")) {
            player.sendMessage(CC.translate(""));
            player.sendMessage(CC.translate("&8&m----------------------------------------"));
            player.sendMessage(CC.translate("&6&lWelcome, &f" + player.getName() + " &6&lto the server!"));
            player.sendMessage(CC.translate("&7We're glad to have you here."));
            player.sendMessage(CC.translate(""));
            player.sendMessage(CC.translate("&7Need help? Join our community:"));
            player.sendMessage(CC.translate("&1&lDISCORD &8» &f<link>"));
            player.sendMessage(CC.translate("&a&lSTORE   &8» &f<link>"));
            player.sendMessage(CC.translate("&3&lRULES   &8» &f<link>"));
            player.sendMessage(CC.translate(""));
            player.sendMessage(CC.translate("&7Recommended Client: &eAutumn Client"));
            player.sendMessage(CC.translate("&7Enhance your gameplay experience!"));
            player.sendMessage(CC.translate("&8&m----------------------------------------"));
            player.sendMessage(CC.translate(""));
        } else {
            player.sendMessage(CC.translate(""));
            player.sendMessage(CC.translate("&8&m----------------------------------------"));
            player.sendMessage(CC.translate("&6&lWelcome back, &f" + player.getName() + " &6&lto the server!"));
            player.sendMessage(CC.translate("&7We're glad to have you here."));
            player.sendMessage(CC.translate(""));
            player.sendMessage(CC.translate("&7Need help? Join our community:"));
            player.sendMessage(CC.translate("&1&lDISCORD &8» &f<link>"));
            player.sendMessage(CC.translate("&a&lSTORE   &8» &f<link>"));
            player.sendMessage(CC.translate("&3&lRULES   &8» &f<link>"));
            player.sendMessage(CC.translate(""));
            player.sendMessage(CC.translate("&7Recommended Client: &eAutumn Client"));
            player.sendMessage(CC.translate("&7Enhance your gameplay experience!"));
            player.sendMessage(CC.translate("&8&m----------------------------------------"));
            player.sendMessage(CC.translate(""));
        }

        if (event.getJoinMessage().contains("joined the game")) {
            event.setJoinMessage(null);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        sendToSpawn(player);
    }

    public void sendToSpawn(Player player) {
        if (player.getLocation() != Bukkit.getWorld("world").getSpawnLocation()) {
            player.teleport(Bukkit.getWorld("world").getSpawnLocation());
        } else {
            return;
        }
    }
}
