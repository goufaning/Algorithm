package aop;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeforeAdvice implements Advice {

    private MethodInvocation invocation;

    private Object bean;

    public BeforeAdvice(Object bean, MethodInvocation invocation) {
        this.bean = bean;
        this.invocation = invocation;
    }





    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        invocation.invoke();
        Object result = method.invoke(bean, args);
        return result;
    }
}
