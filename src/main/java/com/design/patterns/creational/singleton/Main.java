package com.design.patterns.creational.singleton;

public class Main {

    public static void main(String[] args) {
        // Lazy Initialization
        LazySingleton lazySingletonInstance1 = LazySingleton.getInstance();
        LazySingleton lazySingletonInstance2 = LazySingleton.getInstance();

        System.out.println("Lazy Initialization:");
        System.out.println("Instance 1: " + lazySingletonInstance1);
        System.out.println("Instance 2: " + lazySingletonInstance2);
        System.out.println("Are instances equal? " + (lazySingletonInstance1 == lazySingletonInstance2));
        System.out.println();

        // Eager Initialization
        EagerSingleton eagerSingletonInstance1 = EagerSingleton.getInstance();
        EagerSingleton eagerSingletonInstance2 = EagerSingleton.getInstance();

        System.out.println("Eager Initialization:");
        System.out.println("Instance 1: " + eagerSingletonInstance1);
        System.out.println("Instance 2: " + eagerSingletonInstance2);
        System.out.println("Are instances equal? " + (eagerSingletonInstance1 == eagerSingletonInstance2));
    }
}
