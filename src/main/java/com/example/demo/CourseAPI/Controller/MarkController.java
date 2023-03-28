package com.example.demo.CourseAPI.Controller;

import com.example.demo.CourseAPI.Moudle.Mark;
import com.example.demo.CourseAPI.Service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "mark")
public class MarkController {
    @Autowired
    MarkService markService;
    @RequestMapping(value = "getById", method = RequestMethod.GET)              //getMarkById
    public Mark getMarkById(@RequestParam Integer markId) {
        Mark mark = markService.getMarkById(markId);
        return mark;
    }
}
