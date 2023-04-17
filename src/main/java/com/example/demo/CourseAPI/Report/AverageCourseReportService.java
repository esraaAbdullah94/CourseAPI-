package com.example.demo.CourseAPI.Report;

import com.example.demo.CourseAPI.DTO.AverageMarkDTO;
import com.example.demo.CourseAPI.Moudle.Course;
import com.example.demo.CourseAPI.Moudle.Mark;
import com.example.demo.CourseAPI.Repository.CourseRepository;
import com.example.demo.CourseAPI.Repository.MarkRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AverageCourseReportService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    MarkRepository markRepository;

    @Autowired
    public static final String pathToReports = "C:\\Users\\user005\\Downloads\\Report";

    public String generateAverageCourseReport() throws FileNotFoundException, JRException {
        List<Mark> markList = markRepository.getAllMarks();// Retrieving all the marks from the database.
        List<AverageMarkDTO> CourseNameWithAverageMarkDTOList = new ArrayList<>(); // Creating new ArrayList to store the data that will be used to generate the report.
        Map<String, List<Integer>> courseObtainedMarksMap = new HashMap<>(); // Creating a new hashmap to store the obtained marks for each course. String for course name and integer for obtain marks
        for (Mark mark : markList) { // loop is used to iterate over each Mark object in the markList.
            String courseName = mark.getCourse().getName(); // table mark there is foreign key of course
            Integer obtainedMarks = mark.getObtainedMarks();
            if (courseObtainedMarksMap.containsKey(courseName)) { // this is used to check if the obtain mark is added to the list or not,\
                // if not then a new list is created with the obtain mark and the course name is added with the hashmap.
                courseObtainedMarksMap.get(courseName).add(obtainedMarks);
            } else {
                List<Integer> obtainedMarksList = new ArrayList<>();
                obtainedMarksList.add(obtainedMarks);
                courseObtainedMarksMap.put(courseName, obtainedMarksList);
            }

        }
        // Loop through the courseObtainedMarksMap and calculate the averageMarks for each courseName
        for (String courseName : courseObtainedMarksMap.keySet()) {
            List<Integer> obtainedMarksList = courseObtainedMarksMap.get(courseName);
            Double sum = 0.0;
            for (Integer obtainedMark : obtainedMarksList) {
                sum = sum + obtainedMark;
            }
            Double averageMark = sum / obtainedMarksList.size();

            AverageMarkDTO markDTOListObj = new AverageMarkDTO(courseName, averageMark);
            CourseNameWithAverageMarkDTOList.add(markDTOListObj);
        }
        File file = new File("C:\\Users\\user005\\IdeaProjects\\demo.CourseAPI\\demo.CourseAPI\\src\\main\\resources\\AverageMark.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(CourseNameWithAverageMarkDTOList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "TechM");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\AverageMark.pdf");

        return "Report generated : " + pathToReports + "\\AverageMark.pdf";
    }
}


