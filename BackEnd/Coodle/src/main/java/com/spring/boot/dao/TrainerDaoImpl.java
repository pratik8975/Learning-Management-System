package com.spring.boot.dao;

import com.spring.boot.entities.Trainer;
import com.spring.boot.repository.TrainerRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TrainerDaoImpl implements TrainerDao {

    @Autowired
    TrainerRepository trainerRepository;

    public List<Trainer> findAllTrainers() {

        return (trainerRepository.findAll());
    }

    public Trainer save(Trainer trainer) {
        return (trainerRepository.save(trainer));
    }

    public Trainer update(int id, Trainer trainer) {

        Trainer myTrainer = new Trainer();
        /**
         * Update by field You can find it based the fields
         */
        myTrainer = trainer;
        return (trainerRepository.save(trainer));
    }
    
    public Trainer findById(int id){
        
        return (trainerRepository.findById(id).orElseThrow());
    }

    public void delete(int id) {
        trainerRepository.deleteById(id);
    }

}
