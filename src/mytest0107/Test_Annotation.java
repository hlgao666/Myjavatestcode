package mytest0107;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Allen
 * @date 2020/1/7 16:56
 * 自定义注解
 */

@Target(value = {ElementType.METHOD, ElementType.TYPE})  //注解目标：方法和类
@Retention(RetentionPolicy.RUNTIME)     //反射运行时使用注解
public @interface Test_Annotation {

    String name = "";       //一定要设置初始值，否则用时会出错

    int age() default 0;

    int id() default -1;    //负数通常表示不存在

    String[] value();

}

