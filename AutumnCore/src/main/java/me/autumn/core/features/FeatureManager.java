package me.autumn.core.features;

import java.util.ArrayList;
import java.util.List;

public class FeatureManager {

    private final List<Feature> features = new ArrayList<>();

    public void registerFeature(Feature feature) {
        features.add(feature);
        feature.enable();
        System.out.println("[FeatureManager] Enabled feature: " + feature.getName());
    }

    public void disableAll() {
        for (Feature feature : features) {
            feature.disable();
            System.out.println("[Feature Manager] Disabled feature: " + feature.getName());
        }
    }

    public <T extends Feature> T getFeature(Class<T> clazz) {
        return features.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .findFirst()
                .orElse(null);
    }
}
