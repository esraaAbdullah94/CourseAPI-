package com.example.demo.CourseAPI.Controller;

import com.example.demo.CourseAPI.Service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(value = "report")
public class ReportController {
    @Autowired
    ReportService reportService;
    @RequestMapping(value = "schoolReport")
    public String generateSchoolsReport() throws JRException, FileNotFoundException {
       return reportService.generateReport();
    }

}
