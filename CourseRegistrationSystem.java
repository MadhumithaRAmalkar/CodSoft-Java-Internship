package com.course.registration;

import java.util.Scanner;

public class CourseRegistrationSystem {
    private static CourseDatabase courseDatabase = new CourseDatabase();  // The course database
    private static StudentDatabase studentDatabase = new StudentDatabase();  // The student database
    private static Scanner scanner = new Scanner(System.in);  // Scanner for user input

    public static void main(String[] args) {
        // Adding some sample courses
        courseDatabase.addCourse(new Course("CS101", "Intro to Computer Science", "Basics of computer science", 30, "MWF 10-11am"));
        courseDatabase.addCourse(new Course("MATH101", "Calculus I", "Introduction to calculus", 25, "TTh 9-10:30am"));

        // Adding some sample students
        studentDatabase.addStudent(new Student("S1001", "Alice"));
        studentDatabase.addStudent(new Student("S1002", "Bob"));

        // Main menu loop
        while (true) {
            System.out.println("\nCourse Registration System");
            System.out.println("1. Display Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    displayAvailableCourses();
                    break;
                case 2:
                    registerCourse();
                    break;
                case 3:
                    dropCourse();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to display all available courses
    private static void displayAvailableCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course course : courseDatabase.getAllCourses()) {
            System.out.println(course);
        }
    }

    // Method to register a student for a course
    private static void registerCourse() {
        System.out.print("\nEnter Student ID: ");
        String studentID = scanner.nextLine();
        Student student = studentDatabase.findStudentByID(studentID);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        Course course = courseDatabase.findCourseByCode(courseCode);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        student.registerCourse(course);
        System.out.println("Registered for course: " + course.getTitle());
    }

    // Method to drop a student from a course
    private static void dropCourse() {
        System.out.print("\nEnter Student ID: ");
        String studentID = scanner.nextLine();
        Student student = studentDatabase.findStudentByID(studentID);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        Course course = courseDatabase.findCourseByCode(courseCode);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        student.dropCourse(course);
        System.out.println("Dropped course: " + course.getTitle());
    }
}
