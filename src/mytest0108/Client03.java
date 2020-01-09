package mytest0108;

/**
 * @author Allen
 * @date 2020/1/9 14:00
 * 满足开闭原则
 */
public class Client03 {

    public static void main(String[] args) {

        Car c1 = new BenFactory().createCar();
        Car c2 = new AudiFactory().createCar();

        c1.run();
        c2.run();
    }
}
