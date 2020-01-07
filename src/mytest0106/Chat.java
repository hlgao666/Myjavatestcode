package mytest0106;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Allen
 * @date 2020/1/6 14:51
 * 在线聊天室：服务器
 * 目标：实现多个客户可以正常收发信息,加入容器实现群聊
 */
public class Chat {
    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<>();        //既要改又要遍历，使用此容器

    public static void main(String[] args) throws IOException {

        System.out.println("-------server---------");
        //1.指定端口 使用SeverSocket创建服务器
        ServerSocket server = new ServerSocket(9999);
        //2.阻塞式等待连接
        while (true) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            Channel c = new Channel(client);
            all.add(c);     //管理所有成员
            new Thread(c).start();
        }
    }

    //一个客户代表一个Channel
    static class Channel implements Runnable {
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning = true;
        private String name;

        //构造器
        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                System.out.println("初始化成功");
                //获取名称
                this.name = receive();
                this.sendOthers("欢迎" + this.name + "来到聊天室", true);

            } catch (IOException e) {
                System.out.println("----1----");
                release();
            }
        }

        @Override
        public void run() {
            while (isRunning) {
                String msg = receive();
                if (!msg.equals("")) {
                    this.sendOthers(msg, false);
                }
            }
        }

        //接收信息
        private String receive() {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                System.out.println("----6-----");
                release();
            }
            return msg;
        }

        //群发送信息
        private void sendOthers(String msg, boolean isSys) {
            boolean isPrivate = msg.startsWith("@");
            //加入私聊:约定数据格式：@xxx:msg
            if (isPrivate) {

                int idx = msg.indexOf(":");
                //获取目标和数据
                String targetname = msg.substring(1, idx);
                msg = msg.substring(idx + 1);
                for (Channel others : all) {
                    if (others.name.equals(targetname)) {
                        others.send(this.name + "悄悄对你说：" + msg);
                    }
                }

            } else {
                for (Channel others : all) {
                    if (others == this) {
                        continue;
                    }
                    if (isSys) {
                        others.send("欢迎" + this.name + "来到聊天室");
                    } else {
                        others.send(this.name + "说：" + msg);
                    }
                }
            }
        }

        //发送信息
        private void send(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                System.out.println("---3---");
                release();
            }

        }

        //释放资源
        private void release() {
            this.isRunning = false;
            Util.close(dis, dos, client);
            //退出
            all.remove(this);
            sendOthers(this.name + "离开了聊天室", true);
        }
    }
}
