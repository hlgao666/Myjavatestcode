package mytest;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {

    public static void main(String[] args){

//        //1
//        int[][] temp1 = new int[][]{
//                {1, 2},
//                {4, 5}
//        };
//        System.out.println(Arrays.toString(temp1[1]));
//
//
//        //2
//        Object[][] tableData;
//        tableData = new Object[][]{
//                {1,2,"at"},
//                {8,9,"d"},
//                {3,6,"e"}
//        };
//        System.out.println(Arrays.toString(tableData[0]));
//
//
//        //3测试冒泡排序
//        int[] values = {3,1,6,2,9,0,7,4,5,8};
//
//        int temp;
//        for(int i=0;i<values.length-1;i++){
//
//            boolean flag = false;
//            for(int j=0; j<values.length-1-i; j++){
//
//                if(values[j]>values[j+1]){
//                    temp = values[j];
//                    values[j]= values[j+1];
//                    values[j+1]= temp;
//                    flag = true;
//                }
//
//            }
//
//            if(!flag){
//                break;
//            }
//        }
//        System.out.println(Arrays.toString(values));
//
//
//        //测试二分查找
//        int[] temp3 = {7,8,9,10,12,30,40,50,80,100};
//        int des= 80;
//        int left = 0;
//        int right = temp3.length-1;
//        int center = 0;
//        while(left<right){
//            center = (left + right)/2;
//            if(temp3[center]>des){
//                right = center;
//
//            }
//            if(temp3[center]<des){
//                left = center;
//            }
//            if(temp3[center] == des){
//                break;
//            }
//        }
//        System.out.println(center);


//        //自动装箱和拆箱
//        Integer a = 234;        //自动装箱。编译器会改成： Integer a = Integer.valueOf(234);
//        int b = a;              //自动拆箱。编译器会改成：int b = a.intValue();
//
//        //字符串转换成包装类Integer
//        Integer c = Integer.valueOf("9999");
//        System.out.println(c);
//
//        //缓存
//        Integer f = 1235;
//        Integer g = 1235;                       //等价于: Integer g = Integer.valueOf(1235);
//        System.out.println(f==g);               //比较对象是否是同一个对象,false(创建了一个新对象,地址不同)
//        System.out.println(f.equals(g));        //比较值是否相等,true
//
//        Integer d = 126;
//        Integer e = 126;                        //等价于: Integer g = Integer.valueOf(126);
//
//        //缓存[-128,127]之间的整数，当调用valueOf的时候，首先检查是否在缓存区间内，如果不在，要创建新的对象。
//        System.out.println(d==e);               //比较对象是否是同一个对象,true(因为启动时已经缓存在了堆内，所以不再创建新的对象）
//        System.out.println(d.equals(e));        //比较值是否相等,true
//
//
//        //字符串一旦实例化，就成为一个常量，不可修改，只能生成新的字符串
//        //比较字符串，需要用equals方法
//        String a1 = "hello ";
//        String a2 = "world";
//        String a3 = "hello world";
//        String a4 = a3.replaceAll(" ","");
//        System.out.println(a4);
//
//        System.out.println(a1+a2);
//        System.out.println(a3.equals(a1+a2));
//
//
//        //StringBuffer或StringBuilder为可修改的字符串序列
//        StringBuilder SB = new StringBuilder(a);
//
//        for(int i=0;i<26;i++){
//            char temp = (char) ((char)'a'+i);
//            SB.append(temp);                    //append方法为在后面添加后继字符
//        }
//
//        System.out.println(SB);
//
//        SB.setCharAt(3,'高');        //setCharAt修改指定位置的字符
//        System.out.println(SB);
//
//        //insert或delete均可以链式调用，因方法return this，返回本身。
//        SB.insert(1,'我').insert(8,'爱').insert(18,'你');
//        System.out.println(SB);
//
//
//        //DateFormat为抽象类，new时只能用它的实例化类SimpleDateFormat
//        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String str = df1.format(400000000);
//        System.out.println(str);
//
//        //获取时间的毫秒数
//        Date date = new Date(2500);
//        System.out.println(date.getTime());


        //Calendar日历类的使用
        //Calendar为抽象类，new时只能用它的实例化类GregorianCalendar

        //获取时间元素
        Calendar calendar = new GregorianCalendar(2099,10,6,23,5,16);

        int year = calendar.get(Calendar.YEAR);             //获取定义的年份
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);   //星期几。1-7, 1代表周日,2代表周一，...
        int month = calendar.get(Calendar.MONTH);           //月份。0-11,0代表1月，。。。11代表12月。

        System.out.println(year);
        System.out.println(weekday);
        System.out.println(month);

        //设置时间元素
        Calendar c1 = new GregorianCalendar();
        c1.set(Calendar.YEAR,5555);
        int c1_year = c1.get(Calendar.YEAR);
        System.out.println(c1_year);

        //日期转换为日历类
        Calendar c2 = new GregorianCalendar();
        Date date = c2.getTime();                           //日历转化为日期类，gettime();
        System.out.println(date);

        c2.setTime(date);                                   //日期类转化为日历,settime();
        test a = new test();
        a.printCalendar(c2);




    }

    //按照自己定义的格式输出时间,编写一个封装方法printCalendar.
    public  void printCalendar(Calendar c){
        //打印：2019年12月31日 23:59:59  周二
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        int dayweek = c.get(Calendar.DAY_OF_WEEK)-1;
//        String dayweek2 = dayweek==0?"日":dayweek+"";
        String dayweek2 = numtochar(dayweek);

        System.out.println(year+"年"+month+"月"+day+"日 "+hour+"时"+minute+"分"+second+"秒  周"+dayweek2);
    }

    //将数字转化为汉字
    public  String numtochar(int n){

        switch (n){
            case 0:
                return "日";
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
        }

        return null;
    }
}
