package mytest0105;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Allen
 * @date 2020/1/5 21:21
 * IP:定位一个节点：计算机、路由、通讯设备
 */
public class TestLocal {
    public static void main(String[] args) throws UnknownHostException {
        //本机
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());  //本机IP
        System.out.println(addr.getHostName());     //本机名称

        //根据域名得到netaddress对象
        addr = InetAddress.getByName("www.baidu.com");
        System.out.println(addr.getHostAddress());  //输出baidu服务器的IP：182.61.200.7
        System.out.println(addr.getHostName());     //输出www.baidu.com
    }
}
