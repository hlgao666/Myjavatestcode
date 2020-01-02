package mytest0102;

import java.util.Map;
import java.util.TreeMap;

//TreeMap是红黑二叉树的典型实现，当需要对键值对排序时需要用到TreeMap
public class TestTreeMap {

    public static void main(String[] args) {
        test02();
    }

    public static void test01() {
        Map tm = new TreeMap();

        tm.put(20, "aa");
        tm.put(6, "gj");
        tm.put(9, "dk");

        //内部排序,按照key递增排序
        for (Object key : tm.keySet()) {        //增强for循环
            System.out.println(key + "----" + tm.get(key));
        }
    }

    public static void test02() {

        //实现自定义排序
        Map<Emp, String> m2 = new TreeMap<>();
        Emp zhangsan = new Emp(1001, "zhangsan", 6000);
        Emp lisi = new Emp(1002, "lisi", 6000);
        Emp wangwu = new Emp(1003, "wangwu", 8000);
        Emp zhaoliu = new Emp(1004, "zhaoliu", 7000);

        m2.put(zhangsan, "zhangsan");
        m2.put(lisi, "lisi");
        m2.put(wangwu, "wangwu");
        m2.put(zhaoliu, "zhaoliu");
        for (Emp key : m2.keySet()) {
            System.out.println(key + "----" + m2.get(key));
        }

    }
}

class Emp implements Comparable<Emp> {       //实现自定义比较接口
    int id;
    String name;
    double salary;

    public Emp(int id, String name, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" + "id=" + id + ", name='" + name + '\'' + ", salary=" + salary + '}';
    }

    @Override       //重写compareTo()方法，实现自定义比较，JDK8以后可使用lambda表达式，更简洁
    public int compareTo(Emp o) {
        if (this.salary > o.salary) {
            return 1;
        } else if (this.salary < o.salary) {
            return -1;
        } else {
            if (this.id > o.id) {
                return 1;
            } else if (this.id < o.id) {
                return -1;
            } else {
                return 0;
            }
        }

    }
}