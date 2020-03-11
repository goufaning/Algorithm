package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

    // 被代理的对象
    private Object targetObject;

    public Object newProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    /**
     *
     * @param proxy 指自己  this, 作用 ： 只有proxy 实例在InvocationHandler 实现类里加载才能产生第二个参数method
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("打印开始");
        Object result = method.invoke(targetObject, args);
        System.err.println("打印结束");
        return result;
    }
}
