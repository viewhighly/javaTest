package foundation.date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * User: gaozhan
 * Date: 12/12/13
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class TimeStampTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
//        Timestamp t = new Timestamp(System.currentTimeMillis());
//        Timestamp t2 = new Timestamp(20);
////        System.out.println(System.currentTimeMillis());
////        System.out.println(t.toString());
////        System.out.println(t.getTime());
//        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        try {
//
//            String tsStr = sdf.format(t);
////            System.out.println(tsStr);
//            tsStr = t.toString();
////            System.out.println(tsStr);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        System.out.println(t2.getTime());
//        Date date = new Date();
//        System.out.println(date.getTime());
//        Calendar calendar = new GregorianCalendar();
//        calendar.set(2014, 0, 1, 13, 25, 34);
//        Date date1 = calendar.getTime();
//        System.out.println(sdf.format(date1));


        Calendar calendar = Calendar.getInstance();
////        System.out.println(calendar.getTime());
//        System.out.println(calendar.get(calendar.MONTH) -1 );
////        System.out.println(calendar.MONTH);
////        System.out.println(calendar.DATE);
//        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 23, 59,59);
////        calendar.set(calendar.HOUR, 23);
////        calendar.set(calendar.MINUTE,59);
////        calendar.set(calendar.SECOND,59);
//        System.out.println(calendar.getTime());
////        System.out.println(calendar.get(calendar.HOUR));
        calendar.set(2014, 0, 1, 12, 32, 33);
        System.out.println(calendar.getTime());
//        long time = calendar.getTime().getTime() - 86400000;
//        Date date = new Date(time);
//        System.out.println(date);
//        System.out.println(calendar.getTime().getTime());
//        calendar.add(Calendar.DATE, -1);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE) - 1, 23, 59,59);
        System.out.println(calendar.getTime());
        double num = 111.3333;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        System.out.println(decimalFormat.format(num));





    }

}