package mytest0108;

/**
 * @author Allen
 * @date 2020/1/8 17:19
 * 单例模式：懒汉式
 */
public class SingletonDemo02 {

    //类初始化时，不初始化这个对象（有延时加载的优势）
    private static SingletonDemo02 instance;

    private SingletonDemo02() {
    }

    //方法同步，调用效率低
    public static synchronized SingletonDemo02 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo02();
        }
        return instance;
    }
}
