package foundation.extend;

/**
 * User: gaozhan
 * Date: 12/12/13
 * Time: 3:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class S extends P {
    private int level;
    public S(int level, String name, int age)
    {
        super(name,age);
        this.level = level;

    }
    public String getName() {
        return super.getName();
    }


}