package mytest0103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//测试Collections辅助类
//Collection是接口，Collections是辅助工具类
//类java.util.Collections可以对Set、Map、List进行排序、填充和辅助查找
public class TestCollections {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("gao:" + i);
        }

        System.out.println(list);

        Collections.reverse(list);      //逆序
        System.out.println(list);

        Collections.shuffle(list);      //随机排列
        System.out.println(list);

        Collections.sort(list);         //递增排列，如果自定义排列：使用Comparable接口
        System.out.println(list);

        System.out.println(Collections.binarySearch(list, "gao:3"));     //二分查找


    }
}
