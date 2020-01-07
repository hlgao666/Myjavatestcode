package mytest0106;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Allen
 * @date 2020/1/6 11:07
 * 创建服务器
 * 1.指定端口 使用SeverSocket创建服务器
 * 2.阻塞式等待连接,accpet()
 * 3.操作：输入输出流操作
 * 4.释放资源
 */
public class TCPSever {

    public static void main(String[] args) throws IOException {
        //1.指定端口 使用SeverSocket创建服务器
        ServerSocket sever = new ServerSocket(8888);
        //2.阻塞式等待连接
        Socket client = sever.accept();
        System.out.println("一个客户端建立了连接");
        //3.操作：输入输出流操作
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        System.out.println(data);

        //4.释放资源
        dis.close();
        client.close();
    }

}
