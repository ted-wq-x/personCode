package website.wangqiang.rmi;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.rmi.Naming;

/**
 * @author BlueT
 * 2017/10/6 20:26
 */
public class FileClient {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Usage: java FileClient fileName machineName");
            System.exit(0);
        }
        try {
            String name = "//" + args[1] + "/FileServer";
            FileInterface fi = (FileInterface) Naming.lookup(name);
            byte[] filedata = fi.downloadFile(args[0]);
            File file = new File(args[0]);
            BufferedOutputStream output = new
                    BufferedOutputStream(new FileOutputStream(file.getName()));
            output.write(filedata,0,filedata.length);
            output.flush();
            output.close();
        } catch(Exception e) {
            System.err.println("FileServer exception: "+ e.getMessage());
            e.printStackTrace();
        }
    }
}
