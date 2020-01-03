package mytest0103;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Allen
 * @date 2020/1/3 21:55
 * sleep()测试线程阻塞,模拟倒计时
 * sleep()是静态方法，谁调用谁阻塞
 */
public class TestBlockedThread {

    public static void main(String[] args) throws InterruptedException {

        Date date = new Date(System.currentTimeMillis() + 1000 * 10);
        long end = date.getTime();      //获得当前时间的毫秒数

        while (true) {

            System.out.println(new SimpleDateFormat("mm:ss").format(date));

            Thread.sleep(1000);
            date = new Date(date.getTime() - 1000);

            if (end - date.getTime() > 10000) {
                break;
            }
        }
    }

}
