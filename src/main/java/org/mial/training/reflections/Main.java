package org.mial.training.reflections;

public class Main {

    public static void main(String[] args) throws Exception {
        MyService myService = ObjectFactory.getInstance().createObject(MyService.class);
    }
}
