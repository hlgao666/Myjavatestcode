package mytest0101;

//测试运行时的异常，需自己加判断处理

public class TestRuntimeException {

    public static void main(String[] args) {

        //NullPointerException空指针异常
        String str = null;
        if (str != null) {
            System.out.println(str.length());
        }

        //ClassCastException强制转型错误
//        Dog a = new Dog();
//        if(a instanceof Cat){
//            Cat b = (Cat)a;
//        }

        //IndexOutOfBoundsException数组越界异常
        int[] arr = new int[5];
        int i = 5;
        if (i < arr.length) {
            System.out.println(arr[i]);
        }

    }
}

class Animal {
}

class Cat extends Animal {
}

class Dog extends Animal {
}
