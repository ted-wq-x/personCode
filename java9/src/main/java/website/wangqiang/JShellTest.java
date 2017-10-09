package website.wangqiang;

import jdk.jshell.JShell;

/**
 * 项目名称：  testcode<br>
 * 类名称：  JShell<br>
 * 描述：使用Java调用jshell
 *
 * @author wangqiang
 * 创建时间：  2017/9/26 0026 15:11
 */
public class JShellTest {
    public static void main(String[] args) {
//        test2();

    }

    static void test1(){
        JShell jShell = JShell.builder().idGenerator((snippet, integer)->"MyId"+integer).build();
        jShell.eval("int a=10;");
        jShell.eval("100+100");
        jShell.variables().forEach(v -> System.out.println(v.typeName() + " " + v.name() + " " + v.id() + v.toString()));
    }

    static void test2(){
        JShell jShell = JShell.builder().build();
        jShell.eval("void helloJShell() { System.out.println(\"hello VJUG\"); }");
        jShell.eval("helloJShell();");
        jShell.variables().forEach(System.out::println);
    }
}
