package mytest0101;


//测试自定义异常
public class TestCustomException {

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(-10);
    }

    //自定义异常，继承自RuntimeException或Exception
    static class IllegalAgeException extends RuntimeException {

        public IllegalAgeException() {               //添加空构造器
        }

        public IllegalAgeException(String msg) {     //添加带参构造器

            super(msg);             //super必须位于构造器第一句，指向父类的引用
            //this表示一个对象的引用,它指向正在执行方法的对象.
        }
    }

    static class Person {
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age < 0) {
                throw new IllegalAgeException("年龄必须大于0");       //若抛出异常，将不再继续往下执行
            }
            this.age = age;
        }
    }

}
