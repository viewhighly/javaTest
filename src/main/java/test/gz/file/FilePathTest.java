package test.gz.file;

import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: gaozhan1
 * Date: 14-1-3
 * Time: 下午10:32
 * To change this template use File | Settings | File Templates.
 */
public class FilePathTest {
    public static void main(String[] args) {
        File file1 = new File(".\\test1.txt");
        File file2 = new File("D:\\github\\javaTest\\test1.txt");
        System.out.println("-----默认相对路径：取得路径不同------");
        System.out.println(System.getProperty("user.dir"));//在IDE里为工程的根路径（用户当前的工作目录），实际运行时取决于用户当前的工作目录，用于生产文件的绝对路径
        System.out.println(file1.getPath());//getPath()把生产文件时的路径名转换为字符串
        System.out.println(file1.getAbsolutePath());
        System.out.println("-----默认绝对路径:取得路径相同------");
        System.out.println(file2.getPath());
        System.out.println(file2.getAbsolutePath());
//public String getCanonicalPath() throws IOException返回抽象路径名的规范路径名字符串。
//规范路径名是绝对路径名，并且是惟一的。规范路径名的准确定义与系统有关。如有必要，此方法首先将路径名转换成绝对路径名，这与调用 getAbsolutePath()
// 方法的效果一样，然后用与系统相关的方式将它映射到其惟一路径名。这通常涉及到从路径名中移除多余的名称（比如 "." 和 ".."）、
// 分析符号连接（对于 UNIX 平台），以及将驱动器名转换成标准大小写形式（对于 Microsoft Windows 平台）。
        File file = new File("..\\somedir\\test1.txt");
        System.out.println(file.getAbsolutePath());
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
//        可以看到CanonicalPath不但是全路径，而且把..或者.这样的符号解析出来。

    }
}
