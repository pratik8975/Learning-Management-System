
package com.sms.daos;

import com.sms.entities.Course;
import com.sms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl implements com.sms.daos.CourseDao {
    
    @Autowired
    CourseRepository courseRepository;
    
    public List<Course> findAllCourses(){
        
        return (courseRepository.findAll());
    }
    
    public Course save(Course course){
        return (courseRepository.save(course));
    }
    
    public Course update(int id, Course course){
        
        Course myCourse = new Course();
        /**
         * Update by field
         * You can find it based the fields
         */
        myCourse = course;
        return (courseRepository.save(course));
    }
    
    public void delete (int id){
        courseRepository.deleteById(id);
    }
}
