
package com.spring.boot.dao;

import com.spring.boot.entities.Course;
import java.util.List;

public interface CourseDao {
    
    public List<Course> findAllCourses();
    
    public Course save(Course course);
    
    public Course update(int id, Course course);
    
    public void delete(int id);    
}
