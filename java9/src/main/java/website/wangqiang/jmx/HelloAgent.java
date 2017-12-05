package website.wangqiang.jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 项目名称：  testcode<br>
 * 类名称：  HelloAgent<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/5 0005 9:42
 */
public class HelloAgent {
    /**
     * 使用jconsole连接
     * @param args
     */
    public static void main(String[] args) {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        try {
            //第14行中的ObjectName中的取名是有一定规范的，格式为：“域名：name=MBean名称”，其中域名和MBean的名称可以任意取。这样定义后，就可以唯一标识我们定义的这个MBean的实现类了。
            Hello object = new Hello();
            mBeanServer.registerMBean(object, new ObjectName("jmxBean:name=hello"));

            new Thread(() -> {
                Random random = new Random();
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(random.nextInt(10));
                    } catch (Exception e) {
                    }
                    object.setAge(random.nextInt(10) + object.getAge());
                }
            }).start();

            Thread.sleep(60*60*1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
