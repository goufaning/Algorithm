package aop;

public class HelloService implements IHelloService {
    @Override
    public void sayHello() {
        System.err.println("Hello");
    }
}
