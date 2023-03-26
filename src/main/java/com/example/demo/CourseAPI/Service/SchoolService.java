package com.example.demo.CourseAPI.Service;

import com.example.demo.CourseAPI.Moudle.School;
import com.example.demo.CourseAPI.Repository.SchoolRepository;
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


    public School getSchoolById(Integer schoolId) {

        return  schoolRepository.getSchoolById(schoolId);
    }

    public List<School> getAllSchools() {
        return schoolRepository.getAllSchools();
    }

    public List<School> getAllActiveSchools() {
        return schoolRepository.getAllActiveSchools();
    }

    public List<School> getAllUnActiveSchools() {
        return  schoolRepository.getAllUnActiveSchools();
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

}
