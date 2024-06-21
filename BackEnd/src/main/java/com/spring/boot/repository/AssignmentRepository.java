
package com.spring.boot.repository;

import com.spring.boot.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer>{
    
}
