package mytest;

import java.io.File;
import java.io.IOException;

            //测试File类的使用

public class testFile{
    public static void main(String[] args) throws IOException {
        File file = new File("E:/movie/Chinese");


        file.mkdir();               //若目录树中有一个路径不存在，则创建失败
        System.out.println(file.getPath());             //获取相对路径

        file.mkdirs();              //在指定路径下，创建整个目录树
        System.out.println(file.getAbsolutePath());     //获取绝对路径

        //在当前工作目录下创建新的文件
        File file2 = new File("gg.txt");
        file2.createNewFile();

        System.out.println(file2.getPath());            //获取相对路径
        System.out.println(file2.getAbsolutePath());             //获取相对路径
        System.out.println(System.getProperty("user.dir"));



    }
}
