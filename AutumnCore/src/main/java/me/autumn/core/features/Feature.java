package me.autumn.core.features;

public interface Feature {

    void enable();

    void disable();

    default String getName() {
        return this.getClass().getSimpleName();
    }
}
