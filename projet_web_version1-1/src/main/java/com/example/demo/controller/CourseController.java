package com.example.demo.controller;

// CourseController.java

import com.example.demo.entities.course;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public course createCourse(@RequestBody course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public course updateCourse(@PathVariable Long id, @RequestBody course updatedCourse) {
        return courseService.updateCourse(id, updatedCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}

