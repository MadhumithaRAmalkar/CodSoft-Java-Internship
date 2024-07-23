package com.course.registration;

import java.util.ArrayList;
import java.util.List;

public class CourseDatabase {
    private List<Course> courses;  // The list of courses

    // Constructor to initialize the course database
    public CourseDatabase() {
        this.courses = new ArrayList<>();
    }

    // Method to add a course to the database
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Method to retrieve all courses
    public List<Course> getAllCourses() {
        return courses;
    }

    // Method to find a course by its code
    public Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;  // Return null if the course is not found
    }
}
