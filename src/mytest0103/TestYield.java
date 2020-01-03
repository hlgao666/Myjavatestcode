package mytest0103;

/**
 * @author Allen
 * @date 2020/1/3 22:16
 * 测试礼让线程Yield()
 */
public class TestYield {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield, "A").start();
        new Thread(myYield, "D").start();

    }

}

class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "---start");
        Thread.yield();     //礼让，谁调用谁礼让
        System.out.println(Thread.currentThread().getName() + "---end");
    }
}
