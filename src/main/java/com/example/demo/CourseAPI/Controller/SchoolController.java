package com.example.demo.CourseAPI.Controller;

import com.example.demo.CourseAPI.Moudle.School;
import com.example.demo.CourseAPI.Service.SchoolService;
import com.example.demo.CourseAPI.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {

        @Autowired
        SchoolService schoolService;
    @Autowired
    private SlackClient slackClient;

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
        slackClient.sendMessage("Just test");

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
    @RequestMapping(value = "getSchoolLatestUpdated")
    public List<School> getSchoolLatestUpdated() {
        List<School> schoolLatestUpdatedList = schoolService.getSchoolLatestUpdated();
        return schoolLatestUpdatedList;
    }
// test
    //function that checks if there is a date created bigger than the given date (getSchoolCreatedAfterDate)
    @RequestMapping(value = "getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public List<School> getSchoolCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<School> createdAfterDate = schoolService.getSchoolCreatedAfterDate(createdDate);
        return createdAfterDate;
    }
    // function that gets the school by the name (getSchoolByName)
    @RequestMapping(value = "getBySchoolName", method = RequestMethod.GET)
    public School getBySchoolName(@RequestParam String school_name) {
        School schoolName = schoolService.getSchoolByName(school_name);
        return schoolName;
    }
    // Function where it gets all the School Created by the given Date (getSchoolByCreatedDate)
    @RequestMapping(value = "getSchoolByCreatedDate", method = RequestMethod.GET)
    public List<School> getSchoolByCreatedDate(String createdDate) throws ParseException {
        List<School> getSchoolByCreatedDateVariable = schoolService.getSchoolsByCreatedDate(createdDate);
        return getSchoolByCreatedDateVariable;
    }
    // Function where it gets all the School Updated by the given Date (getSchoolByUpdatedDate)
    @RequestMapping(value = "getSchoolByUpdatedDate", method = RequestMethod.GET)
    public List<School> getSchoolByUpdatedDateVariable(String updatedDate) throws ParseException {
        List<School> getSchoolByUpdatedDateVariable = schoolService.getSchoolByUpdatedDate(updatedDate);
        return getSchoolByUpdatedDateVariable;
    }
    @RequestMapping(value = "deleteSchoolById")
    public String deleteSchoolById(Integer id) {
        schoolService.deleteSchoolById(id);
        return "updated successful";
    }
    // This function updates all the school 'isActive' column to false (deleteAllSchool)
    @RequestMapping(value = "deleteAllSchool", method = RequestMethod.POST)
    public String deleteAllSchool() {
        schoolService.deleteAllSchool();
        return "updated successful";
    }

    @RequestMapping(value = "deleteBySchoolName", method = RequestMethod.POST)
    public String deleteBySchoolName(@RequestParam String name) {
            schoolService.deleteBySchoolName(name);
        return "updated successful";
    }
    @RequestMapping(value = "createSchool")
    public void createSchool(String name) {
        schoolService.createSchool(name);
    }




}





