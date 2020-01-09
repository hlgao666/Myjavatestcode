package mytest0108;

/**
 * @author Allen
 * @date 2020/1/8 20:29
 * 使用枚举实现单例模式，没有延时加载
 */
public enum SingletonDemo04 {

    //这个枚举元素，本身就是单例对象
    INSTANCE;

    //添加自己需要的操作
    public void singletonOperation() {
    }
}
