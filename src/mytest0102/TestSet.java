package mytest0102;

import java.util.HashMap;
import java.util.Map;

//手写Set底层代码,用HashMap实现
public class TestSet {

    HashMap map;
    private static final Object PRESENT = new Object();

    public TestSet() {
        map = new HashMap();
    }

    public void add(Object key) {
        map.put(key, PRESENT);
    }

    public int size() {
        return map.size();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");

        for (Object key : map.keySet()) {
            sb.append(key + ",");
        }
        sb.setCharAt(sb.length() - 1, ']');

        return sb.toString();
    }

    public static void main(String[] args) {

        TestSet a = new TestSet();

        a.add("ghk");
        a.add("sdo");
        a.add("euk");

        System.out.println(a);

    }
}
