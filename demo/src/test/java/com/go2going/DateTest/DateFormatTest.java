package com.go2going.DateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 项目名称：  testcode<br>
 * 类名称：  DateFormatTest<br>
 * 描述：测试SimpleDateFormat的安全性，多试几次会发现抛出异常
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 15:59
 */
public class DateFormatTest extends Thread {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private String name;
    private String dateStr;
    public DateFormatTest(String name, String dateStr) {
        this.name = name;
        this.dateStr = dateStr;
    }
    @Override
    public void run() {
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(name + " : date: " + date);
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new DateFormatTest("Test_A", "2000-04-28"));
        executor.execute(new DateFormatTest("Test_B", "2017-04-28"));
        executor.shutdown();
        
    }
}
