package com.design.patterns.behavioral.state;

// State interface
interface TrafficLightState {
    void handle();
}

// Concrete States
class RedState implements TrafficLightState {
    @Override
    public void handle() {
        System.out.println("Traffic Light is RED. Stop!");
    }
}

class YellowState implements TrafficLightState {
    @Override
    public void handle() {
        System.out.println("Traffic Light is YELLOW. Prepare to stop or proceed with caution.");
    }
}

class GreenState implements TrafficLightState {
    @Override
    public void handle() {
        System.out.println("Traffic Light is GREEN. Go!");
    }
}

// Context
class TrafficLight {
    private TrafficLightState currentState;

    public TrafficLight(TrafficLightState state) {
        currentState = state;
    }

    public void setState(TrafficLightState state) {
        currentState = state;
    }

    public void change() {
        if (currentState instanceof RedState) {
            setState(new GreenState());
        } else if (currentState instanceof GreenState) {
            setState(new YellowState());
        } else if (currentState instanceof YellowState) {
            setState(new RedState());
        }

        currentState.handle();
    }
}

// Client
 class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight(new RedState());

        trafficLight.change();  // Output: Traffic Light is GREEN. Go!
        trafficLight.change();  // Output: Traffic Light is YELLOW. Prepare to stop or proceed with caution.
        trafficLight.change();  // Output: Traffic Light is RED. Stop!
    }
}

