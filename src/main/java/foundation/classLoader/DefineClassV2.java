package foundation.classLoader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * User: gaozhan
 * Date: 12/10/13
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefineClassV2 {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader cl = new ClassLoader() {
            @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream in = getClass().getResourceAsStream(fileName);
                    if (in == null) {
                        System.out.println("can not find class " + name + " and the file " + fileName +
                                " ,delegate to parent classloader");
                        return  super.loadClass(name);

                    } else {
                        System.out.println("find the class" + name);

                    }
                    byte[] b = new byte[in.available()];
                    in.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);

                }
            }
        };

        Class klass = cl.loadClass("mytest.foundation.classLoader.TestClass");
        Method method=klass.getMethod("say");
//        System.out.println(method);
        method.invoke(klass.newInstance());
        Object obj = klass.newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof foundation.classLoader.TestClass);

    }

}
/*值得注意的是在loadClass方法中使用了Object和System类，以及在后面代码中使用了Method类，这些类不是通过自定义的classLoad加载的，而是由
* bootstrap类加载其加载的。这几个类同时存在于自定义的classLoader、appClassLoader、extClassLoader和bootstrapClassLoader中。可以参见：
*
* 看到JAVA书上说到如题的话，不是特别理解“不能互相访问”的含义，比如一个简单的类：
* public class CLTest {
    public void parse(String s){
    System.out.println(s);
    }
    public static void main(String[] args) {
    String str = new String("ok");  //String 类是又启动类装载器装载的
    CLTest test = new CLTest();    //CLTest类是有系统类装载器装载的
    test.parse(str);    <span style="color: #FF0000;">//这叫做互相访问吗？</span>
    }
}
答案当然肯定不是，那么什么样的访问才叫做“互相访问”？
还有在上边的例子里，String类和CLTest类拥有不同的“命名空间”吗（因为书上说不同的类装载器装载的类有不同的命名空间）？
我肯定是没有理解这个概念，请大家指教
*
* 一，有两个术语，一个叫“定义类加载器”，一个叫“初始类加载器”。
比如有如下的类加载器结构：
bootstrap
  ExtClassloader
    AppClassloader
    -自定义clsloadr1
    -自定义clsloadr2
如果用“自定义clsloadr1”加载java.lang.String类，那么根据双亲委派最终bootstrap会加载此类，那么bootstrap类就叫做该类的“定义类加载器”，而包括bootstrap的所有得到该类class实例的类加载器都叫做“初始类加载器”。

二，所说的“命名空间”，是指jvm为每个类加载器维护的一个“表”,这个表记录了所有以此类加载器为“初始类加载器”（而不是定义类加载器，所以一个类可以存在于很多的命名空间中）加载的类的列表，所以，题目中的问题就可以解释了：
CLTest是AppClassloader加载的，String是通过加载CLTest的类加载器也就是AppClassloader进行加载，但最终委派到bootstrap加载的（当然，String类其实早已经被加载过了，这里只是举个例子）。所以，对于String类来说，bootstrap是“定义类加载器”，AppClassloader是“初始类加载器”。根据刚才所说，String类在AppClassloader的命名空间中（同时也在bootstrap，ExtClassloader的命名空间中，因为bootstrap，ExtClassloader也是String的初始类加载器），所以CLTest可以随便访问String类。这样就可以解释“处在不同命名空间的类，不能直接互相访问”这句话了。

三，一个类，由不同的类加载器实例加载的话，会在方法区产生两个不同的类，彼此不可见，并且在堆中生成不同Class实例。

四，那么由不同类加载器实例（比如-自定义clsloadr1，-自定义clsloadr2）所加载的classpath下和ext下的类，也就是由我们自定义的类加载器委派给AppClassloader和ExtClassloader加载的类，在内存中是同一个类吗？
所有继承ClassLoader并且没有重写getSystemClassLoader方法的类加载器，通过getSystemClassLoader方法得到的AppClassloader都是同一个AppClassloader实例，类似单例模式。
在ClassLoader类中getSystemClassLoader方法调用私有的initSystemClassLoader方法获得AppClassloader实例，在initSystemClassLoader中：
sun.misc.Launcher l = sun.misc.Launcher.getLauncher();
。。。
scl = l.getClassLoader();
AppClassloader是sun.misc.Launcher类的内部类，Launcher类在new自己的时候生成AppClassloader实例并且放在自己的私有变量loader里：
loader = AppClassLoader.getAppClassLoader(extclassloader);
值得一提的是sun.misc.Launcher类使用了一种类似单例模式的方法，即既提供了单例模式的接口getLauncher()又把构造函数设成了public的。但是在ClassLoader中是通过单件模式取得的Launcher 实例的，所以我们写的每个类加载器得到的AppClassloader都是同一个AppClassloader类实例。
这样的话得到一个结论，就是所有通过正常双亲委派模式的类加载器加载的classpath下的和ext下的所有类在方法区都是同一个类，堆中的Class实例也是同一个。*/