# Factory Method Pattern

## Description
Factory Method is a creational design pattern that provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created. It falls under the category of creational design patterns and is widely used in frameworks and libraries to define an interface for creating objects.

## Components
1. **Creator Interface:** This is the interface that declares the factory method for creating objects. It may also include other methods that operate on the products created by the factory method.

2. **Concrete Creator:** This is a concrete implementation of the creator interface. It overrides the factory method to produce specific products.

3. **Product Interface:** This is the interface for the products created by the factory method. It declares the methods that will be implemented by concrete products.

4. **Concrete Product:** These are the specific implementations of the product interface. They are created by the factory method in concrete creator classes.

## Features and Advantages
- Defines an interface for creating objects but lets subclasses alter the type of objects created.
- Encapsulates the instantiation of a product, making it possible to use different product implementations.

## Notes
- Factory Method Pattern allows a class to delegate the responsibility of instantiating its objects to its subclasses.
- It promotes loose coupling between client code and created objects.

## Benefits of Factory Method Pattern

1. **Flexibility in Object Creation:**
    - Factory Method Pattern provides flexibility in creating objects by allowing subclasses to alter the type of objects that will be created. This promotes scalability and adaptability.

2. **Encapsulation of Object Creation:**
    - The creation of objects is encapsulated within the factory method, making it easy to extend or modify the creation process without affecting the client code.

3. **Loose Coupling:**
    - Client code is decoupled from the specific classes of objects it creates. It relies on the factory method interface, promoting a more maintainable and extendable design.

4. **Common Interface for Products:**
    - Factory Method enforces a common interface for the products created by different concrete creators, ensuring consistency and ease of use.

## Examples of Factory Method Pattern Usage

1. **Document Creation Framework:**
    - A document creation framework may define a factory method for creating different types of documents. Concrete subclasses (e.g., `PdfDocumentCreator`, `TextDocumentCreator`) implement the factory method to create specific document types.

2. **GUI Framework:**
    - In a graphical user interface framework, a factory method may be used to create different types of UI elements, such as buttons, text fields, or windows.

3. **Vehicle Manufacturing:**
    - A vehicle manufacturing system may use a factory method to create different types of vehicles (e.g., cars, bicycles) with specific features and functionalities.

Note: Factory Method Pattern is particularly useful when a class cannot anticipate the class of objects it needs to create, allowing for flexibility and extensibility in object creation.
