package mytest0105;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author Allen
 * @date 2020/1/5 22:42
 * 1.使用DatagramSocket 指定端口 创建发送端
 * 2.准备数据，一定转成字节数组
 * 3.封装成DatagramPacket包裹，一定指定目的地
 * 4.发送包裹send(DatagramPacket p)
 * 5.释放资源
 */
//发送端
public class UdpClient {

    public static void main(String[] args) throws Exception {

        System.out.println("发送方启动中......");

        //1.使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket();

        //2.准备数据，一定转成字节数组
        String data = "完成比完美更重要！";
        byte[] datas = data.getBytes();

        //3.封装成DatagramPacket包裹，一定指定目的地
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                new InetSocketAddress("localhost", 8888));

        //4.发送包裹send(DatagramPacket p)
        client.send(packet);

        //5.释放资源
        client.close();
    }
}
