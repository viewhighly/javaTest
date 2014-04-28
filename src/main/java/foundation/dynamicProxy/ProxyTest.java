package foundation.dynamicProxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.lang.reflect.Proxy;

/**
 * User: gaozhan
 * Date: 8/6/13
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProxyTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        AdderImpl adder = new AdderImpl();
        Handler handler = new Handler(adder);
        IAdder proxy = (IAdder)Proxy.newProxyInstance(adder.getClass().getClassLoader(), adder.getClass().getInterfaces(), handler);
        proxy.add(1,3);
        System.out.println(proxy.getSum());
    }

}