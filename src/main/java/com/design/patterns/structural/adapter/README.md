# Adapter Pattern

## Description
The Adapter Pattern is a structural design pattern that allows incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces by converting the interface of a class into another interface that a client expects. This pattern enables the integration of existing systems and ensures their compatibility without modifying their source code.

## Components
1. **Target:**
    - This is the interface that the client expects to interact with. It represents the desired interface that the client works with.

2. **Adapter:**
    - This is the class that implements the Target interface and wraps around the Adaptee. It translates requests from the client into calls to the Adaptee's interface.

3. **Adaptee:**
    - This is the class that has an incompatible interface with the Target. The Adapter wraps around the Adaptee to make it compatible with the Target interface.

4. **Client:**
    - This is the class that interacts with the Target interface. It is unaware of the Adapter's presence and communicates directly with the Target.

## Features and Advantages
- Allows the integration of incompatible interfaces without modifying existing code.
- Facilitates the reuse of existing classes that have incompatible interfaces.
- Enables the interaction between new and legacy systems.

## Notes
- The Adapter Pattern is useful when integrating systems with different interfaces or when reusing existing classes with incompatible interfaces.

## Benefits of Adapter Pattern

1. **Code Reusability:**
    - Existing classes with incompatible interfaces can be reused in new systems without modification.

2. **Interoperability:**
    - Facilitates the integration of components or systems with different interfaces, ensuring they can work together seamlessly.

3. **Client Independence:**
    - Clients interact with the Target interface without being aware of the underlying Adaptee, promoting loose coupling.

4. **Legacy System Integration:**
    - Allows the integration of legacy systems with modern systems by adapting their interfaces.

## Examples of Adapter Pattern Usage

1. **Library Integration:**
    - Adapting an older library with a different interface to work with a new system without modifying the library code.

2. **Device Compatibility:**
    - Creating adapters for different types of plugs to make electronic devices compatible with various power outlets.

