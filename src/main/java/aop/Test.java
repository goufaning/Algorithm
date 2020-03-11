package aop;

public class Test {
    public static void main(String[] args) {
        MethodInvocation invocation = () -> System.err.println("before log");
        IHelloService helloService = new HelloService();
        Advice advice = new BeforeAdvice(helloService, invocation);
        IHelloService proxy = (IHelloService) SimpleAop.getProxy(helloService, advice);
        proxy.sayHello();
    }

}
