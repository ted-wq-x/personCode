package wangqiang.website.createType;

/**
 * 单例模式
 * Created by wangq on 2017/5/12.
 */
public class Singleton {

}

/**
 * 饿汉模式,存在多线程问题
 */
class HungrySingleton {
    private static HungrySingleton singleton = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance() {
        return singleton;
    }
}

/**
 * 懒汉模式
 */
class LazySingleton {
    private static LazySingleton singleton = null;
    private LazySingleton(){}
    public static LazySingleton getInstance() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }
}

/**
 * 饿汉式单例类不能实现延迟加载，不管将来用不用始终占据内存；懒汉式单例类线程安全控制烦琐，而且性能受影响<br>
 *     Initialization Demand Holder (IoDH)更好的实现方式，克服了以上两种方式的缺点
 */
class IoDhSingleton {
    private IoDhSingleton(){}
    private static class HolderClass{
        private static final IoDhSingleton singleton = new IoDhSingleton();
    }

    public static IoDhSingleton getInstance(){
        return HolderClass.singleton;
    }
}

