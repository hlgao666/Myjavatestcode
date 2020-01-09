package mytest0108;

/**
 * @author Allen
 * @date 2020/1/9 13:46
 * 不满足开闭原则
 */
public class Client02 {
    public static void main(String[] args) {

        Car c1 = CarFactory.createAudi();
        Car c2 = CarFactory.createBen();

        c1.run();
        c2.run();
    }
}
