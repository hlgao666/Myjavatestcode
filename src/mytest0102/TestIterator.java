package mytest0102;

import java.util.*;

public class TestIterator {

    //定义迭代器实现List的循环
    public static void testIterList() {
        List<String> list = new ArrayList<>();
        list.add("ahk");
        list.add("wof");
        list.add("fox");

        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String temp = iterator.next();      //初始游标在第一个元素前，游标向后移动一个位置，并将该位置的元素赋给temp，进入下一步判断
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

        Set<Integer> keySet = map1.keySet();
        for (Iterator<Integer> iterator = keySet.iterator(); iterator.hasNext(); ) {
            Integer key = iterator.next();
            System.out.println(key + "---" + map1.get(key));
        }
    }

    public static void main(String[] args) {
        testIterList();
        testIterSet();
        testIterMap01();
        testIterMap02();
    }
}
