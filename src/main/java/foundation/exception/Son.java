package foundation.exception;

import java.io.*;

/**
 * User: gaozhan
 * Date: 1/2/14
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Son implements Parent {
    @Override
    public void say() {

//        throw new IOException();//Error
//        throw new IndexOutOfBoundsException();//OK
        try{
            String fileName = "xxx";
            File f = new File(fileName);
            InputStream inputStream = new FileInputStream(f);
        }
        catch (FileNotFoundException e) {
            throw new NoFileException();

        }
//        throw new IndexOutOfBoundsException();//OK
        //To change body of implemented methods use File | Settings | File Templates.
    }
    public void say2() throws NoFileException {
    }
}
/*子类抛出的已检查异常不可以超出父类声明的抛出的已检查异常的范围，但子类可以抛出运行时异常，
* 所以当子类需要抛出一个已检查异常时可以把其封装为运行时异常然后再抛出。调用会抛出运行时异常的方法时，可以
* 不添加异常处理器。*/
