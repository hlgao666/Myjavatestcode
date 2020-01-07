package mytest0107;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Allen
 * @date 2020/1/7 21:10
 */

@SuppressWarnings("all")
public class Demo03 {
    public static void main(String[] args) {
        String path = "mytest0107.User";
        try {
            Class clazz = Class.forName(path);

            //通过反射API调用构造方法，构造对象
            User u = null;
            u = (User) clazz.newInstance();     //无参构造
            System.out.println(u.getName());

            Constructor<User> c = clazz.getDeclaredConstructor(String.class, String.class, int.class);
            User user = c.newInstance("1001", "gao", 18);     //有参构造
            System.out.println(user.getAge());

            //通过反射API调用普通方法
            // 方法名和值可以从别的地方获取，实现动态调用
            User user1 = (User) clazz.newInstance();
            Method method = clazz.getDeclaredMethod("setName", String.class);
            method.invoke(user1, "wuli");
            System.out.println(user1.getName());

            //通过反射API获取属性
            User user2 = (User) clazz.newInstance();
            Field f = clazz.getDeclaredField("name");
            f.setAccessible(true);      //此属性不需要做安全检查了，可以直接访问,提高反射执行效率
            f.set(user2, "kkk");         //通过反射直接写属性
            System.out.println(user2.getName());    //通过反射直接读属性
            System.out.println(f.get(user2));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
