package mytest0108;

import java.lang.reflect.Constructor;

/**
 * @author Allen
 * @date 2020/1/8 20:54
 * 测试反射破解单例模式
 */
public class Client {
    public static void main(String[] args) throws Exception {
        SingletonDemo05 s1 = SingletonDemo05.getInstance();
        SingletonDemo05 s2 = SingletonDemo05.getInstance();

        System.out.println(s1);
        System.out.println(s2);

        //通过反射的方式直接调用私有构造器
        Class<SingletonDemo05> clz = (Class<SingletonDemo05>) Class.forName("mytest0108.SingletonDemo05");
        Constructor<SingletonDemo05> c = clz.getDeclaredConstructor(null);

        c.setAccessible(true);

        SingletonDemo05 s3 = c.newInstance();
        SingletonDemo05 s4 = c.newInstance();
        System.out.println(s3);
        System.out.println(s4);
    }

}
