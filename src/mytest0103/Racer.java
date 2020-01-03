package mytest0103;

//龟兔赛跑，模拟多线程，并发及数据安全
public class Racer implements Runnable {

    private String WINNER = null;//胜利者

    @Override
    public void run() {

        for (int steps = 1; steps <= 100; steps++) {

            //模拟兔子休息
            if (Thread.currentThread().getName().equals("rabbit") && steps % 10 == 0) {     //当兔子执行该线程，steps是兔子的steps
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "--->" + steps);
            boolean flag = gameOver(steps);
            if (flag) {
                break;
            }
        }
    }

    //游戏是否结束
    private boolean gameOver(int steps) {

        if (WINNER != null) {
            return true;
        } else {
            if (steps == 100) {
                WINNER = Thread.currentThread().getName();
                System.out.println("winner: " + WINNER);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer, "tortoise").start();
        new Thread(racer, "rabbit").start();
    }
}
