package mytest0108;

/**
 * @author Allen
 * @date 2020/1/8 17:10
 * 单例模式：饿汉式
 */
public class SingletonDemo01 {

    //类初始化时，立即加载这个对象（没有延时加载的优势）。加载类时，天然的线程安全！
    private static SingletonDemo01 instance = new SingletonDemo01();

    private SingletonDemo01() {
    }

    //方法没有同步，调用效率高
    public static SingletonDemo01 getInstance() {
        return instance;
    }
}
