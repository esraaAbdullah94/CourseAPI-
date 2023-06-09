package com.example.demo.CourseAPI.Service;

import com.example.demo.CourseAPI.Moudle.Course;
import com.example.demo.CourseAPI.Moudle.School;
import com.example.demo.CourseAPI.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public List<Course> getAllActiveCourse() {
        return courseRepository.getAllActiveCourse();
    }
    public List<Course> getAllUnActiveCourse() {
        return courseRepository.getAllUnActiveCourse();
    }

    public List<Course> getCourseLatestRow() {
        return courseRepository.getCourseLatestRow();
    }
    public List<Course> getCourseLatestUpdated() {
        return courseRepository.getCourseLatestUpdated();
    }

    public List<Course> getCourseCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<Course> course = courseRepository.getCourseCreatedAfterDate(convertedDateFromStringToDateFormat);
        return course;
    }

    public List<Course> getCourseByCreatedDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<Course> course = courseRepository.getCourseByCreatedDate(convertedDateFromStringToDateFormat);
        return course;
    }

    public List<Course> getCourseByUpdatedDate(String updatedDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(updatedDate);
        List<Course> course = courseRepository.getCourseByUpdatedDate(convertedDateFromStringToDateFormat);
        return course;
    }

    public List<Course> getCoursesByStudentId(Integer id) {
        List<Course> coursesList = courseRepository.getCoursesByStudentId(id);
        return coursesList;
    }


    public void createCourse(String name) {
        Course course = new Course();
        course.setName(name);
        course.setCreatedDate(new Date());
        course.setUpdatedDate(new Date());
        course.setIsActive(Boolean.TRUE);
        courseRepository.save(course);
    }
}
