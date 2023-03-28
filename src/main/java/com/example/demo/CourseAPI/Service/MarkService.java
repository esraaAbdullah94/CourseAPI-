package com.example.demo.CourseAPI.Service;

import com.example.demo.CourseAPI.Moudle.Course;
import com.example.demo.CourseAPI.Moudle.Mark;
import com.example.demo.CourseAPI.Repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkService {
@Autowired
MarkRepository markRepository;

    public Mark getMarkById(Integer id) {
        Mark mark = markRepository.getMarkById(id);
        return mark;
    }
}
