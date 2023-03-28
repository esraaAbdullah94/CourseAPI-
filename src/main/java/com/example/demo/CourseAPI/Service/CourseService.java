package com.example.demo.CourseAPI.Service;

import com.example.demo.CourseAPI.Moudle.Course;
import com.example.demo.CourseAPI.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CourseService {

    @Autowired
    CourseRepository courseRepository;


    public Course getCourseById(Integer id) {
        Course course = courseRepository.getCourseById(id);
        return course;
    }


}
