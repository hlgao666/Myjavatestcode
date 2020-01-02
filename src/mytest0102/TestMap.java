package mytest0102;

import java.util.HashMap;
import java.util.Map;
//测试HashMap
//Map是接口Interface，HashMap是具体实现类

//HashMap存储原理：(数组+链表):(Hashcode-Key-Value-next)--(Hashcode-Key-Value-next)--(Hashcode-Key-Value-next)
//根据Key对象的hashcode()方法，获得hashcode,对每一对象的Hashcode取余，得到对应的Hash值，根据Hash值存储到相应下标的数组中
//JDK8以后，当某一链表长度>8时，会自动变为红黑树存储结构
public class TestMap {

    public static void main(String[] args) {
//        testMap01();

        testMap02();

    }

    static void testMap01() {
        Map<Integer, String> m1 = new HashMap<>();

        m1.put(1, "AA");
        m1.put(2, "BB");
        m1.put(3, "dd");

        System.out.println(m1.get(2));

        //键不能重复(根据equal方法判断是否重复)，否则原有值将被新值取代
        m1.put(2, "hello");
        System.out.println(m1.get(2));
    }

    static void testMap02() {
        Employee e1 = new Employee(1001, "ASJ", 50000);
        Employee e2 = new Employee(1002, "HKD", 60000);
        Employee e3 = new Employee(1003, "wfg", 70000);

        //键和值对象可以为任意类型
        Map<Integer, Employee> map = new HashMap<>();

        map.put(1001, e1);
        map.put(1002, e2);
        map.put(1003, e3);

        Employee e = map.get(1002);
        System.out.println(e.toString());
    }
}

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + "', salary=" + salary + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
