package foundation.interfaceTest;

import java.util.HashMap;

/**
 * User: gaozhan
 * Date: 1/7/14
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
final class Son implements Parent {

    @Override
    public void say() {
        //To change body of implemented methods use File | Settings | File Templates.

    }

}
//Son can be non-public class,方法是final表示该方法无法被覆盖。类是fianl表示该类“绝后”，无法被继承，自然类中的方法无法被覆盖。