package foundation.file.path.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * User: gaozhan
 * Date: 8/6/13
 * Time: 10:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class FilePathTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws IOException {
        File f = new File("src/mytest/foundation/file/file.text");
        File f2 = new File("src/mytest/foundation/resource/file2.text");
        PrintWriter pw = new PrintWriter(new FileOutputStream(f));
        PrintWriter pw2 = new PrintWriter(new FileOutputStream(f2));
        pw.println("my file");
        pw2.println("my file2");
        pw.close();
        pw2.close();
        InputStream is = FilePathTest.class.getResourceAsStream("file.text");
        InputStream is2 = FilePathTest.class.getResourceAsStream("/mytest/foundation/resource/file2.text");
        System.out.println(is.read());
        System.out.println(is2.read());
        is.close();
        is2.close();
    }

}
//-----------------------------------Conclusion-----------------------------------
//new File()操作是以项目作为跟路径的,通过class loader取文件则是以classpath作为跟路径的也就是src为跟路径
//Java中getResourceAsStream的用法
//
//        首先，Java中的getResourceAsStream有以下几种：
//        1. Class.getResourceAsStream(String path) ： path 不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从
//
//        ClassPath根下获取。其只是通过path构造一个绝对路径，最终还是由ClassLoader获取资源。
//
//        2. Class.getClassLoader.getResourceAsStream(String path) ：默认则是从ClassPath根下获取，path不能以’/'开头，最终是由
//
//        ClassLoader获取资源。
//
//        3. ServletContext. getResourceAsStream(String path)：默认从WebAPP根目录下取资源，Tomcat下path是否以’/'开头无所谓，
//
//        当然这和具体的容器实现有关。