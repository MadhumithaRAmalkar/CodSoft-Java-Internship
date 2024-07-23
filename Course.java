package com.course.registration;

public class Course {
    private final String courseCode;   // The unique code of the course
    private final String title;        // The title of the course
    private String description;  // A brief description of the course
    private final int capacity;        // The maximum number of students allowed
    private final String schedule;     // The schedule of the course (e.g., MWF 10-11am)
    private int enrolled;        // The current number of enrolled students

    // Constructor to initialize the course object
    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolled = 0;  // Initially, no students are enrolled
    }

    // Getters for the class properties
    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getEnrolled() {
        return enrolled;
    }

    // Method to check if the course is full
    public boolean isFull() {
        return enrolled >= capacity;
    }

    // Method to enroll a student in the course
    public void enrollStudent() {
        if (!isFull()) {
            enrolled++;
        }
    }

    // Method to drop a student from the course
    public void dropStudent() {
        if (enrolled > 0) {
            enrolled--;
        }
    }

    // Overriding the toString method to provide a string representation of the course
    @Override
    public String toString() {
        return courseCode + ": " + title + "\nDescription: " + description +
                "\nCapacity: " + capacity + ", Enrolled: " + enrolled + "\nSchedule: " + schedule;
    }
}
