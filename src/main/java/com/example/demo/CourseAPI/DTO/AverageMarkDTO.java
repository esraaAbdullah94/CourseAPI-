package com.example.demo.CourseAPI.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AverageMarkDTO {

    public AverageMarkDTO(String courseName, Double averageMark) {
        this.courseName = courseName;
        this.averageMark = averageMark;
    }

    String courseName;
    Double averageMark;
}
