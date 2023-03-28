package com.example.demo.CourseAPI.Controller;

import com.example.demo.CourseAPI.Moudle.School;
import com.example.demo.CourseAPI.Moudle.Student;
import com.example.demo.CourseAPI.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {


    @Autowired
    StudentService studentService;



    @RequestMapping(value = "getById", method = RequestMethod.GET) // "student/getById" is a prefix
    public Student getStudentById(@RequestParam Integer studentId) { //Request Parameter gets the parameter you want
        Student student = studentService.getStudentById(studentId); // so the school will return school = schoolService.getSchoolById(id)
        return student;
    }

    @RequestMapping(value = "getByName" , method = RequestMethod.GET)
    public Student getStudentByName(@RequestParam String stdName){
        Student std=studentService.getStudentByName(stdName);
        return std;
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
    @RequestMapping(value = "getStudentLatestUpdated")
    public List<Student> getStudentLatestUpdated() {
        List<Student> StudentLatestUpdated = studentService.getStudentLatestUpdated();

        return StudentLatestUpdated;
    }

    public List<Student> getStudentByCreatedDate(String createdDate) throws ParseException {
        List<Student> getStudentByCreatedDateVariable = studentService.getStudentByCreatedDate(createdDate);
        return getStudentByCreatedDateVariable;
    }

    @RequestMapping(value = "getStudentsByUpdatedDate", method = RequestMethod.GET)
    public List<Student> getStudentsByUpdatedDate(String updatedDate) throws ParseException {
        List<Student> getStudentByUpdatedDateVariable = studentService.getStudentByUpdatedDate(updatedDate);
        return getStudentByUpdatedDateVariable;
    }


}