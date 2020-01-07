package mytest0106;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author Allen
 * @date 2020/1/6 16:08
 * 使用多线程封装：接收端
 * 1.接收信息
 * 2.释放资源
 * 3.重写run()
 */
public class Receive implements Runnable {
    private DataInputStream dis;
    private Socket client;
    private boolean isRunning = true;

    public Receive(Socket client) {
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            System.out.println("====2====");
            release();
        }
    }

    //接收信息
    private String receive() {
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            System.out.println("====5====");
            release();
        }
        return msg;
    }

    @Override
    public void run() {
        while (isRunning) {
            String msg = receive();
            if (!msg.equals("")) {
                System.out.println(msg);
            }
        }
    }

    //释放资源
    private void release() {
        this.isRunning = false;
        Util.close(dis, client);
    }
}
