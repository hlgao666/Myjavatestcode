package mytest0102;

import java.util.*;

public class TestIterator {

    //定义迭代器实现List的循环
    public static void testIterList01() {
        List<String> list = new ArrayList<>();
        list.add("ahk");
        list.add("wof");
        list.add("fox");

        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String temp = iterator.next();      //初始游标在第一个元素前，游标向后移动一个位置，并将该位置的元素赋给temp，进入下一步判断
            System.out.println(temp);
        }
    }

    //使用while循环实现List的遍历
    public static void testWhileList02() {

        List<String> list = new ArrayList<>();
        list.add("ahk");
        list.add("wof");
        list.add("fox");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {     //需要一边遍历一边删除时，使用while循环
            Object obj = iterator.next();
            iterator.remove();
            System.out.println(obj);
        }
    }

    //使用增强for循环实现List的遍历
    public static void testForList03() {

        List<String> list2 = new ArrayList<>();

        list2.add("WD");
        list2.add("KL");
        list2.add("AP");

        for (String temp : list2) {
            System.out.println(temp);
        }
    }
    //定义迭代器实现Set的循环
    public static void testIterSet() {
        Set<String> set = new TreeSet<>();
        set.add("dog");
        set.add("mouse");
        set.add("rabbit");

        for (Iterator<String> iterator = set.iterator(); iterator.hasNext(); ) {
            String TEMP = iterator.next();
            System.out.println(TEMP);
        }
    }

    //定义迭代器实现Map的循环
    public static void testIterMap01() {
        Map<Integer, String> map = new TreeMap<>();
        map.put(15, "sk");
        map.put(56, "ko");
        map.put(89, "wk");

        //先获取键值对的Set集合
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();

        for (Iterator<Map.Entry<Integer, String>> ss = entrySet.iterator(); ss.hasNext(); ) {
            Map.Entry<Integer, String> temp = ss.next();
            System.out.println(temp.getKey() + "---" + temp.getValue());
        }
    }

    //定义迭代器实现Map的循环
    public static void testIterMap02() {
        Map<Integer, String> map1 = new TreeMap<>();
        map1.put(111, "dkl");
        map1.put(333, "aop");
        map1.put(555, "wwe");

        //获取键的集合
        Set<Integer> keySet = map1.keySet();
        for (Iterator<Integer> iterator = keySet.iterator(); iterator.hasNext(); ) {
            Integer key = iterator.next();
            System.out.println(key + "---" + map1.get(key));
        }
    }

    public static void main(String[] args) {
//        testIterList01();
        testWhileList02();
//        testForList03();
//        testIterSet();
//        testIterMap01();
        testIterMap02();
    }
}
