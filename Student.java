package com.course.registration;

import java.util.ArrayList;
import java.util.List;

class Student {
    private String studentID;   // The unique ID of the student
    private String name;        // The name of the student
    private List<Course> courses;  // The list of courses the student is registered for

    // Constructor to initialize the student object
    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.courses = new ArrayList<>();  // Initially, the student is not registered for any courses
    }

    // Getters for the class properties
    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    // Method to register the student for a course
    public void registerCourse(Course course) {
        if (!course.isFull()) {
            courses.add(course);
            course.enrollStudent();
        }
    }

    // Method to drop the student from a course
    public void dropCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            course.dropStudent();
        }
    }

    // Overriding the toString method to provide a string representation of the student
    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name + ", Registered courses: " + courses.size();
    }
}
