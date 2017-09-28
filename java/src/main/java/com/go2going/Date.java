package com.go2going;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.SplittableRandom;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Date<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/9/27 0027 14:06
 */
public class Date {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SplittableRandom random = new SplittableRandom();

        random.ints(10,0,10).parallel().forEach(value -> {
            String s = Thread.currentThread().getId() + ":" + value;
            System.out.println(s);
        });

        SecureRandom instanceStrong = SecureRandom.getInstanceStrong();
        instanceStrong.ints(10,0,10).forEach(System.out::println);



        LocalDate date = LocalDate.parse("1993-11-27");
        LocalDate now = LocalDate.of(2017, 9, 27);
        System.out.println(now);
        System.out.println(date.getMonth().getValue());
    }
}
