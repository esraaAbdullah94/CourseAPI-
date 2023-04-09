package com.example.demo.CourseAPI.Moudle;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data


@Entity
public class Mark extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer obtainedMarks;

    Integer grade;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    Course course;
}