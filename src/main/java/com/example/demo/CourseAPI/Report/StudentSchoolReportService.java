package com.example.demo.CourseAPI.Report;

import com.example.demo.CourseAPI.DTO.StudentDTO;
import com.example.demo.CourseAPI.Moudle.Student;
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
public class StudentSchoolReportService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    public static final String pathToReports = "C:\\Users\\user005\\Downloads\\Report";

    public String generateReport() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudent();
        List<StudentDTO> StudentDTOList = new ArrayList<>();
        for (Student studentListVariable : studentList) {
            String schoolName = studentListVariable.getSchool().getName();
            String studentName = studentListVariable.getName();
            String studentRollNumber = studentListVariable.getRollNumber();
            StudentDTO studentDTO = new StudentDTO(schoolName, studentName, studentRollNumber);
            StudentDTOList.add(studentDTO);
        }

            File file = new File("C:\\Users\\user005\\IdeaProjects\\demo.CourseAPI\\demo.CourseAPI\\src\\main\\resources\\schoolStudebReport.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(StudentDTOList);
            Map<String, Object> paramters = new HashMap<>();
            paramters.put("CreatedBy", "TechM");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\schoolStudebReport.pdf");
            return "Report generated : " + pathToReports + "\\schoolStudebReport.pdf";
        }


}
