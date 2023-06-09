package com.example.demo.CourseAPI.Repository;



import com.example.demo.CourseAPI.Moudle.School;
import com.example.demo.CourseAPI.Moudle.Student;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

    @Query(value = "SELECT s from School s")
    List<School> getAllSchools();

    @Query(value = "SELECT s from School s where s.id = :schoolId")
    School getSchoolById(@Param("schoolId") Integer id);

    @Query(value = "SELECT s from School s where s.isActive = true")
    List<School> getAllActiveSchools();

    @Query(value = "SELECT s from School s where s.isActive = false")
    List<School> getAllUnActiveSchools();

    @Query(value = "SELECT sch from School sch where sch.id = (SELECT Max(sch.id) FROM School sch)")
    List<School> getSchoolLatestRow();

    @Query(value = "SELECT sch from School sch where sch.updatedDate = (SELECT MAX(sch.updatedDate) FROM School sch)")
    List<School> getSchoolLatestUpdated();

    @Query("SELECT sch from School sch where sch.createdDate >= :createdDate")
    List<School> getSchoolCreatedAfterDate(Date createdDate);

    @Query("SELECT sch from School sch where sch.name= :schoolName")
    School getSchoolByName(@Param("schoolName") String school_name); // mapping the query and returning the school

    @Query(value = "SELECT sch from School sch where sch.createdDate = :createdDate ")
    List<School> getSchoolsByCreatedDate(Date createdDate);

    @Query(value = "SELECT sch from School sch where sch.updatedDate = :updatedDate ")
    List<School> getSchoolByUpdatedDate(Date updatedDate);


    @Modifying
    @Transactional
    @Query(value = "Update School sch Set sch.isActive = false")
    void deleteAllSchool();


}