
package com.spring.boot.services;

import com.spring.boot.entities.Course;
import java.util.List;

public interface CourseService {
    
    public List<Course> findAllCourses();   
}
