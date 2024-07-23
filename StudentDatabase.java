package com.course.registration;

import java.util.HashMap;
import java.util.Map;

public class StudentDatabase {
    private Map<String, Student> students;  // A map of student IDs to student objects

    // Constructor to initialize the student database
    public StudentDatabase() {
        this.students = new HashMap<>();
    }

    // Method to add a student to the database
    public void addStudent(Student student) {
        students.put(student.getStudentID(), student);
    }

    // Method to find a student by their ID
    public Student findStudentByID(String studentID) {
        return students.get(studentID);
    }

    // Method to retrieve all students
    public Map<String, Student> getAllStudents() {
        return students;
    }
}
