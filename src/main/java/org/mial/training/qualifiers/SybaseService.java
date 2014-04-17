package org.mial.training.qualifiers;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SybaseService implements DBService {

    @Sybase
    private Dao dao;

    @Override
    @PostConstruct
    public void doWork() {
        System.out.println("I'm SYBASE Service");
        dao.save();
    }
}
