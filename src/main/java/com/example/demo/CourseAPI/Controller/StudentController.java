package com.example.demo.CourseAPI.Controller;

import com.example.demo.CourseAPI.Moudle.Student;
import com.example.demo.CourseAPI.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @RequestMapping(value = "getBySchoolName", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolName(@RequestParam String schoolName) {
        return studentService.getStudentsBySchoolName(schoolName);
    }

    @RequestMapping(value ="getAllStudent" ,method = RequestMethod.GET)
    public List<Student> getALlStudent(){
        List<Student> stdList=studentService.getAllStudent();
         return stdList;
    }

    @RequestMapping(value = "getAllStudentBySchoolId", method = RequestMethod.GET)
    public List<Integer> getAllStudentBySchoolId(){
        List<Integer> stdListBySchoolId=studentService.getAllStudentBySchoolId();
        return  stdListBySchoolId;
    }
    //GetallActive
    @RequestMapping(value = "getAllStudentByIsActive")
    public List<Student> getAllActiveStudent() {
        List<Student> activeStudentList = studentService.getAllActiveStudent();
        return activeStudentList;
    }
    @RequestMapping(value = "getAllStudentByIsUnActive")
    public List<Student> getAllUnActiveStudent() {
        List<Student> notActiveStudentList = studentService.getAllUnActiveStudent();
        return notActiveStudentList;
    }
    @RequestMapping(value = "getStudentLatestRow")
    public List<Student> getStudentLatestRow() {
        List<Student> studentLatestRowList = studentService.getStudentLatestRow();
        return studentLatestRowList;
    }

}