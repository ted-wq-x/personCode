package com.go2going;

import com.go2going.bean.Product;
import org.joda.time.DateTime;
import org.springframework.core.serializer.support.SerializingConverter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Main<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 15:59
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
/*
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(("\\xAC\\xED\\x00" +
                "\\x05sr\\x00\\x11java.lang.Integer\\x12\\xE2\\xA0\\xA4\\xF7\\x81\\x878\\x02\\x00\\x01I\\x00" +
                "\\x05valuexr\\x00\\x10java.lang" +
                ".Number\\x86\\xAC\\x95\\x1D\\x0B\\x94\\xE0\\x8B\\x02\\x00\\x00xp\\x00\\x00\\x00\\x01").getBytes()));

        Object o = inputStream.readObject();


        inputStream.close();*/
        System.out.println(Main.class);
    }
}
