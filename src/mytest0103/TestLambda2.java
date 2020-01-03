package mytest0103;

/**
 * @author Allen
 * @date 2020/1/3 20:39
 * Lambda推导+简化+带参数+带返回值
 */
public class TestLambda2 {

    public static void main(String[] args) {

        IT temp;

        temp = (a, b) -> {
            System.out.println("IT---" + (a + b));
            return 100;
        };
        System.out.println(temp.it(5, 9));

        //线程+Lambda表达式
        new Thread(() -> {
            System.out.println("WKO");
        }).start();

    }
}

interface IT {
    int it(int a, int b);
}