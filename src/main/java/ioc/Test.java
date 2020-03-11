package ioc;

public class Test {

    public static void main(String[] args) throws Exception {
        String location = Test.class.getResource("ioc.xml").getPath();
        SimpleIoc ioc = new SimpleIoc(location);
        Wheel wheel = (Wheel) ioc.getBean("wheel");
        System.err.println(wheel.toString());
        Car car = (Car) ioc.getBean("car");
        System.err.println(car.toString());
    }
}
