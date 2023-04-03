package com.example.demo.CourseAPI.Controller;

import com.example.demo.CourseAPI.Moudle.Course;
import com.example.demo.CourseAPI.Moudle.Student;
import com.example.demo.CourseAPI.Repository.CourseRepository;
import com.example.demo.CourseAPI.Repository.SchoolRepository;
import com.example.demo.CourseAPI.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

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

    @RequestMapping(value = "getByName" , method = RequestMethod.GET)
    public Course getByCourseName(@RequestParam String courseName){
        Course course=courseService.getByCourseName(courseName);
        return course;
    }
    @RequestMapping(value = "getAllCourseByIsActive", method = RequestMethod.GET)
    public List<Course> getAllActiveCourse() {
        List<Course> activeCourseList = courseService.getAllActiveCourse();
        return activeCourseList;
    }
    @RequestMapping(value = "getAllCourseByIsUnActive", method = RequestMethod.GET)
    public List<Course> getAllUnActiveCourse() {
        List<Course> notActiveCourseList = courseService.getAllUnActiveCourse();
        return notActiveCourseList;
    }
    @RequestMapping(value = "getCourseLatestRow", method = RequestMethod.GET)
    public List<Course> getCourseLatestRow() {
       List<Course>  courseLatestRowList = courseService.getCourseLatestRow();
        return courseLatestRowList;
    }
    @RequestMapping(value = "getCourseLatestUpdated")
    public List<Course> getCourseLatestUpdated() {
        List<Course> courseLatestUpdatedList = courseService.getCourseLatestUpdated();
        return courseLatestUpdatedList;
    }
    @RequestMapping(value = "getCourseCreatedAfterDate", method = RequestMethod.GET)
    public List<Course> getCourseCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Course> createdAfterDate = courseService.getCourseCreatedAfterDate(createdDate);
        return createdAfterDate;
    }
    //getCourseByCreatedDate
    @RequestMapping(value = "getCourseByCreatedDate", method = RequestMethod.GET)
    public List<Course> getCourseByCreatedDate(@RequestParam String createdDate) throws ParseException {
        List<Course> createdDateVariable = courseService.getCourseByCreatedDate(createdDate);
        return createdDateVariable;
    }
    @RequestMapping(value = "getCourseByUpdatedDate", method = RequestMethod.GET)
    public List<Course> getCourseByUpdatedDate(@RequestParam String updatedDate) throws ParseException {
        List<Course> updatedDateVariable = courseService.getCourseByUpdatedDate(updatedDate);
        return updatedDateVariable;
    }
    //    // Function that gets all courses from the student ID (getCourseByStudentId)
    @RequestMapping(value = "getCourseByStudentId", method = RequestMethod.GET)
    public List<Course> getCourseByStudentId(@RequestParam Integer id) {
        List<Course> coursesOfAStudent = courseService.getCoursesByStudentId(id);
        return coursesOfAStudent;
    }
    // Create a new course record (createCourse)
    @RequestMapping(value = "createCourse")
    public void createCourse(String name) {
        courseService.createCourse(name);
    }


}
