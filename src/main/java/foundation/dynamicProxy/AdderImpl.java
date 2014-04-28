package foundation.dynamicProxy;

/**
 * User: gaozhan
 * Date: 8/6/13
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdderImpl implements IAdder {
    private int sum;

    @Override
    public int add(int a, int b) {

        return sum = a + b;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getSum() {
        return sum;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
