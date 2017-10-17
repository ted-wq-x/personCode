package website.wangqiang.rmi;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author BlueT
 * 2017/10/6 20:19
 */
public class FileImpl extends UnicastRemoteObject implements FileInterface {
    private String name;

    protected FileImpl(String name) throws RemoteException {
        super();
        this.name = name;
    }

    @Override
    public byte[] downloadFile(String fileName) throws RemoteException {
        try {
            File file = new File(fileName);
            byte buffer[] = new byte[(int)file.length()];
            BufferedInputStream input = new
                    BufferedInputStream(new FileInputStream(fileName));
            input.read(buffer,0,buffer.length);
            input.close();
            return buffer;
        } catch(Exception e){
            System.out.println("FileImpl: "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
