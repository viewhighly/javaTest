package framework.mybatis;

import foundation.serialization.Animal;
import framework.mybatis.data.entity.AnimalObj;
import framework.mybatis.data.entity.Student;
import framework.mybatis.data.entity.VmResource;
import framework.mybatis.data.mapper.AccountingVmResource;
import framework.mybatis.data.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * User: gaozhan
 * Date: 1/16/14
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestClass {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        SqlSession session = null;
        try


        {
            session = DBAccessor.sqlSessionFactory.openSession();
            AccountingVmResource mapper = session.getMapper(AccountingVmResource.class);
            VmResource vm = new VmResource(1, 2, 1024, 1, 2048, "gaozhan", "10.100.211.111", "SLES");
            vm.setStartTime(new Date(12345678));
            mapper.addVmResource(vm);
//            VmResource vm2 = new VmResource(1, 2, 1024, 2, 2048, "gaozhan", "10.100.211.111", "SLES");
//            vm.setStartTime(new Date(1234567));
//            mapper.addVmResource(vm2);
//            VmResource vm3 = new VmResource(1, 2, 1024, 2, 2048, "gao", "10.100.211.111", "SLES");
//            vm.setStartTime(new Date(123456789));
//            mapper.addVmResource(vm3);
            Student s1 = new Student(1, 18, "jim", "f");
            StudentMapper sm = session.getMapper(StudentMapper.class);
            sm.saveStudent(s1);
            sm.saveStudent(s1);
            session.commit();
        }
        catch (Exception e)
        {
            System.out.println("exception occurs");
            e.printStackTrace();
            session.rollback();

        }

        finally {
            if (null != session) session.close();
        }

    }
    @Test
    public void testWriteObjectToDB() {
        SqlSession session = null;
        try


        {
            session = DBAccessor.sqlSessionFactory.openSession();
            AccountingVmResource mapper = session.getMapper(AccountingVmResource.class);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            Animal animal = new Animal(100, "tiger");
            objectOutputStream.writeObject(animal);
            byte[] bytes = byteArrayOutputStream.toByteArray();
//            Blob blob = new SerialBlob(bytes);
            AnimalObj animalObj = new AnimalObj(bytes);
//            mapper.addAnimal(animalObj);
            HashMap map = new HashMap();
            map.put("IMAGE", bytes);
            mapper.addAnimal(map);
            session.commit();
        }
        catch (Exception e)
        {
            System.out.println("exception occurs");
            e.printStackTrace();
            session.rollback();

        }

        finally {
            if (null != session) session.close();
        }

    }


    @Test
    public void testReadObjectToDB() {
        SqlSession session = null;
        try


        {
            session = DBAccessor.sqlSessionFactory.openSession();
            AccountingVmResource mapper = session.getMapper(AccountingVmResource.class);
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//            Animal animal = new Animal(100, "tiger");
//            objectOutputStream.writeObject(animal);
//            byte[] bytes = byteArrayOutputStream.toByteArray();
//            Blob blob = new SerialBlob(bytes);
//            AnimalObj animalObj = new AnimalObj(bytes);
            Map animalObj = mapper.getAnimalObject(5);
            if (animalObj.isEmpty()) System.out.println("empty animal obj");
            byte[] bytes = (byte [])animalObj.get("IMAGE");
            System.out.print(bytes.length);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Animal animal = (Animal)objectInputStream.readObject();
            System.out.println(animal.toString());
            session.commit();
        }
        catch (Exception e)
        {
            System.out.println("exception occurs");
            e.printStackTrace();
            session.rollback();

        }

        finally {
            if (null != session) session.close();
        }

    }
    @Test
    public void newTest() throws InterruptedException {
        System.out.println("3UI_i".toLowerCase());
        System.out.println(new Date().getTime());
//        Thread.sleep(3);
        System.out.println(new Date().getTime());
    }

}