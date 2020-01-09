package mytest0109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Allen
 * @date 2020/1/9 20:02
 * 网络爬虫
 * Linux工具：Wget
 */
public class WebSpider {

    //获得urlStr对应网页的源码内容
    public static String getURLContent(String urlStr, String charset) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName(charset)));
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                sb.append(temp);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static List<String> getMatherSubstrs(String destStr, String regexStr) {
        Pattern p = Pattern.compile(regexStr);     //超链接地址
        Matcher m = p.matcher(destStr);
        List<String> result = new ArrayList<>();
        while (m.find()) {
            result.add(m.group(1));
        }
        return result;
    }

    public static void main(String[] args) {
        String desStr = getURLContent("http://www.163.com", "gbk");


//        Pattern p = Pattern.compile("<a[\\s\\S]+?</a>");    //取到的整个超链接
        List<String> result = getMatherSubstrs(desStr, "href=\"(htt+[\\w\\s./:]+?)\"");
        for (String temp : result) {
            System.out.println(temp);
        }
    }
}
