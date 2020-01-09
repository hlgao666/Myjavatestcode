package mytest0108;

import java.io.Serializable;

/**
 * @author Allen
 * @date 2020/1/8 20:46
 * 测试如何防止反射和反序列化漏洞
 */
public class SingletonDemo05 implements Serializable {
    //类初始化时，不初始化这个对象（有延时加载的优势）
    private static SingletonDemo05 instance;

    private SingletonDemo05() {
        if (instance != null) {
            throw new RuntimeException();       //防止反射和反序列化漏洞
        }
    }

    //方法同步，调用效率低
    public static synchronized SingletonDemo05 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo05();
        }
        return instance;
    }

}
