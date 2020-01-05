package mytest0105;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author Allen
 * @date 2020/1/5 22:42
 * 1.使用DatagramSocket 指定端口 创建接收端
 * 2.准备容器，封装成DatagramPacket包裹
 * 3.阻塞式接收包裹，receive(DatagramPacket p);
 * 4.分析数据
 * byte[] getData()
 * getLength()
 * 5.释放资源
 */
//接收端
public class UdpSever {

    public static void main(String[] args) throws Exception {

        System.out.println("接收方启动中......");
        //1.使用DatagramSocket 指定端口 创建接收端
        DatagramSocket sever = new DatagramSocket(8888);

        //2.准备容器，封装成DatagramPacket包裹
        byte[] container = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);

        //3.阻塞式接收包裹，receive(DatagramPacket p);
        sever.receive(packet);

        //4.分析数据
        //byte[] getData()
        //getLength()
        byte[] datas = packet.getData();
        int length = packet.getLength();
        System.out.println(new String(datas, 0, length));

        //5.释放资源
        sever.close();

    }
}
