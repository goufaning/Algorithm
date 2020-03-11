package proxy;

public class Test {

    public static void main(String[] args) {
        ProxyHandler handler = new ProxyHandler();
        IPrinter printer = (IPrinter) handler.newProxyInstance(new Printer());
        printer.print();
    }
}
