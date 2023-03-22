package com.example.demo.CourseAPI.Controller;

import com.example.demo.CourseAPI.Moudle.School;
import com.example.demo.CourseAPI.Moudle.Student;
import com.example.demo.CourseAPI.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {




        @Autowired
        SchoolService schoolService;

        // get school by ID (getById)
        @RequestMapping(value = "getById", method = RequestMethod.GET)
        public School getSchoolById(@RequestParam Integer schoolId) {
            School school = schoolService.getSchoolById(schoolId);
            return school;
        }

    // get all school (getAll)
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    //function that returns all school
    public List<School> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();

        return schools;
    }

    // get all the active schools (getAllActiveSchools)
    @RequestMapping(value = "getAllSchoolByIsActive")
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        return activeSchoolsList;
    }
    // get all the not active schools (getAllSchoolByIsUnActive)
    @RequestMapping(value = "getAllSchoolByIsUnActive")
    public List<School> getAllUnActiveSchools() {
        List<School> notActiveSchoolsList = schoolService.getAllUnActiveSchools();
        return notActiveSchoolsList;
    }
    // gets the Latest row of the school (getSchoolLatestRow)
    @RequestMapping(value = "getSchoolLatestRow")
    public List<School> getSchoolLatestRow() {
        List<School> schoolLatestRowList = schoolService.getSchoolLatestRow();
        return schoolLatestRowList;

    }

    //gets the latest update for school (getSchoolLatestUpdated)
    @RequestMapping(value = "/getSchoolLatestUpdated")
    public List<School> getSchoolLatestUpdated() {
        List<School> schoolLatestUpdatedList = schoolService.getSchoolLatestUpdated();
        return schoolLatestUpdatedList;
    }



}
