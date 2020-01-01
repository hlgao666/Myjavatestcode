package mytest0101;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//测试ArrayList类
public class TestArrayList {

    public static void main(String[] args) {

        test03();

    }

    public static void test01() {

        Collection<String> c = new ArrayList();     //ArrayList是List的实例类，List继承自Collection接口

        c.add("monday");            //c仅仅存放"monday"对象的引用地址
        c.add("tuesday");
        System.out.println(c);

        c.remove("monday");     //移除后，"monday"对象还在，仅移除了对象的引用地址
        System.out.println(c);

    }

    public static void test02() {

        List lists = new ArrayList();
        lists.add("aa");
        lists.add("bb");
        lists.add("cc");

        List lists2 = new ArrayList();
        lists2.add("aa");
        lists2.add("dd");
        lists2.add("ee");

        System.out.println(lists);
//        lists.addAll(lists2);           //取和集，允许重复
//        lists.removeAll(lists2);        //将lists中与lists2相同的元素移除
        lists.retainAll(lists2);        //取交集
        System.out.println(lists);
        System.out.println(lists.containsAll(lists2));      //lists是否包含lists中的所有元素

    }

    public static void test03() {

        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list);

        list.add(2, "请君");           //插入
        System.out.println(list);

        list.set(2, "5");                              //替换
        System.out.println(list);

        list.add("B");
        System.out.println(list.indexOf("B"));                 //返回第一次出现B的索引
        System.out.println(list.lastIndexOf("B"));          //返回最后一次出现B的索引

    }


}

