package mytest0108;

/**
 * @author Allen
 * @date 2020/1/8 20:20
 * 静态内部类实现懒加载
 * 线程安全，调用效率高，并且实现了延时加载
 */
public class SingletonDemo03 {

    //类初始化时，不初始化这个对象（有延时加载的优势）
    private static class SingletonClassInstance {
        private static final SingletonDemo03 instance = new SingletonDemo03();
    }

    private SingletonDemo03() {
    }

    //方法同步，调用效率低
    public static SingletonDemo03 getInstance() {
        return SingletonClassInstance.instance;
    }
}
