package mytest0104;

/**
 * @author Allen
 * @date 2020/1/4 17:13
 * 守护线程:为用户线程服务，JVM停止不用等待Daemon执行完毕
 * JVM等待用户线程执行完毕即停止
 */
public class TestDaemon {

    public static void main(String[] args) {

        God god = new God();
        You you = new You();

        Thread t = new Thread(god);
        t.setDaemon(true);              //设置为守护线程
        t.start();

//        new Thread(god).start();
        new Thread(you).start();
    }
}

class You implements Runnable {
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            System.out.println("Alive");
        }
        System.out.println("life is over 000000000000000");
    }
}

class God implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("God bless you!");
        }
    }
}