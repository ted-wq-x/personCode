package website.wangqiang.rmi;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

/**
 * @author BlueT
 * 2017/10/6 20:23
 */
public class FileServer {
    public static void main(String[] args) {
        if(System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            FileInterface fi = new FileImpl("FileServer");
            Naming.rebind("//127.0.0.1/FileServer", fi);
        } catch(Exception e) {
            System.out.println("FileServer: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
