package website.wangqiang.jmx;

/**
 * 项目名称：  testcode<br>
 * 类名称：  HelloMBean<br>
 * 描述：定义一个MBean接口，接口的命名规范为以具体的实现类为前缀（这个规范很重要）
 *
 * @author wangqiang
 * 创建时间：  2017/12/5 0005 9:40
 */
public interface  HelloMBean {
    String getName();

    void setName(String name);

    String getAge();

    void setAge(String age);

    void helloWorld();

    void helloWorld(String str);

    void getTelephone();
}
