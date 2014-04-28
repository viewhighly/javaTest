package foundation.enumTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

/**
 * User: gaozhan
 * Date: 9/12/13
 * Time: 2:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnumTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        System.out.println(Color.RED);

    }


    enum Color{
        RED(255,0,2),BLUE(0,0,255),BLACK(0,0,0),YELLOW(255,255,0),GREEN(0,255,0);
        //构造枚举值，比如RED(255,0,0)
        private Color(int rv,int gv,int bv){
            this.redValue=rv;
            this.greenValue=gv;
            this.blueValue=bv;
        }

        public String toString(){  //覆盖了父类Enum的toString()
            return super.toString()+"("+redValue+","+greenValue+","+blueValue+")";
        }

        private int redValue;  //自定义数据域，private为了封装。
        private int greenValue;
        private int blueValue;
    }
    enum WeekDay {
        Mon("first"),Tue("second");
        private WeekDay(String str) {
                               content = str;
        }
        private String content;

    }

}