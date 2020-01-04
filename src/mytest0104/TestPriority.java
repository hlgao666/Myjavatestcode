package mytest0104;

/**
 * @author Allen
 * @date 2020/1/4 16:55
 * 测试优先级Priority
 * 概率，不代表绝对的先后顺序
 */
public class TestPriority {

    public static void main(String[] args) {

        MyPriority mp = new MyPriority();

        new Thread(mp).start();         //Thread.NORM_PRIORITY

        Thread t1 = new Thread(mp, "t1");
        Thread t2 = new Thread(mp, "t2");
        Thread t3 = new Thread(mp, "t3");
        Thread t4 = new Thread(mp, "t4");
        Thread t5 = new Thread(mp, "t5");
        Thread t6 = new Thread(mp, "t6");

        //在start前设置priority
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);
        t5.setPriority(Thread.MIN_PRIORITY);
        t6.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }


}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println((Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority()));
        Thread.yield();     //礼让
    }
}
