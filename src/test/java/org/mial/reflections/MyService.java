package org.mial.reflections;

public class MyService {

    @RunThisMethod(repeat = 3)
    public void execute(){
        System.out.println("Execute method");
    }
}
