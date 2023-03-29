package com.example.demo.CourseAPI.Repository;

import com.example.demo.CourseAPI.Moudle.Course;
import com.example.demo.CourseAPI.Moudle.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface CourseRepository extends CrudRepository<Course, Integer> {
    @Query("SELECT c from Course c where c.id= :courseId")
    Course getCourseById(@Param("courseId") Integer id);
    @Query("SELECT c from Course c where c.name= :courseName")
    Course getByCourseName(@Param("courseName") String courseName);
    @Query(value = "SELECT c from Course c where c.isActive = true")
    List<Course> getAllActiveCourse();
    @Query(value = "SELECT c from Course c where c.isActive = false")
    List<Course> getAllUnActiveCourse();
@Query(value = "SELECT c from Course c where c.id = (SELECT Max(c.id) FROM Course c)")
    List<Course> getCourseLatestRow();
    @Query(value = "SELECT c from Course c where c.updatedDate = (SELECT MAX(c.updatedDate) FROM Course c)")
    List<Course> getCourseLatestUpdated();
@Query(value = "SELECT c from Course c where c.createdDate >= :createdDate")
    List<Course> getCourseCreatedAfterDate(Date createdDate);
}
