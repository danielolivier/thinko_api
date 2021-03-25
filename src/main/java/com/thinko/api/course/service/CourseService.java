package com.thinko.api.course.service;

import com.thinko.api.course.model.Course;
import com.thinko.api.course.model.DTO.CourseResponse;
import com.thinko.api.course.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private final Logger logger = LoggerFactory.getLogger(CourseService.class);

    @Autowired
    CourseRepository courseRepository;

    public List<CourseResponse> getCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().iterator().forEachRemaining(courses::add);
        List<CourseResponse> responseList = new ArrayList<>();
        for (Course course : courses) {
            CourseResponse response = new CourseResponse(course);
            responseList.add(response);
        };
        return responseList;
    }
}
