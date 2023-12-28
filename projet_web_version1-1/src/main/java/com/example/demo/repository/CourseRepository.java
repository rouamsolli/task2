package com.example.demo.repository;


import com.example.demo.entities.course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<course, Long> {
    // Additional query methods can be added if needed
}
