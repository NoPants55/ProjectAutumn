package me.autumn.core.features.factions;

import me.autumn.core.AutumnCorePlugin;
import me.autumn.core.features.Feature;

public class FactionsFeature implements Feature {

    private final AutumnCorePlugin plugin;

    public FactionsFeature(AutumnCorePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void enable() {
        //register commands/listeners

        System.out.println("[FactionsFeature] Factions feature enabled!");
    }

    @Override
    public void disable() {
        System.out.println("[FactionsFeature] Factions feature disabled!");
    }
}
