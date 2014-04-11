package org.mial.training.inter0.reflections;

public class Main {

    public static void main(String[] args) throws Exception {
        MyService myService = ObjectFactory.getInstance().createObject(MyService.class);
    }
}
