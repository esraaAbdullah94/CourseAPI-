package com.example.demo.CourseAPI.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SchoolControllerTest {
    @Autowired
    SchoolController schoolController;
    @Test
    void getSchoolById()  throws Exception{
        String SchoolName=schoolController.getSchoolById(1).getName();
        assertEquals("Musact", SchoolName);

    }
    @Test
    void getSchoolByIdTow()  throws Exception{
        String SchoolName=schoolController.getSchoolById(2).getName();
        assertEquals("Nizwa", SchoolName);

    }
    @Test
    void getSchoolByIdThree()  throws Exception{
        String SchoolName=schoolController.getSchoolById(3).getName();
        assertEquals("Matrah", SchoolName);

    }
    @Test
    void getSchoolByIdFour()  throws Exception{
        String SchoolName=schoolController.getSchoolById(1).getName();
        assertEquals("Musact", SchoolName);

    }


}