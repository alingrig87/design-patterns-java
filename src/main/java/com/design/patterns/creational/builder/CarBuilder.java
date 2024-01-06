package com.design.patterns.creational.builder;

// Car Class
class Car {
    private String brand;
    private String model;
    private int year;
    private String color;
    private int horsepower;
    private boolean hasGPS;

    // Constructor is made private to enforce the use of the builder
    private Car() {}

    // Getter methods for the car's properties

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public boolean hasGPS() {
        return hasGPS;
    }

    // Builder Class
    static class Builder {
        private Car car;

        Builder() {
            this.car = new Car();
        }

        // Methods for setting optional properties of the car

        Builder withBrand(String brand) {
            car.brand = brand;
            return this;
        }

        Builder withModel(String model) {
            car.model = model;
            return this;
        }

        Builder withYear(int year) {
            car.year = year;
            return this;
        }

        Builder withColor(String color) {
            car.color = color;
            return this;
        }

        Builder withHorsepower(int horsepower) {
            car.horsepower = horsepower;
            return this;
        }

        Builder withGPS(boolean hasGPS) {
            car.hasGPS = hasGPS;
            return this;
        }

        // Method to construct the final car
        Car build() {
            return car;
        }
    }
}

// Client Code
class Main {
    public static void main(String[] args) {
        // Creating a car using the builder
        Car car = new Car.Builder()
                .withBrand("Toyota")
                .withModel("Camry")
                .withYear(2022)
                .withColor("Blue")
                .withHorsepower(200)
                .withGPS(true)
                .build();

        // Accessing properties of the car
        System.out.println("Brand: " + car.getBrand());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Color: " + car.getColor());
        System.out.println("Horsepower: " + car.getHorsepower());
        System.out.println("Has GPS: " + car.hasGPS());
    }
}

