package mytest0108;

/**
 * @author Allen
 * @date 2020/1/9 13:58
 */
public class BenFactory implements CarFactory02 {
    @Override
    public Car createCar() {
        return new Ben();
    }
}
