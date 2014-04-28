package framework.mybatis.data.entity;

/**
 * User: gaozhan
 * Date: 1/16/14
 * Time: 3:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Student {
    int id;

    public Student(int id, int age, String name, String sex) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int age;
    String name;
    String sex;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
