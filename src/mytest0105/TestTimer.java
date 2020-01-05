package mytest0105;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Allen
 * @date 2020/1/5 14:51
 * 测试定时调度
 */

public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Calendar calendar = new GregorianCalendar();
        timer.schedule(new MyTask(), calendar.getTime(), 2000);
    }
}

class MyTask extends TimerTask {    //继承自TimerTask类
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("wo--->" + i);
        }
        System.out.println("--------END--------");
    }
}