package com.example.demo.CourseAPI.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseControllerTest {
@Autowired
CourseController courseController;
    @Test
    void getCourseById() {
        // Check if the name of the course with ID 1 is "Math". If the name is not "Math", the test will fail.
        String courseName = courseController.getCourseById(1).getName();
        assertEquals("Math", courseName);

        // Check if the ID of the returned course matches the requested ID (which is 1).
        int courseId = courseController.getCourseById(1).getId();
        assertEquals(1, courseId);

    }

    }
