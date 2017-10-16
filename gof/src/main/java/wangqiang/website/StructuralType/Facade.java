package wangqiang.website.StructuralType;

/**
 * 外观模式 <br>
 * 外观角色
 * Created by wangqiang on 17-5-14.
 */
public class Facade {
    private SubSystemA obj1 = new SubSystemA();
    private SubSystemB obj2 = new SubSystemB();
    private SubSystemC obj3 = new SubSystemC();

    public void Method()
    {
        obj1.MethodA();
        obj2.MethodB();
        obj3.MethodC();
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.Method();
    }
}

/**
 * 子系统
 */
class SubSystemA{
    public void MethodA()
    {
        //业务实现代码
        System.out.println("i'm a method");
    }
}

/**
 * 子系统
 */
class SubSystemB{
    public void MethodB()
    {
        //业务实现代码
        System.out.println("i'm b method");
    }
}

/**
 * 子系统
 */
class SubSystemC{
    public void MethodC()
    {
        //业务实现代码
        System.out.println("i'm c method");
    }
}