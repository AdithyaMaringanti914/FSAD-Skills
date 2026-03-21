package com.university.studentapi.controller;

import com.university.studentapi.dto.Student;
import com.university.studentapi.exception.InvalidInputException;
import com.university.studentapi.exception.StudentNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StudentController {

    private static final Map<Long, Student> STUDENTS = Map.of(
            1L, new Student(1L, "Vamsi Krishna", "Computer Science"),
            2L, new Student(2L, "Rahul", "Mechanical Engineering"),
            3L, new Student(3L, "Sneha", "Electronics")
    );

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable String id) {
        Long studentId;
        try {
            studentId = Long.parseLong(id);
        } catch (NumberFormatException ex) {
            throw new InvalidInputException("Invalid student ID format. Please provide a numeric ID.");
        }

        Student student = STUDENTS.get(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student with ID " + studentId + " not found.");
        }

        return student;
    }
}
