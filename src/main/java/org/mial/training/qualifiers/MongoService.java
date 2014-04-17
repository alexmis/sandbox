package org.mial.training.qualifiers;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MongoService implements DBService{

    @Mongo
    private Dao dao;

    @Override
    @PostConstruct
    public void doWork() {
        System.out.println("I'm Mongo Service");
        dao.save();
    }
}
