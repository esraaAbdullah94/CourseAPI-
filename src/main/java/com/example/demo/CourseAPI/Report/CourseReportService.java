package com.example.demo.CourseAPI.Report;

import com.example.demo.CourseAPI.DTO.MarkDTO;
import com.example.demo.CourseAPI.Moudle.Mark;
import com.example.demo.CourseAPI.Repository.CourseRepository;
import com.example.demo.CourseAPI.Repository.MarkRepository;
import com.example.demo.CourseAPI.Repository.SchoolRepository;
import com.example.demo.CourseAPI.Repository.StudentRepository;
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
public class CourseReportService {
    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    MarkRepository markRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    public static final String pathToReports = "C:\\Users\\user005\\Downloads\\Report";
    public String generateCourseReport() throws FileNotFoundException, JRException {
        List<Mark> markList = markRepository.getAllMarks();
        List<MarkDTO> markDTOArrayList = new ArrayList<>();
        for (Mark markListVariable : markList){
            String courseName = markListVariable.getCourse().getName();
            Integer obtainedMarks = markListVariable.getObtainedMarks();
            Integer grade = markListVariable.getGrade();
            MarkDTO markDTO = new MarkDTO(courseName, obtainedMarks, grade);
            markDTOArrayList.add(markDTO);
        }
        File file = new File("C:\\Users\\user005\\IdeaProjects\\demo.CourseAPI\\demo.CourseAPI\\src\\main\\resources\\Course.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(markDTOArrayList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "TechM");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Course.pdf");
        return "Report generated : " + pathToReports + "\\CourseReport.pdf";

    }

}
