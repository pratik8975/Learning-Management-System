
package com.spring.boot.services;

import com.spring.boot.entities.Assignment;

import java.util.List;

public interface AssignmentService {
    public List<Assignment> findAllAssignments();
    
}
