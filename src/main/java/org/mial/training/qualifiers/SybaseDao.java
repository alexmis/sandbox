package org.mial.training.qualifiers;

@Sybase
public class SybaseDao implements Dao {
    @Override
    public void save() {
        System.out.println("save as Sybase");
    }
}
