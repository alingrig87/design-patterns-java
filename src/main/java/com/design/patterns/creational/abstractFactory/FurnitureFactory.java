package com.design.patterns.creational.abstractFactory;

// Abstract Product: Chair
interface Chair {
    void sitOn();
}

// Concrete Products
class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a modern chair");
    }
}

class VictorianChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Victorian chair");
    }
}

// Abstract Product: Table
interface Table {
    void useForDining();
}

// Concrete Products
class ModernTable implements Table {
    @Override
    public void useForDining() {
        System.out.println("Using a modern table for dining");
    }
}

class VictorianTable implements Table {
    @Override
    public void useForDining() {
        System.out.println("Using a Victorian table for dining");
    }
}

// Abstract Factory
interface FurnitureFactory {
    Chair createChair();
    Table createTable();
}

// Concrete Factories
class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}

class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }
}

// Client Code
class Main {
    public static void main(String[] args) {
        // Creating a modern furniture factory
        FurnitureFactory modernFactory = new ModernFurnitureFactory();

        // Creating modern chair and table
        Chair modernChair = modernFactory.createChair();
        Table modernTable = modernFactory.createTable();

        // Using modern furniture
        modernChair.sitOn();
        modernTable.useForDining();

        // Creating a Victorian furniture factory
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();

        // Creating Victorian chair and table
        Chair victorianChair = victorianFactory.createChair();
        Table victorianTable = victorianFactory.createTable();

        // Using Victorian furniture
        victorianChair.sitOn();
        victorianTable.useForDining();
    }
}
