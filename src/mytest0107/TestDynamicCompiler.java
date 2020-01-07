package mytest0107;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Allen
 * @date 2020/1/7 22:02
 * 测试动态编译
 */
public class TestDynamicCompiler {
    public static void main(String[] args) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "D:/IJ2019WORKSPACE/mytestcode/src/mytest0107/Demo03.java");
        System.out.println(result == 0 ? "编译成功" : "编译失败");

        try {
            URL[] urls = new URL[]{new URL("file:/" + "D:/IJ2019WORKSPACE/mytestcode/src/mytest0107/")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("mytest0107.Demo03");
            //调用加载类的main方法
            Method m = c.getMethod("main", String[].class);
            m.invoke(null, (Object) new String[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
