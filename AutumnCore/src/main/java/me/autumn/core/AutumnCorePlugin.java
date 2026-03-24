package me.autumn.core;

import com.sun.org.apache.regexp.internal.RE;
import me.autumn.core.features.FeatureManager;
import me.autumn.core.features.factions.FactionsFeature;
import me.autumn.core.listeners.ChatListener;
import me.autumn.core.listeners.PlayerJoinQuitListener;
import org.bukkit.plugin.java.JavaPlugin;

public class AutumnCorePlugin extends JavaPlugin {

    private static AutumnCorePlugin instance;
    private FeatureManager featureManager;

    public void onEnable() {
        instance = this;
        this.featureManager = featureManager;
        registerCommands();
        registerListeners();
        registerFeatures();
        getLogger().info("AutumnCore Enabled!");

    }

    public void onDisable() {

    }

    public void registerCommands() {

    }

    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerJoinQuitListener(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);

    }

    public void registerFeatures() {
        featureManager.registerFeature(new FactionsFeature(this));
    }

    public FeatureManager getFeatureManager() {
        return featureManager;
    }

    public static AutumnCorePlugin getInstance() {
        return instance;
    }
}