package com.design.patterns.structural.facade;

// Subsystem - Class representing the CPU
class CPU {
    public void start() {
        System.out.println("CPU started");
    }

    public void shutdown() {
        System.out.println("CPU shut down");
    }
}

// Subsystem - Class representing the Memory
class Memory {
    public void load() {
        System.out.println("Memory loaded");
    }

    public void unload() {
        System.out.println("Memory unloaded");
    }
}

// Subsystem - Class representing the Hard Drive
class HardDrive {
    public void read() {
        System.out.println("Hard Drive read");
    }

    public void write() {
        System.out.println("Hard Drive write");
    }
}

// Facade - Provides a simplified interface to the subsystem
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    // Start the computer by coordinating the actions of the subsystem
    public void startComputer() {
        cpu.start();
        memory.load();
        hardDrive.read();
        System.out.println("Computer started successfully");
    }

    // Shut down the computer by coordinating the actions of the subsystem
    public void shutdownComputer() {
        cpu.shutdown();
        memory.unload();
        hardDrive.write();
        System.out.println("Computer shut down successfully");
    }
}

// Client code
class FacadePatternExample {
    public static void main(String[] args) {
        // Create a computer facade
        ComputerFacade computerFacade = new ComputerFacade();

        // Start and shut down the computer using the facade
        computerFacade.startComputer();
        System.out.println("----------");
        computerFacade.shutdownComputer();
    }
}
