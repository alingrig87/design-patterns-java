package com.design.patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

// Receiver - Restaurant
import java.util.ArrayList;
import java.util.List;

// Receiver - Restaurant
class Restaurant {
    private List<MenuItem> orders = new ArrayList<>();

    public void takeOrder(MenuItem item) {
        orders.add(item);
        System.out.println("Order taken: " + item.getName());
    }

    public void generateBill() {
        System.out.println("Generating the bill...");
        System.out.println("Items ordered:");
        for (MenuItem item : orders) {
            System.out.println("- " + item.getName() + " ($" + item.getPrice() + ")");
        }
        double totalAmount = orders.stream().mapToDouble(MenuItem::getPrice).sum();
        System.out.println("Total amount: $" + totalAmount);
    }
}

// MenuItem class
class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Command interface
interface Command {
    void execute();
}

// Concrete Command for placing an order
class PlaceOrderCommand implements Command {
    private Restaurant restaurant;
    private MenuItem item;

    public PlaceOrderCommand(Restaurant restaurant, MenuItem item) {
        this.restaurant = restaurant;
        this.item = item;
    }

    @Override
    public void execute() {
        restaurant.takeOrder(item);
    }
}

// Concrete Command for generating the bill
class GenerateBillCommand implements Command {
    private Restaurant restaurant;

    public GenerateBillCommand(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void execute() {
        restaurant.generateBill();
    }
}

// Invoker - Waiter
class Waiter {
    private List<Command> commands = new ArrayList<>();

    public void takeOrder(Command command) {
        commands.add(command);
    }

    public void placeOrders() {
        for (Command command : commands) {
            command.execute();
        }
        commands.clear(); // Clear the orders after placing them
    }
}

// Client code
class RestaurantManagementSystem {
    public static void main(String[] args) {
        // Create a restaurant
        Restaurant restaurant = new Restaurant();

        // Create menu items
        MenuItem pasta = new MenuItem("Pasta", 12.99);
        MenuItem steak = new MenuItem("Steak", 24.99);

        // Create command objects for placing an order and generating the bill
        Command placeOrderCommand1 = new PlaceOrderCommand(restaurant, pasta);
        Command placeOrderCommand2 = new PlaceOrderCommand(restaurant, steak);
        Command generateBillCommand = new GenerateBillCommand(restaurant);

        // Create a waiter
        Waiter waiter = new Waiter();

        // Waiter takes orders
        waiter.takeOrder(placeOrderCommand1);
        waiter.takeOrder(placeOrderCommand2);

        // Waiter places the orders
        waiter.placeOrders();

        // Waiter generates the bill
        waiter.takeOrder(generateBillCommand);
        waiter.placeOrders();
    }
}
