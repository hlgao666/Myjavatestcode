package mytest0101;


//增加数组扩容
//增加数组越界异常处理
public class TestArrayList2 {

    public static void main(String[] args) {

        TestArrayList03<String> tal = new TestArrayList03<>(2);

        for (int i = 0; i < 20; i++) {
            tal.add("gao" + i);
        }

        System.out.println(tal.toString());
        tal.remove(12);
        System.out.println(tal.toString());
        tal.remove("gao5");
        System.out.println(tal.toString());

//        tal.set("nihao",25);

    }
}

class TestArrayList03<E> {

    private Object[] elementData;
    private static final int MAX_CAPACITY = 10;
    private int size;           //初始为0

    public TestArrayList03() {
        elementData = new Object[MAX_CAPACITY];
    }

    public TestArrayList03(int capacity) {

        if (capacity < 0) {
            throw new RuntimeException("容器容量需大于0");     //异常处理
        } else if (capacity == 0) {
            elementData = new Object[MAX_CAPACITY];
        } else {
            elementData = new Object[capacity];
        }

    }

    public void add(E obj) {

        //何时扩容？
        if (size == elementData.length) {
            //扩容操作
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
            System.out.println(newArray.length);        //打印每次扩容后的长度，便于理解
        }
        elementData[size++] = obj;      //调用add时，size++
    }

    public void remove(E obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                remove(i);      //调用remove(int index)方法
            }
        }
    }

    //自定义remove方法
    public void remove(int index) {
        int nummoved = size - 1 - index;
        if (nummoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, nummoved);
        }
        elementData[--size] = null;
    }


    public E get(int index) {
        checkException(index);
        return (E) elementData[index];
    }

    public void set(E obj, int index) {
        checkException(index);
        elementData[index] = obj;
    }

    //自定义异常
    public void checkException(int index) {
        if (index < 0 || index > elementData.length - 1) {
            throw new RuntimeException("索引不合法：" + index);
        }
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
