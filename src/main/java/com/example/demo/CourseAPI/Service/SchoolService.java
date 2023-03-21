package com.example.demo.CourseAPI.Service;

import com.example.demo.CourseAPI.Moudle.School;
import com.example.demo.CourseAPI.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;
    public School getSchoolByName(String schoolName) {
        School school = schoolRepository.getBySchoolName(schoolName);
        return school;
    }

}
