package com.design.patterns.structural.facade;

// Subsystem - FlightBooking
class FlightBooking {
    public void bookFlight(String destination) {
        System.out.println("Flight booked to " + destination);
    }
}

// Subsystem - HotelBooking
class HotelBooking {
    public void bookHotel(String location, int nights) {
        System.out.println("Hotel booked in " + location + " for " + nights + " nights");
    }
}

// Subsystem - CarRental
class CarRental {
    public void rentCar(String city, int days) {
        System.out.println("Car rented in " + city + " for " + days + " days");
    }
}

// Facade - TravelPlanner
class TravelPlanner {
    private FlightBooking flightBooking;
    private HotelBooking hotelBooking;
    private CarRental carRental;

    public TravelPlanner() {
        this.flightBooking = new FlightBooking();
        this.hotelBooking = new HotelBooking();
        this.carRental = new CarRental();
    }

    // Plan a complete trip by coordinating the actions of the subsystem
    public void planTrip(String destination, String hotelLocation, int nights, String carCity, int carDays) {
        flightBooking.bookFlight(destination);
        hotelBooking.bookHotel(hotelLocation, nights);
        carRental.rentCar(carCity, carDays);
        System.out.println("Trip planned successfully");
    }
}

// Client code
class FacadePatternExampleTravelPlanner {
    public static void main(String[] args) {
        // Create a travel planner facade
        TravelPlanner travelPlanner = new TravelPlanner();

        // Plan a trip using the facade
        travelPlanner.planTrip("Paris", "Eiffel Tower area", 3, "Paris", 4);
    }
}
