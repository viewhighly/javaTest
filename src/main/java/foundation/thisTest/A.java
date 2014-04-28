package foundation.thisTest;

/**
 * User: gaozhan
 * Date: 3/28/14
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class A {
    private B b;
    public void printThis()
    {
        System.out.println("The current this obj is " + this);

    }
    public static void main(String[] args) {
        A maina = new A();
        maina.printTest();

    }
    public void printTest()
    {
        A a = new A();
        a.printThis();
        B b = new B();
        a.printThis();
        b.printThisWithOther(this);
    }

}
