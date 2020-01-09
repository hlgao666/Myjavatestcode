package mytest0108;

/**
 * @author Allen
 * @date 2020/1/9 13:44
 * 简单工厂模式，不满足开闭原则
 */
public class CarFactory {
    public static Car createAudi() {
        return new Audi();
    }

    public static Car createBen() {
        return new Ben();
    }
}
