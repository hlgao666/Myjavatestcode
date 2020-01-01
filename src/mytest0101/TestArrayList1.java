package mytest0101;

public class TestArrayList1 {
    public static void main(String[] args) {
        TestArrayList02<String> tal = new TestArrayList02<>(5);

        tal.add("aa");
        tal.add("ee");
        System.out.println(tal.toString());
    }
}

class TestArrayList02<E> {

    private Object[] elementData;
    private static final int MAX_CAPACITY = 10;
    private int size;           //初始为0

    public TestArrayList02() {
        elementData = new Object[MAX_CAPACITY];
    }

    public TestArrayList02(int capacity) {
        elementData = new Object[capacity];
    }

    public void add(E obj) {
        elementData[size++] = obj;      //调用add时，size++
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();     //StringBuilder类的对象，下标从1开始

        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length() - 1, ']');

        return sb.toString();       //将sb中的所有内容作为一个字符串返回
    }


}