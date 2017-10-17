package website.wangqiang;

/**
 * @author BlueT
 * 2017/10/7 22:35
 */
public class ReferenceTest {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        System.out.println("**********强引用测试（放一个4M的数组，触发GC）**********");
           byte[] bytes = new byte[4 * _1MB];
        bytes = null;
            System.gc();
    }
}
