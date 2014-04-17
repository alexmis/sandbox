package org.mial.training.heroes;

import org.mial.training.annotation.InjectRandomInt;

public class Dwarf {

    @InjectRandomInt(min = 20, max = 30)
    private int strength;

    @InjectRandomInt(min = 3, max = 18)
    private int dexterity;


    @Override
    public String toString() {
        return "Dwarf{" +
                "strength=" + strength +
                ", dexterity=" + dexterity +
                '}';
    }
}
