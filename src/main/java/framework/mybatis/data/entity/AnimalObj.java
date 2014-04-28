package framework.mybatis.data.entity;

import foundation.serialization.Animal;

/**
 * User: gaozhan
 * Date: 1/21/14
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnimalObj {
    byte[] animal;

    public byte[] getAnimal() {
        return animal;
    }

    public void setAnimal(byte[] animal) {
        this.animal = animal;
    }

    public AnimalObj(byte[] animal) {
        this.animal = animal;
    }
    public AnimalObj()
    {}

}
