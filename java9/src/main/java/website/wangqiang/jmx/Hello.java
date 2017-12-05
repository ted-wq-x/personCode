package website.wangqiang.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Hello<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/5 0005 9:41
 */
public class Hello extends NotificationBroadcasterSupport implements HelloMBean {

    //增加序号
    private long sequenceNumber = 1;

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[]{
                //属性变化的时候，发送通知
                AttributeChangeNotification.ATTRIBUTE_CHANGE
        };

        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[]{info};
    }

    private String name;

    private String age;

    public void getTelephone() {
        System.out.println("get Telephone");
    }

    public void helloWorld() {
        System.out.println("hello world");
    }

    public void helloWorld(String str) {
        System.out.println("helloWorld:" + str);
    }

    public String getName() {
        System.out.println("get name 123");
        return name;
    }

    public void setName(String name) {
        System.out.println("set name 123");
        this.name = name;
    }

    public String getAge() {
        System.out.println("get age 123");
        return age;
    }

    public synchronized void setAge(String age) {
        System.out.println("current age value=" + this.age);

        //发送通知
        Notification n = new AttributeChangeNotification(this, sequenceNumber++, System.currentTimeMillis(), "age " +
                "have " +
                "change", "age", "String", this.age, age);
        sendNotification(n);

        this.age = age;
    }
}
