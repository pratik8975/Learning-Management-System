package com.spring.boot.services;

import com.spring.boot.dao.AssignmentDao;
import com.spring.boot.entities.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    AssignmentDao assignmentDao;

    @Override
    public List<Assignment> findAllAssignments() {
        return (assignmentDao.findAllAssignments());
    }

}
