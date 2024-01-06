package com.design.patterns.creational.singleton;

// (Eager Initialization), the singleton instance is created at the time of class loading.
// This ensures fast access to the instance but may lead to unnecessary resource allocation in some cases.

public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        // Private constructor to prevent direct instantiation
    }

    public static EagerSingleton getInstance() {
        return instance;
    }

    // Other methods and class members
}
