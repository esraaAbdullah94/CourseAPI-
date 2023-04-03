package com.example.demo.CourseAPI.Service;

import com.example.demo.CourseAPI.Moudle.School;
import com.example.demo.CourseAPI.Moudle.Student;
import com.example.demo.CourseAPI.Repository.SchoolRepository;
import com.example.demo.CourseAPI.Repository.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    public static final String pathToReports = "C:\\Users\\user005\\Downloads\\Report";
    public String generateReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools();

        File file = ResourceUtils.getFile("classpath:School.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Esraa");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\schools.pdf");
        return "Report generated : " + pathToReports+"\\schools.pdf";
    }

//    public String generateReportk() throws FileNotFoundException, JRException {
//        List<Student> studentList = studentRepository.getAllStudent();
//
//        File file = ResourceUtils.getFile("classpath:schoolStudebReport.jrxml");
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentList);
//        Map<String, Object> paramters = new HashMap<>();
//        paramters.put("CreatedBy", "Esraa");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\schoolStudebReport.pdf");
//        return "Report generated : " + pathToReports+"\\schoolStudebReport.pdf";
//    }
}
