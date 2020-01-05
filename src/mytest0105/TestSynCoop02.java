package mytest0105;

/**
 * @author Allen
 * @date 2020/1/5 14:11
 * 并发协作模型：生产者-消费者模式（信号灯法）
 * 借助标志位
 */
public class TestSynCoop02 {

    public static void main(String[] args) {

        TV tv = new TV();
        Player player = new Player(tv);
        Watcher watcher = new Watcher(tv);
        player.start();
        watcher.start();

    }
}

class Player extends Thread {
    TV tv = new TV();

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                try {
                    this.tv.play("奇葩说");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    this.tv.play("taiwule");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Watcher extends Thread {
    TV tv = new TV();

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            try {
                tv.watch();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TV {
    String voice;

    boolean flag = true;
    //T表示演员表演，观众等待
    //F表示观众观看，演员等待

    //表演
    public synchronized void play(String voice) throws InterruptedException {

        //演员等待
        if (!flag) {
            this.wait();
        }

        System.out.println("表演:" + voice);
        this.voice = voice;
        //唤醒
        this.notifyAll();
        //切换标志位
        this.flag = !flag;
    }

    //观看
    public synchronized void watch() throws InterruptedException {

        //观众等待
        if (flag) {
            this.wait();
        }

        System.out.println("观看:" + voice);
        //唤醒
        this.notifyAll();
        //切换标志位
        this.flag = !flag;
    }
}