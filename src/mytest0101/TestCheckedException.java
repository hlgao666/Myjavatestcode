package mytest0101;

//测试已检查异常

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestCheckedException {
    //main将异常交给JRE处理
    public static void main(String[] args) throws IOException {
        FileReader reader = null;

        try {
            reader = new FileReader("d://g.txt");

            char c = (char) reader.read();
            System.out.println(c);

        } catch (FileNotFoundException e) {             //捕获异常时，子类异常FileNotFoundException在前，父类异常IOException在后
            System.out.println("step1");
            e.printStackTrace();                        //否则，只执行到父类异常就不再往下执行
        } catch (IOException e) {
            System.out.println("step2");
            e.printStackTrace();
        } finally {                              //finally，无论是否捕获了异常，都执行finally里面的内容close();
            System.out.println("step3");
            try {
                if (reader != null) {            //注意空指针异常
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //使用throws声明异常,将异常交给调用者main来处理
        readMyFile();

    }

    //或者使用throws声明异常,将异常交给调用者readMyFile()处理
    static void readMyFile() throws IOException {
        FileReader reader = null;
        reader = new FileReader("d://g.txt");
        char c = (char) reader.read();
        System.out.println(c);
        reader.close();
    }

}
