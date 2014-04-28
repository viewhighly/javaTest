package foundation.thisTest;

/**
 * User: gaozhan
 * Date: 3/28/14
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class B {
    private A a;
    public void printThisWithOther(Object obj) {
        System.out.println("Print from B : the current this is" + this);
    }

}
