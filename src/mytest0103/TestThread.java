package mytest0103;

//创建多线程方式一：继承Thread类+重写run();
//启动：创建子类对象+start()
public class TestThread extends Thread {

    //线程入口点
    @Override
    public void run() {     //线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("coding");
        }
    }

    //测试方式一
    public static void test01() {

        //创建子类对象
        TestThread tt = new TestThread();
        //启动。将线程挂起，不保证立即运行，由CPU调用
        tt.start();       //只会执行run()中的线程体

//            tt.run();       //调用普通方法

        for (int i = 0; i < 200; i++) {
            System.out.println("listening to music");
        }
    }

    //测试方式二
    public static void test02() {

        //创建实现类对象
        TestRunnableThread trt = new TestRunnableThread();
        //创建代理类对象，并启动
        new Thread(trt).start();        //匿名对象 new Thread(trt)

        for (int i = 0; i < 200; i++) {
            System.out.println("FOX");
        }
    }

    public static void main(String[] args) {
        test01();
        test02();
    }
}

//创建多线程方式二：实现Runnable接口+重写run
//启动：创建实现类对象+Thread对象+start

//推荐：避免单继承的局限性，优先使用接口
//方便资源共享
class TestRunnableThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("DOG");
        }
    }

    //具体实现位于test02()中
}

//创建多线程方式三：在juc并发包下，实现callable接口
//call()方法可返回值，可抛出异常
//步骤1：创建执行服务
//步骤2：提交执行
//3：获取结果
//4：关闭服务