package mytest0105;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Allen
 * @date 2020/1/5 22:12
 * test URL
 */
public class TestURL {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.bilibili.com/video/av59814573?p=238#a");
        //获取四个值
        System.out.println("协议" + url.getProtocol());
        System.out.println("域名" + url.getHost());
        System.out.println("端口" + url.getPort());
        System.out.println("资源" + url.getFile());

        //参数
        System.out.println("参数" + url.getQuery());
        //锚点
        System.out.println("锚点" + url.getRef());

    }
}
