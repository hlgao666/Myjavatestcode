package mytest0105;

/**
 * @author Allen
 * @date 2020/1/5 16:40
 * DCL单例模式：在懒汉式基础上加入并发控制，保证在多线程环境下，对外存在一个对象
 * 1.构造器私有化--->避免外部new构造器
 * 2.提供私有的静态属性--->存储对象地址
 * 3.提供公共的静态方法--->获取属性
 */
public class DoubleCheckingLock {

    //2.提供私有的静态属性--->存储对象地址
    private static volatile DoubleCheckingLock instance;
    //没有volatile，其他线程可能访问一个没有初始化的对象

    //1.构造器私有化--->避免外部new构造器
    private DoubleCheckingLock() {

    }

    //3.提供公共的静态方法--->获取属性
    public static DoubleCheckingLock getInstance() {

        //double checking,避免不必要的同步，已经存在对象
        if (instance != null) {
            return instance;
        }

        synchronized (DoubleCheckingLock.class) {
            if (instance == null) {
                instance = new DoubleCheckingLock();
            }
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            System.out.println(DoubleCheckingLock.getInstance());
        });
        t.start();
        Thread.sleep(1000);
        System.out.println(DoubleCheckingLock.getInstance());
    }
}
