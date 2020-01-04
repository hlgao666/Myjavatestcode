package mytest0104;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Allen
 * @date 2020/1/4 21:10
 * 操作容器，synchronized锁的是一个不变的对象（地址不变）
 */
public class SynBlock02 {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {

            new Thread(() -> {
                synchronized (list) {        //同步块
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
