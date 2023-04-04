package com.example.demo.CourseAPI.Controller;

import com.example.demo.CourseAPI.Report.StudentSchoolReportService;
import com.example.demo.CourseAPI.Service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(value = "report")
public class ReportController {
    @Autowired
    ReportService reportService;
    @Autowired
    StudentSchoolReportService studentSchoolReport;
    @RequestMapping(value = "schoolReport" ,method = RequestMethod.GET)
    public String generateSchoolsReport() throws JRException, FileNotFoundException {
       return reportService.generateReport();
    }

    @RequestMapping(value = "studentReport" ,method = RequestMethod.GET)
    public void generateReport() throws JRException, FileNotFoundException {
        studentSchoolReport.generateReport();
    }



}
