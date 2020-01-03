package mytest0103;

import java.util.*;

//ROM思想，对象关系映射

public class TestTableData {

    public static void main(String[] args) {
        Map<Integer, Emp1> map = new HashMap<>();

        Emp1 E1 = new Emp1(1001, "ZHANGSAN", 40000);
        Emp1 E2 = new Emp1(1002, "LISI", 50000);
        Emp1 E3 = new Emp1(1003, "WANGWU", 6000);

        map.put(1001, E1);
        map.put(1002, E2);
        map.put(1003, E3);

        //先获得键集合
        Set<Integer> keyset = map.keySet();
        for (Integer key : keyset) {
            System.out.println(key + "----" + map.get(key));
        }
    }
}

//一个完整的javabean要有set、get方法，以及空构造器
class Emp1 {
    private int id;
    private String name;
    private double salary;

    public Emp1() {
    }

    public Emp1(int id, String name, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", \tname='" + name + '\'' + ", \tsalary=" + salary + '}';
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

