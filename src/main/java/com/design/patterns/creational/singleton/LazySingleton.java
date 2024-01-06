package com.design.patterns.creational.singleton;

// (Lazy Initialization), the singleton instance is created only when needed, i.e.,
// on the first call to the getInstance() method.
// This saves resources but requires careful management of concurrent access.
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
        // Private constructor to prevent direct instantiation
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    // Other methods and class members
}
