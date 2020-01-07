package mytest0107;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author Allen
 * @date 2020/1/7 20:09
 * 使用反射读取注解信息
 */
public class Demo02 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("mytest0107.Student");
            //获得类的所有注解
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }
            //获得类的指定注解
            Table clz = (Table) clazz.getAnnotation(Table.class);
            System.out.println(clz.VALUE());

            //获得类的属性注解
            Field f = clazz.getDeclaredField("id");
            mytest0107.Field temp = f.getAnnotation(mytest0107.Field.class);
            System.out.println("columnname:" + temp.columnname() + "  type:" + temp.type() + "  length:" + temp.length());

            //根据获得的表明字段信息，拼出sql语句

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
