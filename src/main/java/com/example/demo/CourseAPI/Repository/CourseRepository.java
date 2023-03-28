package com.example.demo.CourseAPI.Repository;

import com.example.demo.CourseAPI.Moudle.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface CourseRepository extends CrudRepository<Course, Integer> {
    @Query("SELECT c from Course c where c.id= :courseId")
    Course getCourseById(@Param("courseId") Integer id);
}
