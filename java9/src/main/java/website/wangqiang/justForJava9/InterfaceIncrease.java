package website.wangqiang.justForJava9;

/**
 * 项目名称：  testcode<br>
 * 类名称：  InterfaceIncrease<br>
 * 描述：java9接口的加强
 *
 * @author wangqiang
 * 创建时间：  2017/9/30 0030 13:36
 */
public interface InterfaceIncrease {


    /**
     * 1.私有的静态方法(不能是protect)，Java8中只能public
     */
    private static void say(){
        System.out.println("Hello java9");
    }

    /**
     * 2.私有方法
     */
    private void sayHello(){
        System.out.println("hello world");
    }

}
