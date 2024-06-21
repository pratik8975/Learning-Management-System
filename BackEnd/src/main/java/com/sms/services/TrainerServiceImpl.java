package com.sms.services;

import com.sms.daos.TrainerDaoImpl;
import com.sms.daos.UserDaoImpl;
import com.sms.entities.*;

import com.sms.entities.dto.requests.TrainerRequest;
import com.sms.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TrainerServiceImpl implements com.sms.services.TrainerService {

    @Autowired(required = false)
    private TrainerDaoImpl trainerDao;

    @Autowired(required = false)
    private UserDaoImpl userDao;

    @Autowired(required = false)
    private RoleRepository roleRepository;

    @Override
    public List<Trainer> findAllTrainers() {

        return trainerDao.findAllTrainers();
    }

    @Override
    public void update(int id, TrainerRequest trainerRequest) {
        

        trainerDao.update(id, setTrainer(id, trainerRequest, setUser(id, trainerRequest)));
        userDao.updateUserTrainer(setUser(id, trainerRequest));
    }
    
    public User setUser(int id, TrainerRequest trainerRequest) {
        User user = new User();
        user.setId(id);
        user.setPassword(trainerRequest.getPassword());
        user.setEmail(trainerRequest.getEmail());
        user.setFirstName(trainerRequest.getFirstName());
        user.setLastName(trainerRequest.getLastName());
        System.err.println("Check set user"+ user);
        return user;
    }

    public Trainer setTrainer(int id, TrainerRequest trainerRequest, User user) {
        
        Trainer trainer = new Trainer();
        trainer.setId(id);
        trainer.setSubbject(trainerRequest.getSubject());
        trainer.setUser(user);
        return trainer;
    }

    @Override
    public Trainer findById(int id) {

        return (trainerDao.findById(id));
    }

    /**
     *
     * @param trainerRequest
     */
    @Override
    public void save(TrainerRequest trainerRequest) {
        Trainer trainer = new Trainer();
        User user = setUser(trainerRequest);
        Set<Role> roles = setRoles();
        user.setRoles(roles);
        //save user trainer in user table
        user = userDao.save(user);
        trainer.setSubbject(trainerRequest.getSubject());
        trainer.setUser(user);
        //save trainer in table trainer
        trainerDao.save(trainer);

    }

    public Set<Role> setRoles() {
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByRole(ERole.ROLE_MODERATOR)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        return roles;
    }

    public User setUser(TrainerRequest trainerRequest) {
        User user = new User();
        user.setEmail(trainerRequest.getEmail());
        user.setFirstName(trainerRequest.getFirstName());
        user.setLastName(trainerRequest.getLastName());
        user.setPassword(trainerRequest.getPassword());
        return user;
    }

    @Override
    public void delete(int id) {

        trainerDao.delete(id);
    }

}
