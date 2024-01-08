package com.design.patterns.behavioral.iterator;

import java.util.Iterator;

// Iterator Interface
interface MyIterator {
    boolean hasNext();
    Object next();
}

// Concrete Iterator Class
class ArrayIterator implements MyIterator {
    private Object[] array;
    private int index;

    // Iterator constructor, initializes array and index
    public ArrayIterator(Object[] array) {
        this.array = array;
        this.index = 0;
    }

    // Implementation of hasNext method from Iterator Interface
    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    // Implementation of next method from Iterator Interface
    @Override
    public Object next() {
        if (hasNext()) {
            return array[index++];
        } else {
            return null;
        }
    }
}

// Aggregate Interface (not explicitly defined, but represented by MyArrayContainer)

// Concrete Aggregate Class
class MyArrayContainer {
    private Object[] elements;

    // Container constructor, initializes the array
    public MyArrayContainer(Object[] elements) {
        this.elements = elements;
    }

    // Factory method to create an Iterator for the array
    public MyIterator getIterator() {
        return new ArrayIterator(elements);
    }
}

// Client Code
class Main {
    public static void main(String[] args) {
        // Creating an array
        Object[] myArray = {1, 2, "three", 4.0, true};

        // Creating a container with the array
        MyArrayContainer container = new MyArrayContainer(myArray);

        // Obtaining an Iterator for the array
        MyIterator iterator = container.getIterator();

        // Iterating through the array using the Iterator
        while (iterator.hasNext()) {
            Object element = iterator.next();
            System.out.println(element);
        }
    }
}
