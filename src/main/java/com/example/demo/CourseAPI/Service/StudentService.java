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

    public Student getStudentById(Integer stdId) {

        return studentRepository.getStudentById(stdId);

    }

    public Student getStudentByName(String stdName){
        return studentRepository.getStudentByName(stdName);
    }
}