package com.example.demo.services;

// src/main/java/com/example/demo/service/CourseService.java

import com.example.demo.entities.course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<course> getAllCourses() {
        return courseRepository.findAll();
    }

    public course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    public course createCourse(course course) {
        return courseRepository.save(course);
    }

    public course updateCourse(Long id, course updatedCourse) {
        course existingCourse = getCourseById(id);

        existingCourse.setTitle(updatedCourse.getTitle());
        existingCourse.setDescription(updatedCourse.getDescription());
        existingCourse.setImage(updatedCourse.getImage());
        existingCourse.setPrice(updatedCourse.getPrice());

        return courseRepository.save(existingCourse);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
