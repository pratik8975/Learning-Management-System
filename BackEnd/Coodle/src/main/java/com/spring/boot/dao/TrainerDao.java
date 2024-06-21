package com.spring.boot.dao;

import com.spring.boot.entities.Trainer;
import java.util.List;

public interface TrainerDao {

    public List<Trainer> findAllTrainers();

    public Trainer save(Trainer Trainer);

    public Trainer update(int id, Trainer trainer);
    
    public Trainer findById(int id);

    public void delete(int id);

}
