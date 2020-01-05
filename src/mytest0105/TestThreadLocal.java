package mytest0105;

/**
 * @author Allen
 * @date 2020/1/5 17:11
 * ThreadLocal:每个线程的本地存储区域，常用方法有get()、set()、initialValue()，建议定义为private static
 * 更改不会影响其他线程
 * 分析上下文环境，找到起点
 * 1.构造器：哪里调用属于哪里
 * 2.run()方法属于自身线程
 * inheritableThreadLocal拷贝一份数据给子线程
 */
public class TestThreadLocal {

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 2);
    private static ThreadLocal<Integer> t = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            new Thread(new MyThread(), "xiaofei" + i).start();     //多个线程之间不会相互影响
        }

        //new Thread参数：Runnable target, String name
        new Thread(new MyRun(), "wudi").start();    //由main调用，main线程。首先执行MyRun构造器中的内容，然后，执行MyRun中run()函数的内容

        t.set(66);
        System.out.println(Thread.currentThread().getName() + "--->" + t.get());

        //子线程由main线程开辟
        new Thread(() -> {
            //由main线程拷贝
            System.out.println(Thread.currentThread().getName() + "--->" + t.get());
            t.set(33);
            //可以更改值，非共享
            System.out.println(Thread.currentThread().getName() + "--->" + t.get());
        }).start();

    }

    private static class MyThread implements Runnable {
        @Override
        public void run() {
            Integer left = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + "得到了--->" + left);
            threadLocal.set(left - 1);
            System.out.println(Thread.currentThread().getName() + "还剩下--->" + threadLocal.get());
        }
    }

    public static class MyRun implements Runnable {

        public MyRun() {
            threadLocal.set(100);
            System.out.println(Thread.currentThread().getName() + "--->" + threadLocal.get());
        }

        @Override
        public void run() {
            threadLocal.set(50);
            System.out.println(Thread.currentThread().getName() + "--->" + threadLocal.get());
        }
    }

}
