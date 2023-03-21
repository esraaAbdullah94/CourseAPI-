package com.example.demo.CourseAPI.Repository;



import com.example.demo.CourseAPI.Moudle.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


    @Query(value = "SELECT st from Student st " +
            "WHERE st.school.id = :id ")
    List<Student> getStudentsBySchoolId(@Param("id") Integer id);
   @Query(value = "SELECT s from Student s")
    List<Student> getAllStudent();

    @Query(value = "SELECT DISTINCT s.school.id FROM Student s")
    List<Integer> getAllStudentBySchoolId();

    @Query(value = "SELECT std from Student std where std.isActive = true")
    List<Student> getAllActiveStudent();

    @Query(value = "SELECT std from Student std where std.isActive = false")
    List<Student> getAllUnActiveStudent();
    @Query(value = "SELECT std from Student std where std.id = (SELECT Max(std.id) FROM Student std)")
    List<Student> getStudentLatestRow();



    @Query(value = "SELECT std from Student std where std.updatedDate = (SELECT MAX(std.updatedDate) FROM Student std)")
    List<Student> getStudentLatestUpdated();
}