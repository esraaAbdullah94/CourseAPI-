package com.example.demo.CourseAPI.Service;

import com.example.demo.CourseAPI.Moudle.Course;
import com.example.demo.CourseAPI.Moudle.School;
import com.example.demo.CourseAPI.Repository.SchoolRepository;
import com.example.demo.CourseAPI.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    private StudentRepository studentRepository;



    public School getSchoolById(Integer schoolId) {

        return schoolRepository.getSchoolById(schoolId);
    }

    public List<School> getAllSchools() {
        return schoolRepository.getAllSchools();
    }

    public List<School> getAllActiveSchools() {
        return schoolRepository.getAllActiveSchools();
    }

    public List<School> getAllUnActiveSchools() {
        return schoolRepository.getAllUnActiveSchools();
    }

    public List<School> getSchoolLatestRow() {
        return schoolRepository.getSchoolLatestRow();
    }

    public List<School> getSchoolLatestUpdated() {
        return schoolRepository.getSchoolLatestUpdated();
    }

    //function that checks if there is a date created bigger than the given date (getSchoolCreatedAfterDate)
    public List<School> getSchoolCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<School> schools = schoolRepository.getSchoolCreatedAfterDate(convertedDateFromStringToDateFormat);
        return schools;
    }

    // function that gets the school by the name (getSchoolByName)
    public School getSchoolByName(String school_name) {
        School schoolName = schoolRepository.getSchoolByName(school_name);// getting the school_name from the user
        return schoolName;
    }

    // Function where it gets all the School Created by the given Date (getSchoolsByCreatedDate)
    public List<School> getSchoolsByCreatedDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<School> schools = schoolRepository.getSchoolsByCreatedDate(convertedDateFromStringToDateFormat);
        return schools;
    }


    // Function that gets all school create by the given updated date (getSchoolByUpdatedDate)
    public List<School> getSchoolByUpdatedDate(String updatedDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(updatedDate);
        List<School> schools = schoolRepository.getSchoolByUpdatedDate(convertedDateFromStringToDateFormat);
        return schools;
    }

    public void deleteSchoolById(Integer id) {
        School school = schoolRepository.getSchoolById(id);
        school.setIsActive(Boolean.FALSE);
        schoolRepository.save(school);

    }

    public void deleteAllSchool() {
        schoolRepository.deleteAllSchool();
    }

    public void deleteBySchoolName(String name) {
        School school = schoolRepository.getSchoolByName(name);
        school.setIsActive(Boolean.FALSE);
        schoolRepository.save(school);
    }


    public void createSchool(String name) {
       School school = new School();
        school.setName(name);
        school.setCreatedDate(new Date());
        school.setUpdatedDate(new Date());
        school.setIsActive(Boolean.TRUE);
       schoolRepository.save(school);


    }
}
