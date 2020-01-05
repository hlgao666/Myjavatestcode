package mytest0105;

/**
 * @author Allen
 * @date 2020/1/5 10:40
 * 测试死锁，过多的同步可能造成相互不释放资源
 * 从而造成等待，一般发生于同步块中持有多个对象的锁
 * 避免：不要在同一个代码块中，同时持有多个对象的锁
 */
public class TestDeadLock {

    public static void main(String[] args) {

        Makeup g1 = new Makeup(0, "BG");
        Makeup g2 = new Makeup(1, "HD");
        g1.start();
        g2.start();

    }
}

class Lipstick {

}

class Mirror {

}

class Makeup extends Thread {

    //加static表示只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girl;

    public Makeup(int choice, String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    @Override
    public void run() {

        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void makeup() throws InterruptedException {

        //相互持有对方的锁,可能造成死锁
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.girl + "获得口红");

                Thread.sleep(2000);

//                synchronized (mirror){
//                    System.out.println(this.girl+"获得镜子");
//                }
            }

            synchronized (mirror) {
                System.out.println(this.girl + "获得镜子");
            }

        } else {
            synchronized (mirror) {
                System.out.println(this.girl + "获得镜子");

                Thread.sleep(2000);

//                synchronized (lipstick){
//                    System.out.println(this.girl+"获得口红");
//                }
            }
            synchronized (lipstick) {
                System.out.println(this.girl + "获得口红");
            }
        }
    }
}