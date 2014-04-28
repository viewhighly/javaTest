package foundation.characterSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


/**
 * User: gaozhan
 * Date: 8/22/13
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class UnicodeTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws UnsupportedEncodingException {
        String c = "\u0041";
        String newc = "\u5750";
        String s = "\uD840\uDDBB";  //一个特殊的汉字，由2个unicode编码表示
        System.out.println(c);
        System.out.println(c.length());
        System.out.println(c.getBytes().length);

        System.out.println(s.length());
        System.out.println(s.codePointCount(0,s.length()));
        System.out.println(s.getBytes("gbk").length);//在gbk编码中用一个字节代表该汉字
        System.out.println(s.getBytes("utf8").length);
        int i = s.charAt(1); //低端代理的值0xDDBB=56763
        System.out.println(i);
        int j = s.charAt(0); //高端代理的值0xD840=55360
        System.out.println(j);
        Map<String, Charset> map = Charset.availableCharsets();
        Set<String> set = map.keySet();
        for (String eachString : set) {
//            System.out.println(eachString);
        }
//        Properties pps=System.getProperties();
//        pps.list(System.out);

        System.out.println(newc);
        byte[] gbk_b = s.getBytes("gbk");
        System.out.println(gbk_b[0]);
        String str = new String(gbk_b,"gb2312");
        System.out.println(String.format("The original character is %s", str));


    }

}
//conclusion:String的length()方法返回的是unicode码元的个数，一个码元由2个字节表示；而String.getBytes(<charSet>).length则
//表示如果以目标的编码集对该String编码所产生的字节数组的元素的个数。对于charAt(<index>)方法来说，其把一个unicode作为一个char，如果index所在的字符
//的值是一个surrogate则返回对应的surrogate的值，可见charAt也是以unicode码元为单位处理的，其返回值并不一定是一个真正意义上的字符。而codePointCount
//则返回一个String中真正的字符的个数，而不是码元的个数。
//在Java中,String的getBytes()方法是得到一个操作系统默认的编码格式的字节数组.这个表示在不同Operation System下,返回的东西不一样!
//
//        String.getBytes(String decode)方法会根据指定的decode编码返回某字符串在该编码下的byte数组表示,如:
//        byte[] b_gbk = "中".getBytes("GBK");
//byte[] b_utf8 = "中".getBytes("UTF-8");
//byte[] b_iso88591 = "中".getBytes("ISO8859-1");
//将分别返回"中"这个汉字在GBK、UTF-8和ISO8859-1编码下的byte数组表示,此时b_gbk的长度为2,b_utf8的长度为3,b_iso88591的长度为1.
//
//        而与getBytes相对的,可以通过new String(byte[], decode)的方式来还原这个"中"字时,这个new String(byte[], decode)实际是使用decode指定的编码来将byte[]解析成字符串.
//        String s_gbk = new String(b_gbk,"GBK");
//String s_utf8 = new String(b_utf8,"UTF-8");
//String s_iso88591 = new String(b_iso88591,"ISO8859-1");
//通过打印s_gbk、s_utf8和s_iso88591,会发现s_gbk和s_utf8都是"中",而只有s_iso88591是一个不认识的字符,为什么使用ISO8859-1编码再组合之后,无法还原"中"字呢,其实原因很简单,因为ISO8859-1编码的编码表中,根本就没有包含汉字字符,当然也就无法通过"中".getBytes("ISO8859-1");来得到正确的"中"字在ISO8859-1中的编码值了,所以再通过new String()来还原就无从谈起了.
//        因此,通过String.getBytes(String decode)方法来得到byte[]时,一定要确定decode的编码表中确实存在String表示的码值,这样得到的byte[]数组才能正确被还原.
//
//        有时候,为了让中文字符适应某些特殊要求(如http header头要求其内容必须为iso8859-1编码),可能会通过将中文字符按照字节方式来编码的情况,如:
//        String s_iso88591 = new String("中".getBytes("UTF-8"),"ISO8859-1"),这样得到的s_iso8859-1字符串实际是三个在ISO8859-1中的字符,可能存在特殊字符，在将这些字符传递到目的地后,目的地程序再通过相反的方式String s_utf8 = new String(s_iso88591.getBytes("ISO8859-1"),"UTF-8")来得到正确的中文汉字"中".这样就既保证了遵守协议规定、也支持中文.
//原则上只要字节数据不丢失数据，最终总是可以找回正确的string的。