package com.design.patterns.structural.bridge;

// Implementor - CourseDisplayAPI interface
interface CourseDisplayAPI {
    void display(String courseName);
}

// Concrete Implementor - SimpleDisplay
class SimpleDisplay implements CourseDisplayAPI {
    @Override
    public void display(String courseName) {
        System.out.println("Simple Display: Displaying course - " + courseName);
    }
}

// Concrete Implementor - DetailedDisplay
class DetailedDisplay implements CourseDisplayAPI {
    @Override
    public void display(String courseName) {
        System.out.println("Detailed Display: Displaying detailed information for course - " + courseName);
    }
}

// Abstraction - Course
abstract class Course {
    protected CourseDisplayAPI displayAPI;
    protected String courseType;

    protected Course(String courseType, CourseDisplayAPI displayAPI) {
        this.courseType = courseType;
        this.displayAPI = displayAPI;
    }

    abstract void show();
}

// Refined Abstraction - CrashCourse
class CrashCourse extends Course {
    public CrashCourse(String courseType, CourseDisplayAPI displayAPI) {
        super(courseType, displayAPI);
    }

    @Override
    void show() {
        System.out.println(courseType + ": Displaying " + courseType + " course");
        displayAPI.display(courseType);
    }
}

// Refined Abstraction - AdvancedCourse
class AdvancedCourse extends Course {
    public AdvancedCourse(String courseType, CourseDisplayAPI displayAPI) {
        super(courseType, displayAPI);
    }

    @Override
    void show() {
        System.out.println(courseType + ": Displaying " + courseType + " course");
        displayAPI.display(courseType);
    }
}

// Client code
class BridgePatternExample {
    public static void main(String[] args) {
        CourseDisplayAPI simpleDisplay = new SimpleDisplay();
        CourseDisplayAPI detailedDisplay = new DetailedDisplay();

        Course crashCourse = new CrashCourse("Crash Course", simpleDisplay);
        Course advancedCourse = new AdvancedCourse("Advanced Course", detailedDisplay);

        crashCourse.show();
        System.out.println("----------");
        advancedCourse.show();
    }
}

