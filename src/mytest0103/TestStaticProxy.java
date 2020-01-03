package mytest0103;

//多线程静态代理设计模式

//实现公共接口：
//1.真实角色
//2.代理角色
public class TestStaticProxy {

    public static void main(String[] args) {

        new WeddingCompy(new You()).happyMarry();
        //new Thread(线程对象).start();
    }
}

interface Marry {
    void happyMarry();
}

//真实角色
class You implements Marry {

    @Override
    public void happyMarry() {
        System.out.println("I LOVE YOU!");
    }
}

//代理角色
class WeddingCompy implements Marry {

    //真实角色
    private Marry target;

    public WeddingCompy(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {

        ready();                    //代理人方法
        this.target.happyMarry();   //真实角色方法
        after();                    //代理方法
    }

    public void ready() {
        System.out.println("整理新房");
    }

    public void after() {
        System.out.println("闹洞房");
    }

}