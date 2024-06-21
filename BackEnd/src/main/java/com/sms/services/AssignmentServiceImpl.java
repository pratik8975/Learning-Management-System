package com.sms.services;

import com.sms.daos.AssignmentDao;
import com.sms.entities.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssignmentServiceImpl implements com.sms.services.AssignmentService {

    @Autowired(required = false)
    AssignmentDao assignmentDao;

    @Override
    public List<Assignment> findAllAssignments() {
        return (assignmentDao.findAllAssignments());
    }

}
