package mytest0106;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Allen
 * @date 2020/1/6 14:50
 */
public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {

        System.out.println("-------Client---------");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名:");
        String name = br.readLine();
        //1.建立连接： 使用Socket创建客户端+服务器的地址和端口
        Socket client = new Socket("localhost", 9999);

        //2.客户端发送信息
        new Thread(new Send(client, name)).start();
        //3.接收信息
        new Thread(new Receive(client)).start();
    }
}
