package mytest0105;

/**
 * @author Allen
 * @date 2020/1/5 11:25
 * 并发协作模型：生产者-消费者模式（管程法）
 * 借助缓冲容器
 */
public class TestSynCoop01 {
    public static void main(String[] args) {

        SynContainer synContainer = new SynContainer();
        new Productor(synContainer).start();
        new Consumer(synContainer).start();
    }
}

//生产者
class Productor extends Thread {
    SynContainer synContainer;

    public Productor(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {

        //生产
        for (int i = 0; i < 100; i++) {
            System.out.println("生产第" + i + "个");
            try {
                synContainer.push(new Product(i));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//消费者
class Consumer extends Thread {
    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        //消费
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println("消费第" + synContainer.pop().id + "个");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

//缓冲区
class SynContainer {
    Product[] products = new Product[10];

    int count;

    //存
    //何时生产？容器不满
    public synchronized void push(Product product) throws InterruptedException {
        //容器满，只能等待，线程阻塞,消费者通知生产解除阻塞
        if (count == products.length) {
            this.wait();
        }
        products[count++] = product;
        this.notifyAll();       //通知消费
    }

    //取
    //何时消费？容器数据不为空
    public synchronized Product pop() throws InterruptedException {

        //容器为空，只能等待，线程阻塞,生产者通知消费解除阻塞
        if (count == 0) {
            this.wait();
        }
//        count--;
        Product product = products[--count];
        this.notifyAll();       //通知生产,存在空间，唤醒对方
        return product;
    }

}

//产品
class Product {
    int id;

    public Product(int id) {
        this.id = id;
    }
}
