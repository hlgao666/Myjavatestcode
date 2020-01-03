package mytest0103;

//Lambda推导
public class TestLambda1 {
    //静态内部类
    static class ILove2 implements Love {

        @Override
        public void print() {
            System.out.println("I LOVE, 2!");
        }
    }

    public static void main(String[] args) {
        Love love;

        love = new ILove();
        love.print();           //执行外部类方法

        love = new ILove2();
        love.print();           //执行静态内部类方法

        //局部内部类
        class ILove3 implements Love {
            @Override
            public void print() {
                System.out.println("I LOVE, 3!");
            }
        }
        love = new ILove3();
        love.print();           //执行局部内部类方法

        //匿名内部类
        love = new Love() {     //匿名内部类
            @Override
            public void print() {
                System.out.println("I LOVE, 4!");
            }
        };
        love.print();           //执行匿名内部类方法

        //Lambda表达式
        //Lambda推导必须存在类型
        love = () -> {
            System.out.println("I LOVE, 5!");
        };
        love.print();           //执行Lambda表达式定义的方法，方法名根据对象所在类或接口获得

    }
}

interface Love {
    void print();
}

//外部类
class ILove implements Love {

    @Override
    public void print() {
        System.out.println("I LOVE, 1!");
    }
}