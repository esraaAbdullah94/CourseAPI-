package com.example.demo.CourseAPI.Repository;


import com.example.demo.CourseAPI.Moudle.Course;
import com.example.demo.CourseAPI.Moudle.Mark;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarkRepository extends CrudRepository<Mark, Integer> {

    @Query("SELECT m from Mark m where m.id= :markId")
    Mark getMarkById(@Param("markId") Integer id);

    @Query("SELECT m from Mark m")
    List<Mark> getAllMarks();
}