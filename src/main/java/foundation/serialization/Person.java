package foundation.serialization;

import java.io.Serializable;

/**
 * User: gaozhan
 * Date: 8/6/13
 * Time: 2:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person implements Serializable {
    int age;
    String name;
    int height;
//    public static final long serialVersionUID = -123456L;//Add this line to fix the serialVersionUID of Person in order to maintain a
//  constant number in case of the varing of Person. If this field is not supplied, when Person changes the serialVersionUID will change
    //accordingly.
    public Person(int age, String name, int height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }
public Person(int age, String name) {
    this.age = age;
    this.name = name;

}
    @Override
    public String toString() {
        return String.format("The name is %s, and the age is %s, and height is %s", name, age, height);
//        return String.format("The name is %s, and the age is %s", name, age);
    }
}
