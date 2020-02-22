package com.design.pattern.singleton;

public enum Singleton {
    INSTANCE;
    private Singleton singleton;

    Singleton() {
    }

    public Singleton getInstance() {
        return INSTANCE;
    }
}
