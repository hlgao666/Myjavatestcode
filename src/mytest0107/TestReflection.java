package mytest0107;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Allen
 * @date 2020/1/7 20:37
 * 应用反射的API,获取类User的信息（类名、属性、方法、构造器）
 */

@SuppressWarnings("all")    //抑制所有警告
public class TestReflection {

    public static void main(String[] args) {
        String path = "mytest0107.User";
        try {
            Class clazz = Class.forName(path);
//            Class clz = int.class;    //获取Class对象
            System.out.println(clazz.hashCode());   //一个类只对应一个Class对象

            System.out.println("类名：");
            //获取类名
            System.out.println(clazz.getName());
            System.out.println(clazz.getSimpleName());

            System.out.println("属性：");
            //获取属性
            Field[] fields = clazz.getDeclaredFields();
            for (Field temp : fields) {
                System.out.println(temp);
            }

            System.out.println("方法：");
            //获取方法
            Method[] methods = clazz.getDeclaredMethods();
            for (Method temp : methods) {
                System.out.println(temp);
            }

            System.out.println("构造器：");
            //获取构造器
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for (Constructor temp : constructors) {
                System.out.println(temp);
            }

            //获取指定构造器
            try {
                Constructor c = clazz.getDeclaredConstructor(String.class, String.class, int.class);
                System.out.println("构造器：" + c);

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
