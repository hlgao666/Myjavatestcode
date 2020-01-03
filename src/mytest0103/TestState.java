package mytest0103;

/**
 * @author Allen
 * @date 2020/1/3 22:46
 * 测试线程所有状态
 */
public class TestState {

    public static void main(String[] args) {

        Thread a = new Thread(() -> {

            for (int i = 0; i < 5; i++) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("线程运行中");
            }

        });
        Thread.State state = a.getState();
        System.out.println(state);      //NEW

        a.start();
        state = a.getState();
        System.out.println(state);      //RUNNABLE,包含就绪和运行两种状态

        while (state != Thread.State.TERMINATED) {

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            state = a.getState();
            System.out.println(state);      //TIMED_WAITING
        }


    }
}
