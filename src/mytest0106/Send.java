package mytest0106;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Allen
 * @date 2020/1/6 16:08
 * 使用多线程封装：发送端
 * 1.发送信息
 * 2.从控制台获取信息
 * 3.释放资源
 * 4.重写run()
 */
public class Send implements Runnable {

    private BufferedReader console;
    private DataOutputStream dos;
    private Socket client;
    private boolean isRunning;
    private String name;

    //构造器
    public Send(Socket client, String name) {
        this.client = client;
        this.name = name;
        try {
            console = new BufferedReader(new InputStreamReader(System.in));
            dos = new DataOutputStream(client.getOutputStream());
            isRunning = true;
            //发送名称
            send(name);
        } catch (IOException e) {
            System.out.println("====1====");
            release();
        }
    }


    @Override
    public void run() {
        while (isRunning) {
            String msg = getStrFromConsole();
            if (!msg.equals("")) {
                send(msg);
            }
        }
    }

    //发送信息
    private void send(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("====3====");
            release();
        }

    }

    //从控制台获取信息
    private String getStrFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
            System.out.println("====4====");
            release();
        }
        return "";
    }

    //释放资源
    private void release() {
        this.isRunning = false;
        Util.close(dos, client);
    }
}
