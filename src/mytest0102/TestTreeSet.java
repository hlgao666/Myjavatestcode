package mytest0102;

import java.util.Set;
import java.util.TreeSet;

//手写TreeSet,底层利用TreeMap实现
public class TestTreeSet {


    public static void main(String[] args) {
        //默认按Key递增方式排序
        Set<Integer> set = new TreeSet<>();
        set.add(15);
        set.add(6);
        set.add(56);

        System.out.println(set);
        //按自定义方式排序
        Set<Emp> set2 = new TreeSet<>();
        set2.add(new Emp(1001, "ZHANGSAN", 8000));
        set2.add(new Emp(1002, "LISI", 6000));
        set2.add(new Emp(1003, "WANGWU", 6000));
        set2.add(new Emp(1005, "ZHAOLIU", 7000));
        for (Emp o : set2) {
            System.out.println(o);
        }

    }
}
