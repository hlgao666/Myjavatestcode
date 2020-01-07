package mytest0107;

import javax.script.Invocable;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;

/**
 * @author Allen
 * @date 2020/1/7 22:54
 * 测试脚本引擎
 */
public class TestScriptEngine {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        //获得脚本引擎对象
        ScriptEngineManager sem = new ScriptEngineManager();
        javax.script.ScriptEngine engine = sem.getEngineByName("javascript");

        //定义变量，存储到引擎上下文中
        engine.put("msg", "he is handsome");
        String str = "var user = {name:'gao',age:18,schools:['PKU','THU']};";
        str += "print(user.name)";

        //执行脚本
        engine.eval(str);
        engine.eval("msg='wo shi hao ren';");
        System.out.println(engine.get("msg"));
        System.out.println("----------");

        //定义函数
        engine.eval("function add(a,b){var sum = a+b; return sum;}");
        //取得调用接口
        Invocable js = (Invocable) engine;
        //执行脚本中定义的方法
        Object result = js.invokeFunction("add", new Object[]{13, 2});
        System.out.println(result);

        //导入其他java包，使用其他包中的java类
        String jscode = "var list=java.util.Arrays.asList([\"bw\",\"kkk\",\"wop\"]);";
        engine.eval(jscode);

        List<String> list = (List<String>) engine.get("list");
        for (String temp : list) {
            System.out.println(temp);
        }

    }
}
