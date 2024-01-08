package com.design.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

// Component - Common interface for simple and composite components
interface Shape {
    void draw();
}

// Leaf - Simple component
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Leaf - Simple component
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Leaf - Simple component
class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}

// Composite - Composite component
class Group implements Shape {
    private List<Shape> shapes = new ArrayList<>();

    // Add a shape to the list of shapes
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    // Draw all shapes in the group
    @Override
    public void draw() {
        System.out.println("Drawing a Group of Shapes");
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    // Group shapes together
    public void group() {
        System.out.println("Grouping Shapes");
        Group newGroup = new Group();
        newGroup.shapes.addAll(shapes);
        shapes.clear();
        shapes.add(newGroup);
    }

    // Ungroup shapes
    public void ungroup() {
        System.out.println("Ungrouping Shapes");
        List<Shape> ungroupedShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape instanceof Group) {
                Group subgroup = (Group) shape;
                ungroupedShapes.addAll(subgroup.shapes);
            } else {
                ungroupedShapes.add(shape);
            }
        }
        shapes.clear();
        shapes.addAll(ungroupedShapes);
    }
}

// Client code
class CompositePatternExample {
    public static void main(String[] args) {
        // Create simple components
        Circle circle = new Circle();
        Square square = new Square();
        Triangle triangle = new Triangle();

        // Create groups
        Group group1 = new Group();
        Group group2 = new Group();

        // Add shapes to the first group
        group1.addShape(circle);
        group1.addShape(square);
        group1.draw();

        // Add shapes to the second group
        group2.addShape(triangle);
        group2.draw();

        // Create a top-level group
        Group topLevelGroup = new Group();
        topLevelGroup.addShape(group1);
        topLevelGroup.addShape(group2);

        // Draw the entire structure
        topLevelGroup.draw();

        // Grouping the top-level group
        topLevelGroup.group();

        // Draw the grouped structure
        topLevelGroup.draw();

        // Ungrouping the top-level group
        topLevelGroup.ungroup();

        // Draw the ungrouped structure
        topLevelGroup.draw();
    }
}