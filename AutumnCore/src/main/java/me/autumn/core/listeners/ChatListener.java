package me.autumn.core.listeners;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.autumn.AutumnClientAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import java.awt.*;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        event.setCancelled(true);

        final Player sender = event.getPlayer();
        final String message = event.getMessage();

        Bukkit.getScheduler().runTask(Bukkit.getPluginManager().getPlugin("AutumnCore"), () -> {
            sendCustomChat(sender, message);
        });
    }

    private void sendCustomChat(Player sender, String message) {

        AutumnClientAPI api = AutumnClientAPI.getInstance();
        boolean usingAutumn = api != null && api.isPlayerUsingAutumnClient(sender);

        String status = usingAutumn
                ? ChatColor.GREEN + "✔ Using Autumn Client"
                : ChatColor.RED + "✘ Not using Autumn Client";

        TextComponent nameComponent = new TextComponent(sender.getName());
        nameComponent.setColor(ChatColor.GOLD);

        nameComponent.setHoverEvent(new HoverEvent(
                HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(ChatColor.GOLD + "Autumn Client\n" + ChatColor.GRAY + "Status: " + status).create()
        ));

        TextComponent messageComponent = new TextComponent(" §8» §7" + message);

        nameComponent.addExtra(messageComponent);

        for (Player online : Bukkit.getOnlinePlayers()) {
            online.spigot().sendMessage(nameComponent);
        }
    }
}
