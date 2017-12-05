package website.wangqiang.jmx;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.util.Set;

/**
 * 项目名称：  testcode<br>
 * 类名称：  JMSClient<br>
 * 描述：使用jmx的客户端而不是jconsole
 *
 * @author wangqiang
 * 创建时间：  2017/12/5 0005 13:53
 */
public class JMSClient {
    public static void main(String[] args) throws IOException, IntrospectionException, InstanceNotFoundException,
            ReflectionException {
        String host = "127.0.0.1";
        int port = 9999;
        String url = "service:jmx:rmi:///jndi/rmi://" + host + ":" + port + "/jmxrmi";

        JMXServiceURL serviceURL = new JMXServiceURL(url);
        final JMXConnector connector;//获取和server端的连接
        try {
            connector = JMXConnectorFactory.connect(serviceURL);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        MBeanServerConnection connection = connector.getMBeanServerConnection();
        Set<ObjectName> objectNames = connection.queryNames(null, null);

        for (ObjectName objectName : objectNames) {
            System.out.println("========" + objectName + "========");
            MBeanInfo mBeanInfo = connection.getMBeanInfo(objectName);
            System.out.println("[Attributes]");
            for (MBeanAttributeInfo attr : mBeanInfo.getAttributes()) {
                Object value = null;
                try {
                    value = attr.isReadable() ? connection.getAttribute(objectName, attr.getName()) : "";
                } catch (Exception e) {
                    value = e.getMessage();
                }
                System.out.println(attr.getName() + ":" + value);
            }
            System.out.println("[Operations]");
            for (MBeanOperationInfo oper : mBeanInfo.getOperations()) {
                System.out.println(oper.getName() + ":" + oper.getDescription());
            }
            System.out.println("[Notifications]");
            for (MBeanNotificationInfo notice : mBeanInfo.getNotifications()) {
                System.out.println(notice.getName() + ":" + notice.getDescription());
            }
        }
    }
}
