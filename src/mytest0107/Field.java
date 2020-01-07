package mytest0107;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Allen
 * @date 2020/1/7 20:03
 * 定义注解
 */
@Target(value = {ElementType.FIELD})  //注解目标：方法和类
@Retention(RetentionPolicy.RUNTIME)     //反射运行时使用注解
public @interface Field {
    String columnname();

    String type();

    int length();
}
