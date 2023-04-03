package com.example.demo.CourseAPI.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentControllerTest {
    @Autowired
    StudentController studentController;

    @Test
    void getStudentById() {
        // Check if the name of the student with ID 1 is "Safa". If the name is not "Safa", the test will fail.
        String studentName = studentController.getStudentById(1).getName();
        assertEquals("Safa", studentName);

        // Check if the ID of the returned student matches the requested ID (which is 1).
        int studentId = studentController.getStudentById(1).getId();
        assertEquals(1, studentId);

    }
}