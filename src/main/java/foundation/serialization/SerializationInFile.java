package foundation.serialization;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * User: gaozhan
 * Date: 8/6/13
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class SerializationInFile {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public void writeObjs() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("publicResource/personFile.txt")));
        Person person = new Person(20, "Jim");
        Animal animal = new Animal(100, "tiger");
        oos.writeObject(person);
        oos.writeObject(animal);
        oos.close();
    }

    public void readObjs() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("publicResource/personFile.txt")));
        Person readPerson = (Person) ois.readObject();
        Animal readAnimal = (Animal) ois.readObject();
        System.out.println("The read person value is " + readPerson);
//        System.out.println("The person's serialVersionUID is " + readPerson.serialVersionUID);
        System.out.println("The read animal value is " + readAnimal);
        ois.close();
    }

    @Test
    public void test() throws IOException, ClassNotFoundException {
//        writeObjs();
        readObjs();


    }
    @Test
    public void writeTest() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        Animal animal = new Animal(100, "tiger");
        objectOutputStream.writeObject(animal);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        String outStr = new String(bytes, "utf-8");
        System.out.println(outStr);
    }


}
//Person之前的serialVsrsionUID是static final long serialVersionUID =   6038761338464530646L
// 给Person添加height域之后其serialVsrsionUID变为static final long serialVersionUID = -6074939545543740001L
// 结果不允许从序列化存储的文件中读取之前保存的Person对象提示：mytest.foundation.serialization.Person;
// local class incompatible: stream classdesc serialVersionUID = 6038761338464530646,
// local class serialVersionUID = -6074939545543740001
//可以给Person赋值一个固定的serialVersionUID比如123456L，这样不论其如何改变都使用这个serialVersionUID，避免不兼容问题
//ObjectInputStream读取object的顺序必须和ObjectOutputStream写object的顺序一致