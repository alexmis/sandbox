package org.mial.training.qualifiers;

@Mongo
public class MongoDao implements Dao {
    @Override
    public void save() {
        System.out.println("save as MONGo");
    }
}
