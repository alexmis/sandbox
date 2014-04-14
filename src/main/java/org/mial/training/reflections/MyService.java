package org.mial.training.reflections;

import org.mial.training.reflections.RunThisMethod;

public class MyService {

    @RunThisMethod(repeat = 3)
    public void execute(){
        System.out.println("Execute method");
    }
}
