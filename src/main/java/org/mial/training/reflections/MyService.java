package org.mial.training.reflections;

import org.mial.training.annotation.InvokeThisMethod;

public class MyService {

    @InvokeThisMethod(repeat = 3)
    public void execute(){
        System.out.println("Execute method");
    }
}
