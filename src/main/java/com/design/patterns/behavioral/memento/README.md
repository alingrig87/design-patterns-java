# Memento Pattern

## Description
The Memento Pattern is a behavioral design pattern that allows an object's internal state to be captured and externalized so that the object can be restored to this state later. This pattern is useful in scenarios where the state of an object needs to be saved and restored without exposing its internal details.

## Components
1. **Originator:**
    - This is the object whose state needs to be saved. It creates a memento containing a snapshot of its internal state and can restore its state from a memento.

2. **Memento:**
    - This is an object that stores the internal state of the originator. It provides a way to retrieve the state and, in some cases, modify it.

3. **Caretaker:**
    - This is an object that is responsible for keeping track of multiple mementos. It does not operate on or modify the mementos but holds them for the originator.

## Features and Advantages
- Allows the capture and externalization of an object's internal state.
- Provides a mechanism for undo/redo functionality.
- Encapsulates the state management, preventing direct access to the originator's internal details.

## Notes
- Memento Pattern is especially useful when implementing features like undo/redo functionality or when the internal state of an object needs to be saved and restored.

## Benefits of Memento Pattern

1. **State Preservation:**
    - Enables an object to capture its internal state and restore it, providing a convenient way to revert to previous states.

2. **Encapsulation of State:**
    - The internal state of the originator is encapsulated within the memento objects, preventing direct access and maintaining object integrity.

3. **Support for Undo/Redo:**
    - Facilitates the implementation of undo/redo functionality by keeping a history of the object's states.

4. **Flexibility in State Management:**
    - Allows for flexible management of an object's state, supporting various strategies for state retention and restoration.

## Examples of Memento Pattern Usage

1. **Text Editor with Undo/Redo:**
    - A text editor can use the Memento Pattern to implement undo and redo functionality by creating mementos for each state change.

2. **Game State Management:**
    - In a game, the Memento Pattern can be employed to save and restore the state of a game character or level.

