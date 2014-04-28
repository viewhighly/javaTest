package foundation.classLoader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.io.IOException;
import java.io.InputStream;

/**
 * User: gaozhan
 * Date: 12/10/13
 * Time: 9:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class DefineClass {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
//        final String testName = "Gaozhan";

        ClassLoader cl = new ClassLoader() {
            @Override
        public Class<?> loadClass(String name) {

                try{
                InputStream in = getClass().getResourceAsStream("TestClass.class");
                final byte[] b = new byte[in.available()];
                in.read(b);
                    return defineClass(name, b, 0, b.length);
                }

                catch (Exception e)
                {
                    return  null;
                }

                }

        };
        Object obj = cl.loadClass("mytest.foundation.classLoader.TestClass").newInstance();

    }

}
/*运行后出现错误如下：
java.lang.NoClassDefFoundError: java/lang/Object
	at java.lang.ClassLoader.defineClass1(Native Method)
	at java.lang.ClassLoader.defineClass(ClassLoader.java:791)
	at java.lang.ClassLoader.defineClass(ClassLoader.java:634)
	at mytest.foundation.classLoader.DefineClass$1.loadClass(DefineClass.java:38)
	at mytest.foundation.classLoader.DefineClass.test(DefineClass.java:49)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:45)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:15)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:42)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:20)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:28)
	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:30)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:263)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:68)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:47)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:231)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:60)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:229)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:50)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:222)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:300)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:157)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:77)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:195)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:63)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:120)
	这是由于TestClass.class文件中有TestClass的父类信息也即java.lang.Object类，所以当defineClass的时候需要加载java.lang.Object类。
	初步怀疑由于覆盖了classLoad方法，并且没有使用双亲委派模式，自定义的类加载其不会委托父加载器加载java.lang.Object,而会在当前目录下加载
	java.lang.Object类，由于找不到，所以报错。可以通过DefineClassV2验证这一点。
	*/