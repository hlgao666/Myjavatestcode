package mytest0106;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * @author Allen
 * @date 2020/1/6 11:07
 * 创建双向(two way)服务器
 * 1.指定端口 使用SeverSocket创建服务器
 * 2.阻塞式等待连接,accpet()
 * 3.操作：输入输出流操作
 * 4.释放资源
 */
public class LoginSever {

    public static void main(String[] args) throws IOException {

        //1.指定端口 使用SeverSocket创建服务器
        ServerSocket sever = new ServerSocket(8888);
        //2.阻塞式等待连接
        Socket client = sever.accept();
        System.out.println("-------sever---------");
        System.out.println("一个客户端建立了连接");
        //3.操作：输入输出流操作
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        String uname = "";
        String upwd = "";
        //分析
        String[] dataArray = data.split("&");

        for (String info : dataArray) {
            String[] userinfo = info.split("=");
            if (userinfo[0].equals("uname")) {
                System.out.println("用户名为" + "--->" + userinfo[1]);
                uname = userinfo[1];
            } else if (userinfo[0].equals("upwd")) {
                System.out.println("密码为" + "--->" + userinfo[1]);
                upwd = userinfo[1];
            }
        }

        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        if (uname.equals("ghl") && upwd.equals("123")) {//成功
            dos.writeUTF("登陆成功，欢迎");
        } else {//失败
            dos.writeUTF("用户名或密码错误");
        }

        dos.flush();
        //4.释放资源
        dis.close();
        client.close();
    }

}

