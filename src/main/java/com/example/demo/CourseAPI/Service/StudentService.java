package com.example.demo.CourseAPI.Service;


import com.example.demo.CourseAPI.Moudle.School;
import com.example.demo.CourseAPI.Moudle.Student;
import com.example.demo.CourseAPI.Repository.SchoolRepository;
import com.example.demo.CourseAPI.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SchoolRepository schoolRepository;

    public void addStudent() {
        Student student = new Student();
        student.setName("Muzzamil Arif");
        student.setRollNumber("1");
        studentRepository.save(student);

    }



    public List<Student> getStudentsBySchoolName(String schoolName){
        School school = schoolRepository.getBySchoolName(schoolName);
        Integer schoolId = school.getId();
        List<Student> studentList = studentRepository.getStudentsBySchoolId(schoolId);
        return studentList;
    }


    public List<Student> getAllStudent() {
        List<Student> stdList=studentRepository.getAllStudent();
        return stdList;
    }

    public List<Integer> getAllStudentBySchoolId() {
        List<Integer> stdListBySchoolId=studentRepository.getAllStudentBySchoolId();
        return stdListBySchoolId;
    }

    public List<Student> getAllActiveStudent(){
        return studentRepository.getAllActiveStudent();
    }

    public List<Student> getAllUnActiveStudent(){
        return studentRepository.getAllUnActiveStudent();
    }

    public List<Student> getStudentLatestRow() {
        return studentRepository.getStudentLatestRow();
    }

    public List<Student> getStudentLatestUpdated() {
        return studentRepository.getStudentLatestUpdated();
    }
}