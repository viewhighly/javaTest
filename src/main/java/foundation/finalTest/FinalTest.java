package foundation.finalTest;

/**
 * User: gaozhan
 * Date: 1/3/14
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class FinalTest {
    private final int age;

    public FinalTest(int age) {
        this.age = age;
    }
    public FinalTest() {
        age = 12;

    }
    static void say(final String content) {
        //content = "new";//error
//        content = content + "tail";//error
    }
    public static void main(String[] args) {

    }
}
//final fields do not required to be initialized when they are declared. Initiaize them in the constructor is OK. But all /*
// the constructor must initialize the final field.*/
//final String argement can make sure that the argument will not be changed in the method