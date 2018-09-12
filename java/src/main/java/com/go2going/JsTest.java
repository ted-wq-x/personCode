package com.go2going;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 使用js引擎，验证能够动态的加载js文件，注意修改的时文件路径
 */
public class JsTest {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException, InterruptedException, FileNotFoundException {
        ScriptEngineFactory engineFactory = new NashornScriptEngineFactory();
        ScriptEngine scriptEngine = engineFactory.getScriptEngine();
        Invocable invocable = (Invocable) scriptEngine;
        String file = JsTest.class.getClassLoader().getResource("test.js").getFile();
        System.out.println(file);
        while (true) {
            scriptEngine.eval(new FileReader(file));
            Object add = invocable.invokeFunction("add", 1, 2);
            System.out.println(add);
            Thread.sleep(3000);
        }


    }
}
