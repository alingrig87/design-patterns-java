# Decorator Pattern

## Description
The Decorator Pattern is a structural design pattern that allows behavior to be added to an individual object, either statically or dynamically, without affecting the behavior of other objects from the same class. It is achieved by creating a set of decorator classes that are used to wrap concrete components. This pattern provides a flexible alternative to subclassing for extending functionality.

## Components
1. **Component:**
    - This is the interface or abstract class that defines the basic behavior that concrete components and decorators must implement.

2. **ConcreteComponent:**
    - This is the class that implements the Component interface. It defines the basic behavior to which additional responsibilities can be added.

3. **Decorator:**
    - This is the abstract class that also implements the Component interface. It has a reference to a Component and can add new behavior to it.

4. **ConcreteDecorator:**
    - These are the classes that extend the Decorator class and add specific responsibilities to the components.

## Features and Advantages
- Allows the addition of new functionality to objects dynamically.
- Promotes the use of composition over inheritance, providing a more flexible way to extend behavior.
- Supports the open/closed principle by allowing the addition of new decorators without modifying existing code.

## Notes
- The Decorator Pattern is beneficial when the behavior of objects needs to be extended or modified dynamically at runtime.

## Benefits of Decorator Pattern

1. **Dynamic Behavior Extension:**
    - Functionality can be added or removed from objects dynamically at runtime.

2. **Open/Closed Principle:**
    - Objects can be extended with new decorators without modifying existing code, adhering to the open/closed principle.

3. **Composition Over Inheritance:**
    - Provides a more flexible alternative to subclassing, promoting code reuse through composition.

4. **Single Responsibility Principle:**
    - Each decorator class has a single responsibility, making the code easier to understand and maintain.

## Examples of Decorator Pattern Usage

1. **Text Formatting:**
    - Decorators can be used to add formatting features such as bold, italic, or underline to a basic text component.

2. **Coffee Ordering System:**
    - In a coffee ordering system, decorators can be applied to a basic coffee component to add extras like milk, sugar, or whipped cream.

