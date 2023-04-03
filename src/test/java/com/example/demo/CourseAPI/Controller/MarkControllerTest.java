package com.example.demo.CourseAPI.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MarkControllerTest {
    @Autowired
    MarkController markController;

    @Test
    void getMarkById()throws Exception {

        // Check if the value of the mark with ID 1 is 30. If the value is not 30, the test will fail.
        int markValue = markController.getMarkById(1).getObtainedMarks();
        assertEquals(30, markValue);

        // Check if the ID of the returned mark matches the requested ID (which is 1).
        int markId = markController.getMarkById(1).getId();
        assertEquals(1, markId);


    }

}