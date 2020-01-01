package mytest0101;


//测试泛型
public class TestGeneric {

    public static void main(String[] args) {

        MyCollection<String> mc = new MyCollection<>();         //将自定义容器类的对象设置成String型

        mc.setObjects("hello", 0);
        mc.setObjects("world", 1);
        String str = mc.getObjects(1);
        System.out.println(str);

        MyCollection<Integer> mc2 = new MyCollection<>();       //将自定义容器类的对象设置成Integer型
        mc2.setObjects(123, 0);
        mc2.setObjects(567, 1);
        Integer integer = mc2.getObjects(1);
        System.out.println(integer);
    }
}

class MyCollection<E> {              //E即泛型，可代表任意类型
    Object[] objects = new Object[5];

    public E getObjects(int index) {
        return (E) objects[index];
    }

    public void setObjects(E object, int index) {
        objects[index] = object;
    }
}

