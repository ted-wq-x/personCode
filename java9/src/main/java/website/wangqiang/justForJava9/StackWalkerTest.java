package website.wangqiang.justForJava9;

import java.util.stream.Collectors;

/**
 * 项目名称：  testcode<br>
 * 类名称：  StackWalkerTest<br>
 * 描述：测试stackWalker api
 *
 * @author wangqiang
 * 创建时间：  2017/9/30 0030 13:50
 */
public class StackWalkerTest {

    public static void main(String[] args) {
        test1();
    }

    static void test1(){
        StackWalker stackWalker = StackWalker.getInstance();
        stackWalker.walk(stackFrameStream -> stackFrameStream.filter(stackFrame -> stackFrame.getClassName().equals
                ("main")).collect(Collectors.toList()));
        stackWalker.forEach(System.out::println);
    }
}
