package mytest0103;

/**
 * @author Allen
 * @date 2020/1/3 21:24
 * 多线程终止
 */
public class TestTerminateMulThread implements Runnable {

    //1.加入标识表示线程体是否可以运行
    private boolean flag = true;

    public static void main(String[] args) {

        TestTerminateMulThread t = new TestTerminateMulThread();
        new Thread(t).start();

        for (int i = 0; i < 100; i++) {
            if (i == 88) {
                t.terminate();
                System.out.println("t game over");
            }
            System.out.println("main---" + i);
        }

    }

    @Override
    public void run() {

        int i = 0;
        while (flag) {        //2.关联标识，true运行，false停止
            System.out.println("线程运行第" + (i++) + "次");
        }
    }

    //3.对外提供方法改变标识
    public void terminate() {
        this.flag = false;
    }
}
