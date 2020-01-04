package mytest0104;

/**
 * @author Allen
 * @date 2020/1/4 19:53
 * 并发控制：
 * 1.Synchronized方法
 * 2.Synchronized块
 * <p>
 * 测试Synchronized锁机制
 */
public class TestSynMethod {

    public static void main(String[] args) {
        Tickets t = new Tickets();
        Thread t1 = new Thread(t, "allen");
        Thread t2 = new Thread(t, "mac");

        t1.start();
        t2.start();
    }

}

class Tickets implements Runnable {

    private int tickets = 10;
    boolean flag = true;

    @Override
    public void run() {

        while (flag) {

            //模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            test01();
        }
    }

    //同步方法
    public synchronized void test() {        //锁了（this）对象的资源，

        if (tickets < 1) {
            flag = false;
            return;
        }

        //模拟延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--->" + tickets--);
    }

    //同步块

    //线程安全：尽可能锁定合理范围（不是指代码，指数据的完整性）
    public void test01() {

        //double checking

        //考虑没有票的情况
        if (tickets < 1) {
            flag = false;
            return;
        }

        synchronized (this) {

            //考虑只剩最后一张票的情况
            if (tickets < 1) {
                flag = false;
                return;
            }

            //模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->" + tickets--);
        }

    }
}