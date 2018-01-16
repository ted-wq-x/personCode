package com.go2going.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Main<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/11 0011 15:00
 */
public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream("E:\\read.log");
            FileChannel channel = inputStream.getChannel();

            ByteBuffer allocate = ByteBuffer.allocate(1024);
            int read = channel.read(allocate);
//            CharBuffer charBuffer  = CharBuffer.allocate(1024);
            while (read!=-1) {

                allocate.flip();

                while (allocate.hasRemaining()) {
                    System.out.print((char) allocate.get());
                }
                allocate.clear();
                read = channel.read(allocate);
            }


            channel.close();
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
