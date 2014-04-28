package foundation.number;

import java.math.BigDecimal;

/**
 * User: gaozhan
 * Date: 1/13/14
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class DoubleTest {
    public static void main(String[] args) {
        double a = 99.0123456789123456789d;
        double b = 99.0123456789123456788d;
        System.out.println(a);
        BigDecimal bigDecimal = new BigDecimal(99.0123456789123456789d);
        System.out.println(bigDecimal);

    }
}

/*
BigDecimal bA = new BigDecimal(99.0123456789123456789d);
BigDecimal bB = new BigDecimal(99.0123456789123456788d);
System.out.println("bA=" + bA);
System.out.println("bB=" + bB);
输出如下：
bA=99.012345678912339508315199054777622222900390625
bB=99.012345678912339508315199054777622222900390625
其实在99.0123456789123456789d转化成bA之前，99.0123456789123456789d先转成了99.01234567891234，所以其实执行的是BigDecimal bA = new BigDecimal(99.01234567891234);
BigDecimal bB = new BigDecimal(99.01234567891234);
当然bA还是与bB相等

附：JAVADOC
public BigDecimal(double val)Translates a double into a BigDecimal. The scale of the BigDecimal is the smallest value such that (10scale * val) is an integer.
Note: the results of this constructor can be somewhat unpredictable. One might assume that new BigDecimal(.1) is exactly equal to .1, but it is actually equal to .1000000000000000055511151231257827021181583404541015625. This is so because .1 cannot be represented exactly as a double (or, for that matter, as a binary fraction of any finite length). Thus, the long value that is being passed in to the constructor is not exactly equal to .1, appearances notwithstanding.

The (String) constructor, on the other hand, is perfectly predictable: new BigDecimal(".1") is exactly equal to .1, as one would expect. Therefore, it is generally recommended that the (String) constructor be used in preference to this one.

 */
