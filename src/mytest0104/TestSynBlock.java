package mytest0104;

/**
 * @author Allen
 * @date 2020/1/4 20:23
 * 锁块Synchronized
 * 同步块,目标更明确
 */
public class TestSynBlock {

    public static void main(String[] args) {

        Account account = new Account("CHUXUGUAN", 1000);
        Draw I = new Draw(account, 80, "I");
        Draw SHE = new Draw(account, 60, "she");
        I.run();
        SHE.run();
    }
}

//账户
class Account {

    String name;
    int money;

    public Account(String name, int money) {
        super();
        this.name = name;
        this.money = money;     //账户金额
    }
}

//模拟取款
class Draw implements Runnable {

    Account account;        //取款账户
    String name;
    int drawing_money;      //取款金额
    int drawing_total;      //取款总额

    public Draw(Account account, int drawing_money, String name) {
        super();
        this.account = account;
        this.drawing_money = drawing_money;
        this.name = name;
    }

    @Override
    public void run() {

        try {
            test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //目标锁定account
    public void test() throws InterruptedException {

        //提高性能
        if (account.money <= 0) {
            return;
        }
        //同步块
        synchronized (account) {
            if (account.money - drawing_money < 0) {
                return;
            }

            Thread.sleep(100);
            account.money -= drawing_money;
            drawing_total += drawing_money;

            System.out.println(this.name + "取款金额为：" + drawing_total);
            System.out.println(this.name + "账户余额为：" + account.money);
        }
    }
}