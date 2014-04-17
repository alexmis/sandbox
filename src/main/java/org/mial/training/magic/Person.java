package org.mial.training.magic;

public class Person {
    private String name;
    private String family;

    public Person(String имя, String фамилия) {
        this.name = имя;
        this.family = фамилия;
    }

    @Override
    public String toString() {
        return "Person{" +
                "family='" + family + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
