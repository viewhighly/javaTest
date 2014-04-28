package foundation.characterSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.io.*;

/**
 * User: gaozhan
 * Date: 12/3/13
 * Time: 9:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class CharCode {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws IOException {
        System.out.println(System.getProperty("file.encoding"));
        String str = "在";

        File directory = new File(".");
        String currentDir = directory.getCanonicalPath();
        File f = new File(currentDir + "/src/mytest/foundation/characterSet/char-test");
        FileOutputStream fo = new FileOutputStream(f);
        try {
            byte[] bs = str.getBytes("gbk");
            for (byte b: bs)
            {
                fo.write(b);

            }
            System.out.println(f.length());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            fo.close();
        }
    }
    @Test
    public void testDecode() throws IOException {

        File directory = new File(".");
        String currentDir = directory.getCanonicalPath();
        File f = new File(currentDir + "/src/mytest/foundation/characterSet/char-test");
        FileInputStream fi = new FileInputStream(f);
        long len = f.length();
        byte[] bs = new byte[(int)len];
        try {
            for (int i = 0; i < len; i ++) {
                bs[i] = (byte)fi.read();

            }
            String out = new String(bs,0,bs.length,"gbk");
            System.out.println("The string read from the file is: " + out);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            fi.close();
        }
    }

}
//在java中String是以unicode编码方式存储的，OS则默认使用utf-8字符集，在IDE中可以设置IDE和project的默认字符集。String.getBytes()如果没有
//指定字符集，则使用IDE中设置的默认字符集。当指定为“GBK”或“UTF-8”字符集时得到的字节数组的长度是不同的。本例中生存的文件可以通过hexdump或vim -b来
//观察生成文件的字节内容.可以看到“在”在utf-8中编码为3个字节，而在gbk中编码为2个字节，在unicode中则编码为4个字节,在iso-8895-1则被编码为1个字节，
// 显示为？，因为iso-8859-1没有汉字字符的编码。当对文件进行解码时也要指定正确的字符集，如果是"gbk"生存的字节数组，则在读取并生成String时也要指定
//"gbk"字符集，new String方法会把"GBK"字符集对应的汉字编码转化为unicode对应的编码。