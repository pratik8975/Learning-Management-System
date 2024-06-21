package com.sms.daos;

import com.sms.entities.Trainer;
import com.sms.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class TrainerDaoImpl implements com.sms.daos.TrainerDao {

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
    
//    public Trainer findById(int id){
//
//        return (trainerRepository.findById(id).orElseThrow());
//    }

    public void delete(int id) {
        trainerRepository.deleteById(id);
    }

}
