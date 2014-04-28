package foundation.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * User: gaozhan
 * Date: 8/6/13
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Handler implements InvocationHandler {
    private Object obj;

    public Handler(Object obj) {
        this.obj = obj;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(String.format("Method %s has been invoked!", method.getName()));
        return method.invoke(obj, args);
    }
}
