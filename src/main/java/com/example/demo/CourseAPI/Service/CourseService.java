package com.example.demo.CourseAPI.Service;

import com.example.demo.CourseAPI.Moudle.Course;
import com.example.demo.CourseAPI.Moudle.School;
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

    public Course getByCourseName(String course_name) {
        Course courseName = courseRepository.getByCourseName(course_name);
        return courseName;
    }
}
