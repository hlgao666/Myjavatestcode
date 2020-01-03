package mytest0103;

//测试Lambda表达式,
//定义了外部类，静态内部类，局部内部类，匿名内部类
public class TestLambda {

    //静态内部类。当被调用时加载，不必随着程序的开启而加载
    static class IIter2 implements Runnable {
        @Override
        public void run() {
            System.out.println("我爱你，2！");
        }
    }

    public static void test01() {
        //局部内部类，定义在方法内部的类
        class IIter3 implements Runnable {
            @Override
            public void run() {
                System.out.println("我爱你，3！");
            }
        }
        new Thread(new IIter3()).start();       //启动局部内部类线程
    }

    public static void main(String[] args) {

        new Thread(new IIter()).start();        //启动外部类线程

        new Thread(new IIter2()).start();       //启动静态内部类线程

        test01();       //由于在方法内部加入了启动代码，因此调用该方法时，线程自动启动

        //匿名内部类，必须借助接口或者父类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("HELLO, WORLD!");
            }
        }).start();

        //JDK8简化，借助于Lambda
        new Thread(() -> System.out.println("我爱你，5！")).start();
    }
}

//外部类
class IIter implements Runnable {

    @Override
    public void run() {
        System.out.println("我爱你，1！");
    }
}