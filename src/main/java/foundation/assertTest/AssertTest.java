package foundation.assertTest;

import java.net.URISyntaxException;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;

/**
 * User: gaozhan
 * Date: 1/3/14
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class AssertTest {
    public static void main(String[] args) throws URISyntaxException {
        int i = 3;
        int a =3;

        assert i > 0 : a + i;
        ProtectionDomain p = AssertTest.class.getProtectionDomain();
        System.out.println(p.getCodeSource().getLocation().getPath());
        Map<String, String> map = new HashMap<String, String>();
        map.put("1","1");
        map.put("1","2");
        System.out.println(map.get("1"));
    }
}
