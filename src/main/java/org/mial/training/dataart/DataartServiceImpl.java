package org.mial.training.dataart;

import org.mial.training.annotation.Benchmark;
import org.mial.training.annotation.Transactional;

@Benchmark
public class DataartServiceImpl implements DataartService {
    @Override
    @Transactional
    public void save() {
        System.out.println("Saving...");
    }

    @Override
    public void load() {
        System.out.println("Loading...");
    }
}
