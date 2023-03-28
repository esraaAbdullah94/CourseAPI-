package com.example.demo.CourseAPI.Controller;

import com.example.demo.CourseAPI.Moudle.Course;
import com.example.demo.CourseAPI.Repository.CourseRepository;
import com.example.demo.CourseAPI.Repository.SchoolRepository;
import com.example.demo.CourseAPI.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    SchoolRepository schoolRepository;


    @RequestMapping(value = "getById", method = RequestMethod.GET) // "course/getById" is a prefix
    public Course getCourseById(@RequestParam Integer courseId) { //Request Parameter gets the parameter you want
        Course course = courseService.getCourseById(courseId);
        return course;
    }
}
