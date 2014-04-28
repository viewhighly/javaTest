package foundation.serialization;

import java.io.Serializable;

/**
 * User: gaozhan
 * Date: 8/6/13
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Animal implements Serializable {
    int weight;
    String name;
    public Animal(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }
    @Override
    public String toString() {
        return String.format("The name is %s, and the weight is %s", name, weight);
    }

}
