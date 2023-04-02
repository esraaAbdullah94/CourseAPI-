package com.example.demo.CourseAPI.Controller;


import com.example.demo.CourseAPI.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping(value = "general")
@RestController
public class GeneralController {

    @Autowired
    SlackClient slackClient;

    @GetMapping(value = "slackMessage")
    public void message(@RequestParam String text){
        slackClient.sendMessage(text);
    }
}
