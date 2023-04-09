package com.example.demo.CourseAPI.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MarkDTO {
    public MarkDTO(String courseName, Integer obtainedMarks, Integer grade) {
        this.courseName = courseName;
        this.obtainedMarks = obtainedMarks;
        this.grade = grade;
    }
    String courseName;
    Integer obtainedMarks;
    Integer grade;


}
