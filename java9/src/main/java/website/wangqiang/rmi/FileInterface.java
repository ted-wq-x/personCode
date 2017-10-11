package website.wangqiang.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 测试RMI和corba
 * @author BlueT
 * 2017/10/6 20:10
 */
public interface FileInterface extends Remote {
    byte[] downloadFile(String fileName) throws
            RemoteException;
}
