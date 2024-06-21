package com.sms.services;

import com.sms.daos.CourseDao;
import com.sms.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements com.sms.services.CourseService {

    @Autowired
    CourseDao courseDao;

    public List<Course> findAllCourses() {
        return (courseDao.findAllCourses());
    }
}
