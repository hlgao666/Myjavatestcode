package mytest0107;

/**
 * @author Allen
 * @date 2020/1/7 17:02
 * 测试自定义注解
 */
@Test_Annotation(value = "aaaa", age = 1)
public class Demo01 {

    @Test_Annotation("bbbb")
    public void test01() {

    }
}
