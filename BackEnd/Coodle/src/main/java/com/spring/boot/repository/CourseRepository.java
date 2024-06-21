package com.spring.boot.repository;

import com.spring.boot.entities.Course;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
