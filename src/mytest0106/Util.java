package mytest0106;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Allen
 * @date 2020/1/6 15:46
 * 工具类
 */
public class Util {

    //释放资源

    public static void close(Closeable... targets) {
        for (Closeable target : targets) {
            try {
                if (null != target) {
                    target.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
