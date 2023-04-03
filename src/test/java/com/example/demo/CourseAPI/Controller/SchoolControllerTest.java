package com.example.demo.CourseAPI.Controller;

import com.example.demo.CourseAPI.Moudle.School;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SchoolControllerTest {
    @Autowired
    SchoolController schoolController;
    @Test
    void getSchoolById()  throws Exception{
        //checks if the name of the school with ID 1 is "Musact". If the name is not "Musact", the test will fail.
        String SchoolName=schoolController.getSchoolById(1).getName();
        assertEquals("Musact", SchoolName);
        // Assert that the ID of the returned school matches the requested ID
        int schoolId = schoolController.getSchoolById(1).getId();
        assertEquals(1, schoolId);
        //checks if an exception is thrown when attempting to get a school with an ID that does not exist (in this case, ID 30). If an exception is not thrown, the test will fail.
        assertThrows(Exception.class, (Executable) schoolController.getSchoolById(30));
    }
    @Test
    void getAllSchools() throws Exception {
        List<School> schools = schoolController.getAllActiveSchools();
        assertNotNull(schools);
    }
    



}