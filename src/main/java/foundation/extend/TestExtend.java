package foundation.extend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

/**
 * User: gaozhan
 * Date: 12/12/13
 * Time: 3:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestExtend {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        S s = new S(4, "jim", 123);
        System.out.println(s.getAge());
        System.out.println(s.getName());
    }

}