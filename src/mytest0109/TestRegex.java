package mytest0109;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Allen
 * @date 2020/1/9 19:24
 */
public class TestRegex {

    public static void main(String[] args) {
//        test01();
//        test02();
//        test03();
        test04();
    }

    public static void test01() {
        //表达式对象
        Pattern p = Pattern.compile("\\w+");        //java中的"\\"对应正则中的"\"
        //Matcher对象
        Matcher m = p.matcher("asdffgj//ajy5414f");
//        boolean matcherflag = m.matches();      //尝试将整个字符序列与表达式匹配,会移动光标到下一个子序列前

//        boolean matcherflag2 = m.find();        //该方法扫描输入的序列，查找与该模式匹配的下一个子序列，会移动光标到下一个子序列前

//        System.out.println(matcherflag);
//        System.out.println(m.group());
//        System.out.println(matcherflag2);
        while (m.find()) {        //可打印多次
            System.out.println(m.group());
        }
    }

    public static void test02() {
        //表达式对象
        Pattern p = Pattern.compile("([a-z]+)([0-9]+)");    //分组处理     //java中的"\\"对应正则中的"\"
        //Matcher对象
        Matcher m = p.matcher("asd222ffgj445//ajy5414f");
//        boolean matcherflag = m.matches();      //尝试将整个字符序列与表达式匹配,扫描完之后会移动光标到下一个子序列前

//        boolean matcherflag2 = m.find();        //该方法扫描输入的序列，查找与该模式匹配的下一个子序列，扫描完之后会移动光标到下一个子序列前

//        System.out.println(matcherflag);
//        System.out.println(m.group());
//        System.out.println(matcherflag2);
        while (m.find()) {        //可打印多次
            System.out.println(m.group());
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }
    }

    public static void test03() {
        //表达式对象
        Pattern p = Pattern.compile("[0-9]+");    //分组处理     //java中的"\\"对应正则中的"\"
        //Matcher对象
        Matcher m = p.matcher("asd222ffgj445//ajy5414f");
//        boolean matcherflag = m.matches();      //尝试将整个字符序列与表达式匹配,扫描完之后会移动光标到下一个子序列前

        //替换
        String newstr = m.replaceAll("&");
        System.out.println(newstr);
    }

    public static void test04() {

        //字符串分割操作
        String str = "a2223b66995c";
        String[] arrs = str.split("\\d+");      //正则表达式分割
        System.out.println(Arrays.toString(arrs));
    }
}
