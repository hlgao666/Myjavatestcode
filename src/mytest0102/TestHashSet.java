package mytest0102;

import java.util.HashSet;
import java.util.Set;

//Set继承自Collection接口,没有顺序，不可重复
//List继承自Collection接口,有顺序，可重复

//Set底层使用Map,set.add()方法加入的是map的key,因map的key不能重复，因此add()不能重复
public class TestHashSet {

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        Set<String> set = new HashSet<>();

        set.add("ashjk");
        set.add("shu");
        set.add("love");
        System.out.println(set);
    }
}
