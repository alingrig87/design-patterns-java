package com.design.patterns.structural.decorator;

// Component interface
interface Coffee {
    double cost();
    String description();
}

// Concrete component
class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 2.0; // Base cost for a simple coffee
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}

// Decorator abstract class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }

    @Override
    public String description() {
        return decoratedCoffee.description();
    }
}

// Concrete decorator - Milk
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        // Additional cost for milk
        return super.cost() + 0.5;
    }

    @Override
    public String description() {
        // Additional description for milk
        return super.description() + " with Milk";
    }
}

// Concrete decorator - Sugar
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        // Additional cost for sugar
        return super.cost() + 0.2;
    }

    @Override
    public String description() {
        // Additional description for sugar
        return super.description() + " with Sugar";
    }
}

// Client code
class DecoratorPatternExample {
    public static void main(String[] args) {
        // Order a simple coffee
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Cost: $" + simpleCoffee.cost() + ", Description: " + simpleCoffee.description());

        // Decorate the simple coffee with milk
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("Cost: $" + milkCoffee.cost() + ", Description: " + milkCoffee.description());

        // Decorate the milk coffee with sugar
        Coffee milkSugarCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Cost: $" + milkSugarCoffee.cost() + ", Description: " + milkSugarCoffee.description());
    }
}

