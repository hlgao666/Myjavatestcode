package testCalendar;

import mytest0101.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestCalendar {

    public static void main(String[] args) throws ParseException {

        System.out.println("请输入日期：格式：2019-12-31");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(str);              //将字符串转为日期类

        Calendar c1 = new GregorianCalendar();
        c1.setTime(date);                       //将日期类转换为日历类
        test a = new test();                    //调用外部类方法
        a.printCalendar(c1);

        int daynum = c1.get(Calendar.DAY_OF_MONTH);

        c1.set(Calendar.DAY_OF_MONTH,1);
        System.out.println("日\t一\t二\t三\t四\t五\t六");

        for(int i=0;i<c1.get(Calendar.DAY_OF_WEEK)-1;i++){
            System.out.print("\t");
        }

        int days = c1.getActualMaximum(Calendar.DATE);
        for(int i=0; i<days;i++){

            System.out.print(c1.get(Calendar.DAY_OF_MONTH));

            if(c1.get(Calendar.DAY_OF_MONTH) == daynum){
                System.out.print("*");
            }
            System.out.print("\t");

            if(c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
                System.out.println();
            }

            c1.add(Calendar.DAY_OF_MONTH,1);
        }

    }
}
