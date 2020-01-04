package mytest0104;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Allen
 * @date 2020/1/4 21:47
 */
public class Syntest {

    public static void main(String[] args) {

        List<Integer> avaliable = new ArrayList<>();
        avaliable.add(1);
        avaliable.add(2);
        avaliable.add(3);
        avaliable.add(4);
        avaliable.add(5);

        List<Integer> seat1 = new ArrayList<>();
        seat1.add(1);
        seat1.add(5);


        List<Integer> seat2 = new ArrayList<>();
        seat2.add(1);
        seat2.add(3);
//        seat2.add(4);

        Cinema cinema = new Cinema(avaliable);

        Customer customer1 = new Customer(cinema, seat1, "GAO");
        Customer customer2 = new Customer(cinema, seat2, "XIAO");
        customer1.run();
        customer2.run();
    }
}

//顾客
class Customer implements Runnable {

    Cinema cinema;
    List<Integer> seats;
    String name;        //名称

    public Customer(Cinema cinema, List<Integer> seats, String name) {
        this.cinema = cinema;
        this.seats = seats;
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println("所需位置为：" + seats);

        synchronized (cinema) {
            boolean flag = cinema.bookTicket(seats);
            if (flag) {
                System.out.println(this.name + "出票成功，位置为：" + seats);
            } else {
                System.out.println(this.name + "出票失败，位置不够");
            }
        }

    }
}

//影院类
class Cinema {

    List<Integer> avaliable;      //可用位置


    public Cinema(List<Integer> avaliable) {
        this.avaliable = avaliable;
    }

    public boolean bookTicket(List<Integer> seats) {

        System.out.println("可用位置为：" + avaliable);
        List<Integer> copy = new ArrayList<>();
        copy.addAll(avaliable);

        //相减
        copy.removeAll(seats);
        //判断大小
        if (avaliable.size() - copy.size() != seats.size()) {
            return false;
        } else {

            avaliable = copy;
            return true;
        }
    }
}